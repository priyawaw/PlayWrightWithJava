package PlayWrightSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingMouseHover {

	public static void main(String[] args) {

		// Initializing browser and importing playwright

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("https://www.way2automation.com/");

		// Handling mouse hover
		
		page.locator("//*[@id=\"menu-item-27597\"]/a").hover();
		page.locator("//*[@id=\"menu-item-27601\"]/a/span[2]").click();
		System.out.println("Category selected by using mouse hover action");
		
		playwright.close();

	}

}
