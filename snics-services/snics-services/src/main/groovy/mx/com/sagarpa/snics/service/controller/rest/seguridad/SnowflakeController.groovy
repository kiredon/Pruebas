package mx.com.sagarpa.snics.service.controller.rest.seguridad

import java.net.Authenticator.RequestorType;

import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.sagarpa.snics.service.ResponseCodes;
import mx.com.sagarpa.snics.service.controller.rest.AbstractRestController
import mx.com.sagarpa.snics.service.seguridad.SnowflakeService
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.LoginRequest
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.LoginResponse
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.LogoutRequest
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.LogoutResponse
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.ObtenerObjetoAutorizacionRequest
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.ObtenerObjetoAutorizacionResponse

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RequestMethod

@Controller
@RequestMapping("Snowflake")
class SnowflakeController extends AbstractRestController{
	
	@Autowired
	@Qualifier("SnowflakeServiceImpl")
	SnowflakeService snowflakeService

	Logger LOG = LoggerFactory.getLogger(this.class)
	
	@RequestMapping(value = "login", method = [RequestMethod.POST])
	@ResponseBody
	public LoginResponse Login(@RequestBody LoginRequest req, HttpServletRequest request, HttpServletResponse response){
		LOG.info("Intentando Loguear con el usuario: " + req.usuario)
		
		LoginResponse resp;
		
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
			ipAddress = request.getRemoteAddr();
		}
		
		if(ipAddress == null){
			req.setIpAddress("")
		}else{
			req.setIpAddress(ipAddress)
		}
		
		String userAgent = request.getHeader("User-Agent")
		
		if(userAgent==null){
			
			req.setUser_agent("")
		}else{
			req.setUser_agent(userAgent)
		}
		
		
		resp = snowflakeService.Login(req)
		
		if(resp == null){
			LOG.info("Error al autenticarse: " + req.usuario)
			response.sendError(500, "Error al autenticarse")
			return
		}else if(resp.getSnowflake().equals("0")){
			LOG.info("Usuario/Contraseña incorrecta: " + req.usuario)
			response.sendError(403, "Usuario/Contraseña incorrecta")
			return
		}else if(resp.getSnowflake().equals("SesionAbierta")){
			LOG.info("Usuario logueado Actualmente: " + req.usuario)
			response.sendError(403, "Usuario logueado Actualmente")
			return
		}

		LOG.info("Saliendo de Login con el usuario: " + req.usuario)
		return resp;
	}
	
	@RequestMapping(value="obtenerObjetoAutorizacion", method=RequestMethod.POST)
	@ResponseBody
	public ObtenerObjetoAutorizacionResponse obtenerObjetoAutorizacion (@RequestBody ObtenerObjetoAutorizacionRequest req, HttpServletRequest request, HttpServletResponse response){
		
		def idUsuario = snowflakeService.obtenerIdUsuario(req.snowflake)
		def nombreUsuario = snowflakeService.obtenerNombreUsuario(req.snowflake)
		
		LOG.info("Obteniendo Objeto de Autorizacion: " + nombreUsuario)
		ObtenerObjetoAutorizacionResponse resp = new ObtenerObjetoAutorizacionResponse()
		resp = snowflakeService.obtenerObjetoAutorizacion(req.snowflake)
		resp.responseCode = ResponseCodes.OK.desc
		LOG.info("Objeto de autorizacion para usuario: " + nombreUsuario)
		return resp
	}
	
	@RequestMapping(value="logout", method=RequestMethod.POST)
	@ResponseBody
	public LogoutResponse logout (@RequestBody LogoutRequest req, HttpServletRequest request, HttpServletResponse response){
		def idUsuario = snowflakeService.obtenerIdUsuario(req.snowflake)
		def nombreUsuario = snowflakeService.obtenerNombreUsuario(req.snowflake)
		
		LOG.info("Logout Usuario: " + nombreUsuario)
		LogoutResponse resp = new LogoutResponse()
	
		resp = snowflakeService.logout(req)

		return resp
	}
}
