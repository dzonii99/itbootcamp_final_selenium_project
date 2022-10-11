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

	@Test(priority = 30)
	public void displaysErrorsWhenUserDoesNotExist() {
		navPage.getLoginNavButton().click();
		loginPage.getEmailInput().sendKeys("non-existing-user@gmal.com");
		loginPage.getPasswordInput().sendKeys("password123");
		loginPage.getLoginButton().click();
		messagePopUpPage.waitMessageToBeVisible();
		Assert.assertTrue(messagePopUpPage.getTextMessage().getText().equals("User does not exists"));
		Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
	}
}
