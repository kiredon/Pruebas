package mx.com.sagarpa.snics.persistence.dao

import java.util.List;
import mx.com.sagarpa.snics.persistence.GenericDao
import mx.com.sagarpa.snics.persistence.entities.CatPermiso


interface CatPermisoDao extends GenericDao<CatPermiso,Integer> {
	public List<CatPermiso> getListByStatus(boolean status)
	public CatPermiso getListById(Integer id)
	public boolean CambiarEstado(CatPermiso Permiso)


}
