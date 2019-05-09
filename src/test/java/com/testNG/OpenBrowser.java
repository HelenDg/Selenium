package com.testNG;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class OpenBrowser {
	public static WebDriver driver;
	  
	  @BeforeTest
	  @Parameters ({"Browser"})
	  public void Open_Browser(String Browser) {
		 
		  if (Browser.equalsIgnoreCase("chrome"))
		  {
			  System.setProperty("webdriver.chrome.driver", "." + File.separator 
					  + "Driver" + File.separator 
					  + (System.getProperty("os.name").toLowerCase().contains("win")
							  ?"chromedriver.exe":"chromedriver")); 
			  driver = new ChromeDriver();
		  }
		  else if (Browser.equalsIgnoreCase("firefox"))
		  {
			  System.setProperty("webdriver.gecko.driver", "." + File.separator
					  + "Driver" + File.separator
					  + (System.getProperty("os.name").toLowerCase().contains("win")
							  ?"geckodriver.exe":"geckodriver"));
			  driver = new FirefoxDriver();
		  }
		  driver.get("https://demo.getsaleor.com/en/");
		  driver.manage().window().maximize();
	  }
 }

