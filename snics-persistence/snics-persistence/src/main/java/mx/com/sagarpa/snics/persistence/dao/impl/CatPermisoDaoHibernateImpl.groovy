package mx.com.sagarpa.snics.persistence.dao.impl

import java.util.List

import mx.com.sagarpa.snics.persistence.dao.CatPermisoDao
import mx.com.sagarpa.snics.persistence.entities.CatPermiso
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl
import org.hibernate.Criteria
import org.hibernate.Session
import org.hibernate.criterion.DetachedCriteria
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;


class CatPermisoDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<CatPermiso,Integer> implements CatPermisoDao {

	public CatPermisoDaoHibernateImpl(HibernateTemplate t){
		super(t)
	}
	
	public String getPersistenceClassId() {
		return "id"
	}

	public  List<String> getPersistenceClassSkippedProperties() {
		return []
	}
	public List<CatPermiso> getListByStatus(boolean status){
		
				if(status==false){
					DetachedCriteria c = DetachedCriteria.forClass(CatPermiso.class)
					c.add(Restrictions.eq("status", status))
					return (List<CatPermiso>) this.getHibernateTemplate().findByCriteria(c)
				}
				else{
					Criteria cr = session.createCriteria(CatPermiso.class);
					List results = cr.list();
					return (List<CatPermiso>)results
				}
	}
	public CatPermiso getListById(Integer id){									
					DetachedCriteria c = DetachedCriteria.forClass(CatPermiso.class)
					c.add(Restrictions.eq("idPermiso", id))
					return (CatPermiso) this.getHibernateTemplate().findByCriteria(c)						
	}
	
	public boolean CambiarEstado(CatPermiso Permiso){
		this.getHibernateTemplate().update(Permiso)
	}
	
	public void insertar(){
//		Session s = this.getSession()
//		CatPermiso permiso =  s.get(CatPermiso.class, 3)
//		CatTipoNotificacion notif = s.get(CatTipoNotificacion.class, 1)
//		
//		Set permis=notif.getCatPermisos()
//		Set tipoNotif = permiso.getCatTipoNotificacions()
//		permis.add(permiso)
//		tipoNotif.add(notif)
//		
//		
//		println "tipo de notificaciones" + tipoNotif.size()
//		
//		notif.setCatPermisos(permis)
//		permiso.setCatTipoNotificacions(tipoNotif)
//		
//		s.save(notif)
//		s.save(permiso)
//		s.flush() 
	}
	
			
}
