package PlayWrightSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DifferentBrowsers {

	public static void main(String[] args) {

		Playwright playwright = Playwright.create();

		// Browser browser = playwright.firefox().launch(new
		// BrowserType.LaunchOptions().setHeadless(false));

		Browser browser = playwright.chromium()
				.launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));

		Page page = browser.newPage();

		page.navigate("https://dev.nccf.youkta.com");

		System.out.println(page.title());

		playwright.close();

	}

}
