package com.lls;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Correct {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"D:/360安全浏览器下载/chromedriver_win32 (2)/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--user-agent=Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_0 like Mac OS X; en-us) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7A341 Safari/528.16");
		driver = new MyDriver(options);
		baseUrl = "http://106.2.33.91/h5/Dashboard/Dashboard.html";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@org.junit.Test
	public void testCorrect() throws Exception {
		driver.get(baseUrl);
		driver.findElement(By.id("clientId")).clear();
		driver.findElement(By.id("clientId")).sendKeys("18603602959");
		driver.findElement(By.id("clientSecret")).clear();
		driver.findElement(By.id("clientSecret")).sendKeys("lls199211221");
		driver.findElement(By.id("clientSecret")).sendKeys(Keys.ENTER);

		driver.findElement(By.cssSelector("a.footnav-item4 > i")).click();
		driver.findElement(By.cssSelector("a.row > div.col-xs-10.col-sm-11"))
				.click();
		driver.findElement(By.cssSelector("#resetLogin > div.col-xs-12"))
				.click();
		driver.findElement(By.id("oldpwd")).clear();
		driver.findElement(By.id("oldpwd")).sendKeys("lls199211221");
		driver.findElement(By.id("authLoginPwdBtn")).click();

		

//		System.out.println("aaaaa");
		waitForElementToLoad(driver,3000,By.id("firstpwd"));
		driver.findElement(By.id("firstpwd")).clear();
		driver.findElement(By.id("firstpwd")).sendKeys("lls19921122");
		driver.findElement(By.id("secondpwd")).clear();
		driver.findElement(By.id("secondpwd")).sendKeys("lls19921122");
		driver.findElement(By.id("confirmResePwdBtn")).click();
		driver.findElement(By.id("iKnow")).click();
	}

	@After
	public void tearDown() throws Exception {
		// driver.quit();
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

	public static void waitForElementToLoad(WebDriver driver, int timeOut,
			final By By) {
		try {
			(new WebDriverWait(driver, timeOut))
					.until(new ExpectedCondition<Boolean>() {

						public Boolean apply(WebDriver driver) {
							WebElement element = driver.findElement(By);
							return element.isDisplayed();
						}
					});
		} catch (TimeoutException e) {
			Assert.fail("超时!! " + timeOut + " 秒之后还没找到元素 [" + By + "]");
		}
	}
}
