package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.CatIntervaloDao;
import mx.com.sagarpa.snics.persistence.entities.CatIntervalo;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class CatIntervaloDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<CatIntervalo, Long> implements CatIntervaloDao{

	public CatIntervaloDaoHibernateImpl(HibernateTemplate t) {
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
