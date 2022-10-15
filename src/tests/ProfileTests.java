package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BasicTest {

	@Test(priority = 10)
	public void visitsTheProfilePage() {
		navPage.getLoginNavButton().click();
		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("12345");
		loginPage.getLoginButton().click();
		navPage.getMyProfileLink().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("/profile"), "Page should contains '/profile' in url");
		profilePage.waitForPleaseWaitMessageToBeInvisible();
		Assert.assertEquals(profilePage.getEmailInputProfile().getAttribute("value"), "admin@admin.com",
				"Email should have value 'admin@admin.com'");
		navPage.getLogoutButton().click();
	}
}
