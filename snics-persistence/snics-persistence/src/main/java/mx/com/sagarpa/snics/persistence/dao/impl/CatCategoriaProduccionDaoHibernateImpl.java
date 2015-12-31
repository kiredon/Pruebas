package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import mx.com.sagarpa.snics.persistence.dao.CatCategoriaProduccionDao;
import mx.com.sagarpa.snics.persistence.entities.CatCategoriaProduccion;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class CatCategoriaProduccionDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<CatCategoriaProduccion, Long> implements CatCategoriaProduccionDao{

	public CatCategoriaProduccionDaoHibernateImpl(HibernateTemplate t) {
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
