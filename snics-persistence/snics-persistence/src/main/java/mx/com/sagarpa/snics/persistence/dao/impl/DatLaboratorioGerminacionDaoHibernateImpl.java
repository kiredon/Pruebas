package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.DatLaboratorioGerminacionDao;
import mx.com.sagarpa.snics.persistence.entities.DatLaboratorioGerminacion;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class DatLaboratorioGerminacionDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<DatLaboratorioGerminacion, Long> implements DatLaboratorioGerminacionDao{

	public DatLaboratorioGerminacionDaoHibernateImpl(HibernateTemplate t) {
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
