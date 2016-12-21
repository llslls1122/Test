package com.lls;

import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.jna.platform.win32.WinNT.HRESULT;

public class DealOut extends TestCase{
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
    baseUrl = "http://172.16.1.85/h5/Dashboard/Dashboard.html";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @org.junit.Test
  public void testDealP() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.id("clientId")).clear();
    driver.findElement(By.id("clientId")).sendKeys("18603602958");
    driver.findElement(By.id("clientSecret")).clear();
    driver.findElement(By.id("clientSecret")).sendKeys("111111");
//    driver.findElement(By.id("clientSecret")).sendKeys(Keys.ENTER);

    WebElement loginBtn=driver.findElement(By.id("loginNormalBtn"));
    new TouchActions(driver).singleTap(loginBtn).perform();
    driver.findElement(By.cssSelector("div.col-xs-8.col-sm-9")).click();
    driver.findElement(By.cssSelector("div.rental-item-head.row > span")).click();
    driver.findElement(By.id("rollOutBtn")).click();
    /*Thread thread= new Thread(new Runnable() {
    	@Override
    	public void run() {
    		System.out.println("test");
    	}
    });
      thread.start();
      thread.sleep(3000);*/
    WebElement outMoney=driver.findElement(By.xpath("//*[@id='amount']"));
    outMoney.clear();
    outMoney.sendKeys("100");
    waitForElementToLoad(driver, 5000, By.xpath("//*[@id='confirmPayBtn']"));
   WebElement confirm= driver.findElement(By.xpath("//*[@id='confirmPayBtn']"));
   confirm.click();
//   new TouchActions(driver).singleTap(confirm).perform();
//   thread.sleep(3000);
   waitForElementToLoad(driver, 5000, By.xpath("//*[@id='key1']"));

   WebElement password1 = driver.findElement(By.xpath("//*[@id='key1']"));
   new TouchActions(driver).singleTap(password1).perform();
   new TouchActions(driver).singleTap(password1).perform();
   new TouchActions(driver).singleTap(password1).perform();
   new TouchActions(driver).singleTap(password1).perform();
   new TouchActions(driver).singleTap(password1).perform();
   new TouchActions(driver).singleTap(password1).perform();
  
  }
  public boolean testNewWindow(){
	  String currentHandle = driver.getWindowHandle();
	  Set<String> handles = driver.getWindowHandles();
	  handles.remove(currentHandle);
	  if (handles.size() > 0) {
	  try{
	  driver.switchTo().window(handles.iterator().next());
	  return true;
	  }
	  catch(Exception e){
	  System.out.println(e.getMessage());
	  return false;
	  }
	  }
	  System.out.println("Did not find window");
	  return false;
	  }
  public void windowTest(){
	  driver.findElement(By.id("password-box")).click();  
      //得到当前窗口的句柄  
      String currentWindow = driver.getWindowHandle();  
      //得到所有窗口的句柄  
      Set<String> handles = driver.getWindowHandles();  
      Iterator<String> it = handles.iterator();  
      while(it.hasNext()){  
          String handle = it.next();  
          if(currentWindow.equals(handle)) continue;  
          WebDriver window = driver.switchTo().window(handle);  
          System.out.println("title,url = "+window.getTitle()+","+window.getCurrentUrl());  
      }  
  }
  @After
  public void tearDown() throws Exception {
//    driver.quit();
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
