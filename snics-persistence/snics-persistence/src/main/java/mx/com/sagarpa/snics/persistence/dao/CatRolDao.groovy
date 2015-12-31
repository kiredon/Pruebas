package mx.com.sagarpa.snics.persistence.dao

import java.util.List;
import mx.com.sagarpa.snics.persistence.entities.CatRol
import mx.com.sagarpa.snics.persistence.GenericDao;


interface CatRolDao extends GenericDao<CatRol,Integer> {
	public List<CatRol> getListByStatus(boolean status, int pagina, int tamanio)
	public CatRol getListByIdRol(Integer id)
	public boolean CambiarEstado(CatRol Rol)
	
	public int getTotalByStatus(boolean status)
	public int getTotalByStatusNombre(String nombre,boolean status)
	public Boolean validaNombre(String nombre)
}
