package PlayWrightSessions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class EvaluatingJavascript {

	public static void main(String[] args) {

		// Initializing browser and importing playwright

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("http://google.com");

		// Evaluating Javascript

		System.out.println(page.evaluate("document.location.href"));

		page.evaluate("() => {" + "const textarea = document.createElement('textarea');"
				+ "document.body.append(textarea);" + "textarea.focus();" + "}");

		String text = "Hello World !!";
		page.keyboard().type(text);
		
		playwright.close();
	}

}
