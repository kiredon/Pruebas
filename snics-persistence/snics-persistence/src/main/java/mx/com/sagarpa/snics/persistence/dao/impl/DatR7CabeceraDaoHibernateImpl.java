package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.DatR7CabeceraDao;
import mx.com.sagarpa.snics.persistence.entities.DatR7Cabecera;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class DatR7CabeceraDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<DatR7Cabecera, Long> implements DatR7CabeceraDao{

	public DatR7CabeceraDaoHibernateImpl(HibernateTemplate t) {
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
