package mx.com.sagarpa.snics.service.controller.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.sagarpa.snics.service.base.dto.ObtenerPaisRequest;
import mx.com.sagarpa.snics.service.base.dto.ObtenerPaisResponse;
import mx.com.sagarpa.snics.service.catalogo.SnicsCatalogoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("combos")
public class CombosController {

//	Logger LOG = LoggerFactory.getLogger(this.getClass());
//
//	@Autowired
//	@Qualifier("SnicsCatalogoServiceImpl")
//	SnicsCatalogoService snicsCatalogoServiceImpl;
//
//	@RequestMapping(value= "pais", method= RequestMethod.POST)
//	@ResponseBody
//	public ObtenerPaisResponse getPais(@RequestBody ObtenerPaisRequest req,
//			HttpServletRequest request, HttpServletResponse response) {
//		LOG.info("combos/pais [INICIO]");
//		return snicsCatalogoServiceImpl.getPais(req);
//	}
}
