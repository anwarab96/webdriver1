package com.webdriver1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class KeyWordFWork {
	
	public static void main(String[] args) throws Exception {
		//Test Data
		String vBrowser, vURL, eXpath, vText, vGetText, vAttribute;
		long vSleep;
		 vBrowser = "Firefox";
		 WebDriver driver;
		 vText = "";
		 eXpath = "//*[@id='hplogo']";
		 vURL = "http://www.google.com/";
		 vSleep = 2000;
		 if (vBrowser=="Firefox"){
			  driver = new FirefoxDriver();
		 }else{
			 driver = new InternetExplorerDriver();
		 }
		 //navigate to a specific URL
		 driver.navigate().to(vURL);
		 
		 //Sendkeys-Find an element and send a text into it
		 eXpath = "/html/body/div/div[3]/form/div[2]/div[2]/div[1]/div[1]/div[1]/div/div[2]/div/input[1]";
		 vText = "selenium webdriver";
		 driver.findElement(By.xpath(eXpath)).sendKeys(vText);
		 vAttribute = "value";
		 vSleep = 2000;
		//Click-Find element and click
		 eXpath = "//*[@id='gbqfb' and @name='btnG']";
		 driver.findElement(By.xpath(eXpath)).click();
		 Thread.sleep(vSleep);
		 //GetText- Find an element and get Text out of it
		 eXpath = "//*[@id='gbqfq']";
		 vText = "selenium webdriver";
		 vGetText = driver.findElement(By.xpath(eXpath)).getText();
		 
		 System.out.println("Text 1 is vGetText");
		 Thread.sleep(vSleep);
		 
		 eXpath = "//*[@id='resultStats']";
		 vText = "selenium webdriver";
		 vGetText = driver.findElement(By.xpath(eXpath)).getText();//from the searchresults for resultstatus;
		 System.out.println("Text 2 is vGetText");
		 Thread.sleep(vSleep);
		 
		 //Getattribute- Find an element and get a value of a certain attribute out of this. 
		 eXpath = "//*[@id='lst-ib']";
		 vAttribute = "value";
		 vGetText=driver.findElement(By.xpath(eXpath)).getAttribute(vAttribute);
		 System.out.println("Text 3 is vGetText");
		 Thread.sleep(vSleep);
		 
		 // Close the WD or the browser
		 driver.close();
		 //Wait
		
	}

}
