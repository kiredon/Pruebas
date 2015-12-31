package mx.com.sagarpa.snics.service.seguridad.impl

import java.util.List;




import mx.com.sagarpa.snics.persistence.dao.DatUsuarioDao
import mx.com.sagarpa.snics.persistence.entities.DatUsuario
import mx.com.sagarpa.snics.service.seguridad.UsuarioService
import mx.com.sagarpa.snics.service.seguridad.permiso.dto.UsuarioPermisosRequest;
import mx.com.sagarpa.snics.service.seguridad.permiso.dto.UsuarioPermisosResponse;
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.ActualizarUsuarioRequest
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.ActualizarUsuarioResponse
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.CrearUsuarioRequest
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.CrearUsuarioResponse
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.ListarUsuarioRequest;
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.ListarUsuarioResponse;
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.ObtenerUsuarioPorIdRequest
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.ObtenerUsuarioPorIdResponse
import mx.com.sagarpa.snics.service.seguridad.vo.UsuarioVo
import mx.com.sagarpa.snics.service.seguridad.vo.UsuarioVoList

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import mx.com.sagarpa.snics.service.ResponseCodes




@Service("UsuarioServiceImpl")
class UsuarioServiceImpl implements UsuarioService {
	private static  Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class)

//	@Autowired
//	LinkRolPermisoDao linkRolPermisoDao
//	@Autowired
//	LinkRolPermisoIdDao linkRolPermisoIdDao
//	@Autowired
//
//	DatDatosMedicoDao datDatosMedicoDao
//	@Autowired
//	CatRolDao catRolDao
	@Autowired
	DatUsuarioDao datUsuarioDao
//	@Autowired
//	DatUnidadJerarquicaDao datUnidadJerarquicaDao

	//	@Transactional
		public CrearUsuarioResponse CrearUsuario(CrearUsuarioRequest request){
			CrearUsuarioResponse response = new CrearUsuarioResponse()
			try{
				def DatUsuario = new DatUsuario()
				DatUsuario Usuario = datUsuarioDao.getByNombreUsuario(request.nombreUsuario)
				if(Usuario==null){
					DatUsuario.setNombre(request.nombre)
					DatUsuario.setStatus(true)
					DatUsuario.setApellidoPaterno(request.apellidoPaterno)
					DatUsuario.setApellidoMaterno(request.apellidoMaterno)
					DatUsuario.setNombreUsuario(request.nombreUsuario)
//					DatUsuario.setContrasena(datUsuarioDao.generarContrasenia(request.nombreUsuario))
					DatUsuario.setContrasena(datUsuarioDao.generarContrasenia(request.contrasena))
					
					
					DatUsuario.setHandheld(request.handheld)
					datUsuarioDao.create(DatUsuario)
					response.setUsuarioVo(new UsuarioVo(handheld:DatUsuario.handheld,idUsuario:DatUsuario.idUsuario,nombreUsuario:DatUsuario.nombreUsuario,nombre:DatUsuario.nombre,apellidoPaterno:DatUsuario.apellidoPaterno,apellidoMaterno:DatUsuario.apellidoMaterno,contrasena:DatUsuario.contrasena,status: DatUsuario.status))
					response.setResponseCode(ResponseCodes.OK.desc)
					return response;
	
				}
				else{
					logger.error("Error al actualizar Usuario: nombre en uso");
					return new CrearUsuarioResponse(responseCode : ResponseCodes.NAME_ALREADY_EXISTS.desc)
				}
				return response;
			}catch(Exception e){
				logger.error("Error en  CrearUsuario, nombreUsuario:  "+request.nombreUsuario, e.getMessage())
				response.setResponseCode(e.getMessage())
	
			}
		}

	@Transactional
	public ActualizarUsuarioResponse ActualizarUsuario(
			ActualizarUsuarioRequest request) {

		ActualizarUsuarioResponse response = null;
		response = new ActualizarUsuarioResponse()

		try {
//			//TODO: Insertar Usuario
			def DatUsuario = new DatUsuario()
			DatUsuario usuario = datUsuarioDao.findById(request.idUsuario)
//			
			if(datUsuarioDao.validaNombre(request.nombreUsuario)==false||usuario.nombreUsuario.equals(request.nombreUsuario)){
				usuario.nombreUsuario=request.nombreUsuario
				usuario.nombre=request.nombre
				usuario.apellidoPaterno=request.apellidoPaterno
				usuario.apellidoMaterno=request.apellidoMaterno
				usuario.handheld=request.handheld
				response.setUsuarioVo(new UsuarioVo(idUsuario:usuario.getIdUsuario()))
				//datUsuarioDao.update(usuario)
				response.setResponseCode(ResponseCodes.OK.desc)
				return response
			}else{
				logger.error("Error al actualizar Usuario: nombre en uso");
				response.setResponseCode(ResponseCodes.NAME_ALREADY_EXISTS.desc)
				return response;
			}
		}
		catch(Exception e) {
			logger.error("Error al actualizar usuario: " + e.getMessage());
			response.setResponseCode(e.getMessage())
		}
		finally {
			return response;
		}

	}

