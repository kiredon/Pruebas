package mx.com.sagarpa.snics.persistence.dao.impl;

import mx.com.sagarpa.snics.persistence.dao.DatUsuarioDao;
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
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl

 class LinkRolPermisoDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<LinkRolPermiso,Integer> implements LinkRolPermisoDao {
	  
	public LinkRolPermisoDaoHibernateImpl(HibernateTemplate t){
		super(t)
	}

	public String getPersistenceClassId() {
		return "id"
	}

	public  List<String> getPersistenceClassSkippedProperties() {
		return []
	}
	public List<LinkRolPermiso> getListByStatus(boolean status){
		if(status==false){
			DetachedCriteria c = DetachedCriteria.forClass(LinkRolPermiso.class)
			c.add(Restrictions.eq("status", status))
			return (List<LinkRolPermiso>) this.getHibernateTemplate().findByCriteria(c)
		}
		else{
			Criteria cr = session.createCriteria(LinkRolPermiso.class);
			List results = cr.list();
			return (List<LinkRolPermiso>)results
		}
	}
	public LinkRolPermiso getByIdRolyIdPermisouIdUsuario(Integer idRol,Integer idPermiso){		
		String queryString = "select l from LinkRolPermiso l where l.catRol.idRol = ? and l.catPermiso.idPermiso = ?";
        return DataAccessUtils.uniqueResult(getHibernateTemplate().find(queryString, idRol, idPermiso));
		}


	public boolean CambiarEstado(LinkRolPermiso UnidadJerarquica){
		this.getHibernateTemplate().update(UnidadJerarquica)
	}

	public LinkRolPermiso getByNombreUsuario(String nombreUsuario) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<LinkRolPermiso> getByRol(Integer idRol){		
			DetachedCriteria c = DetachedCriteria.forClass(LinkRolPermiso.class)
			c.add(Restrictions.eq("catRol.idRol", idRol))
			return (List<LinkRolPermiso>) this.getHibernateTemplate().findByCriteria(c)
	
		
	}
	public List<LinkRolPermiso> getByPermiso(Integer idPermiso){
		return (List<LinkRolPermiso>) hibernateTemplate.find("SELECT l FROM LinkRolPermiso l where l.catPermiso.idPermiso = ?", idPermiso)
		//DetachedCriteria c = DetachedCriteria.forClass(LinkRolPermiso.class)
		//c.add(Restrictions.eq("catPermiso.idPermiso", idPermiso))
		//return (List<LinkRolPermiso>) this.getHibernateTemplate().findByCriteria(c)
		
	}
	



	

}
