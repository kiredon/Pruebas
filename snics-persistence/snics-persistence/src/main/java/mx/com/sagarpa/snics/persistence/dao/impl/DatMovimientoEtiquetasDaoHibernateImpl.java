package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import mx.com.sagarpa.snics.persistence.dao.DatMovimientoEtiquetasDao;
import mx.com.sagarpa.snics.persistence.entities.DatMovimientoEtiquetas;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class DatMovimientoEtiquetasDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<DatMovimientoEtiquetas, Long> implements DatMovimientoEtiquetasDao{

	public DatMovimientoEtiquetasDaoHibernateImpl(HibernateTemplate t) {
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