//
	@Transactional
	public ObtenerUsuarioPorIdResponse ObtenerUsuarioPorId(ObtenerUsuarioPorIdRequest request) {
		ObtenerUsuarioPorIdResponse response = new ObtenerUsuarioPorIdResponse()
		try{
			DatUsuario Usuario = datUsuarioDao.findById(request.idUsuario)
			response.setUsuarioVo(new UsuarioVo(idUsuario:Usuario.idUsuario,nombreUsuario:Usuario.nombreUsuario,nombre:Usuario.nombre,apellidoPaterno:Usuario.apellidoPaterno,apellidoMaterno:Usuario.apellidoMaterno,status:Usuario.status,contrasena:Usuario.contrasena,handheld:Usuario.handheld))
			response.setResponseCode(ResponseCodes.OK.desc)
			return response;
		}catch(Exception e){
			logger.error("Error ObtenerUsuarioPorId, idUsuario:  "+request.idUsuario, e.getMessage())
			response.setResponseCode(e.getMessage())
		}
	}
//	@Transactional
//	public ObtenerUsuarioLoginResponse ObtenerUsuarioLogin(ObtenerUsuarioLoginRequest request,String idUsuario) {
//		ObtenerUsuarioLoginResponse response = new ObtenerUsuarioLoginResponse()
//		try{
//			DatUsuario Usuario = datUsuarioDao.findById(Integer.parseInt(idUsuario))
//			DatUnidadJerarquica unidadJerarquica = datUnidadJerarquicaDao.findById(Usuario.getDatUnidadJerarquica().getIdUnidadJerarquica())
//			response.setUsuarioVo(new UsuarioVo(idRol:Usuario.catRol.idRol,idUsuario:Usuario.idUsuario,nombreUsuario:Usuario.nombreUsuario,nombre:Usuario.nombre,apellidoPaterno:Usuario.apellidoPaterno,apellidoMaterno:Usuario.apellidoMaterno,status:Usuario.status,contrasena:Usuario.contrasena,correoElectronico:Usuario.correoElectronico, idUnidadJerarquica: unidadJerarquica.getIdUnidadJerarquica()))
//			response.setResponseCode(ResponseCodes.OK.desc)
//			return response;
//		}catch(Exception e){
//			logger.error("Error ObtenerUsuarioPorId, idUsuario:  "+Integer.parseInt(idUsuario), e.getMessage())
//			response.setResponseCode(e.getMessage())
//		}
//	}
//
//	@Transactional
//	public CambiarEstadoUsuarioResponse CambiarEstadoUsuario(CambiarEstadoUsuarioRequest request) {
//		CambiarEstadoUsuarioResponse response = new CambiarEstadoUsuarioResponse()
//		try{
//
//			DatUsuario Usuario = datUsuarioDao.findById(request.idUsuario)
//			Usuario.status=request.status
//			response.setUsuarioVo(new UsuarioVo(idRol:Usuario.catRol.idRol,idUsuario:Usuario.idUsuario,nombreUsuario:Usuario.nombreUsuario,nombre:Usuario.nombre,apellidoPaterno:Usuario.apellidoPaterno,apellidoMaterno:Usuario.apellidoMaterno,status:Usuario.status,contrasena:Usuario.contrasena,correoElectronico:Usuario.correoElectronico))
//			datUsuarioDao.update(Usuario)
//			response.setResponseCode(ResponseCodes.OK.desc)
//			return response;
//		}catch (Exception e){
//			logger.error("Error en CambiarEstadoUsuario, idUsuario:  "+request.idUsuario, e.getMessage())
//			response.setResponseCode(e.getMessage())
//		}
//	}

	@Transactional
	public ListarUsuarioResponse ListarUsuario(ListarUsuarioRequest request) {
		ListarUsuarioResponse response = null;
		try{

			response = new ListarUsuarioResponse()
			response.total = datUsuarioDao.getTotalByStatus(request.status)
			List<DatUsuario> listUsuario = datUsuarioDao.getListByStatus(request.status,request.pagina,request.tamanio)
			List<UsuarioVo> listUsuarioVo = new ArrayList<UsuarioVo>()


			if(listUsuario.empty){
				response.setResponseCode(ResponseCodes.EMPTY_LIST.desc)
				return response
			}
			listUsuario.each(){
				UsuarioVo usuarioVo = new UsuarioVo(
						nombreUsuario: it.nombreUsuario,
						nombre:it.nombre,
						apellidoPaterno:it.apellidoPaterno,
						apellidoMaterno:it.apellidoMaterno,
						idUsuario:it.idUsuario,
						status:it.status,
						contrasena:it.contrasena,
						hanheld:it.handheld
						)

//				if(it.datUnidadJerarquica != null){
//					usuarioVo.idUnidadJerarquica = it.datUnidadJerarquica.idUnidadJerarquica
//				}else{
//					usuarioVo.idUnidadJerarquica = 0
//				}
				listUsuarioVo.add(usuarioVo)
			}
			response.setUsuarioVoList(new UsuarioVoList(ListUsuario: listUsuarioVo))
			response.setResponseCode(ResponseCodes.OK.desc)
			return response;
		}catch (Exception e){

			logger.error("Error en ListarUsuario, status:  "+request.status + " - " + e.getMessage())
			response.setResponseCode(e.getMessage())
		}
	}
