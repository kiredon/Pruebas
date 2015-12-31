package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.DatR1OrigenDao;
import mx.com.sagarpa.snics.persistence.entities.DatR1Origen;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class DatR1OrigenDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<DatR1Origen, Long> implements DatR1OrigenDao{

	public DatR1OrigenDaoHibernateImpl(HibernateTemplate t) {
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
