package mx.com.sagarpa.snics.persistence.dao

import mx.com.sagarpa.snics.persistence.GenericDao
import mx.com.sagarpa.snics.persistence.entities.CatConfig



interface CatConfigDao extends GenericDao<CatConfig,Integer> {
	
	public String getConfigByName(String name)
}