//	@Transactional
//	public ListarBusquedaUsuarioResponse ListarBusquedaUsuario(ListarBusquedaUsuarioRequest request) {
//		ListarBusquedaUsuarioResponse response = null;
//		try{
//
//			response = new ListarBusquedaUsuarioResponse()
//			response.total = datUsuarioDao.getTotalByStatusNombre(request.nombre,request.status)
//			List<DatUsuario> listUsuario = datUsuarioDao.getListByNombre(request.nombre,request.status,request.pagina,request.tamanio)
//			List<UsuarioVo> listUsuarioVo = new ArrayList<UsuarioVo>()
//			if(listUsuario.empty){
//				response.setResponseCode(ResponseCodes.EMPTY_LIST.desc)
//				return response
//			}
//			listUsuario.each(){
//				UsuarioVo usuarioVo = new UsuarioVo(
//						nombreUsuario: it.nombreUsuario,
//						nombre:it.nombre,
//						apellidoPaterno:it.apellidoPaterno,
//						apellidoMaterno:it.apellidoMaterno,
//						correoElectronico:it.correoElectronico,
//						idRol:it.catRol.idRol,
//						idUsuario:it.idUsuario,
//						status:it.status,
//						//contrasena:it.contrasena,
//						nombreRol:it.getCatRol().getNombreRol()
//						)
//
//				if(it.datUnidadJerarquica != null){
//					usuarioVo.idUnidadJerarquica = it.datUnidadJerarquica.idUnidadJerarquica
//				}else{
//					usuarioVo.idUnidadJerarquica = 0
//				}
//				listUsuarioVo.add(usuarioVo)
//			}
//			response.setUsuarioVoList(new UsuarioVoList(ListUsuario: listUsuarioVo))
//			response.setResponseCode(ResponseCodes.OK.desc)
//			return response;
//		}catch (Exception e){
//			e.printStackTrace()
//			logger.error("Error en Listar Busqueda de Usuario, status:  "+request.status, e.getMessage())
//			response.setResponseCode(e.getMessage())
//		}
//	}
//	@Transactional()
//	public CambiarContrasenaUsuarioResponse CambiarContrasena(CambiarContrasenaUsuarioRequest request) {
//		try{
//			CambiarContrasenaUsuarioResponse response = new CambiarContrasenaUsuarioResponse()
//			DatUsuario Usuario = datUsuarioDao.findById(request.idUsuario)
//			//DatUsuario Usuario = datUsuarioDao.getListByIdUsuario(request.idUsuario)
//			//		DatUsuario Usuario = datUsuarioDao.getByPass(datUsuarioDao.cifrarContrasenia(request.contrasena))
//			if(Usuario!=null){
//				Usuario.contrasena=datUsuarioDao.cifrarContrasenia(request.nuevaContrasena)
//				response.setUsuarioVo(new UsuarioVo(idRol:Usuario.catRol.idRol,idUsuario:Usuario.idUsuario,nombreUsuario:Usuario.nombreUsuario,nombre:Usuario.nombre,apellidoPaterno:Usuario.apellidoPaterno,apellidoMaterno:Usuario.apellidoMaterno,status:Usuario.status,contrasena:Usuario.contrasena,correoElectronico:Usuario.correoElectronico))
//				datUsuarioDao.update(Usuario)
//			}
//			response.setResponseCode(ResponseCodes.OK.desc)
//			return response;
//		}catch(Exception e){
//			e.printStackTrace()
//			logger.error("Error CambiarContrasenaUsuario, idUsuario:  "+request.idUsuario, e.getMessage())
//		}
//	}
//	public RestablecerContrasenaUsuarioResponse RestablecerContrasena(RestablecerContrasenaUsuarioRequest request) {
//		try{
//			RestablecerContrasenaUsuarioResponse response = new RestablecerContrasenaUsuarioResponse()
//			DatUsuario Usuario = datUsuarioDao.findById(request.idUsuario)
//			Usuario.setContrasena(datUsuarioDao.generarContrasenia(Usuario.nombreUsuario))
//			response.setUsuarioVo(new UsuarioVo(idRol:Usuario.catRol.idRol,idUsuario:Usuario.idUsuario,nombreUsuario:Usuario.nombreUsuario,nombre:Usuario.nombre,apellidoPaterno:Usuario.apellidoPaterno,apellidoMaterno:Usuario.apellidoMaterno,status:Usuario.status,contrasena:Usuario.contrasena,correoElectronico:Usuario.correoElectronico))
//			datUsuarioDao.update(Usuario)
//			return response;
//		}catch(Exception e){
//			logger.error("Error en RestablecerContrasenaUsuario, idUsuario:  "+request.idUsuario, e.getMessage())
//		}
//	}
//
//
//	@Transactional
//	public AsociarUsuarioUnidadResponse AsociarUsuarioUnidad(AsociarUsuarioUnidadRequest request){
//		AsociarUsuarioUnidadResponse response = new AsociarUsuarioUnidadResponse()
//		try{
//
//			DatUnidadJerarquica unidadJerarquica = datUnidadJerarquicaDao.findById(request.idUnidad)
//			DatUsuario usuario = datUsuarioDao.findById(request.idUsuario)
//
//			if(unidadJerarquica == null || usuario == null){
//				response.setResponseCode(ResponseCodes.NOT_FOUND.desc)
//				return response
//			}
//
//			usuario.setDatUnidadJerarquica(unidadJerarquica)
//			datUsuarioDao.update(usuario)
//			response.setResponseCode(ResponseCodes.OK.desc)
//
//		}catch(Exception e){
//			logger.error("Error al asociar unidad con Usuario - " + e.getMessage())
//			response.setResponseCode(e.getMessage())
//		}
//		return response
//	}
	@Transactional
	public UsuarioPermisosResponse  UsuarioPermisos( UsuarioPermisosRequest request){
		 UsuarioPermisosResponse response = new  UsuarioPermisosResponse()
		
		try{
//manejo del token
			def token=request.token
			Integer idUsuario=Integer.parseInt(token)
			//
			Boolean autorizacion=false;
			DatUsuario usuario = datUsuarioDao.findById(idUsuario)
//			int idUsuarioRol=usuario.getCatRol().idRol;
//			List<LinkRolPermiso> listLinkRolPermiso = linkRolPermisoDao.getByRol(idUsuarioRol)
//			listLinkRolPermiso.each(){
//				if(it.catPermiso.funcionUrl.equals(request.ruta)){
//					autorizacion=true;
//					response.token=token
//					response.Autorizacion=autorizacion;
//					response.setResponseCode(ResponseCodes.OK.desc);
//					return response;
//				}
//			}
			if(autorizacion==false){
			response.token=token
			response.Autorizacion=autorizacion;
			response.setResponseCode(ResponseCodes.FORBIDDEN.desc);
			logger.info("Acceso denegado al usuario id " +idUsuario+", para la ruta: "+request.ruta )
			}
			//Boolean autorizacion = datUsuarioDao.validaPermiso(request.ruta,idUsuario);
			

		}catch(Exception e){
			logger.error("Error al obtener los permisos del usuario - " + e.getMessage())
			response.setResponseCode(e.getMessage())
			response.setResponseCode(ResponseCodes.ERROR.desc);
			
		}
		return response
	}
