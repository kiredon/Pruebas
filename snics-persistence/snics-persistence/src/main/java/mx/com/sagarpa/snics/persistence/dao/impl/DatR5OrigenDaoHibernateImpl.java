package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import mx.com.sagarpa.snics.persistence.dao.DatR5OrigenDao;
import mx.com.sagarpa.snics.persistence.entities.DatR5Origen;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class DatR5OrigenDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<DatR5Origen, Long> implements DatR5OrigenDao{

	public DatR5OrigenDaoHibernateImpl(HibernateTemplate t) {
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
