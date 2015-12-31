package mx.com.sagarpa.snics.service.seguridad.permiso.dto

import javax.validation.constraints.NotNull;

class UsuarioPermisosRequest {
	@NotNull
	String token;
	String ruta;
}
