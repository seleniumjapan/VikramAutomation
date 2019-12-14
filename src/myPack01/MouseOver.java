package myPack01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseOver {

	WebDriver driver;
	
	@BeforeMethod
	public void openBrowser() {
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		String browserDriverPath = projectPath + "\\browserDriver\\chromedriver.exe";
		System.out.println(browserDriverPath);
		 System.setProperty("webdriver.chrome.driver", browserDriverPath);
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://www.naukri.com/");
	}
	
	
	@Test
	public void forEmployers() {
		WebElement employers = driver.findElement(By.xpath("//a[@title='For Employers']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(employers);
		act.build().perform();
		WebElement buyOnline = driver.findElement(By.xpath("//a[text()='Buy online']"));
		buyOnline.click();
	}
	
	
	
	
	
	@AfterMethod
	public void closeBrowser() {
		//driver.close();
	}
}
