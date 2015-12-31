package mx.com.sagarpa.snics.service.seguridad.permiso.dto

import java.util.Date;

import javax.validation.constraints.NotNull

class InsertarPermisoRequest {
	@NotNull
	Integer idPermiso
    String nombrePermiso;
    String funcionUrl;
	Boolean status
}
