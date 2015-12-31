package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.CatTipoMedidaDao;
import mx.com.sagarpa.snics.persistence.entities.CatTipoMedida;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class CatTipoMedidaDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<CatTipoMedida, Long> implements CatTipoMedidaDao{

	public CatTipoMedidaDaoHibernateImpl(HibernateTemplate t) {
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