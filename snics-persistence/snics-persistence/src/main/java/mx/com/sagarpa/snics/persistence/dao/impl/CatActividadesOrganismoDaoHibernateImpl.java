package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import mx.com.sagarpa.snics.persistence.dao.CatActividadesOrganismoDao;
import mx.com.sagarpa.snics.persistence.entities.CatActividadesOrganismo;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class CatActividadesOrganismoDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<CatActividadesOrganismo, Long> implements CatActividadesOrganismoDao{

	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	public CatActividadesOrganismoDaoHibernateImpl(HibernateTemplate t) {
		super(t);
	}

	@Override
	public String getPersistenceClassId() {
		return "id";
	}

	@Override
	public List<String> getPersistenceClassSkippedProperties() {
		return  null;
	}

	
	
}
