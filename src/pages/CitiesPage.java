package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public CitiesPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getNewItemButton() {
		return driver.findElement(By.className("btnNewItem"));
	}

	public WebElement getNewItemInput() {
		return driver.findElement(By.id("name"));
	}

	public WebElement getSearchInput() {
		return driver.findElement(By.id("search"));
	}

	public void waitForEditAndAddItemMessageToBeVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dlgNewEditItem")));
	}

	public void waitForDeleteMessageToBeVisible() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("warning")));
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.className("btnSave"));
	}

	public WebElement getDeleteButton() {
		return driver.findElement(By.xpath("//*[@class='v-card__actions']//*[@type='button'][2]"));
	}

	public void waitForRowsInTheTable(int rowNumber) {
		wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//tbody/tr"), rowNumber));
	}

	public String getCellFromTable(int rowNumber, int columnNumber) {
		return driver
				.findElement(By.xpath("//tbody/tr[" + rowNumber + "]/td[@class='text-left'][" + columnNumber + "]"))
				.getText();
	}

	public WebElement getEditButtonFromTable(int rowNumber) {
		return driver.findElement(By.xpath("//tbody/tr[" + rowNumber + "]//button[@id='edit']"));

	}

	public WebElement getDeleteButtonFromTable(int rowNumber) {
		return driver.findElement(By.xpath("//tbody/tr[" + rowNumber + "]//button[@id='delete']"));
	}

}
