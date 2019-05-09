package com.testNG;

import java.io.File;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SaleorWeb2 extends OpenBrowser
{
	
   @Test
     public void LogIn() {
	  driver.findElement(By.cssSelector("ul.float-right a[href*= 'account/login/']")).click();
      driver.findElement(By.id("id_username")).clear();
      driver.findElement(By.id("id_username")).sendKeys("admin@example.com ");
      driver.findElement(By.id("id_password")).clear();
      driver.findElement(By.id("id_password")).sendKeys("admin");
      driver.findElement(By.cssSelector("div.login__btn-group button.btn-primary")).click();
      
   }
}
