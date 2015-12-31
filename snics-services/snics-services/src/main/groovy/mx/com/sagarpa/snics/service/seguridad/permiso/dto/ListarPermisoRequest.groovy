package mx.com.sagarpa.snics.service.seguridad.permiso.dto
import javax.validation.constraints.NotNull;

class ListarPermisoRequest {
	@NotNull
	Integer pagina
	Integer tamanio
}
