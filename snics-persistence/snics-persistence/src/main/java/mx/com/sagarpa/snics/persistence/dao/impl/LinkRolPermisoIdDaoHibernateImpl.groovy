package mx.com.sagarpa.snics.persistence.dao.impl

import java.util.List

import org.hibernate.Criteria
import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.dao.support.DataAccessUtils

import mx.com.sagarpa.snics.persistence.dao.LinkRolPermisoIdDao
import mx.com.sagarpa.snics.persistence.entities.CatRol;
import mx.com.sagarpa.snics.persistence.entities.DatUsuario;
import mx.com.sagarpa.snics.persistence.entities.LinkRolPermiso
import mx.com.sagarpa.snics.persistence.entities.LinkRolPermisoId
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl

class LinkRolPermisoIdDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<LinkRolPermisoId,Integer> implements LinkRolPermisoIdDao {

	public LinkRolPermisoIdDaoHibernateImpl(HibernateTemplate t){
		super(t)
	}

	public String getPersistenceClassId() {
		return "id"
	}

	public  List<String> getPersistenceClassSkippedProperties() {
		return []
	}
	public List<LinkRolPermisoId> getListByStatus(boolean status){
		if(status==false){
			DetachedCriteria c = DetachedCriteria.forClass(LinkRolPermisoId.class)
			c.add(Restrictions.eq("status", status))
			return (List<LinkRolPermisoId>) this.getHibernateTemplate().findByCriteria(c)
		}
		else{
			Criteria cr = session.createCriteria(LinkRolPermisoId.class);
			List results = cr.list();
			return (List<LinkRolPermisoId>)results
		}
	}
	
	public LinkRolPermisoId getListByIdRol(Integer id){
		DetachedCriteria c = DetachedCriteria.forClass(LinkRolPermisoId.class)
		c.add(Restrictions.eq("idRol", id))

		return (LinkRolPermisoId) this.getHibernateTemplate().findByCriteria(c)
	}
	public LinkRolPermisoId getListByIdPermiso(Integer id){
		DetachedCriteria c = DetachedCriteria.forClass(LinkRolPermisoId.class)
		c.add(Restrictions.eq("idPermiso", id))

		return (LinkRolPermisoId) this.getHibernateTemplate().findByCriteria(c)
	}

	public boolean CambiarEstado(LinkRolPermisoId UnidadJerarquica){
		this.getHibernateTemplate().update(UnidadJerarquica)
	}
	public LinkRolPermiso getByIdRol(String id){
		return DataAccessUtils.uniqueResult(hibernateTemplate.find("SELECT r FROM LinkRolPermiso r where r.idRol = ?", id))
	}
	public LinkRolPermiso getByIdPermiso(Integer id){
		return DataAccessUtils.uniqueResult(hibernateTemplate.find("SELECT r FROM LinkRolPermiso r where r.idPermiso = ?", id))
	}


}
