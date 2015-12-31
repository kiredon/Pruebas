package mx.com.sagarpa.snics.dto;

import java.io.Serializable;
import java.util.List;

import mx.com.sagarpa.snics.vo.FuncionAutorizacionVo;
import mx.com.sagarpa.snics.vo.ObjetoAutorizacionVo;
import mx.com.sagarpa.snics.vo.PermisoAutorizacionVo;




public class ObtenerObjetoAutorizacionResponse extends ServiceResponse implements Serializable {
	
	public ObjetoAutorizacionVo getObjetoAutorizacion() {
		return objetoAutorizacion;
	}
	public void setObjetoAutorizacion(ObjetoAutorizacionVo objetoAutorizacion) {
		this.objetoAutorizacion = objetoAutorizacion;
	}
	public List<PermisoAutorizacionVo> getPermisos() {
		return permisos;
	}
	public void setPermisos(List<PermisoAutorizacionVo> permisos) {
		this.permisos = permisos;
	}
	public List<FuncionAutorizacionVo> getFunciones() {
		return funciones;
	}
	public void setFunciones(List<FuncionAutorizacionVo> funciones) {
		this.funciones = funciones;
	}
	public boolean isPrescripcion() {
		return prescripcion;
	}
	public void setPrescripcion(boolean prescripcion) {
		this.prescripcion = prescripcion;
	}
	public boolean isServicio() {
		return servicio;
	}
	public void setServicio(boolean servicio) {
		this.servicio = servicio;
	}
	
	ObjetoAutorizacionVo objetoAutorizacion;
	List<PermisoAutorizacionVo> permisos;
	List<FuncionAutorizacionVo> funciones;

	boolean prescripcion = false;
	boolean servicio = false;
	 
}
