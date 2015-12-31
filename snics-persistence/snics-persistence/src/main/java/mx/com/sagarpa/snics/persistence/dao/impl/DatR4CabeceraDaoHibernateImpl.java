package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.DatR4CabeceraDao;
import mx.com.sagarpa.snics.persistence.entities.DatR4Cabecera;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class DatR4CabeceraDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<DatR4Cabecera, Long> implements DatR4CabeceraDao{

	public DatR4CabeceraDaoHibernateImpl(HibernateTemplate t) {
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
