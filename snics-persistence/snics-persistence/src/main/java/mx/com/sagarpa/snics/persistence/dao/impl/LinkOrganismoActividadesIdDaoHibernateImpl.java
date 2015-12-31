package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.LinkOrganismoActividadesIdDao;
import mx.com.sagarpa.snics.persistence.entities.LinkOrganismoActividadesId;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class LinkOrganismoActividadesIdDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<LinkOrganismoActividadesId, Long> implements LinkOrganismoActividadesIdDao {

	public LinkOrganismoActividadesIdDaoHibernateImpl(HibernateTemplate t) {
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
