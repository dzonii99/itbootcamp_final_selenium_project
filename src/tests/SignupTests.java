package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest {

	@Test(priority = 10)
	public void visitsTheSignupPage() throws InterruptedException {
		navPage.getSignUpButton().click();
		Thread.sleep(1000);
		Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "Page should contain '/signup' in url");
	}

	@Test(priority = 20)
	public void checksInputTypes() {
		navPage.getSignUpButton().click();
		softAssert.assertTrue(signUpPage.getNameInput().getAttribute("type").equals("text"),
				"Name input should have type - 'text'");
		softAssert.assertTrue(signUpPage.getEmailInput().getAttribute("type").equals("email"),
				"Email input should have type - 'email'");
		softAssert.assertTrue(signUpPage.getPasswordInput().getAttribute("type").equals("password"),
				"Password input should have type - 'password'");
		softAssert.assertTrue(signUpPage.getConfirmPasswordInput().getAttribute("type").equals("password"),
				"Confirm password input should have type - 'password'");
		softAssert.assertAll();
	}

	@Test(priority = 30)
	public void displaysErrorsWhenuserAlreadyExists() {
		navPage.getSignUpButton().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "Page should contain '/signup' in url");
		signUpPage.getNameInput().sendKeys("Another User");
		signUpPage.getEmailInput().sendKeys("admin@admin.com");
		signUpPage.getPasswordInput().sendKeys("12345");
		signUpPage.getConfirmPasswordInput().sendKeys("12345");
		signUpPage.getSignUpButton().click();
		messagePopUpPage.waitMessageToBeVisible();
		Assert.assertEquals(messagePopUpPage.getMessage().getText(), "E-mail already exists",
				"Pop up message should be 'E-mail already exists'");
		Assert.assertTrue(driver.getCurrentUrl().contains("/signup"), "Page should contain '/signup' in url");
	}

	@Test(priority = 40)
	public void signup() {
		navPage.getSignUpButton().click();
		signUpPage.getNameInput().sendKeys("Nikola Milovanovic");
		signUpPage.getEmailInput().sendKeys("nikola.milovanovic@itbootcamp.rs");
		signUpPage.getPasswordInput().sendKeys("12345");
		signUpPage.getConfirmPasswordInput().sendKeys("12345");
		signUpPage.getSignUpButton().click();
		driver.get(baseUrl + "/home");
		Assert.assertTrue(messagePopUpPage.getVerifyMessage().getText().equals("IMPORTANT: Verify your account"),
				"Verify pop up message should be 'IMPORTANT: Verify your account'");
		messagePopUpPage.getVerifyCloseButton().click();
		navPage.getLogoutButton().click();
	}
}
