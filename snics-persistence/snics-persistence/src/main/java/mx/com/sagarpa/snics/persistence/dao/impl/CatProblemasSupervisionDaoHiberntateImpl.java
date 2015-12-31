package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.CatProblemasSupervisionDao;
import mx.com.sagarpa.snics.persistence.entities.CatProblemasSupervision;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class CatProblemasSupervisionDaoHiberntateImpl extends AbstractGenericDaoHibernateImpl<CatProblemasSupervision, Long> implements CatProblemasSupervisionDao{

	public CatProblemasSupervisionDaoHiberntateImpl(HibernateTemplate t) {
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
