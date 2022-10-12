package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest {

	@Test(priority = 10)
	public void visitTheAdminCitiesPageAndListCities() {
		navPage.getLoginNavButton().click();
		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("12345");
		loginPage.getLoginButton().click();
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"));
	}

}
