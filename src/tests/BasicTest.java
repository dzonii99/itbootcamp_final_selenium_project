package tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import pages.CitiesPage;
import pages.LoginPage;
import pages.MessagePopUpPage;
import pages.NavPage;
import pages.ProfilePage;
import pages.SignUpPage;

public abstract class BasicTest {
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";
	protected SoftAssert softAssert;
	protected SignUpPage signUpPage;
	protected NavPage navPage;
	protected LoginPage loginPage;
	protected CitiesPage citiesPage;
	protected MessagePopUpPage messagePopUpPage;
	protected ProfilePage profilePage;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		softAssert = new SoftAssert();
		signUpPage = new SignUpPage(driver);
		navPage = new NavPage(driver);
		loginPage = new LoginPage(driver);
		citiesPage = new CitiesPage(driver, wait);
		profilePage = new ProfilePage(driver);
		messagePopUpPage = new MessagePopUpPage(driver, wait);
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get(baseUrl);
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if (ITestResult.FAILURE == result.getStatus()) {
//			Date currentDate = new Date();
//			String screenshot = currentDate.toString().replace(" ", "-");
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File("img/" + result.getName() + ".png"));
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
