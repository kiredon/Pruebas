package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import mx.com.sagarpa.snics.persistence.dao.DatR5CabeceraDao;
import mx.com.sagarpa.snics.persistence.entities.DatR5Cabecera;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class DatR5CabeceraDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<DatR5Cabecera, Long> implements DatR5CabeceraDao{

	public DatR5CabeceraDaoHibernateImpl(HibernateTemplate t) {
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
