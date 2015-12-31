import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping

@Controller
public class EndpointDocController {
 private final RequestMappingHandlerMapping handlerMapping;

 @Autowired
 public EndpointDocController(RequestMappingHandlerMapping handlerMapping) {
  this.handlerMapping = handlerMapping;
 }

 @RequestMapping(value="/endpointdoc", method=[RequestMethod.POST])
 public void show(HttpServletRequest request, HttpServletResponse response) {
  //model.addAttribute("handlerMethods", this.handlerMapping.getHandlerMethods());
 this.handlerMapping.getHandlerMethods().each {
 		k,v -> println "${k} - ${v}"
	 }
 } 
}