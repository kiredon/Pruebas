package mx.com.sagarpa.snics.service.seguridad.permiso.dto

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;


class ObtenerPermisoPorIdRequest {
	@NotNull
	@Min(1L)
	Integer idPermiso
}
