package com.Task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {

	WebDriver driver;
	
	
	@BeforeClass
	public void setup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	
	@BeforeMethod
	public void url_setup() {
		driver.get("http://uitestingplayground.com/sampleapp");
	}

	
	@Test(dataProvider="Logindata")
	public void Test_Random_Password(String username , String password) {

		String Current_Url = driver.getCurrentUrl();

		// Url validation
		Assert.assertEquals(Current_Url, "http://uitestingplayground.com/sampleapp",
				"Sample app page is not displayed");

		// step 2 - Sending a random value to user name field
		driver.findElement(By.name("UserName")).sendKeys(username);
		
		// step 3 - Sending 'pwd' into the password field
		driver.findElement(By.name("Password")).sendKeys(password);
		
		// step 4 - Click on the Log in Button
		driver.findElement(By.id("login")).click();
		
		// welcome message Validation
		boolean Welcome_message = driver.findElement(By.id("loginstatus")).getText().equals("Welcome, "+username+"!");
		Assert.assertTrue(Welcome_message, "Welcome message is not displayed");
		
		// step 6 - Click on the Log out Button
		driver.findElement(By.xpath("//button[@class=\"btn btn-primary\" and text()=\"Log Out\"]")).click(); 
		
		// User logged out message validation
		boolean Loggedout_message = driver.findElement(By.id("loginstatus")).getText().equals("User logged out.");
		Assert.assertTrue(Loggedout_message,"User Logged out message is not displayed");

	}
	
	@DataProvider(name = "Logindata")
	public Object[][] createData1() {
	 return new Object[][] {
	   { "Cedric", "pwd" },
	   { "Anne", "pwd"},
	   { "alo", "pwd1"},
	 };
	}

	
	@AfterClass
	public void teardown() {
		driver.quit();	
	}

}
