package PlayWrightSessions;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DownloadingFiles {

	public static void main(String[] args) {

		// Initializing browser and importing playwright

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		// Navigation to website

		Page page = browser.newPage();
		page.navigate("https://www.selenium.dev/downloads/");

		// Downloading Files

		Download file = page.waitForDownload(() -> {

			page.locator(
					"body > div > main > div.row.justify-content-center.px-5.pb-5 > div:nth-child(3) > div > div.card-body.px-0.text-center > p:nth-child(2) > a")
					.click();
		});

		file.saveAs(Paths.get("./src/test/resources/Files/selenium.jar"));

	}

}
