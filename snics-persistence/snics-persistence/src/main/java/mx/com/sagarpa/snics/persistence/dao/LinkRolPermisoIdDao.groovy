package mx.com.sagarpa.snics.persistence.dao

import mx.com.sagarpa.snics.persistence.GenericDao;
import mx.com.sagarpa.snics.persistence.entities.LinkRolPermisoId


interface LinkRolPermisoIdDao extends GenericDao<LinkRolPermisoId,Integer> {
	public LinkRolPermisoId getListByIdRol(Integer id)
	public LinkRolPermisoId getListByIdPermiso(Integer id)
		
}
