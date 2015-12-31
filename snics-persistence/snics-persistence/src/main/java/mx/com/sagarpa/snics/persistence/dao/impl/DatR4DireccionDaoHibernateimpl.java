package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.DatR4DireccionDao;
import mx.com.sagarpa.snics.persistence.entities.DatR4Direccion;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class DatR4DireccionDaoHibernateimpl extends AbstractGenericDaoHibernateImpl<DatR4Direccion, Long> implements DatR4DireccionDao{

	public DatR4DireccionDaoHibernateimpl(HibernateTemplate t) {
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
