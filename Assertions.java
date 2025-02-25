package PlayWrightSessions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Assertions {

	public static void main(String[] args) {

		// Initializing browser and importing playwright

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		// Navigation to website

		Page page = browser.newPage();
		page.navigate("http://www.tizag.com/htmlT/htmlcheckboxes.php");

		// Checking assertions

		assertThat(page).hasURL("http://www.tizag.com/htmlT/htmlcheckboxes.php");

		assertThat(page).hasTitle("HTML Tutorial - Checkboxes");

		assertThat(page.locator("#menu > a:nth-child(29)")).hasText("HTML - Tags");

		assertThat(page.locator("//html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[6]/input[1]"))
				.isChecked();

		assertThat(page.locator("//html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[6]/input[1]"))
				.isVisible();

		// assertThat(page.locator("//html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[6]/input[2]")).isChecked();

		page.close();
		browser.close();
		playwright.close();
	}

}
