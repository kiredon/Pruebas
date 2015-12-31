package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.CatTipoCultivoDao;
import mx.com.sagarpa.snics.persistence.entities.CatTipoCultivo;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class CatTipoCultivoDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<CatTipoCultivo, Long> implements CatTipoCultivoDao{

	public CatTipoCultivoDaoHibernateImpl(HibernateTemplate t) {
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