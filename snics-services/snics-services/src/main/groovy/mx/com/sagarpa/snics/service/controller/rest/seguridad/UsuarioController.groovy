package mx.com.sagarpa.snics.service.controller.rest.seguridad

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import mx.com.sagarpa.snics.service.controller.rest.AbstractRestController
import mx.com.sagarpa.snics.service.seguridad.UsuarioService
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.ActualizarUsuarioRequest
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.ActualizarUsuarioResponse
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.CrearUsuarioRequest
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.CrearUsuarioResponse
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.ListarUsuarioRequest
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.ListarUsuarioResponse
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.ObtenerUsuarioPorIdRequest
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.ObtenerUsuarioPorIdResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMethod

@Controller
@RequestMapping("Usuario")
class UsuarioController extends AbstractRestController {

	@Autowired
	@Qualifier("UsuarioServiceImpl")
	UsuarioService UsuarioService

	Logger LOG = LoggerFactory.getLogger(this.class)
	

	@RequestMapping(value = "insertar", method = [RequestMethod.POST])
	@ResponseBody
	public CrearUsuarioResponse CrearUsuario (@RequestBody CrearUsuarioRequest req, HttpServletRequest request, HttpServletResponse response){
		def idUsuario = obtenerIdUsuario(request)
		def nombreUsuario = obtenerNombreUsuario(request)
		LOG.info("Entrando a servicio CrearUsuario : " + nombreUsuario);
		def resp = UsuarioService.CrearUsuario(req)
		LOG.info("Saliendo de servicio CrearUsuario, nombreUsuario : " + req.nombreUsuario + " : " + nombreUsuario);
		return resp
	}

