package mx.com.sagarpa.snics.persistence.dao.impl;

import mx.com.sagarpa.snics.persistence.dao.DatUsuarioDao;
import mx.com.sagarpa.snics.persistence.dao.LinkRolUsuarioDao
import mx.com.sagarpa.snics.persistence.entities.DatUsuario;

import java.util.List

import org.hibernate.Criteria
import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.dao.support.DataAccessUtils

import mx.com.sagarpa.snics.persistence.dao.LinkRolPermisoDao
import mx.com.sagarpa.snics.persistence.entities.CatRol;
import mx.com.sagarpa.snics.persistence.entities.LinkRolPermiso
import mx.com.sagarpa.snics.persistence.entities.LinkRolUsuario
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl

 class LinkRolUsuarioDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<LinkRolUsuario,Integer> implements LinkRolUsuarioDao {
	  
	public LinkRolUsuarioDaoHibernateImpl(HibernateTemplate t){
		super(t)
	}

	public String getPersistenceClassId() {
		return "id"
	}

	public  List<String> getPersistenceClassSkippedProperties() {
		return []
	}

	public List<LinkRolUsuario> getByRol(Integer idRol){

			DetachedCriteria c = DetachedCriteria.forClass(LinkRolUsuario.class)
			c.add(Restrictions.eq("catRol.idRol", idRol))
			return (List<LinkRolUsuario>) this.getHibernateTemplate().findByCriteria(c)		
	}
	public List<LinkRolUsuario> getByUsuario(Integer idUsuario){
		return (List<LinkRolUsuario>) hibernateTemplate.find("SELECT l FROM LinkRolUsuario l where l.datUsuario.idUsuario = ?", idUsuario)
		//DetachedCriteria c = DetachedCriteria.forClass(LinkRolPermiso.class)
		//c.add(Restrictions.eq("catPermiso.idPermiso", idPermiso))
		//return (List<LinkRolPermiso>) this.getHibernateTemplate().findByCriteria(c)
		
	}
	



	

}
