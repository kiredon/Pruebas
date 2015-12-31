package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.DatExistenciasEtiquetasDao;
import mx.com.sagarpa.snics.persistence.entities.DatExistenciasEtiquetas;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class DatExistenciasEtiquetasDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<DatExistenciasEtiquetas, Long> implements DatExistenciasEtiquetasDao{

	public DatExistenciasEtiquetasDaoHibernateImpl(HibernateTemplate t) {
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
