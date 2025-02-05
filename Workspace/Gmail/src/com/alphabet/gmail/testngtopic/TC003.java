package com.alphabet.gmail.testngtopic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC003 {		//	TestNG program to Test Login with Multiple Login Credentials

	@DataProvider(name="credentials")	/*	We can give any @DataProvider name we like but then it has to be made sure that the same name is passed to the @Test annotation for it to be executed
	 										if @DataProvider(name) is not given then the name of the method getData(for example in this program) is the name of the @DataProvider	*/
	public Object getData() {
		
		return new Object [] [] {	{"admin", "manager"},
			   	{"trainee", "trainee"},
			   	{"ABDeVillers", "ABDe"},
			   	{"Virat", "Anushka"},
			   	{"Shane Watson", "Steve Smith"} };
			   	
		/*	------------------------- OR -------------------------  
		Object [][] arr = {	{"admin", "manager"},
						   	{"trainee", "trainee"},
						   	{"ABDeVillers", "ABDe"},
						   	{"Virat", "Anushka"},
						   	{"Shane Watson", "Steve Smith"} }; 
				
		return arr;
		 */
	}
	
	@Test(dataProvider="credentials", description = "Test Case to Test Login with Multiple Login Credentials")		//	@DataProvider name used here given by the programmer i.e "credentials"
	public void testValidLogin(String usernm, String passd) {
			
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://demo.actitime.com/");
			
			driver.findElement(By.id("username")).sendKeys(usernm);
			driver.findElement(By.name("pwd")).sendKeys(passd);
			driver.findElement(By.id("loginButton")).click();
			
		}
	
}
