package com.lls;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class S {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		File file = new File(
				"C:/Users/Administrator/AppData/Roaming/Mozilla/Firefox/Profiles/wtmrnwta.default/extensions/{e968fc70-8f95-4ab9-9e79-304de2a71ee1}.xpi");
		FirefoxProfile profile = new FirefoxProfile();
		try {
			profile.addExtension(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		profile.setPreference(
				"general.useragent.override",
				"Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_0 like Mac OS X; en-us) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7A341 Safari/528.16");
		driver = new FirefoxDriver(profile);
		baseUrl = "http://106.2.33.91/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@org.junit.Test
	public void testS() throws Exception {
		driver.get(baseUrl + "/h5/Dashboard/user/login.html?flow=loginRedirect");
		driver.findElement(By.id("clientId")).clear();
		driver.findElement(By.id("clientId")).sendKeys("18603602959");
		driver.findElement(By.id("clientSecret")).clear();
		driver.findElement(By.id("clientSecret")).sendKeys("lls19921122");
//		driver.findElement(By.id("clientSecret")).sendKeys(Keys.A);

		driver.findElement(By.id("clientSecret")).sendKeys(Keys.ENTER);

		driver.findElement(By.cssSelector("a.footnav-item1 > i")).click();
		driver.findElement(By.cssSelector("div.ryb-headline-left > span"))
				.click();
		
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
