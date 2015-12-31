package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.DatLaboratorioDatosDao;
import mx.com.sagarpa.snics.persistence.entities.DatLaboratorioDatos;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class DatLaboratorioDatosDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<DatLaboratorioDatos, Long> implements DatLaboratorioDatosDao{

	public DatLaboratorioDatosDaoHibernateImpl(HibernateTemplate t) {
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
