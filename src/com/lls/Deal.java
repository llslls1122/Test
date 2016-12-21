package com.lls;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.Select;

public class Deal {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"D:/360°²È«ä¯ÀÀÆ÷ÏÂÔØ/chromedriver_win32 (2)/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		// options.addArguments("--user-data-dir=C:/Users/ADMINI~1/AppData/Local/Temp/scoped_dir21320_26210");
		options.addArguments("--user-agent=Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Mobile Safari/537.36");
		// options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
		// Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like
		// Gecko) Chrome/55.0.2883.87 Safari/537.36
		// --load-component-extension="C:\Users\ADMINI~1\AppData\Local\Temp\scoped_dir21320_14011\internal"
		// options.addArguments("--flag-switches-begin");
		driver = new MyDriver(options);
		baseUrl = "http://172.16.1.131/h5/Dashboard/Dashboard.html";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@org.junit.Test
	public void testDeal() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.id("clientId")).clear();
		driver.findElement(By.id("clientId")).sendKeys("13655555555");
		driver.findElement(By.id("clientSecret")).clear();
		driver.findElement(By.id("clientSecret")).sendKeys("12345678a");
		WebElement loginBtn = driver.findElement(By.id("loginNormalBtn"));
		new TouchActions(driver).singleTap(loginBtn).perform();
		driver.findElement(By.cssSelector("div.col-xs-8.col-sm-9")).click();
		driver.findElement(
				By.cssSelector("li.YQB-rental-item.YQB00101 > a > div.rental-item-head.row > span"))
				.click();
		driver.findElement(By.id("backBtn")).click();
		driver.findElement(
				By.cssSelector("li.YQB-rental-item.YQB00101 > a > div.rental-item-head.row > span"))
				.click();
		driver.findElement(By.id("backBtn")).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
