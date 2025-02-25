package PlayWrightSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingTabsAndPopups {

	public static void main(String[] args) {

		// Initializing browser and importing playwright

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("https://sso.teachable.com/secure/673/identity/sign_up/email");

		// Handling popup

		Page popup = page.waitForPopup(() -> {

			page.locator(
					"body > main > div > form > div.form-footer.ash.m-b-3-xs > div.m-b-3-xs.form-footer.ash.bodyMain > a:nth-child(2)")
					.nth(0).click();
			System.out.println("Landed on privacy policy page");

		});

		popup.locator("//*[@id=\"header-sign-up-btn\"]").click();
		popup.locator("[id='name']").fill("Priya Bhopale");
		System.out.println("Name entered in name field");

		popup.close();
		playwright.close();

	}

}
