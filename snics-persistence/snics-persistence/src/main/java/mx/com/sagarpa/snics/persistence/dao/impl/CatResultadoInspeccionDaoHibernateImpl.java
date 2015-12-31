package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.CatResultadoInspeccionDao;
import mx.com.sagarpa.snics.persistence.entities.CatResultadoInspeccion;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class CatResultadoInspeccionDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<CatResultadoInspeccion, Long> implements CatResultadoInspeccionDao{

	public CatResultadoInspeccionDaoHibernateImpl(HibernateTemplate t) {
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
