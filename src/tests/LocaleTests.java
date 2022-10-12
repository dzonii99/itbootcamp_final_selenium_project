package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest {

	@Test(priority = 10)
	public void setLocaleToES() {
		navPage.getLanguageButton().click();
		navPage.getSpanishButton().click();
		Assert.assertTrue(navPage.getHeaderOfPage().getText().contains("Página de aterrizaje"),
				"Header should be 'Página de aterrizaje'");
	}

	@Test(priority = 20)
	public void setLocaleToEN() {
		navPage.getLanguageButton().click();
		navPage.getEnglishButton().click();
		Assert.assertTrue(navPage.getHeaderOfPage().getText().contains("Landing"), "Header should be 'Landing'");
	}

	@Test(priority = 30)
	public void setLocaleToCN() {
		navPage.getLanguageButton().click();
		navPage.getChineseButton().click();
		Assert.assertTrue(navPage.getHeaderOfPage().getText().contains("首页"), "Header should be '首页'");
	}

	@Test(priority = 40)
	public void setLocaleToFR() {
		navPage.getLanguageButton().click();
		navPage.getFranceButton().click();
		Assert.assertTrue(navPage.getHeaderOfPage().getText().contains("Page d'atterrissage"),
				"Header should be 'Page d'atterrissage'");
	}

	@Test(priority = 50)
	public void setLocaleToUA() {
		navPage.getLanguageButton().click();
		navPage.getUkraineButton().click();
		Assert.assertTrue(navPage.getHeaderOfPage().getText().contains("Лендінг"), "Header should be 'Лендінг'");
	}
}
