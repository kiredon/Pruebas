package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.DatLaboratorioPantulasDao;
import mx.com.sagarpa.snics.persistence.entities.DatLaboratorioPantulas;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class DatLaboratorioPantulasDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<DatLaboratorioPantulas, Long> implements DatLaboratorioPantulasDao{

	public DatLaboratorioPantulasDaoHibernateImpl(HibernateTemplate t) {
		super(t);
	}

	@Override
	public String getPersistenceClassId() {
		return null;
	}

	@Override
	public List<String> getPersistenceClassSkippedProperties() {
		return null;
	}

}
