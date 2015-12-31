package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import mx.com.sagarpa.snics.persistence.dao.CatCategoriaDao;
import mx.com.sagarpa.snics.persistence.entities.CatCategoria;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class CatCategoriaDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<CatCategoria, Long> implements CatCategoriaDao{

	public CatCategoriaDaoHibernateImpl(HibernateTemplate t) {
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
