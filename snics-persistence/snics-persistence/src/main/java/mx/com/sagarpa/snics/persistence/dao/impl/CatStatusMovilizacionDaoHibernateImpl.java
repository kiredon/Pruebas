package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.CatStatusMovilizacionDao;
import mx.com.sagarpa.snics.persistence.entities.CatStatusMovilizacion;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class CatStatusMovilizacionDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<CatStatusMovilizacion, Long> implements CatStatusMovilizacionDao{

	public CatStatusMovilizacionDaoHibernateImpl(HibernateTemplate t) {
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
