package mx.com.sagarpa.snics.persistence.configuration

import mx.com.sagarpa.snics.persistence.dao.CatActividadesOrganismoDao
import mx.com.sagarpa.snics.persistence.dao.CatCalificacionDao
import mx.com.sagarpa.snics.persistence.dao.CatCategoriaDao
import mx.com.sagarpa.snics.persistence.dao.CatCategoriaProduccionDao
import mx.com.sagarpa.snics.persistence.dao.CatCicloAgricolaDao
import mx.com.sagarpa.snics.persistence.dao.CatColoniaDao
import mx.com.sagarpa.snics.persistence.dao.CatCondicionCultivoDao
import mx.com.sagarpa.snics.persistence.dao.CatConfigDao
import mx.com.sagarpa.snics.persistence.dao.CatCultivoDao
import mx.com.sagarpa.snics.persistence.dao.CatFuncionDao
import mx.com.sagarpa.snics.persistence.dao.CatPermisoDao
import mx.com.sagarpa.snics.persistence.dao.CatRolDao
import mx.com.sagarpa.snics.persistence.dao.DatSnowflakeDao
import mx.com.sagarpa.snics.persistence.dao.DatUsuarioDao
import mx.com.sagarpa.snics.persistence.dao.LinkRolPermisoDao
import mx.com.sagarpa.snics.persistence.dao.LinkRolPermisoIdDao
import mx.com.sagarpa.snics.persistence.dao.LinkRolUsuarioDao



/**
 * 
 * @author etorres
 *
 */
interface SnicsPersistenceConfiguration {
	public CatCalificacionDao catCalificacionDao()
	public DatSnowflakeDao datSnowflakeDao();
	public DatUsuarioDao datUsuarioDao();
	public CatConfigDao catConfigDao();
	public CatActividadesOrganismoDao catActividadesOrganismoDao();
	public CatCategoriaDao catCategoriaDao();
	public CatCategoriaProduccionDao CatCategoriaProduccionDao();
	public CatCicloAgricolaDao catCicloAgricolaDao();
	public CatColoniaDao catColoniDao();
	public CatCondicionCultivoDao catCondicionCultivoDao();
	public CatFuncionDao catFuncionDao();
	public CatPermisoDao catPermisoDao();
	public CatRolDao catRolDao();
	public LinkRolPermisoDao linkRolPermisoDao();
	public LinkRolPermisoIdDao linkRolPermisoIdDao();
	public LinkRolUsuarioDao linkRolUsuarioDao();
	
	
	
	
	
	
	
}
