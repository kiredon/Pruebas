package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import mx.com.sagarpa.snics.persistence.dao.CatEstadoDao;
import mx.com.sagarpa.snics.persistence.entities.CatEstado;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class CatEstadoDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<CatEstado, Long> implements CatEstadoDao{

	public CatEstadoDaoHibernateImpl(HibernateTemplate t) {
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
