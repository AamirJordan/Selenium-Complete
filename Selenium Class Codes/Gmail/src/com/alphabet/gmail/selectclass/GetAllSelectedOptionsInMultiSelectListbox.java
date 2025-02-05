package com.alphabet.gmail.selectclass;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.alphabet.gmail.webdrivermethods.BasicSettings;

public class GetAllSelectedOptionsInMultiSelectListbox extends BasicSettings
{
	public static void main(String[] args) 
	{
		WebDriver driver = setUp("file:///D:/Java%20Selenium/SCSW4/Session%2023/index.html");
		WebElement subjectsListBox=driver.findElement(By.id("multi"));
		
		Select s = new Select(subjectsListBox);
		
		if(s.isMultiple())
		{
			System.out.println("Its a MultiSelect List Box");
		}
		else
		{
			System.out.println("Its a Single Select List Box");
		}
		
		List<WebElement> allOptions = s.getOptions();
		for(int i=0;i<=allOptions.size()-1;i+=2)
		{
			s.selectByIndex(i);
			mySleepInSeconds(1);
		}
		System.out.println("=======List of Options Selected======");
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		for(WebElement selectedOption:allSelectedOptions)
		{
			System.out.println(selectedOption.getText());	
		}
		driver.close();
	}
}


