package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.LinkOrganismoActividadesDao;
import mx.com.sagarpa.snics.persistence.entities.LinkOrganismoActividades;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class LinkOrganismoActividadesDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<LinkOrganismoActividades, Long> implements LinkOrganismoActividadesDao{

	public LinkOrganismoActividadesDaoHibernateImpl(HibernateTemplate t) {
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
