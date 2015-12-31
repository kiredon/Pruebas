package mx.com.sagarpa.snics.service.seguridad.impl

import java.security.InvalidKeyException;
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher
import javax.crypto.IllegalBlockSizeException
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec













import mx.com.sagarpa.snics.persistence.dao.CatConfigDao
import mx.com.sagarpa.snics.persistence.dao.DatSnowflakeDao
import mx.com.sagarpa.snics.persistence.dao.DatUsuarioDao
import mx.com.sagarpa.snics.persistence.dao.LinkRolUsuarioDao
import mx.com.sagarpa.snics.persistence.entities.DatSnowflake
import mx.com.sagarpa.snics.persistence.entities.DatUsuario
import mx.com.sagarpa.snics.persistence.entities.LinkRolUsuario
import mx.com.sagarpa.snics.service.seguridad.SnowflakeService
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.LoginRequest
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.LoginResponse
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.LogoutRequest
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.LogoutResponse
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.ObtenerObjetoAutorizacionResponse
import mx.com.sagarpa.snics.service.seguridad.vo.FuncionAutorizacionVo
import mx.com.sagarpa.snics.service.seguridad.vo.ObjetoAutorizacionVo
import mx.com.sagarpa.snics.service.seguridad.vo.PermisoAutorizacionVo
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.beans.factory.annotation.Autowired

import java.util.List;
import java.util.Stack;
@Service("SnowflakeServiceImpl")
class SnowflakeServiceImpl implements SnowflakeService {
	public List<Integer> acumuladorArbol=[];
	private final String PASSPHRASE = "SNOWFLAKE_PASSPHRASE_TO_CYPHER"
	private final String TIMEOUT_KEY = "TIMEOUT_SESSION"

	Logger LOG = LoggerFactory.getLogger(this.class)

	@Autowired
	DatUsuarioDao datUsuarioDao

	@Autowired
	CatConfigDao catConfigDao

	@Autowired
	DatSnowflakeDao datSnowflakeDao
	@Autowired
	LinkRolUsuarioDao linkRolUsuarioDao
	
	
	@Transactional
	public LoginResponse Login(LoginRequest request) {
		LoginResponse response = new LoginResponse();
		try{
			request.setContrasenia(datUsuarioDao.cifrarContrasenia(request.getContrasenia()))
			DatUsuario usuario = datUsuarioDao.getByNombreUsuarioContrasenia(request.usuario, request.getContrasenia())
			response = new LoginResponse();
			
			//Login incorrecto no regresa snowflake
			if(usuario == null){
				LOG.info("Nombre usuario / contrasenia incorrecta: " + request.usuario);
				response.setSnowflake("0")
				return response
			}
			
			//Usuario desactivado no regresa snowflake
			if(!usuario.status){
				
				LOG.info("Usuario Desactivado: " + request.usuario);
				response.setSnowflake("0")
				return response
			}
			
			//int min = Integer.parseInt(catConfigDao.getConfigByName(TIMEOUT_KEY))
			Date now = new Date()
		//	long caducidad = now.getTime() + (1000*60*min)
			long caducidad = now.getTime() + (1000*60)
			
			//Borra todos los snowflakes caducados para el usuario
			datSnowflakeDao.borrarSnowflakeCaducados(usuario.idUsuario)
			
			//Si intenta entrar desde una IP o un explorador diferente no loguea
			if(!datSnowflakeDao.validarSesion(usuario.idUsuario, request.getIpAddress(), request.getUser_agent())){
				response.setSnowflake("SesionAbierta")
				return response
			}
			
			DatSnowflake snowflakeAnterior = datSnowflakeDao.obtieneSnowflake(usuario.idUsuario, request.getIpAddress(), request.getUser_agent())
			
			if( snowflakeAnterior != null){
				LOG.info("Sesion ya abierta, regresando el mismo Snowflake")
				snowflakeAnterior.setFechaCaducidad(new Date(caducidad))
				datSnowflakeDao.update(snowflakeAnterior)
				response.setSnowflake(snowflakeAnterior.getSnowflake())
				return response
			}			
			String nakedSnowflake = 
					UUID.randomUUID().toString() + "||" +
					"SNOWFLAKE_START||" +
					usuario.getIdUsuario() + "||" +
					usuario.getNombreUsuario() + "||" +
					request.getIpAddress() + "||" +
					request.getUser_agent() + "||" +
					"SNOWFLAKE_END||" +					
					UUID.randomUUID().toString()


			String AESSnowflake = cifrarSnowflake(nakedSnowflake)
			LOG.debug("SNOWFLAKE : " + nakedSnowflake)
			
			DatSnowflake snowflake = new DatSnowflake();
			snowflake.setSnowflake(AESSnowflake)
			snowflake.setFechaCreacion(now)
			snowflake.setFechaCaducidad(new Date(caducidad))
			snowflake.setDatUsuario(usuario)
			snowflake.setOrigen(request.getIpAddress())
			snowflake.setUserAgent(request.getUser_agent())

			datSnowflakeDao.create(snowflake)

			response.setSnowflake(AESSnowflake)
		}catch(Exception ex){
			LOG.error("Error al generar el snowflake: " + ex.getMessage())
			response = null
			ex.printStackTrace()
		}
		return response;
	}

