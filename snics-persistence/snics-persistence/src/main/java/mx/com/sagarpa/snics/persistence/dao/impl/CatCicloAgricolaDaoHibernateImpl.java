package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.CatCicloAgricolaDao;
import mx.com.sagarpa.snics.persistence.entities.CatCicloAgricola;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class CatCicloAgricolaDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<CatCicloAgricola, Long> implements CatCicloAgricolaDao{

	public CatCicloAgricolaDaoHibernateImpl(HibernateTemplate t) {
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
