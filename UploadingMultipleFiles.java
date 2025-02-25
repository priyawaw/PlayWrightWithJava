package PlayWrightSessions;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class UploadingMultipleFiles {

	public static void main(String[] args) {

		// Initializing browser and importing playwright

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		// Navigation to website

		Page page = browser.newPage();
		page.navigate("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_fileupload_multiple");
		
		// Uploading files

		page.frameLocator("#iframeResult").locator("#myFile").setInputFiles(new Path[] {

				Paths.get("./src/test/resources/files/Dr Prescription.jpg"),
				Paths.get("./src/test/resources/files/youkta_logo.png") });
		
		System.out.println("Files uploaded");
		
		playwright.close();

	}

}
