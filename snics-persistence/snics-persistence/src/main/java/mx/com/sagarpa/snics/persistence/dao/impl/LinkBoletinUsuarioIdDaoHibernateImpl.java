package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.LinkBoletinUsuarioIdDao;
import mx.com.sagarpa.snics.persistence.entities.LinkBoletinUsuarioId;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class LinkBoletinUsuarioIdDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<LinkBoletinUsuarioId, Long> implements LinkBoletinUsuarioIdDao{

	public LinkBoletinUsuarioIdDaoHibernateImpl(HibernateTemplate t) {
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
