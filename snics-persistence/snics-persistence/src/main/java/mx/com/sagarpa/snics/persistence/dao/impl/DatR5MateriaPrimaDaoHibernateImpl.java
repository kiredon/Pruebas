package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import mx.com.sagarpa.snics.persistence.dao.DatR5MateriaPrimaDao;
import mx.com.sagarpa.snics.persistence.entities.DatR5MateriaPrima;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class DatR5MateriaPrimaDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<DatR5MateriaPrima, Long> implements DatR5MateriaPrimaDao{

	public DatR5MateriaPrimaDaoHibernateImpl(HibernateTemplate t) {
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
