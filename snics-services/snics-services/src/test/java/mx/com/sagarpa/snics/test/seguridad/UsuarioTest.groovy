package mx.com.sagarpa.snics.test.seguridad



import mx.com.sagarpa.snics.service.seguridad.UsuarioService
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.CrearUsuarioRequest
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.CrearUsuarioResponse
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.ObtenerUsuarioPorIdRequest
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.ObtenerUsuarioPorIdResponse
import org.junit.runner.RunWith
import org.junit.Test
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Profile
import org.springframework.test.context.ContextConfiguration
import org.springframework.transaction.annotation.Transactional
import org.springframework.test.annotation.Rollback



@RunWith(SpringJUnit4ClassRunner.class)
@Profile("STANDALONE")
@ContextConfiguration(locations = [
	"/MainAppCtx.xml"
])

@Transactional
class UsuarioTest {

	static{
		System.setProperty("spring.profiles.active", "STANDALONE");
	}
	@Autowired
	@Qualifier("UsuarioServiceImpl")
	UsuarioService UsuarioService
	
	// @Test
//	@Rollback(false)
//	public void CrearDatosUsuarioTest(){
//		println "Usuario insertar TEST"
//	
//		ActualizarDatosMedicoRequest request = new ActualizarDatosMedicoRequest(idUsuario: 42,cedula:"Test",especialidad:"super" )
//		ActualizarDatosMedicoResponse resp = UsuarioService.ActualizarDatosMedico(request)
//		
//	}
	
	 @Test
	@Rollback(false)
	public void CrearUsuarioTest(){
		println "Usuario insertar TEST"
		Date fechacreacion=new Date()
		CrearUsuarioRequest request = new CrearUsuarioRequest(nombreUsuario: "etorres", contrasena: "zerote", nombre: "emmanuel",apellidoPaterno: "torres" ,apellidoMaterno:"padilla",handheld:true,status:true )
		CrearUsuarioResponse resp = UsuarioService.CrearUsuario(request)
		println resp.UsuarioVo.nombreUsuario
	}
	
//	 @Test
	@Rollback(false)
	public void ObtenerUsuarioPorIdTest(){
		println "Usuario obtener TEST"
		ObtenerUsuarioPorIdRequest request = new ObtenerUsuarioPorIdRequest(idUsuario: 1 )
		ObtenerUsuarioPorIdResponse resp = UsuarioService.ObtenerUsuarioPorId(request)
		println resp.UsuarioVo.idUsuario
		 println resp.UsuarioVo.nombreUsuario
	}
////	@Test
//	@Rollback(false)
//	public void CambiarEstadoUsuarioTest(){
//		println "cambiando Usuario TEST"
//		CambiarEstadoUsuarioRequest request = new CambiarEstadoUsuarioRequest(idUsuario: 1,status: 0 )
//		CambiarEstadoUsuarioResponse resp = UsuarioService.CambiarEstadoUsuario(request)
//	}
////	@Test
//	@Rollback(false)
//	public void listarUsuarioTest(){
//		println "ListarUsuario TEST"
//		ListarUsuarioRequest request = new ListarUsuarioRequest(pagina: 1, tamanio: 10, status: true)
//		ListarUsuarioResponse resp= UsuarioService.ListarUsuario(request)
//		for(int i=0;i<resp.getUsuarioVoList().getListUsuario().size();i++){
//		print resp.getUsuarioVoList().getListUsuario().get(i).nombreUsuario
//		println resp.getUsuarioVoList().getListUsuario().get(i).idUsuario
//		//println resp.getUsuarioVoList().getListUsuario().get(i).catRol.idRol
//		}
//	}
//    //@Test
//	@Rollback(false)
//	public void CambiarContrasenaUsuarioTest(){
//		println "CambiarContrasenaUsuario TEST"
//		CambiarContrasenaUsuarioRequest request = new CambiarContrasenaUsuarioRequest( idUsuario:10,contrasena:"1431911809768testtt0.8482184214921668",nuevaContrasena:"eckxo33")
//		CambiarContrasenaUsuarioResponse resp= UsuarioService.CambiarContrasena(request)	
//	}
//	//@Test
//	@Rollback(false)
//	public void RestablecerContrasenaUsuarioTest(){
//		println "CambiarContrasenaUsuario TEST"
//		RestablecerContrasenaUsuarioRequest request = new RestablecerContrasenaUsuarioRequest( idUsuario:6)
//		RestablecerContrasenaUsuarioResponse resp= UsuarioService.RestablecerContrasena(request)
//		println("contrasena:")
//		println(resp.getUsuarioVo().contrasena)
//	}
//	
//	// @Test
//	@Rollback(false)
//	public void AsociarUsuario(){
//		
//		println "Asociar Usuario"
//		
//		AsociarUsuarioUnidadRequest request = new AsociarUsuarioUnidadRequest(
//			idUsuario: 4,
//			idUnidad:40)
//		AsociarUsuarioUnidadResponse response = UsuarioService.AsociarUsuarioUnidad(request)
//		
//		println response.getResponseCode()
//		
//		 
//	}
//	
//	@Test
//	@Rollback(false)
//	public void obtenerDatosMedico() {
//		println "obtenerDatosMedico TEST"
//		ObtenerDatosMedicoRequest request = new ObtenerDatosMedicoRequest(idUsuario: 30)
//		ObtenerDatosMedicoResponse response = UsuarioService.obtenerDatosMedico(request)
//		def datDatosMedico = response.getDatosMedico()
//		println "idUsuario: " + datDatosMedico.idUsuario + ", " + "nombreInstitucion: " + datDatosMedico.nombreInstitucion + ", " + "cedula: " + datDatosMedico.cedula + ", " + "especialidad: " + datDatosMedico.especialidad
//		println datDatosMedico.dump()	 
//	}
//	
	
}