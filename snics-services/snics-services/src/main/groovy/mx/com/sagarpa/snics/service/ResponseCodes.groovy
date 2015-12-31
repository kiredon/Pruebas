package mx.com.sagarpa.snics.service

enum ResponseCodes {

	/*Execution of service it's ok.*/
	OK("00","OK"),
	ERROR("01","Error Generico"),
	FORBIDDEN("03","Acceso denegado"),
	
	/*VALIDATION ERRORS*/
	REQUEST_VALIDATION_ERRORS("A001", "Request field errors"),

	/*REGISTER SERVICE RESPONSE CODES*/
	REGISTER_AUTHORITY_DOES_NOT_EXIST("00", "Authority does not exist"),
	REGISTER_USERNAME_ALREADY_EXISTS("E002", "Username already exists"),
	REGISTER_INVALID_TOKEN("E003", "Invalid token for confirmation"),
	DUPLICATED_USER("E004", "Duplicated user"),
	NAME_ALREADY_EXISTS("E002", "Nombre en uso"),
	CLAVE_ALREADY_EXISTS("E002", "Clave en uso"),
	NOT_FOUND("N001","Dato no encontrado"),
	EMPTY_LIST("N002","Lista vacia"),
	NOT_STATUS("N003","El estatus de la transferencia no corresponde a esta sección"),

	
	
	private ResponseCodes(String code, String desc) {
		this.code = code
		this.desc = desc
	}

	String code
	String desc
}
