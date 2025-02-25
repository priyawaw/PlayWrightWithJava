package PlayWrightSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator.ClickOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Page.TypeOptions;

public class Locators {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {

		// Initializing browser and importing playwright

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		// Navigation to website

		Page page = browser.newPage();
		page.navigate("https://dev.nccf.youkta.com");
		//Thread.sleep(6000);
		System.out.println(page.title());

		// Find locators

		page.locator("xpath = //html/body/app-root/app-carousel/div[2]/div[1]/div/div[5]/a/b").click();
		System.out.println("Successfully landed on login page");

		// Providing input to login page nccfadmin@youkta.com NccfTrader@23

		page.getByText("username").fill("nccfadmin@youkta.com");
		System.out.println("Email address entered in email field");
		//Thread.sleep(6000);

		page.locator("xpath = //input[@name='password']").fill("NccfTrader@23");
		System.out.println("Password entered in email field");

		// page.click("text = Sign In ");
		page.locator("xpath = //button[@type='submit']").click();
		System.out.println("Admin user logged in to portal");
		
		playwright.close();

	}

}
