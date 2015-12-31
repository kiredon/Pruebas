package mx.com.sagarpa.snics.common.config


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext

/**
 * 
 * @author 
 *
 */
class AppConfigProfileInitializer implements ApplicationContextInitializer {

	public void initialize(ConfigurableApplicationContext applicationContext) {
		AppConfig config = new AppConfig()
		//Loads the JEE environment by default
		String profile = config.getString("server.specification", "JEE")
		//Properties p = new Properties();
		//p.load(load("runtime.properties"));
		//String str=p.getProperty("server.specification");
		//String str = config.getString("server.specification");
		println "********************************************     Setting [${profile}] as active Spring Profile."
		
		
		
		applicationContext.getEnvironment().setActiveProfiles(profile)
	}
	
	public static InputStream load( final String file ) throws Exception
	{
	 
	 InputStream is ;
	 
			 if(file==null)
				 throw new Exception("File to load is null");
			 
			 byte[] bytes=null;
			 
			 System.out.println( "Loading resource from file system. file["+file+"]" );
			File f = new File(file);
			if(f.exists())
			{
				FileInputStream fis = new FileInputStream( file );
				is= fis;
			}
			else
			{
				System.out.println("Resource not found in file system. Trying to load as classpath resource");
				URL resource = AppConfigProfileInitializer.class.getResource(file);
				if(resource==null)
				{
					throw new Exception("Resource not found in classpath");
				}
				String resourceFile = resource.getFile();
				if(resourceFile==null)
					throw new Exception("resource is null");
				f = new File(file);
				FileInputStream fis;
				try
				{
					fis= new FileInputStream( file);
					is=fis;
				}
				catch(Exception e)
				{
					System.out.println("Could not Load as system file. loading as resource from jar");
					is= new FileInputStream( new File(resource.toURI()));
				}
				System.out.println("Resource loaded from classpath.");
			}
			
			return is;
	}
	
	
}