package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import mx.com.sagarpa.snics.persistence.dao.CatLugarMuestreoDao;
import mx.com.sagarpa.snics.persistence.entities.CatLugarMuestreo;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class CatLugarMuestreoDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<CatLugarMuestreo, Long> implements CatLugarMuestreoDao{

	public CatLugarMuestreoDaoHibernateImpl(HibernateTemplate t) {
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
