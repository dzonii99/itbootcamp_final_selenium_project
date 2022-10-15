package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
	private WebDriver driver;
	private WebDriverWait wait;

	public ProfilePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getEmailInputProfile() {
		return driver.findElement(By.id("email"));
	}

	public void waitForPleaseWaitMessageToBeInvisible() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(@class, 'v-card__text')]")));
	}

}
