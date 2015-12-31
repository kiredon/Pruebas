package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.DatA5CabeceraDao;
import mx.com.sagarpa.snics.persistence.entities.DatA5Cabecera;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class DatA5CabeceraDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<DatA5Cabecera, Long> implements DatA5CabeceraDao{

	public DatA5CabeceraDaoHibernateImpl(HibernateTemplate t) {
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
