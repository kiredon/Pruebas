package mx.com.sagarpa.snics.service.seguridad.usuario.dto

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;


class ListarUsuarioRequest {
	@NotNull
	@Min(1L)
	Boolean status
	Integer pagina
	Integer tamanio
}
