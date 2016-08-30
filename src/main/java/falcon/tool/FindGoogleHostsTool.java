package falcon.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.log4j.chainsaw.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindGoogleHostsTool {
	private static final Logger logger = LoggerFactory.getLogger(FindGoogleHostsTool.class)	;
	public static  void  getHosts() throws IOException, URISyntaxException{
		
		URL url = new URL(PropertiesTools.getProperties(PropertiesTools.GIT_HUB_URL_KEY));
		InputStream in  = null;
		FileOutputStream  out = new FileOutputStream(new File(PropertiesTools.HOSTS_PATH_KEY));
		in = url.openStream(); 
		for(int buf;(buf=in.read())!=-1;){
			out.write(buf);
		}
		if(null!=out){
			out.close();
		}
		if(null!=in){
			in.close();
		}
	}
	public static void main(String[] args) throws IOException, URISyntaxException {
		getHosts();
	}

	
}
