package PlayWrightSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingResizableElements {

	public static void main(String[] args) throws InterruptedException {

		// Initializing browser and importing playwright

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("https://jqueryui.com/resources/demos/resizable/default.html");

		// Handling Resizable elements

		Locator slider = page.locator("//*[@id=\"resizable\"]/div[3]");

		page.mouse().move(slider.boundingBox().x + slider.boundingBox().width / 2,
				slider.boundingBox().y + slider.boundingBox().height / 2);
		Thread.sleep(2000);
		page.mouse().down();

		page.mouse().move(slider.boundingBox().x + 400, slider.boundingBox().y + 400);
		page.mouse().up();
		System.out.println("Box get resized");

		playwright.close();

	}

}
