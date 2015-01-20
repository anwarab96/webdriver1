package com.webdriver1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ExploringFindElement {

	public static void main(String[] args) throws Exception {
	//WebDriver driver = new InternetExplorerDriver();
	WebDriver driver = new FirefoxDriver();
	//WebDriver myDriver = new HtmlUnitDriver();
	driver.get("http://www.amazon.com");
	//find the link and click on it
	driver.findElement(By.linkText("Sell on Amazon")).click();
	Thread.sleep(3000);
	driver.navigate().back();
	Thread.sleep(3000);
	driver.findElement(By.linkText("Become an Affiliate")).click();
	
	//wait for 2 sec at this step
	Thread.sleep(2000);
	driver.navigate().to("http://www.amazon.com");
	Thread.sleep(2000);
//	driver.findElement(By.name("map_0_image-map-ns_15BE6HHT2310BDZDEECR_10333_")).sendKeys("kindle");
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("//span[@class='nav-line--1']"));

	}

}
