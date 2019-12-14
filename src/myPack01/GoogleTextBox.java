package myPack01;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTextBox {

WebDriver driver;
	
	@BeforeMethod
	
	public void openBrowser() throws InterruptedException {
		//open browser
         String projectPath = System.getProperty("user.dir");
         System.out.println(projectPath);
        String browserDriverPath = projectPath + "\\browserDriver\\chromedriver.exe";
        System.out.println("Browser driver payh is :" + browserDriverPath);
        
        System.setProperty("webdriver.chrome.driver", browserDriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
		
		//Enter URL
		driver.get("https://www.google.co.in/");
	
}
	
	@Test
	//Google text box suggestion list
	
	public void googleTextBoxSuggestion() {
		String keyWord = "Java";
		WebElement autoSuggestion = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
		autoSuggestion.sendKeys(keyWord);
		System.out.println("Suggestion list fron Java keyword :" + keyWord);
		
		//display autoSuggestionList
		List <WebElement> autoSuggestionList = driver.findElement(By.xpath("//div[@class='UUbT9']")).findElements(By.tagName("li"));
		System.out.println("Total auto Suggestions are :" + autoSuggestionList.size());
		
		String needToSelect = "java online compiler";
		for(int i=0;i<autoSuggestionList.size();i++) {
			String needToSelectKeyWord = autoSuggestionList.get(i).getText();
			System.out.println(needToSelectKeyWord);
			if(needToSelectKeyWord.contains(needToSelect)) {
				autoSuggestionList.get(i).click();
				break;
			}
		}
	}
	
	@AfterMethod
	//close browser
	public void closeBrowser() {
	//	driver.close();
	}
}