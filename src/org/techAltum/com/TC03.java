package org.techAltum.com;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import basePack.BaseClass;

public class TC03 extends BaseClass{
	
	@Test
	public void testCase03() throws InterruptedException {
		driver.get("https://www.naukri.com/");
		
		WebElement SearchJobTxtBo = driver.findElement(By.id("qsbClick"));
		SearchJobTxtBo.click();
		
		//Enter Skill
		String skills = "Java";
		WebElement skilltxtBo = driver.findElement(By.name("qp"));
		skilltxtBo.sendKeys(skills);
		System.out.println("Skill '" + skills + "' is entered.");
		
		//Enter location
		String loc = "Pune";
		WebElement locationtxtBo = driver.findElement(By.name("ql"));
		locationtxtBo.sendKeys(loc);
		System.out.println("Location '" + loc + "' is entered.");
		
		
		//Select Exp
	/*	Select exp = new Select(driver.findElement(By.xpath("//input[@class='sdTxt w85']")));
		exp.selectByIndex(5); */
		
		         //Select code and press ctrl + shift + / = to comment
				//Select code and press ctrl + shift + \ = to uncomment
				//to import all at once ct.rl + shijft + o
				
				//to get all shortcut keys of eclipse = ctrl + shift + l
		
		//Press Tap key
		locationtxtBo.sendKeys(Keys.TAB);
		System.out.println("Tap key is pressed"); 
		
		//Arrow Down - Exp
		WebElement exp = driver.findElement(By.xpath("//input[@class='sdTxt w85']"));
		for(int i=0;i<=6;i++) {
		exp.sendKeys(Keys.ARROW_DOWN);	
		}
		System.out.println("Experience is selected");
		
		WebElement selectedExp = driver.findElement(By.id("exp_ddHid"));
		selectedExp.getAttribute("value");
		System.out.println(selectedExp);
		
		//Arrow Down - Salary
		WebElement sal = driver.findElement(By.xpath("(//input[@class='sdTxt w85'])[2]"));
		for(int i=0;i<=10;i++) {
		sal.sendKeys(Keys.ARROW_DOWN);	
		}
		System.out.println("Salary is selected");
		
		WebElement Expectedsal = driver.findElement(By.id("salary_ddHid"));
		selectedExp.getAttribute("value");
		System.out.println(Expectedsal);
		
		//Mouse over on Recruiters
		Thread.sleep(2000);
		WebElement recruiters = driver.findElement(By.xpath("(//div[@class='mTxt'])[2]"));
		Actions action = new Actions(driver);
		action.moveToElement(recruiters);
		action.build().perform();
		System.out.println("Mouse over on Recruiter");
		
		//Mouse over on All recruiters
		WebElement allRecruiters = driver.findElement(By.xpath("//a[@title='Browse All Recruiters']"));
		allRecruiters.click();
	}

}
