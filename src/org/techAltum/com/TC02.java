package org.techAltum.com;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import basePack.BaseClass;
public class TC02 extends BaseClass{
	
	@Test
	public void testCase02() throws InterruptedException {
		driver.get("http://snapdeal.com");
		
		//Use of Actions class
		//Tap on Sign IN button
		WebElement signIN = driver.findElement(By.xpath("//div[@class='accountInner']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(signIN);
		act.build().perform();
		System.out.println("Mouse over - done");
		
		//Click on Login
		WebElement logIN = driver.findElement(By.xpath("//a[text()='login']"));
		logIN.click();
		System.out.println("Click on Login button");
		
		//switch to Frame
		driver.switchTo().frame(driver.findElement(By.id("loginIframe")));
		System.out.println("Switch on Frame");
		
		Thread.sleep(2000);
		//Enter Mobile Number
		WebElement mobileNum = driver.findElement(By.id("userName"));
		mobileNum.sendKeys("8880583530");
		System.out.println("Enter mobile number" + mobileNum);
		
		//Tap on Continue button
	/*	WebElement cont = driver.findElement(By.xpath("//button[text()='continue']"));
		cont.click();
		System.out.println("User click on Continue button"); */
		
		//Tap on Facebook
		WebElement facebk = driver.findElement(By.xpath("//span[@class='social-content']"));
		facebk.click();
		System.out.println("User click on Facebook"); 
		
		//Facebook account login : need to ask
		
		WebElement facebook = driver.findElement(By.id("email"));
		facebook.sendKeys("vikrambarh@gmail.com");
		
		WebElement pass = driver.findElement(By.id("pass"));
		pass.clear();
		pass.sendKeys("123456789");
		
		WebElement login = driver.findElement(By.id("loginbutton"));
		login.click();
		
		//Tap on Google
	/*	WebElement google = driver.findElement(By.xpath("//span[text()='Google']"));
		google.click();
		System.out.println("User click on Google"); */
		
		//driver.switchTo().defaultContent();
	}

}
