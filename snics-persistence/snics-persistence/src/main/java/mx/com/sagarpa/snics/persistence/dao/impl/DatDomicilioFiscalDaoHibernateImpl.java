package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.DatDomicilioFiscalDao;
import mx.com.sagarpa.snics.persistence.entities.DatDomicilioFiscal;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class DatDomicilioFiscalDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<DatDomicilioFiscal, Long> implements DatDomicilioFiscalDao{

	public DatDomicilioFiscalDaoHibernateImpl(HibernateTemplate t) {
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
