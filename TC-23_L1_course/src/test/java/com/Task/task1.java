package com.Task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class task1 {

	WebDriver driver;
	
	//Pick any random user name here
	String username = "Arif";

	
	@BeforeMethod
	public void Setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://uitestingplayground.com/sampleapp");
	}

	
	@Test
	public void TestRandomPassword() {

		boolean Username_Field = driver.findElement(By.name("UserName")).isDisplayed();

		// Page validation through checking username field
 		Assert.assertTrue(Username_Field, "Sample app page is not displayed");

		// step 2 - Sending a random value to user name field
		driver.findElement(By.name("UserName")).sendKeys(username);
		
		// step 3 - Sending 'pwd' into the password field
		driver.findElement(By.name("Password")).sendKeys("pwd");
		
		// step 4 - Click on the Log in Button
		driver.findElement(By.id("login")).click();
		
		// welcome message Validation
		boolean Welcome_message = driver.findElement(By.id("loginstatus")).getText().equals("Welcome, "+username+"!");
		Assert.assertTrue(Welcome_message, "Welcome message is not displayed");
		
		// step 6 - Click on the Log out Button
		driver.findElement(By.xpath("//button[@class='btn btn-primary' and contains(text(), 'Log Out' )]")).click(); 
		
		// User logged out message validation
		boolean Loggedout_message = driver.findElement(By.id("loginstatus")).getText().equals("User logged out.");
		Assert.assertTrue(Loggedout_message,"User Logged out message is not displayed");

	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();	
	}

}
