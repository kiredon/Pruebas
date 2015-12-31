package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.CatVariedadCultivoDao;
import mx.com.sagarpa.snics.persistence.entities.CatVariedadCultivo;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class CatVariedadCultivoDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<CatVariedadCultivo, Long> implements CatVariedadCultivoDao{

	public CatVariedadCultivoDaoHibernateImpl(HibernateTemplate t) {
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
