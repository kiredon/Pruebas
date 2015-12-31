package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.DatR5ParticularesDao;
import mx.com.sagarpa.snics.persistence.entities.DatR5Particulares;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class DatR5ParticularesDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<DatR5Particulares, Long> implements DatR5ParticularesDao{

	public DatR5ParticularesDaoHibernateImpl(HibernateTemplate t) {
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