	@Transactional
	public boolean validaServicio(LoginRequest request, String snowflake,Boolean ajustaTiempo){
		String nakedSnowflake
		try{
		 nakedSnowflake = this.descifrarSnowflake(snowflake)
		}catch(Exception e){
		LOG.error("Snowflake indecifrable")
		return false
		}
		String [] snowflakeParam = nakedSnowflake.split("\\|\\|")
		if(snowflakeParam.length != 8){
			LOG.info("Snowflake malformado")
			return false
		}
		String user_agent = request.getUser_agent()
		if(!user_agent.equals(snowflakeParam[5])){
			LOG.info("Enviado desde un explorador Diferente, impersonado el snowflake con el usuario: " + snowflakeParam[3])
			return false
		}
		String origen = request.getIpAddress()
		if(!origen.equals(snowflakeParam[4])){
			
			LOG.info("Enviado desde una IP diferente: " + origen + " : " + snowflakeParam[4] + ", impersonado el snowflake con el usuario: " + snowflakeParam[3])
			return false
		}
		
		DatSnowflake datSnowflake = datSnowflakeDao.validarSnowflakeServicio(snowflake, origen, user_agent)
		if(datSnowflake != null){
//			int min = Integer.parseInt(catConfigDao.getConfigByName(TIMEOUT_KEY))
			Date now = new Date()
			if(ajustaTiempo==true){
//				long caducidad = now.getTime() + (1000*60*min)
				long caducidad = now.getTime() + (1000*60)
				
				datSnowflake.setFechaCaducidad(new Date(caducidad))
			}
			datSnowflakeDao.update(datSnowflake)
			return true
		}
		return false		
	}
	
	public String obtenerIdUsuario(String snowflake){
		String nakedSnowflake = this.descifrarSnowflake(snowflake)
		String [] snowflakeParam = nakedSnowflake.split("\\|\\|")
		
		return snowflakeParam[2]
	}

	public String obtenerNombreUsuario(String snowflake){
		String nakedSnowflake = this.descifrarSnowflake(snowflake)
		String [] snowflakeParam = nakedSnowflake.split("\\|\\|")
		
		return snowflakeParam[3]
	}

	private String cifrarSnowflake (String nakedSnowflake){
		MessageDigest md = MessageDigest.getInstance("SHA-256")

		md.update(PASSPHRASE.getBytes())
		byte[] sha256 = md.digest()

		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
		final SecretKeySpec secretkey = new SecretKeySpec(sha256,"AES")
		cipher.init(Cipher.ENCRYPT_MODE,secretkey)
		final String encryptedSnowflake = org.apache.commons.codec.binary.Base64.encodeBase64String(cipher.doFinal(nakedSnowflake.getBytes()))
		return encryptedSnowflake;
	}

	private String descifrarSnowflake (String snowflake) throws IllegalBlockSizeException{
		MessageDigest md = MessageDigest.getInstance("SHA-256")

		md.update(PASSPHRASE.getBytes())
		byte[] sha256 = md.digest()

		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
		final SecretKeySpec secretkey = new SecretKeySpec(sha256,"AES")
		cipher.init(Cipher.DECRYPT_MODE,secretkey)
		final String nakedSnowflake = new String(cipher.doFinal(org.apache.commons.codec.binary.Base64.decodeBase64(snowflake)))

		return nakedSnowflake
	}

	@Transactional
	public boolean validaServicioAutorizado(String authHeader,String MD5){
		String nakedSign = new String(org.apache.commons.codec.binary.Base64.decodeBase64(authHeader));
		
		LOG.info("nakedSign: " + nakedSign)
		String [] signSplit = nakedSign.split("\\|\\|");
		
		String secretKey = catConfigDao.getConfigByName(signSplit[0]);
		String nakedSignCalculate = "SIGNED_REQUEST||"	+ MD5 + "||SIGNED_REQUEST";
		String calculatedSign = this.hmacSha256Sign(nakedSignCalculate, secretKey);
		
		if(calculatedSign.equals(signSplit[1])){
			return true;
		}	
		return false;
	}
	
	
	private String hmacSha256Sign (String nakedSign, String secretKey){
		String sign = "";
		try {
			Mac hmac_sha256 = Mac.getInstance("HmacSHA256");
			SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(),"HmacSHA256");
			hmac_sha256.init(key);
			sign = Base64.encodeBase64String(hmac_sha256.doFinal(nakedSign.getBytes()));
		} catch (NoSuchAlgorithmException | InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sign;
	}

