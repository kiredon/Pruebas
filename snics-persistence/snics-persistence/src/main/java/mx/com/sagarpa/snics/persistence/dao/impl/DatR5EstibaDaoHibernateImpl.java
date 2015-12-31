package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.DatR5EstibaDao;
import mx.com.sagarpa.snics.persistence.entities.DatR5Estiba;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class DatR5EstibaDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<DatR5Estiba, Long> implements DatR5EstibaDao{

	public DatR5EstibaDaoHibernateImpl(HibernateTemplate t) {
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
