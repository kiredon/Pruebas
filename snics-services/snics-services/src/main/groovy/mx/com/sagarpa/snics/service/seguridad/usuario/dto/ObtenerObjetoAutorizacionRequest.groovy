package mx.com.sagarpa.snics.service.seguridad.usuario.dto

import javax.validation.constraints.NotNull;

class ObtenerObjetoAutorizacionRequest {

	@NotNull
	String snowflake
}
