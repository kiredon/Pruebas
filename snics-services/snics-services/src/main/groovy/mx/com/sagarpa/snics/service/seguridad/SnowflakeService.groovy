package mx.com.sagarpa.snics.service.seguridad

import mx.com.sagarpa.snics.service.seguridad.usuario.dto.LoginRequest
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.LoginResponse
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.LogoutRequest
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.LogoutResponse
import mx.com.sagarpa.snics.service.seguridad.usuario.dto.ObtenerObjetoAutorizacionResponse


interface SnowflakeService {
	public LoginResponse Login(LoginRequest request)
	public boolean validaServicio(LoginRequest request, String snowflake,Boolean ajustaTiempo)//la tercera variable es para que se incremente o no el timpo de vida del snowflake
	public String obtenerIdUsuario(String snowflake)
	public String obtenerNombreUsuario(String snowflake)
	public ObtenerObjetoAutorizacionResponse obtenerObjetoAutorizacion(String snowflake)
	public boolean validaServicioAutorizado(String authHeader,String MD5)
	public LogoutResponse logout(LogoutRequest request)
}
