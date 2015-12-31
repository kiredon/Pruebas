package mx.com.sagarpa.snics.service;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import mx.com.sagarpa.snics.service.seguridad.SnowflakeService
import mx.com.sagarpa.snics.service.seguridad.SnowflakeService
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.LoginRequest
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;



public class SeguridadFiltroServices implements Filter {

	@Autowired
	@Qualifier("SnowflakeServiceImpl")
	SnowflakeService snowflakeService;


	Logger LOG = LoggerFactory.getLogger(this.class)

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		LoginRequest req = new LoginRequest();
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		if(!httpRequest.getMethod().equals("POST")){
			chain.doFilter(request, response);
			return;
		}

		HttpServletResponse httpResponse = (HttpServletResponse)response;
		String snowflake = httpRequest.getHeader("x-requested-with")

		String authHeader = httpRequest.getHeader("Authorization")
		String MD5 = httpRequest.getHeader("Content-MD5")

		if(snowflake == null){
			if(authHeader != null && MD5 != null){

				LOG.info("AuthHeader: " + authHeader)
				LOG.info("MD5: " + MD5)
				if( snowflakeService.validaServicioAutorizado(authHeader, MD5)){

					chain.doFilter(request, response);
					return;
				}else{
					httpResponse.sendError(513, "Sin Autorizacion");
				}
			}else{
				httpResponse.sendError(513, "Sin snowflake de autorizacion");
				return;
			}
		}

		httpRequest.getRequestURL()

		String ipAddress = httpRequest.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
			ipAddress = request.getRemoteAddr();
		}

		if(ipAddress == null){
			req.setIpAddress("");
		}else{
			req.setIpAddress(ipAddress);
		}

		String userAgent = httpRequest.getHeader("User-Agent");
		if(userAgent==null){
			req.setUser_agent("");
		}else{
			req.setUser_agent(userAgent);
		}

		if(snowflake.indexOf(',') > -1){


			String [] headers = snowflake.split(",");
			for(String header : headers){
				if(snowflakeService.validaServicio(req, header,true)){
					chain.doFilter(request, response);
					return
				}
			}
			httpResponse.sendError(513, "Snowflake  indecifrable");

			return
		}else{
			boolean valida;
			
			//LOG.info(httpRequest.getContextPath())

				valida = snowflakeService.validaServicio(req, snowflake,true)
			
			if(valida){
				chain.doFilter(request, response);
				return
			}else{
				httpResponse.sendError(513, "Snowflake no autorizado");

				return
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
}
