package com.webdriver1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOver2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		//maximize window
		driver.manage().window().maximize();
		//wait for page load
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		//Go to URL
		driver.get("http://flex.apache.org/");
		//Get web element
		WebElement element = driver.findElement(By.xpath("//ul[@id='nav']/li[5]/a"));
		//Thread.sleep(1000);
		//Get sub web element/html/body/div[1]/div[1]/
		WebElement element1 = driver.findElement(By.xpath("//a[contains(text(),'Getting Started')]"));
		//Declare Actions Object
		Actions action = new Actions(driver);
		//Mouse over on element items
		action.moveToElement(element).build().perform();
		//wait for items
		Thread.sleep(2000);
		//click on element1 items
		 action.moveToElement(element1).click().build().perform();


	}

}
