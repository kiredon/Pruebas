package mx.com.sagarpa.snics.persistence.daoimport mx.com.sagarpa.snics.persistence.GenericDaoimport mx.com.sagarpa.snics.persistence.entities.DatSnowflake
interface DatSnowflakeDao extends GenericDao<DatSnowflake,Integer> {
	public boolean validarSesion(int idUsuario,String origen,String user_agent)  	public boolean borrarSnowflakeCaducados(int idUsuario)	public DatSnowflake obtieneSnowflake(int idUsuario,String origen,String user_agent)	public DatSnowflake validarSnowflakeServicio(String snowflake,String origen,String user_agent)	public void borraSnowflake(Integer idUsuario)	
}
