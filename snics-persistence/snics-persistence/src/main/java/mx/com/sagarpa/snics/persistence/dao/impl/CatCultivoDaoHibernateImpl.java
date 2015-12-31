package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import mx.com.sagarpa.snics.persistence.dao.CatCultivoDao;
import mx.com.sagarpa.snics.persistence.entities.CatCultivo;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class CatCultivoDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<CatCultivo, Long> implements CatCultivoDao{

	public CatCultivoDaoHibernateImpl(HibernateTemplate t) {
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
