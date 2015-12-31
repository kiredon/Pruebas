package mx.com.sagarpa.snics.persistence

import java.util.List;

import mx.com.sagarpa.snics.persistence.dao.CatPermisoDao
import mx.com.sagarpa.snics.persistence.dao.CatRolDao
import mx.com.sagarpa.snics.persistence.dao.DatUsuarioDao;
import mx.com.sagarpa.snics.persistence.dao.LinkRolPermisoDao
import mx.com.sagarpa.snics.persistence.dao.LinkRolPermisoIdDao
import mx.com.sagarpa.snics.persistence.dao.LinkRolUsuarioDao
import mx.com.sagarpa.snics.persistence.entities.CatPermiso
import mx.com.sagarpa.snics.persistence.entities.CatRol
import mx.com.sagarpa.snics.persistence.entities.DatUsuario
import mx.com.sagarpa.snics.persistence.entities.LinkRolPermiso
import mx.com.sagarpa.snics.persistence.entities.LinkRolPermisoId
import mx.com.sagarpa.snics.persistence.entities.LinkRolUsuario

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
class LinkRolPermisoTest {

	 @Autowired
	 LinkRolPermisoDao linkRolPermisoDao
	 @Autowired
	 LinkRolPermisoIdDao linkRolPermisoIdDao
	 @Autowired
	 DatUsuarioDao datUsuarioDao
	 @Autowired
	 CatRolDao catRolDao
	 @Autowired
	 CatPermisoDao catPermisoDao
	 @Autowired
	 LinkRolUsuarioDao linkRolUsuarioDao
	 @Autowired
	 CatPermisoDao catpermisoDao
	 
	
//	@Test
	@Rollback(false)
	void createLinkRolPermiso(){
		println("jojoj")
		def CatRol=catRolDao.findById(1)
		println(CatRol.idRol)
		
		def LinkRolPermiso = new LinkRolPermiso()		
		def LinkRolPermisoId=new LinkRolPermisoId()
		LinkRolPermisoId.setIdPermiso(1)
		LinkRolPermisoId.setIdRol(1)
		def DatUsuario=datUsuarioDao.findById(1)
		println(DatUsuario.nombreUsuario)
		def CatPermiso=catPermisoDao.findById(1)
		println(CatPermiso.nombrePermiso)
		
		LinkRolPermiso.setDatUsuario(DatUsuario)							
		LinkRolPermiso.setCatRol(CatRol)
		LinkRolPermiso.setCatPermiso(CatPermiso)
		LinkRolPermiso.setFechaCreacion(new java.util.Date())
		LinkRolPermiso.setId(LinkRolPermisoId)
		println(LinkRolPermiso.id.idPermiso)
		println(LinkRolPermiso.id.idRol)
		println(LinkRolPermiso.catRol.idRol)
		println(LinkRolPermiso.catPermiso.idPermiso)
		println(LinkRolPermiso.datUsuario)
		println(LinkRolPermiso.fechaCreacion)
		linkRolPermisoDao.create(LinkRolPermiso)

	}
	
//@Test
	@Rollback(false)
	void getLinkRolPermiso(){		
		def LinkRol = new LinkRolPermiso()
		LinkRol = linkRolPermisoDao.getByIdRolyIdPermisouIdUsuario(1, 1)
		println LinkRol.catPermiso.idPermiso;
	}
	
//	@Test
	@Rollback(false)
	void getLinkRolUsuario(){
		def	LinkRol= linkRolUsuarioDao.findById(1)
	}
	
	
	
}