	@RequestMapping(value = "actualizar", method = [RequestMethod.POST])
	@ResponseBody
	public ActualizarUsuarioResponse ActualizarUsuario (@RequestBody ActualizarUsuarioRequest req, HttpServletRequest request, HttpServletResponse response){
		def idUsuario = obtenerIdUsuario(request)
		def nombreUsuario = obtenerNombreUsuario(request)
		LOG.info("Entrando a servicio actualizar Usuario : " + nombreUsuario);
		def resp = UsuarioService.ActualizarUsuario(req)
		LOG.info("Saliendo de servicio actualizar Usuario, nombreUsuario : " + req.nombreUsuario + " : " + nombreUsuario);
		return resp
	}

	
//	@RequestMapping(value = "cambiarEstado", method = [RequestMethod.POST])
//	@ResponseBody
//	public CambiarEstadoUsuarioResponse CambiarEstadoUsuario (@RequestBody CambiarEstadoUsuarioRequest req, HttpServletRequest request, HttpServletResponse response){
//		def idUsuario = obtenerIdUsuario(request)
//		def nombreUsuario = obtenerNombreUsuario(request)
//		LOG.info("Entrando a servicio CambiarEstadoUsuario : " + nombreUsuario);
//		def resp = UsuarioService.CambiarEstadoUsuario(req)
//		LOG.info("Saliendo de servicio CambiarEstadoUsuario, idUsuario : " + req.idUsuario + " : " + nombreUsuario);
//		return resp
//	}
	
	
	@RequestMapping(value = "obtener", method = [RequestMethod.POST])
	@ResponseBody
	public ObtenerUsuarioPorIdResponse obtenerUsuarioPorId (@RequestBody ObtenerUsuarioPorIdRequest req, HttpServletRequest request, HttpServletResponse response){
		def idUsuario = obtenerIdUsuario(request)
		def nombreUsuario = obtenerNombreUsuario(request)
		LOG.info("Entrando a servicio obtenerUsuarioPorId : " + nombreUsuario);
		def resp = UsuarioService.ObtenerUsuarioPorId(req)
		LOG.info("Saliendo de servicio obtenerUsuarioPorId, idUsuario : " + req.idUsuario + " : " + nombreUsuario);
		return resp

	}
//	@RequestMapping(value = "obtenerLogin", method = [RequestMethod.POST])
//	@ResponseBody
//	public ObtenerUsuarioLoginResponse obtenerUsuarioPorId (@RequestBody ObtenerUsuarioLoginRequest req, HttpServletRequest request, HttpServletResponse response){
//		def idUsuario = obtenerIdUsuario(request)
//		def nombreUsuario = obtenerNombreUsuario(request)
//		LOG.info("Entrando a servicio obtenerUsuarioPorId : " + nombreUsuario);
//		def resp = UsuarioService.ObtenerUsuarioLogin(req,idUsuario)
//		LOG.info("Saliendo de servicio obtenerUsuarioPorId, idUsuario : " + idUsuario + " : " + nombreUsuario);
//		return resp
//
//	}
	
//	@RequestMapping(value = "restablecerContrasena", method = [RequestMethod.POST])
//	@ResponseBody
//	public RestablecerContrasenaUsuarioResponse RestablecerContrasenaUsuario (@RequestBody RestablecerContrasenaUsuarioRequest req, HttpServletRequest request, HttpServletResponse response){
//		def idUsuario = obtenerIdUsuario(request)
//		def nombreUsuario = obtenerNombreUsuario(request)
//		LOG.info("Entrando a servicio InsertarPermiso : " + nombreUsuario);
//		def resp =  UsuarioService.RestablecerContrasena(req)
//		LOG.info("Saliendo de servicio InsertarPermiso, idUsuario : " + req.idUsuario + " : " + nombreUsuario);
//		return resp
//		
//	}
//	
//	@RequestMapping(value = "cambiarContrasena", method = [RequestMethod.POST])
//	@ResponseBody
//	public CambiarContrasenaUsuarioResponse CambiarContrasenaUsuario (@RequestBody CambiarContrasenaUsuarioRequest req, HttpServletRequest request, HttpServletResponse response){
//		def idUsuario = obtenerIdUsuario(request)
//		def nombreUsuario = obtenerNombreUsuario(request)
//		LOG.info("Entrando a servicio CambiarContrasenaUsuario : " + nombreUsuario);
//		def resp =  UsuarioService.CambiarContrasena(req)
//		LOG.info("Saliendo de servicio CambiarContrasenaUsuario, idUsuario : " + req.idUsuario + " : " + nombreUsuario);
//		return resp
//
//	}
	
	
	@RequestMapping(value = "listar", method = [RequestMethod.POST])
	@ResponseBody
	public ListarUsuarioResponse ListarUsuario (@RequestBody ListarUsuarioRequest req, HttpServletRequest request, HttpServletResponse response){
		def idUsuario = obtenerIdUsuario(request)
		def nombreUsuario = obtenerNombreUsuario(request)
		LOG.info("Entrando a servicio ListarUsuario : " + nombreUsuario);
		println "Usuario logueado: " + obtenerIdUsuario(request)
		def resp =  UsuarioService.ListarUsuario(req)
		LOG.info("Saliendo de servicio ListarUsuario, status : " + req.status + " : " + nombreUsuario);
		return resp
	}


//	@RequestMapping(value = "listarBusqueda", method = [RequestMethod.POST])
//	@ResponseBody
//	public ListarBusquedaUsuarioResponse ListarBusquedaUsuario (@RequestBody ListarBusquedaUsuarioRequest req, HttpServletRequest request, HttpServletResponse response){
//		def idUsuario = obtenerIdUsuario(request)
//		def nombreUsuario = obtenerNombreUsuario(request)
//		LOG.info("Entrando a servicio ListarBusquedaUsuario : " + nombreUsuario);
//		def resp =  UsuarioService.ListarBusquedaUsuario(req)
//		LOG.info("Saliendo de servicio ListarBusquedaUsuario, status : " + req.status + " : " + nombreUsuario);
//		return resp
//	}
	

	
//	@RequestMapping(value = "validarPermiso", method = [RequestMethod.POST])
//	@ResponseBody
//	public UsuarioPermisosResponse UsuarioPermisos (@RequestBody UsuarioPermisosRequest req, HttpServletRequest request, HttpServletResponse response){
//		def idUsuario = obtenerIdUsuario(request)
//		def nombreUsuario = obtenerNombreUsuario(request)
//		LOG.info("Entrando a servicio validar permiso : " + nombreUsuario);
//		def resp =  UsuarioService.UsuarioPermisos(req)
//		LOG.info("Saliendo de servicio validar permisos permiso : " + req.token + " : " + nombreUsuario);
//		return resp
//	}
	


}
