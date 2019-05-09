package com.testNG;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SaleorWeb3 extends OpenBrowser
{
	
	@Test (priority = 1)
    public void LogIn() {
	 driver.findElement(By.cssSelector("ul.float-right a[href*= 'account/login/']")).click();
     driver.findElement(By.id("id_username")).clear();
     driver.findElement(By.id("id_username")).sendKeys("admin@example.com ");
     driver.findElement(By.id("id_password")).clear();
     driver.findElement(By.id("id_password")).sendKeys("admin");
     driver.findElement(By.cssSelector("div.login__btn-group button.btn-primary")).click();
  }
	@Test (priority = 2)
	public void Action()
	{
		driver.findElement(By.xpath("//ul[contains(@class, 'float-right')]//a[normalize-space()='Your account']")).click();
		driver.findElement(By.xpath("//div[@id = 'accordion']//div[normalize-space()= '#3264']//parent::div[contains(@class, 'row')]//div[normalize-space() ='Details']")).click();
	    driver.findElement(By.id("id_customer_note")).sendKeys("Add note");
	    driver.findElement(By.cssSelector(".form-group .btn-primary")).click();
	}
	
	
	
}
