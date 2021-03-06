package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.DatR1PredioDao;
import mx.com.sagarpa.snics.persistence.entities.DatR1Predio;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class DatR1PredioDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<DatR1Predio, Long> implements DatR1PredioDao{

	public DatR1PredioDaoHibernateImpl(HibernateTemplate t) {
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
