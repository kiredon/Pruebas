package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.CatTipoIntervaloDao;
import mx.com.sagarpa.snics.persistence.entities.CatTipoIntervalo;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class CatTipoIntervaloDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<CatTipoIntervalo, Long> implements CatTipoIntervaloDao{

	public CatTipoIntervaloDaoHibernateImpl(HibernateTemplate t) {
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
