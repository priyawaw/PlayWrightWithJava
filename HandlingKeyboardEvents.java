package PlayWrightSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator.TypeOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingKeyboardEvents {

	public static void main(String[] args) throws InterruptedException {

		// Initializing browser and importing playwright

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("https://login.yahoo.com/");

		// Handling Keyboard Events

		page.locator("#login-username").type("trainer@way2automation.com", new TypeOptions().setDelay(100));
		page.keyboard().press("Enter");
		Thread.sleep(1000);

		page.goBack();

		page.keyboard().press("Control+A");
		Thread.sleep(1000);

		page.keyboard().press("Control+X");
		Thread.sleep(1000);

		page.keyboard().press("Control+V");
		Thread.sleep(1000);

		page.keyboard().press("Shift");
		for (int i = 0; i < 3; i++) {

			page.keyboard().press("ArrowLeft");
			Thread.sleep(1000);
		}

	}

}
