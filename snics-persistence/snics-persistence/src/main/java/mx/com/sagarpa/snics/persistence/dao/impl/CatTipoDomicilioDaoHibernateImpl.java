package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.CatTipoDomicilioDao;
import mx.com.sagarpa.snics.persistence.entities.CatTipoDomicilio;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class CatTipoDomicilioDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<CatTipoDomicilio, Long> implements CatTipoDomicilioDao{

	public CatTipoDomicilioDaoHibernateImpl(HibernateTemplate t) {
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
