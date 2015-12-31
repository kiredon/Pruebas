package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import mx.com.sagarpa.snics.persistence.dao.CatOrigenDao;
import mx.com.sagarpa.snics.persistence.entities.CatOrigen;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class CatOrigenDaoHinbernateImpl extends AbstractGenericDaoHibernateImpl<CatOrigen, Long> implements CatOrigenDao{

	public CatOrigenDaoHinbernateImpl(HibernateTemplate t) {
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
