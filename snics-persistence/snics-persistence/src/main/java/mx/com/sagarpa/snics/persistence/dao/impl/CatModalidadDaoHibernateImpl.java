package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import mx.com.sagarpa.snics.persistence.dao.CatModalidadDao;
import mx.com.sagarpa.snics.persistence.entities.CatModalidad;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class CatModalidadDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<CatModalidad, Long> implements CatModalidadDao{

	public CatModalidadDaoHibernateImpl(HibernateTemplate t) {
		super(t);
	}

	@Override
	public String getPersistenceClassId() {
		return null;
	}

	@Override
	public List<String> getPersistenceClassSkippedProperties() {
		return null;
	}

}
