package com.testNG;
import org.testng.annotations.Test;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class LogInEmail {
	public WebDriver driver;
	  
	  @BeforeMethod
	  @Parameters ({"Browser"})
	  public void OpenBrowser(String Browser) {
		 
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
		  driver.get("http://mail.google.com");
		  driver.manage().window().maximize();
	  }
	  @Test(dataProvider = "EmailData")
	  public void LogIn_Email(String sUsername, String sPassword) {
		  driver.findElement(By.id("identifierId")).sendKeys(sUsername);
	      driver.findElement(By.id("identifierNext")).click();
	  
	  WebDriverWait wait = new WebDriverWait(driver, 30);
	  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#password input[type ~= 'password']"))).sendKeys(sPassword);;   
	  driver.findElement(By.id("passwordNext")).click();    
	  }

  @DataProvider(name = "EmailData")
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "montesting01", "Kms@2017" },
      new Object[] { "montesting02", "Kms@2017" },
    };
  }
  
  @AfterMethod
  public void closeBrowser()
  {
	  driver.quit();
  }
 
}
