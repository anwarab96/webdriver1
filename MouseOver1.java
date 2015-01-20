package com.webdriver1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOver1 {

	public static void main(String[] args) throws InterruptedException {
	//initilize chorome driver
		//System.setProperty("WebDriver.Chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Go to URL
		driver.get("http://flex.apache.org/");
		//Get web element
		WebElement element=driver.findElement(By.xpath("//ul[@id='nav']/li[3]/a"));
		//get sub element 
		WebElement subelement = driver.findElement(By.xpath("//ul[@id='nav']/li[3]/ul/li[6]/a/i"));
		//declare Actions object
		Actions action = new Actions(driver);
		//Mouse over on element
		 action.moveToElement(element).build().perform();
		//wait for subelement 
		Thread.sleep(2000);
		//click on subelement
		 action.moveToElement(subelement).click().build().perform();

	}

}
