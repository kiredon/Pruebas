package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.CatCalificacionDao;
import mx.com.sagarpa.snics.persistence.entities.CatCalificacion;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class CatCalificacionDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<CatCalificacion, Long> implements CatCalificacionDao{

	public CatCalificacionDaoHibernateImpl(HibernateTemplate t) {
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
