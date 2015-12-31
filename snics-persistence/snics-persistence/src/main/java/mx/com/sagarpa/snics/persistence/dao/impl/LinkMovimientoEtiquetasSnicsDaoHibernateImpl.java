package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import mx.com.sagarpa.snics.persistence.entities.LinkMovimientoEtiquetasSnics;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class LinkMovimientoEtiquetasSnicsDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<LinkMovimientoEtiquetasSnics, Long>{

	public LinkMovimientoEtiquetasSnicsDaoHibernateImpl(HibernateTemplate t) {
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
