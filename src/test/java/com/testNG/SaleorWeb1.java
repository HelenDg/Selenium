package com.testNG;

import org.testng.annotations.Test;

import net.bytebuddy.utility.RandomString;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;


//Create 3, 4 class to define template and use @before 
//class A: link -> search text -> check display "name"
//class B: link -> clikc log in -> input username/pass -> log in 
//class C: link -> login -> your acc -> clict "detail" the 1st value -> 
//input note "...." -> submit note -> check note
//Test Suite:
//<test 1> class A -> B
//<test 2> class A -> C

public class SaleorWeb1 extends OpenBrowser
{
	
  @Test
  public void SearchText() {
	  String entertext = "Doraemon";
	  driver.findElement(By.cssSelector("input.form-control")).sendKeys(entertext);
	  driver.findElement(By.cssSelector("form.search-form button.btn-primary")).click();
	  String text = driver.findElement(By.cssSelector("div.maincontent h2 strong")).getText();
	  System.out.println(text);
	  Assert.assertEquals(entertext.toUpperCase(),text);
	  

  }
 

}
