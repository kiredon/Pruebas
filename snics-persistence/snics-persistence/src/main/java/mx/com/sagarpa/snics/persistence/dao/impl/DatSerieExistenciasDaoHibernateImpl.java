package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import mx.com.sagarpa.snics.persistence.dao.DatSerieExistenciasDao;
import mx.com.sagarpa.snics.persistence.entities.DatSerieExistencias;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class DatSerieExistenciasDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<DatSerieExistencias, Long> implements DatSerieExistenciasDao{

	public DatSerieExistenciasDaoHibernateImpl(HibernateTemplate t) {
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
