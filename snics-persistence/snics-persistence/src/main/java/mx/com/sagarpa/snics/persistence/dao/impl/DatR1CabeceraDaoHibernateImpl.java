package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import mx.com.sagarpa.snics.persistence.dao.DatR1CabeceraDao;
import mx.com.sagarpa.snics.persistence.entities.DatR1Cabecera;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class DatR1CabeceraDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<DatR1Cabecera, Long> implements DatR1CabeceraDao{

	public DatR1CabeceraDaoHibernateImpl(HibernateTemplate t) {
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
