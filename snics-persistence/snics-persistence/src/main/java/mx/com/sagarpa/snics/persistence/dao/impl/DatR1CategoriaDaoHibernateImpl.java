package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import mx.com.sagarpa.snics.persistence.dao.DatR1CategoriaDao;
import mx.com.sagarpa.snics.persistence.entities.DatR1Categoria;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class DatR1CategoriaDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<DatR1Categoria, Long> implements DatR1CategoriaDao{

	public DatR1CategoriaDaoHibernateImpl(HibernateTemplate t) {
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
