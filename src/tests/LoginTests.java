package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {
	@Test(priority = 10)
	public void visitsTheLoginPage() {
		navPage.getLanguageButton().click();
		navPage.getEnglishButton().click();
		navPage.getLoginNavButton().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
	}

	@Test(priority = 20)
	public void checksInputTypes() {
		navPage.getLoginNavButton().click();
		Assert.assertTrue(signUpPage.getEmailInput().getAttribute("type").equals("email"));
		Assert.assertTrue(signUpPage.getPasswordInput().getAttribute("type").equals("password"));
	}
}
