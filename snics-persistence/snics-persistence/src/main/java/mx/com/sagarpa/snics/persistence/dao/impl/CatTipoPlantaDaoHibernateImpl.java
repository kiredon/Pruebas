package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.CatTipoPlantaDao;
import mx.com.sagarpa.snics.persistence.entities.CatTipoPlanta;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class CatTipoPlantaDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<CatTipoPlanta, Long> implements CatTipoPlantaDao{

	public CatTipoPlantaDaoHibernateImpl(HibernateTemplate t) {
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
