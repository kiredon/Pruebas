package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import mx.com.sagarpa.snics.persistence.dao.CatEtapaCultivoDao;
import mx.com.sagarpa.snics.persistence.entities.CatEtapaCultivo;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class CatEtapaCultivoDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<CatEtapaCultivo, Long> implements CatEtapaCultivoDao{

	public CatEtapaCultivoDaoHibernateImpl(HibernateTemplate t) {
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
