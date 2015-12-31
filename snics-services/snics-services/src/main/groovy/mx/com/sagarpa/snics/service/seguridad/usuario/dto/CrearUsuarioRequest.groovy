package mx.com.sagarpa.snics.service.seguridad.usuario.dto

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;





class CrearUsuarioRequest {
	 @NotNull
	 @Min(1L)
	 public Integer idUsuario;
	 public boolean handheld;
     public String nombreUsuario;
     public String nombre;
     public String apellidoPaterno;
     public String apellidoMaterno;
     public String contrasena;
     public boolean status;

}
