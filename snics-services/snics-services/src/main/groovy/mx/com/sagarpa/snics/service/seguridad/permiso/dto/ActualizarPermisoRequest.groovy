package mx.com.sagarpa.snics.service.seguridad.permiso.dto

import java.util.Date;

import javax.validation.constraints.NotNull;

class ActualizarPermisoRequest {
	@NotNull
	Integer idPermiso
	String nombrePermiso
    String funcionUrl;
	boolean status
	
}
