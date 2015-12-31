package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.LinkBoletinUsuarioDao;
import mx.com.sagarpa.snics.persistence.entities.LinkBoletinUsuario;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class LinkBoletinUsuarioDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<LinkBoletinUsuario, Long> implements LinkBoletinUsuarioDao{

	public LinkBoletinUsuarioDaoHibernateImpl(HibernateTemplate t) {
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
