package mx.com.sagarpa.snics.common.config;



import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.configuration.AbstractFileConfiguration;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;

/**
 * Decorator around Configuration
 * @author 
 */
@SuppressWarnings("rawtypes")
public class AppConfig implements Configuration {
	
	private Configuration config;
	
	private String propertiesPackage = "/mx/com/sagarpa/snics/config/";
	
	public AppConfig() throws ConfigurationException{
		try
		{
		System.out.println(" AppConfig default constructor."); 
		config= load(propertiesPackage + "runtime.properties");
		((AbstractFileConfiguration) config).setReloadingStrategy(new FileChangedReloadingStrategy());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public AppConfig(String file) throws ConfigurationException{
		config=new PropertiesConfiguration(file);
		((AbstractFileConfiguration) config).setReloadingStrategy(new FileChangedReloadingStrategy());
	}

	public Configuration subset(String prefix) {
		return config.subset(prefix);
	}

	public boolean isEmpty() {
		return config.isEmpty();
	}

	public boolean containsKey(String key) {
		return config.containsKey(key);
	}

	public void addProperty(String key, Object value) {
		config.addProperty(key, value);
	}

	public void setProperty(String key, Object value) {
		config.setProperty(key, value);
	}

	public void clearProperty(String key) {
		config.clearProperty(key);
	}

	public void clear() {
		config.clear();
	}

	public Object getProperty(String key) {
		return config.getProperty(key);
	}

	public Iterator getKeys(String prefix) {
		return config.getKeys(prefix);
	}

	public Iterator getKeys() {
		return config.getKeys();
	}

	public Properties getProperties(String key) {
		return config.getProperties(key);
	}

	public boolean getBoolean(String key) {
		return config.getBoolean(key);
	}

	public boolean getBoolean(String key, boolean defaultValue) {
		return config.getBoolean(key, defaultValue);
	}

	public Boolean getBoolean(String key, Boolean defaultValue) {
		return config.getBoolean(key, defaultValue);
	}

	public byte getByte(String key) {
		return config.getByte(key);
	}

	public byte getByte(String key, byte defaultValue) {
		return config.getByte(key, defaultValue);
	}

	public Byte getByte(String key, Byte defaultValue) {
		return config.getByte(key, defaultValue);
	}

	public double getDouble(String key) {
		return config.getDouble(key);
	}

	public double getDouble(String key, double defaultValue) {
		return config.getDouble(key, defaultValue);
	}

	public Double getDouble(String key, Double defaultValue) {
		return config.getDouble(key, defaultValue);
	}

	public float getFloat(String key) {
		return config.getFloat(key);
	}

	public float getFloat(String key, float defaultValue) {
		return config.getFloat(key, defaultValue);
	}

	public Float getFloat(String key, Float defaultValue) {
		return config.getFloat(key, defaultValue);
	}

	public int getInt(String key) {
		return config.getInt(key);
	}

	public int getInt(String key, int defaultValue) {
		return config.getInt(key, defaultValue);
	}

	public Integer getInteger(String key, Integer defaultValue) {
		return config.getInteger(key, defaultValue);
	}

	public long getLong(String key) {
		return config.getLong(key);
	}

	public long getLong(String key, long defaultValue) {
		return config.getLong(key, defaultValue);
	}

	public Long getLong(String key, Long defaultValue) {
		return config.getLong(key, defaultValue);
	}

	public short getShort(String key) {
		return config.getShort(key);
	}

	public short getShort(String key, short defaultValue) {
		return config.getShort(key, defaultValue);
	}

	public Short getShort(String key, Short defaultValue) {
		return config.getShort(key, defaultValue);
	}

	public BigDecimal getBigDecimal(String key) {
		return config.getBigDecimal(key);
	}

	public BigDecimal getBigDecimal(String key, BigDecimal defaultValue) {
		return config.getBigDecimal(key, defaultValue);
	}

	public BigInteger getBigInteger(String key) {
		return config.getBigInteger(key);
	}

	public BigInteger getBigInteger(String key, BigInteger defaultValue) {
		return config.getBigInteger(key, defaultValue);
	}

	public String getString(String key) {
		return config.getString(key);
	}

	public String getString(String key, String defaultValue) {
		return config.getString(key, defaultValue);
	}

	public String[] getStringArray(String key) {
		return config.getStringArray(key);
	}

	public List getList(String key) {
		return config.getList(key);
	}

	public List getList(String key, List defaultValue) {
		return config.getList(key, defaultValue);
	}
	
	public PropertiesConfiguration load( final String file ) throws Exception
    {
		System.out.println("Cargando properties desde: " + file);
		
		ClassLoader classLoader = getClass().getClassLoader();
		if(classLoader.getResource(file) != null){
			File f = new File( classLoader.getResource(file).getFile());
			return new PropertiesConfiguration(f);
		}else{
			PropertiesConfiguration c = new PropertiesConfiguration();
			c.load(getClass().getResourceAsStream(file));
			return c;
		}
		
		
//		return f;
//	 InputStream is ;
//	 
//	 		if(file==null)
//	 			throw new Exception("File to load is null");
//	 		
//	 		byte[] bytes=null;
//	 		
//	 		System.out.println( "Loading resource from file system. file["+file+"]" );
//            File f = new File(file);
//            if(f.exists())
//            {
//	            FileInputStream fis = new FileInputStream( file );
//	            is= fis;
//            }
//            else
//            {
//            	System.out.println("Resource not found in file system. Trying to load as classpath resource");
//            	URL resource = AppConfig.class.getResource(file);
//				if(resource==null)
//				{
//					throw new Exception("Resource not found in classpath");
//				}
//				String resourceFile = resource.getFile();
//				if(resourceFile==null)
//					throw new Exception("resource is null");
//				f = new File(file);
//				FileInputStream fis;
//				try
//				{
//					fis= new FileInputStream( f);
//					is=fis;
//				}
//				catch(Exception e)
//				{
//					System.out.println("Could not Load as system file. loading as resource from jar");
//					f = new File(resource.toURI());
//					is= new FileInputStream(f);
//				}
//				System.out.println("Resource loaded from classpath.");
//            }
//            
//            return f;
    }

	
}
