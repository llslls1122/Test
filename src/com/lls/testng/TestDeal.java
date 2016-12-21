package com.lls.testng;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.lls.MyDriver;

public class TestDeal {
	private WebDriver driver;
	private String baseUrl;
	@BeforeTest
	public void setup(){
		System.setProperty("webdriver.chrome.driver",
				"D:/360安全浏览器下载/chromedriver_win32 (2)/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--user-agent=Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_0 like Mac OS X; en-us) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7A341 Safari/528.16");
		driver = new MyDriver(options);
		baseUrl = "http://172.16.1.85/h5/Dashboard/Dashboard.html";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
  @Test
  public void f() {
	  driver.get(baseUrl);
		driver.findElement(By.id("clientId")).clear();
		driver.findElement(By.id("clientId")).sendKeys("18603602958");
		driver.findElement(By.id("clientSecret")).clear();
		driver.findElement(By.id("clientSecret")).sendKeys("111111");
		// driver.findElement(By.id("clientSecret")).sendKeys(Keys.ENTER);

		WebElement loginBtn = driver.findElement(By.id("loginNormalBtn"));
		new TouchActions(driver).singleTap(loginBtn).perform();
		driver.findElement(By.cssSelector("div.col-xs-8.col-sm-9")).click();
		driver.findElement(By.cssSelector("div.rental-item-head.row > span"))
				.click();
		driver.findElement(By.id("rollInBtn")).click();
		WebElement money = driver.findElement(By.xpath("//*[@id='amount']"));
		money.clear();
		money.sendKeys("200");
		waitForElementToLoad(driver, 5000, By.id("confirmPay"));

		WebElement confirm = driver.findElement(By.id("confirmPay"));
//		waitForElementToLoad(driver, 3000, By.xpath("//*[@id='amount']"));
		
		new TouchActions(driver).singleTap(confirm).perform();
		waitForElementToLoad(driver, 8000,
				By.xpath("//*[@id='custom-keyboard']/div[1]"));
		WebElement password1 = driver.findElement(By
				.xpath("//*[@id='custom-keyboard']/div[1]"));
		new TouchActions(driver).singleTap(password1).perform();
		new TouchActions(driver).singleTap(password1).perform();
		new TouchActions(driver).singleTap(password1).perform();
		new TouchActions(driver).singleTap(password1).perform();
		new TouchActions(driver).singleTap(password1).perform();
		new TouchActions(driver).singleTap(password1).perform();
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
