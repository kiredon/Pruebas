package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import mx.com.sagarpa.snics.persistence.dao.CatFechaCilcoDao;
import mx.com.sagarpa.snics.persistence.entities.CatFechaCiclo;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class CatFechaCicloDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<CatFechaCiclo, Long> implements CatFechaCilcoDao
{

	public CatFechaCicloDaoHibernateImpl(HibernateTemplate t) {
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
