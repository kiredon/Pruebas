package mx.com.sagarpa.snics.service.seguridad.usuario.dto

import javax.validation.constraints.NotNull;

class LoginRequest {
	@NotNull
	String usuario
	
	@NotNull
	String contrasenia
	
	String user_agent
	
	String ipAddress
}
