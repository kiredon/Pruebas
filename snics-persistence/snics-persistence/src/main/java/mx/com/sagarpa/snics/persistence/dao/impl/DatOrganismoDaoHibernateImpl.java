package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import mx.com.sagarpa.snics.persistence.dao.DatOrganismoDao;
import mx.com.sagarpa.snics.persistence.entities.DatOrganismo;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class DatOrganismoDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<DatOrganismo, Long> implements DatOrganismoDao{

	public DatOrganismoDaoHibernateImpl(HibernateTemplate t) {
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
