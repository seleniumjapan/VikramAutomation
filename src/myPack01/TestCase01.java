package myPack01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase01 {

WebDriver driver;
	
	@BeforeMethod
	// open browser
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium_New\\TechAltum_Selenium_Project_4\\browserDriver\\chromedriver.exe");
		//G:\\Selenium_New\\TechAltum_Selenium_4\\browserDrivers\\chromedriver.exe
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.snapdeal.com/");
		
		//validate that user is on current page
		String pageTitle = driver.getTitle();
		System.out.println("Page title is : " + pageTitle);
		if(pageTitle.contains("Snapdeal")) {
			System.out.println("User is on current page");
		}
		else {
			System.out.println("User is not on current page");
		}
	}
	
	@Test
	public void testSnapdealPage() throws InterruptedException {
		Thread.sleep(3000);
		/*driver.findElement(By.xpath("//a[@class='dp-widget-link hookLink']")).click();
		driver.findElement(By.xpath("(//a[@class='dp-widget-link hookLink'])[1]")).click();
		driver.findElement(By.xpath("(//a[@class='dp-widget-link hookLink'])[2]")).click();
		driver.findElement(By.xpath("(//a[@class='dp-widget-link hookLink'])[3]")).click();
		driver.findElement(By.xpath("(//a[@class='dp-widget-link hookLink'])[4]")).click();
		driver.findElement(By.xpath("(//a[@class='dp-widget-link hookLink'])[5]")).click();
		driver.findElement(By.xpath("//a[text()='Gift Cards']")).click();*/
		driver.findElement(By.xpath("//*[text()='Donate Sanitary Pads']")).click();
		
		//type some string to search
		driver.findElement(By.id("inputValEnter")).sendKeys("Shirts");
		
		//click on search button
		driver.findElement(By.xpath("//button[@class='searchformButton col-xs-4 rippleGrey']")).click();
		Thread.sleep(2000);
		
		//Get total no. of items
		String totalItems = driver.findElement(By.xpath("//div[@class='search-result-txt-section  marT12']/span")).getText();
		System.out.println(totalItems);
		
		
		driver.findElement(By.xpath("//span[@class='accountUserName col-xs-12 reset-padding']")).click();
		Thread.sleep(3000);
		//click on Sign IN
				//driver.findElement(By.xpath("//*[text()='Sign In']")).click();
				driver.findElement(By.xpath("//span[text()='Sign In']")).click();
				//click on Log IN
				Thread.sleep(2000);
				//driver.findElement(By.xpath("//a[text()='login']")).click();
				driver.findElement(By.xpath("//*[text()='login']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='col-xs-24 clickOnceOnly']")).sendKeys("8880583530");
		driver.findElement(By.xpath("//button[@id='checkUser']")).click();
	}
	
	@AfterMethod
	public void quitBrowser() {
		driver.quit();
	}
}
