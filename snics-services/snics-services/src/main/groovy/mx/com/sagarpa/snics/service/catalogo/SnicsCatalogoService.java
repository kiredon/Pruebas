package mx.com.sagarpa.snics.service.catalogo;

import mx.com.sagarpa.snics.service.base.dto.ObtenerPaisRequest;
import mx.com.sagarpa.snics.service.base.dto.ObtenerPaisResponse;


public interface SnicsCatalogoService {
	
	public ObtenerPaisResponse getPais(ObtenerPaisRequest req);
//
}
