package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.LinkOrganismoCultivoDao;
import mx.com.sagarpa.snics.persistence.entities.LinkOrganismoCultivo;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class LinkOrganismoCultivoDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<LinkOrganismoCultivo, Long> implements LinkOrganismoCultivoDao{

	public LinkOrganismoCultivoDaoHibernateImpl(HibernateTemplate t) {
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
