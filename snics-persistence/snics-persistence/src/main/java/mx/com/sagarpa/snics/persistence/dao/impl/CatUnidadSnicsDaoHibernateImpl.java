package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.CatUnidadSnicsDao;
import mx.com.sagarpa.snics.persistence.entities.CatUnidadSnics;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class CatUnidadSnicsDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<CatUnidadSnics, Long> implements CatUnidadSnicsDao{

	public CatUnidadSnicsDaoHibernateImpl(HibernateTemplate t) {
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
