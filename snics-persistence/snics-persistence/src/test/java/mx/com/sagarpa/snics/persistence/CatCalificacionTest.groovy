package mx.com.sagarpa.snics.persistence

import mx.com.sagarpa.snics.common.config.AppConfig
import mx.com.sagarpa.snics.persistence.dao.CatCalificacionDao
import mx.com.sagarpa.snics.persistence.dao.LinkRolPermisoDao;
import mx.com.sagarpa.snics.persistence.dao.LinkRolPermisoIdDao;
import mx.com.sagarpa.snics.persistence.entities.CatCalificacion

import org.junit.Test
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(["STANDALONE"])
@Transactional
@ContextConfiguration(locations = [
	"/PersistenceTestCtx.xml",

])

class CatCalificacionTest {

	@Autowired
	CatCalificacionDao catCalificacionDao
	
	@Autowired
	LinkRolPermisoDao linkRolPermisoDao
	@Autowired
	LinkRolPermisoIdDao linkRolPermisoIdDao

	
	@Test
	@Rollback(false)
	void getCalificacion(){
		def CatCalificacion = catCalificacionDao.findById(100)
		println CatCalificacion.nombreCalificacion
		
	}
	
	
//	@Test
	@Rollback(false)
	void createCalificacion(){
		def CatCalificacion = new CatCalificacion()
		CatCalificacion.setNombreCalificacion("6")
		catCalificacionDao.create(CatCalificacion)
		
	}
//	@Test
	@Rollback(false)
	void getLinkRolPermiso(){
		println ("ff")
		
//		List<LinkRolPermiso> LinkRol = linkRolPermisoDao.getByRol(1)
		
	 def LinkRol = linkRolPermisoDao.getByIdRolyIdPermisouIdUsuario(1, 1)
		 println("gg")
	   
	}
	
}