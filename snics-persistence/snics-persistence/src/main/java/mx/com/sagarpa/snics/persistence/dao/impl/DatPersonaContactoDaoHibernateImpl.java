package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import mx.com.sagarpa.snics.persistence.dao.DatPersonaContactoDao;
import mx.com.sagarpa.snics.persistence.entities.DatPersonaContacto;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class DatPersonaContactoDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<DatPersonaContacto, Long> implements DatPersonaContactoDao{

	public DatPersonaContactoDaoHibernateImpl(HibernateTemplate t) {
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

}
