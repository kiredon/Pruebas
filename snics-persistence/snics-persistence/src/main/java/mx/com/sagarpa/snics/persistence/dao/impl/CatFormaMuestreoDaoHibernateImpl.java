package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.CatFormaMuestreoDao;
import mx.com.sagarpa.snics.persistence.entities.CatFormaMuestreo;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class CatFormaMuestreoDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<CatFormaMuestreo, Long> implements CatFormaMuestreoDao{

	public CatFormaMuestreoDaoHibernateImpl(HibernateTemplate t) {
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
