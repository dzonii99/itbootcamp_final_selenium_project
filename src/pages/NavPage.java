package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavPage {
	private WebDriver driver;

	public NavPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getHomeLink() {
		return driver.findElement(By.className("btnHome"));
	}

	public WebElement getAboutLink() {
		return driver.findElement(By.className("btnAbout"));
	}

	public WebElement getMyProfileLink() {
		return driver.findElement(By.className("btnProfile"));
	}

	public WebElement getAdminButton() {
		return driver.findElement(By.className("btnAdmin"));
	}

	public WebElement getCitiesLink() {
		return driver.findElement(By.className("btnAdminCities"));
	}

	public WebElement getUsersLink() {
		return driver.findElement(By.className("btnAdminUsers"));
	}

	public WebElement getSignUpButton() {
		return driver.findElement(By.xpath("//*[contains(@class,'btnLogin')][2]"));
	}

	public WebElement getLoginNavButton() {
		return driver.findElement(By.xpath("//*[contains(@class,'btnLogin')][1]"));
	}

	public WebElement getLogoutButton() {
		return driver.findElement(By.className("btnLogout"));
	}

	public WebElement getLanguageButton() {
		return driver.findElement(By.className("btnLocaleActivation"));
	}

	public WebElement getEnglishButton() {
		return driver.findElement(By.className("btnEN"));
	}

	public WebElement getSpanishButton() {
		return driver.findElement(By.className("btnES"));
	}

	public WebElement getFranceButton() {
		return driver.findElement(By.className("btnFR"));
	}

	public WebElement getChineseButton() {
		return driver.findElement(By.className("btnCN"));
	}

	public WebElement getUkraineButton() {
		return driver.findElement(By.className("btnUA"));
	}

	public WebElement getHeaderOfPage() {
		return driver.findElement(By.className("display-2"));
	}

}
