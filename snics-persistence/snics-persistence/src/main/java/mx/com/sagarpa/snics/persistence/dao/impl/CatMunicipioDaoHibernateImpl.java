package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import mx.com.sagarpa.snics.persistence.dao.CatMunicipioDao;
import mx.com.sagarpa.snics.persistence.entities.CatMunicipio;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class CatMunicipioDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<CatMunicipio, Long> implements CatMunicipioDao{

	public CatMunicipioDaoHibernateImpl(HibernateTemplate t) {
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
