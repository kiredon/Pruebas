package mx.com.sagarpa.snics.persistence.dao.impl

import java.util.List

import mx.com.sagarpa.snics.persistence.dao.CatRolDao
import mx.com.sagarpa.snics.persistence.entities.CatRol
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl
import org.hibernate.Criteria
import org.hibernate.criterion.DetachedCriteria
import org.hibernate.criterion.Restrictions
import org.springframework.orm.hibernate3.HibernateTemplate;


class CatRolDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<CatRol,Integer> implements CatRolDao {

	public CatRolDaoHibernateImpl(HibernateTemplate t){
		super(t)
	}
	
	public String getPersistenceClassId() {
		return "id"
	}

	public  List<String> getPersistenceClassSkippedProperties() {
		return []
	}
	
	public Boolean validaNombre(String nombre){
		Criteria c = session.createCriteria(CatRol.class)
		c.add(Restrictions.eq("nombreRol", nombre))
		if(c.uniqueResult()==null)
		return false; //no existe
		else return true
	}
	
	public List<CatRol> getListByStatus(boolean status, int pagina, int tamanio){
		
				if(status==false){
					Criteria c = session.createCriteria(CatRol.class)
					c.add(Restrictions.eq("status", true))
					if(pagina > 0 && tamanio > 0){
						c.setFirstResult((pagina-1)*tamanio)
						c.setMaxResults(tamanio)
					}
					return (List<CatRol>) c.list()
				}
				else{
					Criteria cr = session.createCriteria(CatRol.class);
					if(pagina > 0 && tamanio > 0){
						cr.setFirstResult((pagina-1)*tamanio)
						cr.setMaxResults(tamanio)
					}
					List results = cr.list()
					return (List<CatRol>)results
				}
			}
	
	public int getTotalByStatus(boolean status){
		if(status==false){
			Criteria c = session.createCriteria(CatRol.class)
			c.add(Restrictions.eq("status", true))
			List results = c.list()
			return results.size()
		}
		else{
			Criteria cr = session.createCriteria(CatRol.class);
			List results = cr.list()
			return results.size()
		}
	}
	
	public int getTotalByStatusNombre(String nombre,boolean status){
		if(status==false){
			Criteria c = session.createCriteria(CatRol.class)
			c.add(Restrictions.eq("status", true))
			c.add(Restrictions.like("nombreRol","%"+nombre+"%"))
			List results = c.list()
			return results.size()
		}
		else{
			Criteria c = session.createCriteria(CatRol.class)
			c.add(Restrictions.like("nombreRol","%"+nombre+"%"))
			List results = c.list()
			return results.size()
		}
	}
	
	
	public CatRol getListByIdRol(Integer id){
		
			
					DetachedCriteria c = DetachedCriteria.forClass(CatRol.class)
					c.add(Restrictions.eq("idRol", id))
					this.HibernateTemplate.initialize(CatRol)
					
					return (CatRol) this.getHibernateTemplate().findByCriteria(c)
				
			}
	
	public boolean CambiarEstado(CatRol Rol){
		this.HibernateTemplate.initialize(CatRol)		
		this.getHibernateTemplate().update(Rol)		
	}
	
	
}
