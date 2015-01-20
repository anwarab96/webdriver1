package com.webdriver1;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TakingListOfElement {

	public static void main(String[] args) throws Exception  {
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://www.amazon.com/");
		List<WebElement> list = driver.findElements(By.tagName("a"));
		int mylist = list.size();
		System.out.println("number of list " + mylist);
		for(int i = 0; i<mylist; i++){
			//System.out.println(i);
		if(!list.get(i).getText().equals(""))
		{	System.out.println("List text is "+list.get(i).getText());
				System.out.print("........");
				System.out.print("URL is "+ list.get(i).getAttribute("href"));
				System.out.println("");
			}
		}
		File myImg = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = "C://Selenium/test.jpg";
		FileUtils.copyFile(myImg, new File(path));
		Thread.sleep(2000);
		driver.close();
	}
}


