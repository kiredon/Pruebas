package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import mx.com.sagarpa.snics.persistence.dao.DatRepresentanteLegalDao;
import mx.com.sagarpa.snics.persistence.entities.DatRepresentanteLegal;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class DatRepresentanteLegalDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<DatRepresentanteLegal, Long> implements DatRepresentanteLegalDao{

	public DatRepresentanteLegalDaoHibernateImpl(HibernateTemplate t) {
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
