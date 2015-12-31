package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.DatR5DetalleDao;
import mx.com.sagarpa.snics.persistence.entities.DatR5Detalle;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class DatR5DetalleDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<DatR5Detalle, Long> implements DatR5DetalleDao{

	public DatR5DetalleDaoHibernateImpl(HibernateTemplate t) {
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