	@Transactional
	public ObtenerObjetoAutorizacionResponse obtenerObjetoAutorizacion(String snowflake) {
		ObtenerObjetoAutorizacionResponse response = new ObtenerObjetoAutorizacionResponse()
		
		String idUsuarioStr = obtenerIdUsuario(snowflake)
		int idUsuario = Integer.parseInt(idUsuarioStr)
		
		response.funciones = new ArrayList<FuncionAutorizacionVo>()
		response.permisos = new ArrayList<PermisoAutorizacionVo>()
		
		DatUsuario usuario = datUsuarioDao.getListByIdUsuario(idUsuario)
		println(usuario.idUsuario);
		
		List<LinkRolUsuario> RolUsuario1=linkRolUsuarioDao.getByUsuario(usuario.idUsuario);
	println(RolUsuario1.size())
		Integer[] roles;
		String[] nombresRol
		if(!(RolUsuario1.isEmpty())){
			roles=new Integer[RolUsuario1.size()]
			nombresRol=new Integer[RolUsuario1.size()]
			int cont=0;
			RolUsuario1.each {
				println(it.catRol.nombreRol)
				roles[cont]=it.catRol.idRol
				nombresRol[cont]=it.catRol.nombreRol
				cont++
			}
		}
		ObjetoAutorizacionVo objetoAutorizacion = new ObjetoAutorizacionVo(
			idUsuario: usuario.idUsuario,
			idRol: roles,
			nombreRol: nombresRol,
			nombreUsuario: usuario.nombreUsuario,
			nombreCompleto: usuario.nombre + " " + usuario.apellidoPaterno + " " + usuario.apellidoMaterno,
			);		
		
//		if(usuario.datUnidadJerarquica != null){
//			acumuladorArbol=[];
//			obtenerHijas(usuario.datUnidadJerarquica.idUnidadJerarquica)
//			objetoAutorizacion.idsUnidadesJerarquicasUsuario=acumuladorArbol
//			objetoAutorizacion.idUnidadJerarquica =usuario.datUnidadJerarquica.idUnidadJerarquica
//			objetoAutorizacion.nombreUnidadJerarquica = usuario.datUnidadJerarquica.nombre
//			objetoAutorizacion.pathUnidadJerarquica = ""
//			
//			List<DatUnidadJerarquica> lista = datUnidadJerarquicaDao.getPathListUnidadJerarquica(objetoAutorizacion.idUnidadJerarquica)
//			
//			Collections.reverse(lista)
//			lista.each {
//
//				objetoAutorizacion.pathUnidadJerarquica = objetoAutorizacion.pathUnidadJerarquica + it.nombre + ">"
//			}
//			objetoAutorizacion.pathUnidadJerarquica = objetoAutorizacion.pathUnidadJerarquica.substring(0, objetoAutorizacion.pathUnidadJerarquica.length()-1);
//			
//		}
//		def datUnidadJerarquica=datUnidadJerarquicaDao.findById(1)
//		objetoAutorizacion.nombreUnidadJerarquicaHospital=datUnidadJerarquica.getNombre();
		response.objetoAutorizacion = objetoAutorizacion
		
		 List<LinkRolUsuario> RolUsuario=linkRolUsuarioDao.getByUsuario(usuario.idUsuario);
		if(RolUsuario!=null){
			RolUsuario.each {
				it.catRol.linkRolPermisos.each {
					PermisoAutorizacionVo permiso = new PermisoAutorizacionVo(
							nombrePermiso: it.catPermiso.nombrePermiso,
							urlPermiso: it.catPermiso.funcionUrl,
							idPermiso: it.catPermiso.idPermiso
					)
					println(permiso.nombrePermiso)
					response.permisos.add(permiso)
					it.catPermiso.catFuncions.each {
						FuncionAutorizacionVo funcion = new FuncionAutorizacionVo(
								nombreFuncion: it.nombreFuncion,
								urlFuncion: it.urlFuncion,
								idPermiso: it.catPermiso.idPermiso,
								idFuncion: it.idFuncion
		
							)
						println(funcion.nombreFuncion)
						response.funciones.add(funcion)
					}
				}
			}
		}
		
//		usuario.catRol.linkRolPermisos.each {
//			PermisoAutorizacionVo permiso = new PermisoAutorizacionVo(
//					nombrePermiso: it.catPermiso.nombrePermiso,
//					urlPermiso: it.catPermiso.funcionUrl,
//					idPermiso: it.catPermiso.idPermiso
//				)
//			response.permisos.add(permiso)
//			it.catPermiso.catFuncions.each {
//				FuncionAutorizacionVo funcion = new FuncionAutorizacionVo(
//						nombreFuncion: it.nombreFuncion,
//						urlFuncion: it.urlFuncion,
//						idPermiso: it.catPermiso.idPermiso,
//						idFuncion: it.idFuncion
//						
//					) 
//				response.funciones.add(funcion)
//			}
//		}
		
		return response
	}
	
	@Transactional
	public LogoutResponse logout(LogoutRequest request) {
		LogoutResponse resp = new LogoutResponse();
		
		String idUsuarioStr = this.obtenerIdUsuario(request.snowflake)
		
		int idUsuario = Integer.parseInt(idUsuarioStr)
		
		datSnowflakeDao.borraSnowflake(idUsuario)
	}
//	public void obtenerHijas(Integer id){
//		acumuladorArbol.add(id)
//		List<DatUnidadJerarquica> unidadesHijas = datUnidadJerarquicaDao.getListIdUnidadJerarquicaPadre(id,false)
//		unidadesHijas.each {
//			obtenerHijas(it.idUnidadJerarquica)	
//		}
//	}

}
