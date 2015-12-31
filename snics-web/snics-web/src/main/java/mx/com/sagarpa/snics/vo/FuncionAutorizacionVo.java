package mx.com.sagarpa.snics.vo;

import java.io.Serializable;

public class FuncionAutorizacionVo implements Serializable {

	public String getNombreFuncion() {
		return nombreFuncion;
	}
	public void setNombreFuncion(String nombreFuncion) {
		this.nombreFuncion = nombreFuncion;
	}
	public String getUrlFuncion() {
		return urlFuncion;
	}
	public void setUrlFuncion(String urlFuncion) {
		this.urlFuncion = urlFuncion;
	}
	public Integer getIdPermiso() {
		return idPermiso;
	}
	public void setIdPermiso(Integer idPermiso) {
		this.idPermiso = idPermiso;
	}
	public Integer getIdFuncion() {
		return idFuncion;
	}
	public void setIdFuncion(Integer idFuncion) {
		this.idFuncion = idFuncion;
	}
	String nombreFuncion;
	String urlFuncion;
	Integer idPermiso;
	private Integer idFuncion;
}
