package myPack01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase02 {

	
	WebDriver driver;
	//open browser
	@BeforeMethod
	public void openBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium_New\\TechAltum_Selenium_Project_4\\browserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		String pageTitle = driver.getTitle();
		System.out.println("Naukari page title is " + pageTitle);
		
		if(pageTitle.contains("Recruitment")) {
			System.out.println("User is on the correct page");
		}
		else {
			System.out.println("User is not on the correct page");
		}
		
	}
	
	
	
	
	
	@Test
	public void searchJobText() {
		
	}
	
	
	
	
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
