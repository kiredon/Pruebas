package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import mx.com.sagarpa.snics.persistence.dao.DatBoletinDao;
import mx.com.sagarpa.snics.persistence.entities.DatBoletin;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class DatBoletinDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<DatBoletin, Long> implements DatBoletinDao{

	public DatBoletinDaoHibernateImpl(HibernateTemplate t) {
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
