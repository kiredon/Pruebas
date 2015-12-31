package mx.com.sagarpa.snics.service



enum ResponseStatus {

	/** Status 200 when request is processed and it's ok. */
	OK(200,"Response Ok"),
	NOT_FOUND(404,"Not found"),
	FORBIDDEN(403,"Forbidden"),
	/**Generic 500 error to avoid giving to much information*/
	INTERNAL_ERROR(500, "Internal Server Error")

	private ResponseStatus(int status,String desc) {
		this.status = status
		this.desc = desc
	}
	/** COmentario de Emmanuel */
	/** Status 200 when request is processed and it's ok. */
	int status
	String desc
}
