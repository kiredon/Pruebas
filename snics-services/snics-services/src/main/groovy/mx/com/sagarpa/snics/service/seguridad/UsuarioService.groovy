package mx.com.sagarpa.snics.service.seguridad

import mx.com.sagarpa.snics.service.seguridad.permiso.dto.UsuarioPermisosRequest
import mx.com.sagarpa.snics.service.seguridad.permiso.dto.UsuarioPermisosResponse
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.ActualizarUsuarioRequest
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.ActualizarUsuarioResponse
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.CrearUsuarioRequest
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.CrearUsuarioResponse
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.ListarUsuarioRequest
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.ListarUsuarioResponse
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.ObtenerUsuarioPorIdRequest
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.ObtenerUsuarioPorIdResponse


interface UsuarioService{


	public ActualizarUsuarioResponse ActualizarUsuario(	ActualizarUsuarioRequest request)
	public ObtenerUsuarioPorIdResponse ObtenerUsuarioPorId(ObtenerUsuarioPorIdRequest request)
	public CrearUsuarioResponse CrearUsuario(CrearUsuarioRequest request)
	public ListarUsuarioResponse ListarUsuario(ListarUsuarioRequest request)
//	public ListarBusquedaUsuarioResponse ListarBusquedaUsuario(ListarBusquedaUsuarioRequest request)
//	public CambiarEstadoUsuarioResponse CambiarEstadoUsuario(CambiarEstadoUsuarioRequest request)
//	public CambiarContrasenaUsuarioResponse CambiarContrasena(CambiarContrasenaUsuarioRequest request) 	
//	public RestablecerContrasenaUsuarioResponse RestablecerContrasena(RestablecerContrasenaUsuarioRequest request)
//	public AsociarUsuarioUnidadResponse AsociarUsuarioUnidad(AsociarUsuarioUnidadRequest request)
	public UsuarioPermisosResponse  UsuarioPermisos( UsuarioPermisosRequest request)
//	public ObtenerUsuarioLoginResponse ObtenerUsuarioLogin(ObtenerUsuarioLoginRequest request,String idUsuario)
//	public ObtenerDatosMedicoResponse obtenerDatosMedico(ObtenerDatosMedicoRequest request)
//	public ObtenerMedicosPorServicioResponse ObtenerMedicos(ObtenerMedicosPorServicioRequest request)
}
