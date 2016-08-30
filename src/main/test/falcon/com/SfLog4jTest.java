package falcon.com;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SfLog4jTest {
	private static final Logger logger =  LoggerFactory.getLogger(SfLog4jTest.class);
	public static void main(String[] args) {
		//BasicConfigurator.configure();
		//PropertyConfigurator.configure("./tb/log4j.properties");
		logger.info("SfLog4jTest");
		logger.error("SfLog4jTest");
	}
}
