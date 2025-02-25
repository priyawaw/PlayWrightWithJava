package PlayWrightSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingSlider {

	public static void main(String[] args) throws InterruptedException {

		// Initializing browser and importing playwright

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("https://jqueryui.com/resources/demos/slider/default.html");

		// Handling slider

		Locator slider = page.locator("//*[@id=\"slider\"]/span");

		page.mouse().move(slider.boundingBox().x + slider.boundingBox().width / 2,
				slider.boundingBox().y + slider.boundingBox().height / 2);
		Thread.sleep(2000);
		page.mouse().down();

		page.mouse().move(slider.boundingBox().x + 400, slider.boundingBox().y + slider.boundingBox().height / 2);
		page.mouse().up();
		System.out.println("Slider moved to right");
		
		playwright.close();

	}

}
