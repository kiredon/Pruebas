package mx.com.sagarpa.snics.persistence.configuration.impl

import javax.sql.DataSource






import mx.com.sagarpa.snics.persistence.configuration.SnicsPersistenceConfiguration
import mx.com.sagarpa.snics.persistence.dao.CatActividadesOrganismoDao;
import mx.com.sagarpa.snics.persistence.dao.CatCalificacionDao
import mx.com.sagarpa.snics.persistence.dao.CatCategoriaDao;
import mx.com.sagarpa.snics.persistence.dao.CatCategoriaProduccionDao;
import mx.com.sagarpa.snics.persistence.dao.CatCicloAgricolaDao;
import mx.com.sagarpa.snics.persistence.dao.CatColoniaDao;
import mx.com.sagarpa.snics.persistence.dao.CatCondicionCultivoDao;
import mx.com.sagarpa.snics.persistence.dao.CatConfigDao;
import mx.com.sagarpa.snics.persistence.dao.CatFuncionDao;
import mx.com.sagarpa.snics.persistence.dao.CatPermisoDao;
import mx.com.sagarpa.snics.persistence.dao.CatRolDao;
import mx.com.sagarpa.snics.persistence.dao.DatSnowflakeDao
import mx.com.sagarpa.snics.persistence.dao.DatUsuarioDao
import mx.com.sagarpa.snics.persistence.dao.LinkRolPermisoDao;
import mx.com.sagarpa.snics.persistence.dao.LinkRolPermisoIdDao;
import mx.com.sagarpa.snics.persistence.dao.LinkRolUsuarioDao;
import mx.com.sagarpa.snics.persistence.dao.impl.CatActividadesOrganismoDaoHibernateImpl
import mx.com.sagarpa.snics.persistence.dao.impl.CatCalificacionDaoHibernateImpl
import mx.com.sagarpa.snics.persistence.dao.impl.CatCategoriaDaoHibernateImpl
import mx.com.sagarpa.snics.persistence.dao.impl.CatCategoriaProduccionDaoHibernateImpl
import mx.com.sagarpa.snics.persistence.dao.impl.CatCicloAgricolaDaoHibernateImpl
import mx.com.sagarpa.snics.persistence.dao.impl.CatColoniaDaoHibernateImpl
import mx.com.sagarpa.snics.persistence.dao.impl.CatCondicionCultivoDaoHibernateImpl
import mx.com.sagarpa.snics.persistence.dao.impl.CatConfigDaoHibernateImpl
import mx.com.sagarpa.snics.persistence.dao.impl.CatFuncionDaoHibernateImpl
import mx.com.sagarpa.snics.persistence.dao.impl.CatPermisoDaoHibernateImpl
import mx.com.sagarpa.snics.persistence.dao.impl.CatRolDaoHibernateImpl
import mx.com.sagarpa.snics.persistence.dao.impl.DatSnowflakeHibernateImpl
import mx.com.sagarpa.snics.persistence.dao.impl.DatUsuarioDaoHibernateImpl
import mx.com.sagarpa.snics.persistence.dao.impl.LinkRolPermisoDaoHibernateImpl
import mx.com.sagarpa.snics.persistence.dao.impl.LinkRolPermisoIdDaoHibernateImpl
import mx.com.sagarpa.snics.persistence.dao.impl.LinkRolUsuarioDaoHibernateImpl

import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.orm.hibernate3.HibernateTemplate


/**
 * 
 * @author etorres
 *
 */
@Configuration
class SnicsPersistenceConfigurationImpl implements SnicsPersistenceConfiguration {

	@Autowired
	@Qualifier("dataSourceSnics")
	DataSource dataSource

	@Autowired
	@Qualifier("sessionFactorySnics")
	SessionFactory sessionFactory

	@Bean
	public HibernateTemplate hibernateTemplateSnics() {
		HibernateTemplate hibernateTemplate = new HibernateTemplate()
		hibernateTemplate.setSessionFactory(sessionFactory)
		return hibernateTemplate
	}


	@Bean
	public CatCalificacionDao catCalificacionDao() {
		return new CatCalificacionDaoHibernateImpl(hibernateTemplateSnics())
	}
	@Bean
	public DatSnowflakeDao datSnowflakeDao(){
		return new DatSnowflakeHibernateImpl(hibernateTemplateSnics());

	}
	@Bean
	public DatUsuarioDao datUsuarioDao(){
		return new DatUsuarioDaoHibernateImpl(hibernateTemplateSnics());

	}
	@Bean
	public CatConfigDao catConfigDao(){
		return new CatConfigDaoHibernateImpl(hibernateTemplateSnics());

	}
	@Bean
	public CatPermisoDao catPermisoDao(){
		return new CatPermisoDaoHibernateImpl(hibernateTemplateSnics());

	}
	@Bean
	public CatRolDao catRolDao(){
		return new CatRolDaoHibernateImpl(hibernateTemplateSnics());

	}
	@Bean
	public CatFuncionDao catFuncionDao(){
		return new CatFuncionDaoHibernateImpl(hibernateTemplateSnics());

	}


	@Bean
	public CatActividadesOrganismoDao catActividadesOrganismoDao() {
		return new CatActividadesOrganismoDaoHibernateImpl(hibernateTemplateSnics());
		
	}


	@Bean
	public CatCategoriaDao catCategoriaDao() {
					return new CatCategoriaDaoHibernateImpl(hibernateTemplateSnics());

	}


	@Bean
	public CatCategoriaProduccionDao CatCategoriaProduccionDao() {
					return new CatCategoriaProduccionDaoHibernateImpl(hibernateTemplateSnics());

	}


	@Bean
	public CatCicloAgricolaDao catCicloAgricolaDao() {
					return new CatCicloAgricolaDaoHibernateImpl(hibernateTemplateSnics());

	}


	@Bean
	public CatColoniaDao catColoniDao() {
					return new CatColoniaDaoHibernateImpl(hibernateTemplateSnics());

	}


	@Bean
	public CatCondicionCultivoDao catCondicionCultivoDao() {
					return new CatCondicionCultivoDaoHibernateImpl(hibernateTemplateSnics());

	}
	@Bean
	public LinkRolPermisoDao linkRolPermisoDao() {
					return new LinkRolPermisoDaoHibernateImpl(hibernateTemplateSnics());

	}
	@Bean
	public LinkRolPermisoIdDao linkRolPermisoIdDao() {
		return new LinkRolPermisoIdDaoHibernateImpl(hibernateTemplateSnics());
		
	}
	@Bean
	public LinkRolUsuarioDao linkRolUsuarioDao() {
			return new LinkRolUsuarioDaoHibernateImpl(hibernateTemplateSnics());

	}
	
	



}
