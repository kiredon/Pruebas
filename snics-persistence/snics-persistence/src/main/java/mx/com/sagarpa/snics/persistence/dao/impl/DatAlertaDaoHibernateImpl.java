package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.DatAlertaDao;
import mx.com.sagarpa.snics.persistence.entities.DatAlerta;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class DatAlertaDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<DatAlerta, Long> implements DatAlertaDao{

	public DatAlertaDaoHibernateImpl(HibernateTemplate t) {
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
