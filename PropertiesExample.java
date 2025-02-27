package PlayWrightSessions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExample {

	public static void main(String[] args) throws IOException {

		// Create a Properties object
		Properties props = new Properties();

		// Load the properties file using FileInputStream
		FileInputStream fis = new FileInputStream("src/test/resources/properties/Locators.properties");

		// Correct: Call load() on props, not fis
		props.load(fis);

		System.out.println(props.get("Browser"));

	}

}
