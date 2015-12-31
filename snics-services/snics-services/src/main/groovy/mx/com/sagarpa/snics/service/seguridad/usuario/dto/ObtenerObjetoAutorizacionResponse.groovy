package mx.com.sagarpa.snics.service.seguridad.usuario.dto

import mx.com.sagarpa.snics.service.dto.ServiceResponse
import mx.com.sagarpa.snics.service.seguridad.vo.FuncionAutorizacionVo
import mx.com.sagarpa.snics.service.seguridad.vo.ObjetoAutorizacionVo
import mx.com.sagarpa.snics.service.seguridad.vo.PermisoAutorizacionVo

class ObtenerObjetoAutorizacionResponse extends ServiceResponse {
	
	ObjetoAutorizacionVo objetoAutorizacion
	List<PermisoAutorizacionVo> permisos
	List<FuncionAutorizacionVo> funciones
	 
}
