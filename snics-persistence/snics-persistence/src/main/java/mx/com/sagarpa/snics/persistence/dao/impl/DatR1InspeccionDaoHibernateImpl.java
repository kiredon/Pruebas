package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.DatR1InspeccionDao;
import mx.com.sagarpa.snics.persistence.entities.DatR1Inspeccion;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class DatR1InspeccionDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<DatR1Inspeccion, Long> implements DatR1InspeccionDao{

	public DatR1InspeccionDaoHibernateImpl(HibernateTemplate t) {
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
