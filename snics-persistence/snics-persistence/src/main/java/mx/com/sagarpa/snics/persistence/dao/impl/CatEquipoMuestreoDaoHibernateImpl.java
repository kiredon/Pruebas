package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import mx.com.sagarpa.snics.persistence.dao.CatEquipoMuestreoDao;
import mx.com.sagarpa.snics.persistence.entities.CatEquipoMuestreo;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class CatEquipoMuestreoDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<CatEquipoMuestreo, Long> implements CatEquipoMuestreoDao{

	public CatEquipoMuestreoDaoHibernateImpl(HibernateTemplate t) {
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
