package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.DatBoletinesArchivosDao;
import mx.com.sagarpa.snics.persistence.entities.DatBoletinesArchivos;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class DatBoletinesArchivosDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<DatBoletinesArchivos, Long> implements DatBoletinesArchivosDao{

	public DatBoletinesArchivosDaoHibernateImpl(HibernateTemplate t) {
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