//	public FirmarPrescripcion(){
//		
//	}
//	
//	@Transactional
//	@Override
//	public ObtenerDatosMedicoResponse obtenerDatosMedico(ObtenerDatosMedicoRequest request) {
//		// TODO Auto-generated method stub
//		ObtenerDatosMedicoResponse response = new ObtenerDatosMedicoResponse()
//		try {
//			def datDatosMedico = datDatosMedicoDao.findById(request.getIdUsuario())
//			
//			if(datDatosMedico != null) {
//				response.setDatosMedico(new DatosMedicoVo(idUsuario: datDatosMedico.getIdUsuario(), nombreInstitucion: datDatosMedico.getNombreInstitucion(), cedula: datDatosMedico.getCedula(), especialidad: datDatosMedico.getEspecialidad()))
//				response.setResponseCode(ResponseCodes.OK.desc)
//			}
//			else {
//				response.setResponseCode(ResponseCodes.NOT_FOUND.desc)
//			}
//		}
//		catch(Exception e) {
//			logger.error("Error al obtener DatosMedico: " + request.getIdUsuario(), e.getMessage())
//			response.setResponseCode(e.getMessage())
//		}
//		finally {
//			return response
//		}
//	}
//	public void obtenerHijas(Integer id){
//		acumuladorArbol.add(id)
//		List<DatUnidadJerarquica> unidadesHijas = datUnidadJerarquicaDao.getListIdUnidadJerarquicaPadre(id,false)
//		unidadesHijas.each {
//			obtenerHijas(it.idUnidadJerarquica)
//		
//		}
//	}
//	



//	@Override
//	public ListarUsuarioResponse ListarUsuario(ListarUsuarioRequest request) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
