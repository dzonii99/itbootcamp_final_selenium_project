package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CitiesPage;

public class AdminCitiesTests extends BasicTest {

	@Test(priority = 10)
	public void visitTheAdminCitiesPageAndListCities() {
		navPage.getLoginNavButton().click();
		loginPage.getEmailInput().sendKeys("admin@admin.com");
		loginPage.getPasswordInput().sendKeys("12345");
		loginPage.getLoginButton().click();
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"),
				"Page should contain '/admin/cities' in url");
	}

	@Test(priority = 20)
	public void checksInputTypesForCreateOrEditNewCity() {
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getNewItemButton().click();
		citiesPage.waitForEditAndAddItemMessageToBeVisible();
		Assert.assertTrue(citiesPage.getNewItemInput().getAttribute("type").equals("text"),
				"Input for add new item should have type - 'text'");

	}

	@Test(priority = 30)
	public void createNewCity() {
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getNewItemButton().click();
		citiesPage.waitForEditAndAddItemMessageToBeVisible();
		citiesPage.getNewItemInput().sendKeys("Nikola Milovanovic's city");
		citiesPage.getSaveButton().click();
		messagePopUpPage.waitCityMessage();
		Assert.assertTrue(messagePopUpPage.getCityMessage().getText().contains("Saved successfully"),
				"Pop up message should be 'Saved successfully'");
	}

	@Test(priority = 40)
	public void editCity() {
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getSearchInput().sendKeys("Nikola Milovanovic's city");
		citiesPage.waitForRowsInTheTable(1);
		citiesPage.getEditButtonFromTable(1).click();
		citiesPage.getNewItemInput().sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
		citiesPage.getNewItemInput().sendKeys("Nikola Milovanovic's city Edited");
		citiesPage.getSaveButton().click();
		messagePopUpPage.waitCityMessage();
		Assert.assertTrue(messagePopUpPage.getCityMessage().getText().contains("Saved successfully"),
				"Pop up message should be 'Saved successfully'");

	}

	@Test(priority = 50)
	public void searchCity() {
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getSearchInput().sendKeys("Nikola Milovanovic's city Edited");
		citiesPage.waitForRowsInTheTable(1);
		Assert.assertTrue(citiesPage.getCellFromTable(1, 1).contains("Nikola Milovanovic's city Edited"),
				"Cell should be 'Nikola Milovanovic's city Edited'");
	}

	@Test(priority = 60)
	public void deleteCity() {
		navPage.getAdminButton().click();
		navPage.getCitiesLink().click();
		citiesPage.getSearchInput().sendKeys("Nikola Milovanovic's city Edited");
		citiesPage.waitForRowsInTheTable(1);
		Assert.assertEquals(citiesPage.getCellFromTable(1, 1), "Nikola Milovanovic's city Edited",
				"Cell should be 'Nikola Milovanovic's city Edited'");
		citiesPage.getDeleteButtonFromTable(1).click();
		citiesPage.waitForDeleteMessageToBeVisible();
		citiesPage.getDeleteButton().click();
		messagePopUpPage.waitCityMessage();
		Assert.assertTrue(messagePopUpPage.getCityMessage().getText().contains("Deleted successfully"),
				"Pop up message should be 'Deleted successfully'");

	}
}
