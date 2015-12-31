package mx.com.sagarpa.snics.controllers;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import mx.com.sagarpa.snics.RestClient;
import mx.com.sagarpa.snics.SeguridadFiltro;
import mx.com.sagarpa.snics.dto.ObtenerObjetoAutorizacionResponse;
import mx.com.sagarpa.snics.vo.FuncionAutorizacionVo;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("pages")
public class RedirectorController {

	Logger LOG = LoggerFactory.getLogger(SeguridadFiltro.class);
	
	private String MEDICO = "Médico";
	private String JEFSER = "Jefa Enfermera de Servicio";
	private String ADMINISTRADOR = "Administrador";
	
	@Autowired
	@Qualifier("RestClientImpl")
	RestClient restClient;
	
	@Autowired
	@Qualifier("applicationConfiguration")
	Configuration config;
	
	@RequestMapping(value = "home" , method=RequestMethod.GET)
	public String redirectToHome (@CookieValue("SNOWFLAKE") String snowflake, ServletRequest request, ServletResponse response){
		
		String urlBaseServices = config.getString("SNICS.SERVICES.BASE");
		String data = "{\"snowflake\":\"" + snowflake + "\"}";
		
		String respuesta = restClient.POST(data ,urlBaseServices + "/Snowflake/obtenerObjetoAutorizacion.do", snowflake); 
		
		((HttpServletRequest)request).getSession().setAttribute("snowflake", snowflake);
		((HttpServletRequest)request).getSession().setAttribute("urlBaseServices", urlBaseServices);
		
		ObjectMapper mapper = new ObjectMapper();
		ObtenerObjetoAutorizacionResponse resp = new ObtenerObjetoAutorizacionResponse();
		
		try {
			resp = mapper.readValue(respuesta, ObtenerObjetoAutorizacionResponse.class);
		} catch (JsonParseException e) {
			LOG.error("Error: " + e.getMessage());
		} catch (JsonMappingException e) {
			LOG.error("Error: " + e.getMessage());
		} catch (IOException e) {
			LOG.error("Error: " + e.getMessage());
		}
		
		//si no tienes permisos, forbidden directo
		if(resp.getPermisos() == null || resp.getPermisos().size() == 0){
			LOG.error("Error11111111: ");
			//return "redirect:/forbidden.jsp";
			resp.setPrescripcion(true);
		}
		LOG.error("errorrrr2222: ");

		String[] nombreRol = resp.getObjetoAutorizacion().getNombreRol() ;
//		if(nombreRol.equals(ADMINISTRADOR)){
//			resp.setPrescripcion(true);
//		}
//		if(nombreRol.equals(JEFSER)){
//			resp.setServicio(true);
//		}
//		if(nombreRol.equals(ADMINISTRADOR)){
//			resp.setServicio(true);
//			resp.setPrescripcion(true);
//		}
		LOG.error("errorrrr2222: ");

		Collections.sort(resp.getPermisos());
		((HttpServletRequest)request).getSession().setAttribute("usuario", resp);
		
		LOG.info("Login con Usuario: " + resp.getObjetoAutorizacion().getNombreUsuario());
		
		String redirectTo = "";
		for(FuncionAutorizacionVo funcion : resp.getFunciones()){
			LOG.info(funcion.getNombreFuncion());
			
			if(funcion.getNombreFuncion().equals(resp.getPermisos().get(0).getUrlPermiso())){
				((HttpServletRequest)request).getSession().setAttribute("active", funcion.getIdPermiso());
				LOG.info(redirectTo);
				redirectTo = funcion.getUrlFuncion();
				break;
			}
		}
		return redirectTo;
	}
	
	
	@RequestMapping(value = "views/{pageDest}" , method=RequestMethod.GET)
	public String redirectToPage (@PathVariable String pageDest,@CookieValue("SNOWFLAKE") String snowflake, ServletRequest request, ServletResponse response){
		//LOG.info("permisos: " + autorizacion.getPermisos().size());
		
		ObtenerObjetoAutorizacionResponse autorizacion = (ObtenerObjetoAutorizacionResponse)(((HttpServletRequest)request).getSession().getAttribute("usuario"));
		if(autorizacion == null){
			LOG.error("Error: " );
			return "redirect:/login.jsp";
		}
		LOG.info("Usuario: " + autorizacion.getObjetoAutorizacion().getNombreUsuario() + " enter to: " + pageDest);
		String redirectTo = "";
		for(FuncionAutorizacionVo funcion : autorizacion.getFunciones()){
			if(funcion.getNombreFuncion().equals(pageDest)){
				redirectTo = funcion.getUrlFuncion();
				((HttpServletRequest)request).getSession().setAttribute("active", funcion.getIdPermiso());
				break;
			}
		}
		if("".equals(redirectTo)){
			LOG.info("Usuario " + autorizacion.getObjetoAutorizacion().getNombreUsuario() + " intento acceder a " + pageDest);
			return "redirect:/forbidden.jsp";
		}
		
		return redirectTo;
	}
	
	@RequestMapping (value="logout", method=RequestMethod.GET)
	public String logout (@CookieValue("SNOWFLAKE") String snowflake, ServletRequest request, ServletResponse response){
		
		ObtenerObjetoAutorizacionResponse autorizacion = (ObtenerObjetoAutorizacionResponse)(((HttpServletRequest)request).getSession().getAttribute("usuario"));
		if(autorizacion == null){
			LOG.error("Redirecciona ");
			return "redirect:/login.jsp";
		}
		
		String urlBaseServices = config.getString("SNICS.SERVICES.BASE");
		String data = "{\"snowflake\":\"" + snowflake + "\"}";
		
		//LOG.info("Base de los servicios: " + urlBaseServices);
		
		restClient.POST(data ,urlBaseServices + "/Snowflake/logout.do", snowflake); 
		
		LOG.info("Usuario: " + autorizacion.getObjetoAutorizacion().getNombreUsuario() + " logout " );
		((HttpServletRequest)request).getSession().invalidate();
		
		
		return "redirect:/login.jsp";
	}
}
