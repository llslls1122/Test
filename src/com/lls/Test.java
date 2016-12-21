package com.lls;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {
	public static void main(String[] args) {
		
		/*System.setProperty("webdriver.firefox.bin", 
				  "D:/firefox36/firefox.exe");*/
		/*System.setProperty("webdriver.chrome.driver",
				 "D:/360安全浏览器下载/chromedriver_win32 (2)/chromedriver.exe");*/
		
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--user-data-dir=C:/Users/ADMINI~1/AppData/Local/Temp/scoped_dir21320_26210");
//		options.addArguments("--user-agent=Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Mobile Safari/537.36");
//		options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
		//Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36
		//--load-component-extension="C:\Users\ADMINI~1\AppData\Local\Temp\scoped_dir21320_14011\internal"
//		options.addArguments("--flag-switches-begin");
		/*WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();*/
//		WebDriver driver=new FirefoxDriver();
		
//		WebDriver driver2=new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver",
				"D:/360安全浏览器下载/chromedriver_win32 (2)/chromedriver.exe");
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--user-agent=Mozilla/5.0 (iPhone; U; CPU iPhone OS 3_0 like Mac OS X; en-us) AppleWebKit/528.18 (KHTML, like Gecko) Version/4.0 Mobile/7A341 Safari/528.16");
		WebDriver driver = new ChromeDriver();
//		String baseUrl = "http://www.baidu.com";
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://www.baidu.com");

//		driver.findElement(By.name("wd")).sendKeys("aaaa");
		WebElement txtbox = driver.findElement(By.name("wd"));
		txtbox.sendKeys("Selenium");

		WebElement btn = driver.findElement(By.id("su"));
		btn.click();
		driver.close();
	}
	
	
}


/*System.setProperty("webdriver.chrome.driver", 
"D:/360安全浏览器下载/chromedriver_win32 (2)/chromedriver.exe");*/

