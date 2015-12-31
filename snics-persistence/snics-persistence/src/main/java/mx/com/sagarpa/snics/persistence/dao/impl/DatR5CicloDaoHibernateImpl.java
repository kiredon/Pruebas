package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import mx.com.sagarpa.snics.persistence.dao.DatR5CicloDao;
import mx.com.sagarpa.snics.persistence.entities.DatR5Ciclo;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class DatR5CicloDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<DatR5Ciclo, Long> implements DatR5CicloDao{

	public DatR5CicloDaoHibernateImpl(HibernateTemplate t) {
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
