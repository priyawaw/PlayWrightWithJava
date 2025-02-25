package PlayWrightSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlinkCheckBoxes {

	public static void main(String[] args) {

		// Initializing browser and importing playwright

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		// Navigation to website

		Page page = browser.newPage();
		page.navigate("http://www.tizag.com/htmlT/htmlcheckboxes.php");

		Locator block = page.locator("//html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]");

		Locator checkboxes = block.locator("[type='checkbox']");

		for (int i = 0; i < checkboxes.count(); i++) {

			checkboxes.nth(i).click();

		}

		System.out.println(checkboxes.count());

		try {

			Thread.sleep(5000);

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

		page.close();

		browser.close();

		playwright.close();

	}

}
