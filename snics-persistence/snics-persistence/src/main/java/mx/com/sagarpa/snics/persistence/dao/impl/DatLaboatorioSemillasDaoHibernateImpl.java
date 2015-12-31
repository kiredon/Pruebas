package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.DatLaboatorioSemillasDao;
import mx.com.sagarpa.snics.persistence.entities.DatLaboatorioSemillas;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class DatLaboatorioSemillasDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<DatLaboatorioSemillas, Long> implements DatLaboatorioSemillasDao{

	public DatLaboatorioSemillasDaoHibernateImpl(HibernateTemplate t) {
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
