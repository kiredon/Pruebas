package mx.com.sagarpa.snics.persistence.dao

import java.util.List;

import mx.com.sagarpa.snics.persistence.GenericDao
import mx.com.sagarpa.snics.persistence.entities.LinkRolPermiso
import mx.com.sagarpa.snics.persistence.entities.LinkRolUsuario;

interface LinkRolUsuarioDao extends GenericDao<LinkRolUsuario, Long>{
	public List<LinkRolUsuario> getByRol(Integer idRol)
	public List<LinkRolUsuario> getByUsuario(Integer idUsuario)
	
	
}
