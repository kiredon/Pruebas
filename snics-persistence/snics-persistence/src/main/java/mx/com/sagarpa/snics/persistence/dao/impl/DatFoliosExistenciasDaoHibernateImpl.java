package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.DatFoliosExistenciasDao;
import mx.com.sagarpa.snics.persistence.entities.DatFoliosExistencias;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class DatFoliosExistenciasDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<DatFoliosExistencias, Long> implements DatFoliosExistenciasDao{

	public DatFoliosExistenciasDaoHibernateImpl(HibernateTemplate t) {
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
