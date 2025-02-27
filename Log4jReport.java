package PlayWrightSessions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jReport {

	public static void main(String[] args) throws IOException {

		Logger log = Logger.getLogger(Log4jReport.class);
		PropertyConfigurator.configure(".\\src\\test\\resources\\properties\\Log4j.prooperties");

		Properties props = new Properties();

		// Load the properties file using FileInputStream
		FileInputStream fis = new FileInputStream("./src/test/resources/properties/Locators.properties");

		// Correct: Call load() on props, not fis
		props.load(fis);

		log.info("Locator Properties file loaded");

		System.out.println(props.get("Browser"));
		log.info("Chrome browser launched");

		System.out.println(props.get("Registerhere_Xpath"));
		log.info("Entering username as admin@nccf.com");

		log.info("Test execution completed");
	}

}
