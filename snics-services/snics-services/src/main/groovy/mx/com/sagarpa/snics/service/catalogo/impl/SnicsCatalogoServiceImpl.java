package mx.com.sagarpa.snics.service.catalogo.impl;

import mx.com.sagarpa.snics.service.base.dto.ObtenerPaisRequest;
import mx.com.sagarpa.snics.service.base.dto.ObtenerPaisResponse;
import mx.com.sagarpa.snics.service.catalogo.SnicsCatalogoService;
import mx.com.sagarpa.snics.persistence.dao.CatPaisDao;
import mx.com.sagarpa.snics.service.base.vo.PaisVO;
import mx.com.sagarpa.snics.persistence.entities.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class SnicsCatalogoServiceImpl implements SnicsCatalogoService{
	
	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CatPaisDao catPaisDao;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ObtenerPaisResponse getPais(ObtenerPaisRequest req)  {
		ObtenerPaisResponse response = new ObtenerPaisResponse();
		
		try {
			PaisVO paisSelect = new PaisVO();
			for (CatPais pais : catPaisDao.listAll()) {
				
				paisSelect.setId_pais(pais.getIdPais().toString());
				paisSelect.setNombre_Pais(pais.getNombrePais());
				response.getList().add(paisSelect);
			}
			response.setResponseCode("00");
		} catch (Exception e) {
			LOG.error("Error! " +  e.getStackTrace());
			response.setResponseCode("01");
		}
		return response;
	}

}
