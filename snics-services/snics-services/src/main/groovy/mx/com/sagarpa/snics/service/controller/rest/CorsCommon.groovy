
package mx.com.sagarpa.snics.service.controller.rest

import javax.servlet.http.HttpServletResponse

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
public class CorsCommon {
    
	@RequestMapping(method = RequestMethod.OPTIONS)
    public void commonOptions(HttpServletResponse theHttpServletResponse) throws IOException {
        theHttpServletResponse.setHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with");
        theHttpServletResponse.setHeader("Access-Control-Max-Age", "60"); // seconds to cache preflight request --> less OPTIONS traffic
        theHttpServletResponse.setHeader("Access-Control-Allow-Methods", "POST");
        theHttpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
    }

}