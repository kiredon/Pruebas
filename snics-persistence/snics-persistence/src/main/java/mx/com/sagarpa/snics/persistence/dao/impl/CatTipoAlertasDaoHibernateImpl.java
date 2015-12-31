package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.CatTipoAlertasDao;
import mx.com.sagarpa.snics.persistence.entities.CatTipoAlertas;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class CatTipoAlertasDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<CatTipoAlertas, Long> implements CatTipoAlertasDao{

	public CatTipoAlertasDaoHibernateImpl(HibernateTemplate t) {
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
