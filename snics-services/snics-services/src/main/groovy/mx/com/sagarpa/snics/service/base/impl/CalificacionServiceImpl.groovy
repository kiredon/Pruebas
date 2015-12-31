package mx.com.sagarpa.snics.service.base.impl



import mx.com.sagarpa.snics.service.base.CalificacionService
import mx.com.sagarpa.snics.persistence.dao.CatCalificacionDao
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service("CalificacionServiceImpl")
class CalificacionServiceImpl implements CalificacionService {

	@Autowired
	CatCalificacionDao catCalificacionDao
	
	Logger log = LoggerFactory.getLogger(this.class);
}
	
//	@Override
//	@Transactional
//	public ListarCalificacionResponse ListarEscolaridadPorId(
//			ListarEscolaridadPorIdRequest request,String idUsuario) {
//		ObtenerEscolaridadPorIdResponse response = null;
//		try {
//		response = new ObtenerEscolaridadPorIdResponse()
//		CatEscolaridad escolaridad = catEscolaridadDao.findById(request.getIdEscolaridad())
//		if(escolaridad == null){
//			response.setResponseCode(ResponseCodes.NOT_FOUND.desc)
//			return response
//		}
//		response.setEscolaridadVo(new EscolaridadVo(idEscolaridad:escolaridad.getIdEscolaridad(),nombreEscolaridad:escolaridad.getNombreEscolaridad(),fechaCreacion:escolaridad.getFechaCreacion(),fechaEdicion:escolaridad.getFechaEdicion(),status:escolaridad.isStatus()))
//		response.setResponseCode(ResponseCodes.OK.desc)
//		}
//		catch(Exception e) {
//			log.error("Error al obtener escolaridad por id: " + e.getMessage());
//			response.setResponseCode(e.getMessage())
//		}
//		finally {
//			return response;
//		}
//	}
//	
//	@Autowired
//	DatUsuarioDao datUsuarioDao
//	
//	@Override
//	@Transactional
//	public InsertarEscolaridadResponse InsertarEscolaridad(
//			InsertarEscolaridadRequest request,String idUsuario) {
//			InsertarEscolaridadResponse response = null;
//			response = new InsertarEscolaridadResponse()
//		if(catEscolaridadDao.validaNombre(request.nombreEscolaridad)==false){
//		
//		try {
//				
//			int idUsuarioInt = Integer.parseInt(idUsuario)
//			def DatUsuario=datUsuarioDao.findById(idUsuarioInt)
//			def CatEscolaridad = new CatEscolaridad()	
//					
//			CatEscolaridad.setNombreEscolaridad(request.getNombreEscolaridad())
//			CatEscolaridad.setStatus(true)
//			CatEscolaridad.setDatUsuarioByIdUsuarioCreacion(DatUsuario)
//			CatEscolaridad.setDatUsuarioByIdUsuarioEdicion(DatUsuario)
//			CatEscolaridad.setFechaEdicion(new java.util.Date())
//			CatEscolaridad.setFechaCreacion(new java.util.Date())
//				
//			response.setEscolaridadVo(new EscolaridadVo(idEscolaridad:CatEscolaridad.getIdEscolaridad(),nombreEscolaridad:CatEscolaridad.getNombreEscolaridad(),fechaCreacion:CatEscolaridad.getFechaCreacion(),fechaEdicion:CatEscolaridad.getFechaEdicion(),status:CatEscolaridad.isStatus()));
//			catEscolaridadDao.create(CatEscolaridad)
//			response.setResponseCode(ResponseCodes.OK.desc)
//		}
//		catch(Exception e) {
//			log.error("Error al insertar escolaridad: " + e.getMessage());
//			
//			response.setResponseCode(e.getMessage())
//		}
//		finally {
//			return response;
//		}
//		}else
//			{
//				log.error("Error al insertar escolaridad: nombre en uso");
//				response.setResponseCode(ResponseCodes.NAME_ALREADY_EXISTS.desc)
//				return response;
//			}
//	}
//
//	@Transactional
//	public CambiarEstadoEscolaridadResponse CambiarEstadoEscolaridad(
//			CambiarEstadoEscolaridadRequest request,String idUsuario) {
//		CambiarEstadoEscolaridadResponse response = null;
//		try {
//			response = new CambiarEstadoEscolaridadResponse()
//			
//			int idUsuarioInt = Integer.parseInt(idUsuario)
//			def DatUsuario=datUsuarioDao.findById(idUsuarioInt)
//			
//			CatEscolaridad escolaridad = catEscolaridadDao.findById(request.idEscolaridad)
//			escolaridad.status=request.status
//			escolaridad.setDatUsuarioByIdUsuarioEdicion(DatUsuario)
//			escolaridad.setFechaEdicion(new Date())
//			response.setEscolaridadVo(new EscolaridadVo(idEscolaridad:escolaridad.getIdEscolaridad(),nombreEscolaridad:escolaridad.getNombreEscolaridad(),fechaCreacion:escolaridad.getFechaCreacion(),fechaEdicion:escolaridad.getFechaEdicion(),status:escolaridad.isStatus()));
//			catEscolaridadDao.update(escolaridad)
//			
//			response.setResponseCode(ResponseCodes.OK.desc)
//		}
//		catch(Exception e) {
//			log.error("Error al cambiar escolaridad: " + e.getMessage());
//			response.setResponseCode(e.getMessage())
//		}
//		finally {
//			return response;
//		}
//	}
//			
//	@Transactional
//	public ListarEscolaridadResponse ListarEscolaridad(
//			ListarEscolaridadRequest request,String idUsuario) {
//		ListarEscolaridadResponse response = null;
//		try {
//			response = new ListarEscolaridadResponse()
//			response.total = catEscolaridadDao.getTotalByStatus(request.status)
//			List<CatEscolaridad> ListEscolaridad = catEscolaridadDao.getListByStatus(request.status,request.pagina,request.tamanio)
//			
//			if(ListEscolaridad.empty){
//				response.setResponseCode(ResponseCodes.EMPTY_LIST.desc)
//				return response
//			}
//			List<EscolaridadVo> listEscolaridadVo = new ArrayList<EscolaridadVo>();
//			ListEscolaridad.each() {
//				EscolaridadVo escolaridadVo = new EscolaridadVo(
//					idEscolaridad: it.getIdEscolaridad(),
//					nombreEscolaridad: it.getNombreEscolaridad(),
//					fechaCreacion:it.getFechaCreacion(),
//					fechaEdicion: it.getFechaEdicion(),
//					status:it.isStatus());
//				listEscolaridadVo.add(escolaridadVo);
//			}
//			response.setEscolaridadVoList(new EscolaridadVoList(ListEscolaridad: listEscolaridadVo));
//			
//			response.setResponseCode(ResponseCodes.OK.desc)
//		}
//		catch(Exception e) {
//			log.error("Error al listar escolaridade(s): " + e.getMessage());
//			
//			response.setResponseCode(e.getMessage())
//		}
//		finally {
//			return response;
//		}
//	}
//			
//	@Transactional
//	public ActualizarEscolaridadResponse ActualizarEscolaridad(
//			ActualizarEscolaridadRequest request,String idUsuario) {
//		ActualizarEscolaridadResponse response = null;
//		response = new ActualizarEscolaridadResponse()
//		if(catEscolaridadDao.validaNombre(request.nombreEscolaridad)==false){
//		try {
//			
//			
//			int idUsuarioInt = Integer.parseInt(idUsuario)
//			
//			def DatUsuario=datUsuarioDao.findById(idUsuarioInt)
//			
//			def CatEscolaridad = new CatEscolaridad()
//			
//			CatEscolaridad escolaridad = catEscolaridadDao.findById(request.idEscolaridad)
//			escolaridad.setFechaEdicion(new java.util.Date())
//			escolaridad.status=request.getStatus()
//			escolaridad.setDatUsuarioByIdUsuarioEdicion(DatUsuario)
//			escolaridad.nombreEscolaridad=request.nombreEscolaridad
//			response.setEscolaridadVo(new EscolaridadVo(idEscolaridad:escolaridad.getIdEscolaridad(),nombreEscolaridad:escolaridad.getNombreEscolaridad(),fechaCreacion:escolaridad.getFechaCreacion(),fechaEdicion:escolaridad.getFechaEdicion(),status:escolaridad.isStatus()))
//			catEscolaridadDao.update(escolaridad)
//			response.setResponseCode(ResponseCodes.OK.desc)
//		}
//		catch(Exception e) {
//			log.error("Error al actualizar escolaridad: " + e.getMessage());
//			response.setResponseCode(e.getMessage())
//		}
//		finally {
//			return response;
//		}
//	}else{
//	log.error("Error al actualizar escolaridad: nombre en uso");
//	response.setResponseCode(ResponseCodes.NAME_ALREADY_EXISTS.desc)
//	return response;
//	
//	}
//	
//	}
		
