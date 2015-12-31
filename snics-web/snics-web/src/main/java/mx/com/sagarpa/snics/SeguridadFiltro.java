package mx.com.sagarpa.snics;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import mx.com.sagarpa.snics.impl.RestClientImpl;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SeguridadFiltro implements Filter{
	Logger LOG = LoggerFactory.getLogger(SeguridadFiltro.class);
	  @Override
	    public void init(FilterConfig config) throws ServletException {
	        //
	    }

	    @Override
	    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
	        HttpServletRequest request = (HttpServletRequest) req;
	        String requestURI = request.getRequestURI();
	       // LOG.info(requestURI);
	        
	        //hardcodear la request uri
	        requestURI="testteooo";
	        //
	        System.out.println(requestURI);
	        RestClientImpl clienteRest=new RestClientImpl();
	        // usr 4 para que truene
	        String respuesta=clienteRest.POST("{\"token\":1,\"ruta\":\""+requestURI+"\"}", "http://localhost:8081/snics-services/Usuario/validarPermiso.do","");
	        System.out.println(respuesta);
	        JSONParser parser = new JSONParser();
	        JSONObject jsonRespuesta=null;
	        try {
	        	 jsonRespuesta = (JSONObject) parser.parse(respuesta);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       Boolean autorizacion=(Boolean)jsonRespuesta.get("autorizacion");
	       String token=(String)jsonRespuesta.get("token");
	       System.out.println(autorizacion);
	       //validacion del token tiempo de espera
	       if(token.length()!=0){
	    	   //validacion de los permisos
	        if(autorizacion==true){
	        	
	        	 chain.doFilter(req, res);
	        }
	        else{	        	
	        	((HttpServletResponse)res).sendRedirect(((HttpServletRequest)req).getContextPath() + "/views/admin/forbidden.jsp");
	        	
	        }
	       }else{
	    	   ((HttpServletResponse)res).sendRedirect(((HttpServletRequest)req).getContextPath() + "/views/admin/login.jsp");
	       }
//	        if (requestURI.startsWith("/Check_License/Dir_My_App/")) {
//	            String toReplace = requestURI.substring(requestURI.indexOf("/Dir_My_App"), requestURI.lastIndexOf("/") + 1);
//	            String newURI = requestURI.replace(toReplace, "?Contact_Id=");
//	            req.getRequestDispatcher(newURI).forward(req, res);
//	        } else {
//	            chain.doFilter(req, res);
//	        }
//	        HttpServletResponse resp = (HttpServletResponse) res;
//	        resp.reset();
//	        resp.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
//	        resp.setHeader("Location", "/mus-web/views/admin/diagnostico.jsp");
//	        return;
	       
	    }
	    
	    @Override
	    public void destroy() {
	        //
	    }
	
}
