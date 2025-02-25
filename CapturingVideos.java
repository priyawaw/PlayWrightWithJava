package PlayWrightSessions;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class CapturingVideos {

	public static void main(String[] args) {

		// Initializing browser and importing playwright

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext context = browser
				.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/")));

		// Navigation to website

		Page page = context.newPage();
		page.navigate("https://dev.nccf.youkta.com/#/login");
		// Thread.sleep(6000);
		System.out.println(page.title());

		// Find locators

		page.locator("xpath = //h3[contains(text(), 'Register here?')]").click();
		System.out.println("Landed on registration page");

		page.locator("id=1").click();
		page.selectOption("select", "PACS");
		System.out.println("User type selected as per choice");

		// Uploading file

		page.locator("#validatedCustomFile").nth(1).setInputFiles(Paths.get("./src/test/resources/files/pdf.pdf"));
		System.out.println("File upoaded sucessfully");

		context.close();
		playwright.close();

	}

}
