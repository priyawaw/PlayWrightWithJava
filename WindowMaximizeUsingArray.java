package PlayWrightSessions;

import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WindowMaximizeUsingArray {

	public static void main(String[] args) throws InterruptedException {

		// importing playwright properties to eclipse

		Playwright playwright = Playwright.create();
		ArrayList<String> arguments = new ArrayList<>();
		arguments.add("--start-maximized");
		Browser browser = playwright.chromium()
				.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
		BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));

		Page page = browserContext.newPage();

		page.navigate("https://dev.nccf.youkta.com");
		
		Thread.sleep(3000);

		System.out.println(page.title());
		
		playwright.close();

	}

}
