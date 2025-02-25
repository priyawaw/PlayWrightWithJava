package PlayWrightSessions;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.*;

public class AutomatedCode {
	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			BrowserContext context = browser.newContext();
			Page page = context.newPage();
			page.navigate("https://dev.nccf.youkta.com/#");
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Register Now")).click();

			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username"))
					.fill("nccfadmin@youkta.com");

			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("NccfTrader@23");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sign In")).click();
		}
	}
}