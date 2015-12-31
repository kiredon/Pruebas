package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.CatStatusMovimientoEtiquetaDao;
import mx.com.sagarpa.snics.persistence.entities.CatStatusMovimientoEtiqueta;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class CatStatusMovimientoEtiquetaDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<CatStatusMovimientoEtiqueta, Long> implements CatStatusMovimientoEtiquetaDao{

	public CatStatusMovimientoEtiquetaDaoHibernateImpl(HibernateTemplate t) {
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
