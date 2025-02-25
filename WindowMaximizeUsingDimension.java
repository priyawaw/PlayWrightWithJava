package PlayWrightSessions;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WindowMaximizeUsingDimension {

	public static void main(String[] args) {

		// checking width and height of screen

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();

		System.out.println(width + "---" + height);

		// importing playwright properties to eclipse
		Playwright playwright = Playwright.create();

		// launching browser
		Browser browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser
				.newContext(new Browser.NewContextOptions().setViewportSize((int) width, (int) height));
		Page page = browserContext.newPage();
		page.navigate("https://dev.nccf.youkta.com/");

		String title = page.title();
		System.out.println("Page title is :  " + title);

		String url = page.url();
		System.out.println("Page url is :  " + url);

		// browser.close();

	}

}
