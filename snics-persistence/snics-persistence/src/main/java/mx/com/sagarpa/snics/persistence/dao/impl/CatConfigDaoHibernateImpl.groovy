package mx.com.sagarpa.snics.persistence.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.hibernate.criterion.Restrictions;





import mx.com.sagarpa.snics.persistence.dao.CatConfigDao;
import mx.com.sagarpa.snics.persistence.entities.CatConfig;
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl;

public class CatConfigDaoHibernateImpl extends AbstractGenericDaoHibernateImpl<CatConfig, Long> implements CatConfigDao{

	public CatConfigDaoHibernateImpl(HibernateTemplate t) {
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
	public List<CatConfig> getListByStatus(boolean status){
		
		if(status==false){
			DetachedCriteria c = DetachedCriteria.forClass(CatConfig.class)
			c.add(Restrictions.eq("status", status))
			return (List<CatConfig>) this.getHibernateTemplate().findByCriteria(c)
		}
		else{
			Criteria cr = session.createCriteria(CatConfig.class);
			List results = cr.list();
			return (List<CatConfig>)results
		}
	}
	public CatConfig getListByIdRol(Integer id){									
					DetachedCriteria c = DetachedCriteria.forClass(CatConfig.class)
					c.add(Restrictions.eq("idConfig", id))
					return (CatConfig) this.getHibernateTemplate().findByCriteria(c)						
			}
	
	public boolean CambiarEstado(CatConfig Config){
		this.getHibernateTemplate().update(Config)
	}

public String getConfigByName(String name){

	Criteria cr = session.createCriteria(CatConfig.class)
	cr.add(Restrictions.eq("nombreConfig", name))
	CatConfig config = cr.uniqueResult()
	
	return config.getConfig()
}
}
