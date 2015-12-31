package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import mx.com.sagarpa.snics.persistence.dao.CatEspecieDao;
import mx.com.sagarpa.snics.persistence.entities.CatEspecie;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class CatEspeciaDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<CatEspecie, Long> implements CatEspecieDao{

	public CatEspeciaDaoHibernateImpl(HibernateTemplate t) {
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
