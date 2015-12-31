package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import mx.com.sagarpa.snics.persistence.dao.DatLaboratorioCabeceraDao;
import mx.com.sagarpa.snics.persistence.entities.DatLaboratorioCabecera;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class DatLaboratorioCabeceraDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<DatLaboratorioCabecera, Long> implements DatLaboratorioCabeceraDao{

	public DatLaboratorioCabeceraDaoHibernateImpl(HibernateTemplate t) {
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
