package com.lls;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

public class XXX {
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
	  
//    driver = new FirefoxDriver();
    baseUrl = "http://172.16.1.85/h5/Dashboard/Dashboard.html";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @org.junit.Test
  public void testXXX() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.id("clientId")).sendKeys("18603602958");
    driver.findElement(By.id("clientSecret")).clear();
    driver.findElement(By.id("clientSecret")).sendKeys("111111");
    // ERROR: Caught exception [ERROR: Unsupported command [keyDown | id=clientSecret | 13]]
    driver.findElement(By.id("clientSecret")).sendKeys(Keys.ENTER);
    driver.findElement(By.cssSelector("div.col-xs-8.col-sm-9")).click();
    driver.findElement(By.cssSelector("div.rental-item-head.row > span")).click();
    driver.findElement(By.id("rollInBtn")).click();
    driver.findElement(By.id("confirmPay")).click();
    driver.findElement(By.id("confirmPay")).click();
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
