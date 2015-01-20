package com.webdriver1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestCase;

public class KeyWordFwork1 extends SeleneseTestCase{
	@Before
	public void beforeBlock(){
		System.out.println("@Before");
	selenium = new DefaultSelenium("localhost",4444,"*firefox C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe", "http://www.google.com");
	selenium.start();
	}
	@Test
	public void testBlock(){
		System.out.println("@Test");
		sOpen("http://www.google.com");
	}
	public void sOpen(String vURL) {
		selenium.open(vURL);
		
	}
	@After
	public void afterBlock(){
		System.out.println("@After");
		
	}

}
