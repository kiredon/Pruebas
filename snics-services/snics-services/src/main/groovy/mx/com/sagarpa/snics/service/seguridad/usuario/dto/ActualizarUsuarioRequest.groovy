package mx.com.sagarpa.snics.service.seguridad.usuario.dto

import javax.validation.constraints.NotNull;


class ActualizarUsuarioRequest {
	@NotNull
     public Integer idUsuario;
     public String nombreUsuario;
     public String nombre;
     public String apellidoPaterno;
     public String apellidoMaterno;
     public String contrasena;
     public boolean status;
	 public boolean handheld;

}
