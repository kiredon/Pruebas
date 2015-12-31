package mx.com.sagarpa.snics.test.seguridad


//import mx.com.sagarpa.snics.service.seguridad.SnowflakeService
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.LoginRequest
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.LoginResponse
import org.junit.Test
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Profile
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional

@RunWith(SpringJUnit4ClassRunner.class)
@Profile("STANDALONE")
@ContextConfiguration(locations = [
	"/MainAppCtx.xml"
])
@Transactional
class SnowflakeTest {

	
	static{
		System.setProperty("spring.profiles.active", "STANDALONE");
	}
	
//	@Autowired
//	@Qualifier("SnowflakeServiceImpl")
//	SnowflakeService snowflakeService
//	
//	@Test
//	@Rollback(false)
//	public void Login(){
//		
//		LoginRequest request = new LoginRequest()
//		request.setUsuario("eckxos")
//		request.setContrasenia("1432137369237eckxo20.12990924996628817")
//		request.setIpAddress("127.0.0.1")
//		request.setUser_agent("Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.152 Safari/537.36")
//		LoginResponse response = snowflakeService.Login(request) 
//		
//		println response.getSnowflake()
//		 
//	}
}
