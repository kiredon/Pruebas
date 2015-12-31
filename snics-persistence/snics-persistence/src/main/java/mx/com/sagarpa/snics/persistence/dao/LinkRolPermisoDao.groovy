package mx.com.sagarpa.snics.persistence.dao

import java.util.List;
import mx.com.sagarpa.snics.persistence.GenericDao
import mx.com.sagarpa.snics.persistence.entities.LinkRolPermiso


interface LinkRolPermisoDao extends GenericDao<LinkRolPermiso,Integer> {
	public LinkRolPermiso getByNombreUsuario(String nombreUsuario)
	public LinkRolPermiso getByIdRolyIdPermisouIdUsuario(Integer idRol,Integer idPermiso)
	public List<LinkRolPermiso> getByRol(Integer idRol)
	public List<LinkRolPermiso> getByPermiso(Integer idPermiso)
	
	
}
