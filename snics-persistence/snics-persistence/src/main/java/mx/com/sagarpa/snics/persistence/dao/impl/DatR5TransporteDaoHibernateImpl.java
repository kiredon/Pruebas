package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.DatR5TransporteDao;
import mx.com.sagarpa.snics.persistence.entities.DatR5Transporte;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class DatR5TransporteDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<DatR5Transporte, Long> implements DatR5TransporteDao{

	public DatR5TransporteDaoHibernateImpl(HibernateTemplate t) {
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
