package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest {

	@Test
	public void visitsTheSignupPage() {
		navPage.getSignUpButton().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
	}

	@Test
	public void checksInputTypes() {
		navPage.getSignUpButton().click();
		Assert.assertTrue(signUpPage.getNameInput().getAttribute("type").equals("text"));
		Assert.assertTrue(signUpPage.getEmailInput().getAttribute("type").equals("email"));
		Assert.assertTrue(signUpPage.getPasswordInput().getAttribute("type").equals("password"));
		Assert.assertTrue(signUpPage.getConfirmPasswordInput().getAttribute("type").equals("password"));
	}
}
