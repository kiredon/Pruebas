package mx.com.sagarpa.snics.service.seguridad.usuario.dto

import mx.com.sagarpa.snics.service.dto.ServiceResponse
import mx.com.sagarpa.snics.service.seguridad.vo.UsuarioVoList


class ListarUsuarioResponse  extends ServiceResponse{

	UsuarioVoList UsuarioVoList
	int total

}
