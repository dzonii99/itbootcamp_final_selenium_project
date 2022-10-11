package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest {

	@Test(priority = 10)
	public void visitsTheSignupPage() throws InterruptedException {
		navPage.getSignUpButton().click();
		Thread.sleep(1000);
		Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
	}

	@Test(priority = 20)
	public void checksInputTypes() {
		navPage.getSignUpButton().click();
		Assert.assertTrue(signUpPage.getNameInput().getAttribute("type").equals("text"));
		Assert.assertTrue(signUpPage.getEmailInput().getAttribute("type").equals("email"));
		Assert.assertTrue(signUpPage.getPasswordInput().getAttribute("type").equals("password"));
		Assert.assertTrue(signUpPage.getConfirmPasswordInput().getAttribute("type").equals("password"));
	}

	@Test(priority = 30)
	public void displaysErrorsWhenuserAlreadyExists() {
		navPage.getSignUpButton().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
		signUpPage.getNameInput().sendKeys("Another User");
		signUpPage.getEmailInput().sendKeys("admin@admin.com");
		signUpPage.getPasswordInput().sendKeys("12345");
		signUpPage.getConfirmPasswordInput().sendKeys("12345");
		signUpPage.getSignUpButton().click();
		messagePopUpPage.waitErrorMessageToBeVisible();
		Assert.assertEquals(messagePopUpPage.getErrorMessage().getText(), "E-mail already exists");
		Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
	}
}
