package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.DatR7InspeccionDao;
import mx.com.sagarpa.snics.persistence.entities.DatR7Inspeccion;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class DatR7InspeccionDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<DatR7Inspeccion, Long> implements DatR7InspeccionDao{

	public DatR7InspeccionDaoHibernateImpl(HibernateTemplate t) {
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
