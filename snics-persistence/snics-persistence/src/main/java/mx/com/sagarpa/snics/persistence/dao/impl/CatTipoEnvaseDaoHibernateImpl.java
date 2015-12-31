package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.CatTipoEnvaseDao;
import mx.com.sagarpa.snics.persistence.entities.CatTipoEnvase;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class CatTipoEnvaseDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<CatTipoEnvase, Long> implements CatTipoEnvaseDao{

	public CatTipoEnvaseDaoHibernateImpl(HibernateTemplate t) {
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
