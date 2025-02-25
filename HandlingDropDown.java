package PlayWrightSessions;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class HandlingDropDown {

	public static void main(String[] args) {

		// Initializing browser and importing playwright

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		// Navigation to website

		Page page = browser.newPage();
		page.navigate("https://dev.nccf.youkta.com/#/login");
		// Thread.sleep(6000);
		System.out.println(page.title());

		// Find locators

		page.locator("xpath = //h3[contains(text(), 'Register here?')]").click();
		System.out.println("Landed on registration page");

		page.locator("id=1").click();
		page.selectOption("select", "PACS");
		System.out.println("User type selected as per choice");

		page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("State")).locator("span").click();
		page.getByText("ANDHRA PRADESH").click();

		Locator values = page.locator("select >> option");
		System.out.println(values.count());

		for (int i = 0; i < values.count(); i++) {

			System.out.println(values.nth(i).innerText() + "----" + values.nth(i).getAttribute("lang"));

		}

		/*
		 * List<ElementHandle> values1 = page.querySelectorAll("select > option");
		 * 
		 * System.out.println(values1.size());
		 * 
		 * for (ElementHandle value : values1) {
		 * 
		 * System.out.println(value.innerText() + "----" + value.getAttribute("lang"));
		 * 
		 * //playwright.close();
		 * 
		 * }
		 */

	}
}
