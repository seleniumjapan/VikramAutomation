package basePack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	protected WebDriver driver;
	
	@BeforeMethod
	public void openBrowser() {
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is" + projectPath);
		
		String browserDriverPath = projectPath + "\\browserDriver\\chromedriver.exe";
		System.out.println("Browser driver path is " + browserDriverPath);
		
		System.setProperty("webdriver.chrome.driver", browserDriverPath);
		driver = new ChromeDriver();
		
		//maximize the window 
		
		driver.manage().window().maximize();
		
		//cookies
	//	driver.manage().deleteAllCookies();
		
	//	driver.navigate();
	}
	
	@AfterMethod
	public void quitBrowser() {
		//driver.quit();
	}
}
