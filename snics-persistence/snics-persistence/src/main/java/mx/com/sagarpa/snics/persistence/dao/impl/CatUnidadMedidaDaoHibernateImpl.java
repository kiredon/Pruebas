package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import mx.com.sagarpa.snics.persistence.dao.CatUnidadMedidaDao;
import mx.com.sagarpa.snics.persistence.entities.CatUnidadMedida;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class CatUnidadMedidaDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<CatUnidadMedida, Long> implements CatUnidadMedidaDao {

	public CatUnidadMedidaDaoHibernateImpl(HibernateTemplate t) {
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
