
package mx.com.sagarpa.snics.service.controller.rest

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


//import mx.com.sagarpa.snics.service.seguridad.SnowflakeService
import mx.com.sagarpa.snics.service.seguridad.SnowflakeService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpStatus
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter

/**
 * 
 * @author r0tten
 *
 */

abstract class AbstractRestController extends HandlerInterceptorAdapter
{
	
//	@Autowired
//	SnowflakeRestService snowflakeService
	
	@Autowired
	@Qualifier("SnowflakeServiceImpl")
	SnowflakeService snowflakeService;
	
	
	Logger LOG = LoggerFactory.getLogger(this.class)
	
	public String obtenerIdUsuario(HttpServletRequest req){
		String snowflake = req.getHeader("x-requested-with")
		if(snowflake == null){
			return "1";
		}else{
			return snowflakeService.obtenerIdUsuario(snowflake)
		}
		
	}
	
	public String obtenerNombreUsuario(HttpServletRequest req){
		String snowflake = req.getHeader("x-requested-with")
		if(snowflake == null){
			return "dummy";
		}else{
			return snowflakeService.obtenerNombreUsuario(snowflake)
		}
		
	}
	
	
	/**
	 * This needs the HttpServletRequestWrapper to work. Check filters
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public  String getBody(HttpServletRequest request) throws IOException 
	{
		StringBuffer s = new StringBuffer("")
		request.getReader().each {
			s.append "${it}\n"
		}
			
		String body=s.toString()
		try{
		body= body.substring(0,body.lastIndexOf("}")+1)
		}catch(Exception e){LOG.debug("No json request found.",e)}
		
		
		return body
			//throw new Exception("testing")
	}
	
	
	
	/**
	 * Gets the accessToken from the request headers
	 * @param req
	 * @return
	 */
	String getAccessToken(HttpServletRequest req)
	{
		return req.getHeader("x-requested-with")
	}
	
	/**
	 * Validates the security. Returns null if everything ok, or a UNAUTHORIZED resp code is sent 
	 * @param request
	 * @param response
	 */
	def checkSecurity( HttpServletRequest request, HttpServletResponse response, def serviceResponse)
	{
		
		println "HEADERS"
		request.headerNames.each {
			println "header[${it}] value[${request.getHeader(it)}]"
		}
		
		String jsonRequest = ''
		String accessToken = ''
		
		if(serviceResponse.class==FileUploadResponse||serviceResponse.class==DownloadFileResponse){
			String name=''
			if(serviceResponse.class==FileUploadResponse){
				name = request.getParameter("filename")
			}else{
				name = request.getParameter("fileName")
			}
			
			jsonRequest= '{"user":"'+request.getParameter("user")+'","initialPath":"'+request.getParameter("initialPath")+'","fileName":"'+name+'","type":"'+request.getParameter("type")+'"}'
		}else{
		jsonRequest=getBody(request)
		}
		if(serviceResponse.class==DownloadFileResponse||serviceResponse.class==FileUploadResponse){
			accessToken=request.getParameter("x-requested-with")
		}else{
			accessToken=getAccessToken(request)
		}
		
		println "AccessToken[${accessToken}] jsonRequest[${jsonRequest}]"
//		try
//		{
//			snowflakeService.validateAccessToken(jsonRequest, accessToken, serviceResponse)
//		}
//		catch(AccessTokenException e)
//		{
//			LOG.error("securityCheck failed. Exception[e] Message[${e.message}] Cause[${e.cause}] ")
//			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED)
//			serviceResponse.errorDescription="Unauthorized.[${e.message}]"
//			return serviceResponse
//			
//		}
		//if everything ok, return null
		return null
		
	}
	
	
	/**
	 * This method is executed before the json parsing of the request.
	 */
	 @Override
	 public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	 {
		 println "PREHANDLE !!!"
		 println "[${getBody(request)}]"
		 
		 
		 
	 //make pre handle here
	 return super.preHandle(request, response, handler);
	 }
	 
	 @ExceptionHandler
	 @org.springframework.web.bind.annotation.ResponseStatus(HttpStatus.BAD_REQUEST)
	 public void handle(HttpMessageNotReadableException e)
	 {
	 LOG.warn("Got a bad request. Returning Http Status 400.", e); //dont log exceptions. they have too much unnecesary info
	 e.printStackTrace()
	 }
	 
	 @Override
	 public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
	 {
	 super.postHandle(request, response, handler, modelAndView);
	 }
	 
	 @Override
	 public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception
	 {
	 super.afterCompletion(request, response, handler, ex);
	 }
	 
	 
	 
	
	
}