package mx.com.sagarpa.snics.service.base.dto;

import java.util.List;

import mx.com.sagarpa.snics.service.dto.ServiceResponse;
import mx.com.sagarpa.snics.service.base.vo.*;

public class ObtenerPaisResponse extends ServiceResponse{
	
	List<PaisVO> list;

	public List<PaisVO> getList() {
		return list;
	}

	public void setList(List<PaisVO> list) {
		this.list = list;
	}
	
}
