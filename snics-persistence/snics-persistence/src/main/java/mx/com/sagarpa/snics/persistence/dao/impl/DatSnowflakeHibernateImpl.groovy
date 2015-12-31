package mx.com.sagarpa.snics.persistence.dao.impl

import java.util.List;

import mx.com.sagarpa.snics.persistence.dao.DatSnowflakeDao
import mx.com.sagarpa.snics.persistence.entities.DatSnowflake
import mx.com.sagarpa.snics.persistence.impl.AbstractGenericDaoHibernateImpl
import org.hibernate.Criteria
import org.hibernate.Query
import org.hibernate.criterion.Criterion
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;


class DatSnowflakeHibernateImpl extends AbstractGenericDaoHibernateImpl<DatSnowflake,Integer> implements DatSnowflakeDao {

	public DatSnowflakeHibernateImpl(HibernateTemplate t){
		super(t)
	}
	
	public String getPersistenceClassId() {
		return "id"
	}

	public  List<String> getPersistenceClassSkippedProperties() {
		return []
	}

	public boolean validarSesion(int idUsuario, String origen, String user_agent) {
		Criteria cr = session.createCriteria(DatSnowflake.class)
		cr.createAlias("datUsuario", "usuario")
		Criterion critEQ = Restrictions.eq("usuario.idUsuario", idUsuario)
		Criterion critOR = Restrictions.or( Restrictions.ne("origen", origen), Restrictions.ne("userAgent", user_agent))
		cr.add(Restrictions.and(critEQ,critOR ))
		
		List<DatSnowflake> lista = cr.list()
		lista.each {
			println it.idSnowflake
		}
		if(lista.size() > 0){
			return false
		}
		return true
	}

	public boolean borrarSnowflakeCaducados(int idUsuario) {
		
		Criteria cr = session.createCriteria(DatSnowflake.class)
		cr.createAlias("datUsuario", "usuario")
		cr.add(Restrictions.eq("usuario.idUsuario", idUsuario))
		cr.add(Restrictions.lt("fechaCaducidad",new Date()))
		List<DatSnowflake> caducados = cr.list()
		caducados.each {
			this.delete(it)
		}
		return true;
	}

	public DatSnowflake obtieneSnowflake(int idUsuario, String origen,
			String user_agent) {
			
		Criteria cr = session.createCriteria(DatSnowflake.class)
		cr.createAlias("datUsuario", "usuario")
		cr.add(Restrictions.eq("origen", origen))
		cr.add(Restrictions.eq("usuario.idUsuario",idUsuario))
		cr.add(Restrictions.eq("userAgent", user_agent))
		return cr.uniqueResult()
	}
			
			
	public DatSnowflake validarSnowflakeServicio(String snowflake,String origen,String user_agent){
		Criteria cr = session.createCriteria(DatSnowflake.class)
		cr.add(Restrictions.eq("snowflake", snowflake))
		cr.add(Restrictions.eq("origen",origen))
		cr.add(Restrictions.eq("userAgent",user_agent))
		cr.add(Restrictions.gt("fechaCaducidad", new Date()))
		
		return cr.uniqueResult()
	}
	
	public void borraSnowflake(Integer idUsuario){
		Criteria cr = session.createCriteria(DatSnowflake.class)
		cr.createAlias("datUsuario", "usuario")
		cr.add(Restrictions.eq("usuario.idUsuario", idUsuario))
		List<DatSnowflake> caducados = cr.list()
		caducados.each {
			this.delete(it)
		}
		
	}
}
