package com.testNG;

import java.io.File;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SendEmail {
	private ChromeDriver driver;
	@BeforeTest
    public void beforeTest(){
		System.setProperty("webdriver.chrome.driver", "." + File.separator + "WinDriver" + File.separator + (System.getProperty("os.name").toLowerCase().contains("win")?"chromedriver.exe":"chromedriver"));
        driver = new ChromeDriver();
        //additional setup
     }
	
	@AfterTest
    public void afterTest(){
      driver.quit();
        //additional setup
     }
	@Test(priority = 1)
	  public void OpenBrowser()
	  {
		  
		  driver.get("http://mail.google.com");
		  driver.manage().window().maximize();
	  }
	@Test (priority = 2)
	public void LogInValidEmail()
	  {
		try
		{
			driver.findElement(By.id("identifierId")).sendKeys("thanhtammis@gmail.com");
            driver.findElement(By.id("identifierNext")).click();
        
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#password input[type ~= 'password']"))).sendKeys("tuoithantien");;   
        driver.findElement(By.id("passwordNext")).click();    
        }
		catch(Exception e)
		{
			throw new ElementNotVisibleException("Not found!");
		}
		  
      }
	@Test (priority = 3)
	public void ComposeEmail()
	  {
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 30);
	          wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role = 'button' and normalize-space() = 'Compose']"))).click();;;
	          driver.findElement(By.cssSelector("div textarea[name ~= 'to']")).sendKeys("kilru0001@gmail.com");
	          driver.findElement(By.cssSelector("div input[name ~= 'subjectbox']")).sendKeys("Test Email");
	          driver.findElement(By.xpath("//div[contains(@class, 'gmail_signature')]//parent::div[contains(@class, 'editable')]")).sendKeys("Vinh Heo like SHIT");
	          driver.findElement(By.xpath("//div[@role = 'button' and normalize-space() = 'Send']")).click();
		}
		catch(Exception e)
		{
			throw new ElementNotVisibleException("Not found!");
		}
          
      }
  
}
