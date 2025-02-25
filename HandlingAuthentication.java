package PlayWrightSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingAuthentication {

	public static void main(String[] args) {

		// Initializing browser and importing playwright

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		// Navigation to website and handling authentication

		BrowserContext context = browser
				.newContext(new Browser.NewContextOptions().setHttpCredentials("admin", "admin"));
		Page page = context.newPage();
		page.navigate("http://the-internet.herokuapp.com/basic_auth");
		
		playwright.close();
	}

}
