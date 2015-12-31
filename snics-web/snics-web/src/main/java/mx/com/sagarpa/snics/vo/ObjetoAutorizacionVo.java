package mx.com.sagarpa.snics.vo;

import java.io.Serializable;

public class ObjetoAutorizacionVo implements Serializable {

	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer[] getIdRol() {
		return idRol;
	}
	public void setIdRol(Integer[] idRol) {
		this.idRol = idRol;
	}
	public Integer getIdUnidadJerarquica() {
		return idUnidadJerarquica;
	}
	public void setIdUnidadJerarquica(Integer idUnidadJerarquica) {
		this.idUnidadJerarquica = idUnidadJerarquica;
	}

	public String[] getNombreRol() {
		return nombreRol;
	}
	public void setNombreRol(String[] nombreRol) {
		this.nombreRol = nombreRol;
	}
	public String getNombreUnidadJerarquica() {
		return nombreUnidadJerarquica;
	}
	public void setNombreUnidadJerarquica(String nombreUnidadJerarquica) {
		this.nombreUnidadJerarquica = nombreUnidadJerarquica;
	}
	public String getPathUnidadJerarquica() {
		return pathUnidadJerarquica;
	}
	public void setPathUnidadJerarquica(String pathUnidadJerarquica) {
		this.pathUnidadJerarquica = pathUnidadJerarquica;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	private Integer idUsuario;
	private Integer[] idRol;
	private Integer idUnidadJerarquica;
	private String[] nombreRol;
	private String nombreUnidadJerarquica;
	private String pathUnidadJerarquica;
	private String nombreUsuario;
	private String nombreCompleto;
	private String correoElectronico;
	private String nombreUnidadJerarquicaHospital;
	private Integer[] idsUnidadesJerarquicasUsuario;
	public String getNombreUnidadJerarquicaHospital() {
		return nombreUnidadJerarquicaHospital;
	}
	public void setNombreUnidadJerarquicaHospital(
			String nombreUnidadJerarquicaHospital) {
		this.nombreUnidadJerarquicaHospital = nombreUnidadJerarquicaHospital;
	}
	public Integer[] getIdsUnidadesJerarquicasUsuario() {
		return idsUnidadesJerarquicasUsuario;
	}
	public void setIdsUnidadesJerarquicasUsuario(
			Integer[] idsUnidadesJerarquicasUsuario) {
		this.idsUnidadesJerarquicasUsuario = idsUnidadesJerarquicasUsuario;
	}

}
