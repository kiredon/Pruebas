package mx.com.sagarpa.snics.service.seguridad.usuario.dto

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;


class ObtenerUsuarioPorIdRequest {
	@NotNull
	@Min(1L)
	Integer idUsuario
}
