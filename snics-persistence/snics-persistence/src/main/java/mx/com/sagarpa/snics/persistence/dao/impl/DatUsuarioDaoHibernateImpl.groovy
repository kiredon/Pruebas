package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Criteria
import org.hibernate.criterion.Criterion
import org.hibernate.criterion.DetachedCriteria
import org.hibernate.criterion.Order
import org.hibernate.criterion.Restrictions
import org.springframework.orm.hibernate3.HibernateTemplate;

import mx.com.sagarpa.snics.persistence.dao.DatUsuarioDao;
import mx.com.sagarpa.snics.persistence.entities.DatUsuario;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

import org.springframework.dao.support.DataAccessUtils

public class DatUsuarioDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<DatUsuario, Long> implements DatUsuarioDao{

	public DatUsuarioDaoHibernateImpl(HibernateTemplate t) {
		super(t);
	}

	@Override
	public String getPersistenceClassId() {
		return "id";
	}

	@Override
	public List<String> getPersistenceClassSkippedProperties() {
		return null;
	}

	public String generarContrasenia (String nombreUsuario){
//		return DigestUtils.sha256Hex(new Date().time+nombreUsuario+Math.random())
		return DigestUtils.sha256Hex(nombreUsuario)
	}
	public String cifrarContrasenia (String contrasenia){
		return DigestUtils.sha256Hex(contrasenia)
	}
	public DatUsuario getByNombreUsuarioContrasenia(String nombreUsuario,
		String contrasena) {
		
	Criteria cr = session.createCriteria(DatUsuario.class)
	cr.add(Restrictions.eq("contrasena", contrasena))
	cr.add(Restrictions.eq("nombreUsuario", nombreUsuario))
	return cr.uniqueResult()
}
//	@Override
	public boolean getByPassId(String contrasenia, String idUsuario) {
		// TODO Auto-generated method stub
		 if(DataAccessUtils.uniqueResult(hibernateTemplate.find("SELECT u FROM DatUsuario u where u.password = ? and u.idUsuario = ?", DigestUtils.sha256Hex(contrasenia), idUsuario))!=null)
			 return true;
		 else
		 return false;
	}
	public DatUsuario getListByIdUsuario(Integer id){
		return DataAccessUtils.uniqueResult(hibernateTemplate.find("SELECT u FROM DatUsuario u where u.idUsuario = ?", id))
			}
	public DatUsuario getByPass(String contrasena){
		return DataAccessUtils.uniqueResult(hibernateTemplate.find("SELECT u FROM DatUsuario u where u.contrasena = ?", contrasena))
	}
	public DatUsuario getByNombreUsuario(String nombreUsuario){
		return DataAccessUtils.uniqueResult(hibernateTemplate.find("SELECT u FROM DatUsuario u where u.nombreUsuario = ?", nombreUsuario))
	}
	public List<DatUsuario> getListByStatus(boolean status, int pagina, int tamanio){
		if(status==false){
			Criteria c = session.createCriteria(DatUsuario.class)
			c.add(Restrictions.eq("status", true))
			if(pagina > 0 && tamanio > 0){
				c.setFirstResult((pagina-1)*tamanio)
				c.setMaxResults(tamanio)
			}
			return (List<DatUsuario>) c.list()
		}
		else{
			Criteria cr = session.createCriteria(DatUsuario.class);
			if(pagina > 0 && tamanio > 0){
				cr.setFirstResult((pagina-1)*tamanio)
				cr.setMaxResults(tamanio)
			}
			List results = cr.list()
			return (List<DatUsuario>)results
		}
	}
	public Boolean validaNombre(String nombre){
		Criteria c = session.createCriteria(DatUsuario.class)
		c.add(Restrictions.eq("nombreUsuario", nombre))
		if(c.uniqueResult()==null)
		return false; //no existe
		else return true
	}
}
