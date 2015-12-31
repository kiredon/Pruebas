package mx.com.sagarpa.snics.vo;

import java.io.Serializable;

public class PermisoAutorizacionVo implements Comparable<PermisoAutorizacionVo>, Serializable {

	public String getNombrePermiso() {
		return nombrePermiso;
	}
	public void setNombrePermiso(String nombrePermiso) {
		this.nombrePermiso = nombrePermiso;
	}
	public String getUrlPermiso() {
		return urlPermiso;
	}
	public void setUrlPermiso(String urlPermiso) {
		this.urlPermiso = urlPermiso;
	}
	String nombrePermiso;
	String urlPermiso;
	private Integer idPermiso;
	@Override
	public int compareTo(PermisoAutorizacionVo o) {
		return this.nombrePermiso.compareTo(o.nombrePermiso);
	}
	public Integer getIdPermiso() {
		return idPermiso;
	}
	public void setIdPermiso(Integer idPermiso) {
		this.idPermiso = idPermiso;
	}
	
	
}
