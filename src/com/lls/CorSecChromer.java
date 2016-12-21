package com.lls;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import org.bouncycastle.jcajce.provider.asymmetric.EC;
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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CorSecChromer {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver",
				"D:/360安全浏览器下载/chromedriver_win32 (2)/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		// options.addArguments("--user-data-dir=C:/Users/ADMINI~1/AppData/Local/Temp/scoped_dir21320_26210");
		options.addArguments("--user-agent=Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Mobile Safari/537.36");
		// options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
		// Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like
		// Gecko) Chrome/55.0.2883.87 Safari/537.36
		// --load-component-extension="C:\Users\ADMINI~1\AppData\Local\Temp\scoped_dir21320_14011\internal"
		// options.addArguments("--flag-switches-begin");
		driver = new MyDriver(options);
		baseUrl = "http://106.2.33.91/h5/Dashboard/Dashboard.html";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @org.junit.Test
  public void test() throws Exception {
	  driver.get(baseUrl);
	    driver.findElement(By.id("clientId")).clear();
	    driver.findElement(By.id("clientId")).sendKeys("18603602959");
	    driver.findElement(By.id("clientSecret")).clear();
	    driver.findElement(By.id("clientSecret")).sendKeys("llslls1122");
//	    driver.findElement(By.id("clientSecret")).sendKeys(Keys.ENTER);
	    WebElement element=driver.findElement(By.id("clientSecret"));
	    new TouchActions(driver).singleTap(element).perform();
	    driver.findElement(By.cssSelector("a.footnav-item4 > i")).click();
	    driver.findElement(By.cssSelector("a.row > div.col-xs-10.col-sm-11")).click();
	    driver.findElement(By.cssSelector("#resetLogin > div.col-xs-12")).click();
	    driver.findElement(By.id("oldpwd")).clear();
	    driver.findElement(By.id("oldpwd")).sendKeys("llslls1122");
	    Wait<WebDriver>wait=new WebDriverWait(driver, 5000);
	    driver.findElement(By.id("authLoginPwdBtn")).click();
	    Wait<WebDriver>wait2=new WebDriverWait(driver, 5000);

	    driver.findElement(By.id("firstpwd")).clear();
	    driver.findElement(By.id("firstpwd")).sendKeys("llslls11221");
	    driver.findElement(By.id("secondpwd")).clear();
	    driver.findElement(By.id("secondpwd")).sendKeys("llslls11221");
	    driver.findElement(By.id("confirmResePwdBtn")).click();
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
  
  
  public static void waitForElementToLoad(WebDriver driver, int timeOut, final By By) {
	           try {
	               (new WebDriverWait(driver, timeOut)).until(new ExpectedCondition<Boolean>() {
	  
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
