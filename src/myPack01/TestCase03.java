package myPack01;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase03 {

	WebDriver driver;
	
	@BeforeMethod
	//open browser
	public void openBrowser() {
	System.setProperty("webdriver.chrome.driver", "G:\\Selenium_New\\TechAltum_Selenium_Project_4\\browserDriver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.snapdeal.com/");
	String pageTitle = driver.getTitle();
	System.out.println(pageTitle);
	
	//Verify that user is on current page
	if(pageTitle.contains("Snapdeal")) {
		System.out.println("User is on current page");
	}
	else {
		System.out.println("User is not on current page");
	}
		
	}
	
	
	
	@Test
	//tap on Gift
	public void giftCards() throws InterruptedException {
		Thread.sleep(3000);
		/*driver.findElement(By.xpath("//a[@class='dp-widget-link hookLink']")).click();
		driver.findElement(By.xpath("(//a[@class='dp-widget-link hookLink'])[1]")).click();
		driver.findElement(By.xpath("(//a[@class='dp-widget-link hookLink'])[2]")).click();
		driver.findElement(By.xpath("(//a[@class='dp-widget-link hookLink'])[3]")).click();
		driver.findElement(By.xpath("(//a[@class='dp-widget-link hookLink'])[4]")).click();
		driver.findElement(By.xpath("(//a[@class='dp-widget-link hookLink'])[5]")).click();*/
		//Sign IN
		/*driver.findElement(By.xpath("//span[@class='accountUserName col-xs-12 reset-padding']")).click();
		driver.findElement(By.xpath("//*[@class='accountUserName col-xs-12 reset-padding']")).click();
		//click on Sign IN
		driver.findElement(By.xpath("//*[text()='Sign In']")).click();*/
		
		//Mouse Over - Sign In
		//Use Actions CLASS
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		WebElement signIn = driver.findElement(By.xpath("//span[text()='Sign In']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(signIn);
		act.build().perform();
		
		//Click on Login
		
	  WebElement login = driver.findElement(By.xpath("//a[text()='login']"));
	  login.click();
	  
	  //Enter Mobile number
	  WebElement mobileNumber = driver.findElement(By.xpath("//input[@class='col-xs-24']"));
	  //WebElement mobileNumber = driver.findElement(By.xpath("//form[@id='commonView']"));
	 act.click(mobileNumber).sendKeys("Hello!").perform();
	 
	  
	  //Click on Continue button
	  WebElement continueButton = driver.findElement(By.xpath("//button[text()='continue']"));
	  continueButton.click();
		}

	@AfterMethod
	//close browser
	public void closeBrowser() {
		//driver.quit();;
	}
	
}
