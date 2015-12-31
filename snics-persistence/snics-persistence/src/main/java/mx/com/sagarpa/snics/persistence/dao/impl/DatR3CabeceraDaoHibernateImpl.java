package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import mx.com.sagarpa.snics.persistence.dao.DatR3CabeceraDao;
import mx.com.sagarpa.snics.persistence.entities.DatR3Cabecera;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class DatR3CabeceraDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<DatR3Cabecera, Long> implements DatR3CabeceraDao{

	public DatR3CabeceraDaoHibernateImpl(HibernateTemplate t) {
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
