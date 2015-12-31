package mx.com.sagarpa.snics.persistence.dao;

import java.util.List;

import mx.com.sagarpa.snics.persistence.GenericDao;
import mx.com.sagarpa.snics.persistence.entities.DatUsuario;

public interface DatUsuarioDao extends GenericDao<DatUsuario, Long> {
	
	public List<DatUsuario> getListByStatus(boolean status, int pagina, int tamanio)
	public DatUsuario getByNombreUsuario(String nombreUsuario)
	public DatUsuario getByPass(String contrasena)
	public DatUsuario getListByIdUsuario(Integer id)
	public boolean getByPassId(String contrasenia, String idUsuario)
	public String cifrarContrasenia (String contrasenia)
	public String generarContrasenia (String nombreUsuario)
	public Boolean validaNombre(String nombre)
	public DatUsuario getByNombreUsuarioContrasenia(String nombreUsuario,String contrasena) 
	
		
		
		
		


}
