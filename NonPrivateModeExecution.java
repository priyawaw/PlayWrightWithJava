package PlayWrightSessions;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.GoBackOptions;
import com.microsoft.playwright.Page.GoForwardOptions;

public class NonPrivateModeExecution {

	public static void main(String[] args) throws InterruptedException {

		Playwright playwright = Playwright.create();

		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		playwright.chromium().launchPersistentContext(Paths.get(""),
				new BrowserType.LaunchPersistentContextOptions().setHeadless(false));

		Page page = browser.newPage();

		page.navigate("https://dev.nccf.youkta.com");
		Thread.sleep(6000);
		System.out.println(page.title());

		page.navigate("http://google.com");
		System.out.println(page.title());

		page.goBack(new GoBackOptions().setTimeout(5000));
		Thread.sleep(3000);

		page.goForward(new GoForwardOptions().setTimeout(5000));
		Thread.sleep(3000);

		page.reload();

		page.close();
		playwright.close();

	}

}
