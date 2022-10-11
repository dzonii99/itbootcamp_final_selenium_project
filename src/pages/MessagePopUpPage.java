package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public void waitErrorMessageToBeVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error")));
	}

	public WebElement getErrorMessage() {
		return driver.findElement(By.className("v-snack__content")).findElement(By.tagName("li"));
	}

	public WebElement getCloseButton() {
		return driver.findElement(By.className("v-snack__content")).findElement(By.tagName("button"));
	}

	public void waitVerifyMessageToBeVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dlgVerifyAccount")));
	}

	public String getVerifyMessage() {
		return driver.findElement(By.className("dlgVerifyAccount")).getText();
	}

	public WebElement getVerifyCloseButton() {
		return driver.findElement(By.className("btnClose "));
	}
}
