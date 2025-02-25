package PlayWrightSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingShadowRootElements {

	public static void main(String[] args) throws InterruptedException {

		// Initializing browser and importing playwright

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("chrome://downloads/");
		
		// Handling shadow root elements

		page.locator("#searchInput").fill("Java");
		Thread.sleep(2000);
		playwright.close();

	}

}
