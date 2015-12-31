package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.CatCondicionCultivoDao;
import mx.com.sagarpa.snics.persistence.entities.CatCondicionCultivo;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class CatCondicionCultivoDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<CatCondicionCultivo, Long> implements CatCondicionCultivoDao{

	public CatCondicionCultivoDaoHibernateImpl(HibernateTemplate t) {
		super(t);
	}

	@Override
	public String getPersistenceClassId() {
		return null;
	}

	@Override
	public List<String> getPersistenceClassSkippedProperties() {
		return null;
	}
}
