package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import mx.com.sagarpa.snics.persistence.dao.DatAlmacenBeneficioDao;
import mx.com.sagarpa.snics.persistence.entities.DatAlmacenBeneficio;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class DatAlmacenBeneficioDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<DatAlmacenBeneficio, Long> implements DatAlmacenBeneficioDao{

	public DatAlmacenBeneficioDaoHibernateImpl(HibernateTemplate t) {
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
