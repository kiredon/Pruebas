package mx.com.sagarpa.snics.dto;

import java.io.Serializable;

class ServiceResponse implements Serializable {
	/**
	 * the http response status: 200:ok, 404: not found, etc
	 */
	private String responseCode;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
}
