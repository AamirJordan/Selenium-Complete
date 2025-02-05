package com.alphabet.gmail.testngtopic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.alphabet.gmail.webdrivermethods.BasicSettings;

public class TC013 extends BasicSettings {	//		Passing Parameters and Feeding Data into the Site
	
	WebDriver driver;
	@BeforeTest
	public void openApp()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com");
	}
	
	@Parameters({"username","password"})
	@Test
	public void loginToApp(@Optional("trainee")String u, @Optional("trainee")String p)		//		parameters accepts value passed in the xml file and alots to the string value passed here. Also the parameter name in java and the parameter name in the xml file should be the same
	{
		driver.findElement(By.id("username")).sendKeys(u);
		driver.findElement(By.name("pwd")).sendKeys(p);
		driver.findElement(By.id("loginButton")).click();
		mySleepInSeconds(10);
	}
	
	@AfterTest
	public void closeApp()
	{
		driver.quit();
	}
}
