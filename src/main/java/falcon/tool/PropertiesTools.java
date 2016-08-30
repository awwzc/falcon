package falcon.tool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PropertiesTools {
	public static final String  GIT_HUB_URL_KEY = "github.url";
	public static final String  OSC_URL_KEY = "osc.url";
	public static final String  HOSTS_PATH_KEY = "hosts.path";
	private static final Logger logger = LoggerFactory.getLogger(PropertiesTools.class)	;
	private static final Map<String,String> props = new HashMap<String,String>();
	
	static
	{
		Properties pt =  new Properties();
		try {
			pt.load(PropertiesTools.class.getClassLoader().getResourceAsStream("urls.properties"));
			props.put(GIT_HUB_URL_KEY, pt.getProperty(GIT_HUB_URL_KEY));
			props.put(OSC_URL_KEY, pt.getProperty(OSC_URL_KEY));
			props.put(HOSTS_PATH_KEY, pt.getProperty(HOSTS_PATH_KEY));
		} catch (FileNotFoundException e) {
			logger.error("cant not find urls.properties ",e);
		} catch (IOException e) {
			logger.error("load  urls.properties exception ",e);
		}
	}
	
   public static   String  getProperties (String key){
	   return  props.get(key);
   }
   
   public static void main(String[] args) {
	   System.out.println("classLoader:"+PropertiesTools.class.getClassLoader());
	  System.out.println(getProperties(PropertiesTools.HOSTS_PATH_KEY)) ;
   }
	
}
