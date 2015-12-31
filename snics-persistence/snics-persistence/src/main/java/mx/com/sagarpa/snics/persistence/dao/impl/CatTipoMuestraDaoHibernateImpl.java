package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.CatTipoMuestraDao;
import mx.com.sagarpa.snics.persistence.entities.CatTipoMuestra;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class CatTipoMuestraDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<CatTipoMuestra, Long> implements CatTipoMuestraDao{

	public CatTipoMuestraDaoHibernateImpl(HibernateTemplate t) {
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
