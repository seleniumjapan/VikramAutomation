package myPack01;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase04 {

	WebDriver driver;
	
	@BeforeMethod
	
	public void openBrowser() throws InterruptedException {
		//open browser
		String projectPath = System.getProperty("user.dir");
		System.out.println("Projejct Path is = " + projectPath);
		
		String browserDriverPath = projectPath + "\\browserDriver\\chromedriver.exe";
		System.out.println("Browser Driver exe path = " + browserDriverPath);
		
		System.setProperty("webdriver.chrome.driver", browserDriverPath);
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//Enter URL
		driver.get("http://www.cheapoair.com");
		//validate that user is on current page
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		}
	
	
	@Test
	public void TicketReservation() throws InterruptedException {
	//Enter from city name
			String fromCityName = "BANG";
			WebElement fromCity = driver.findElement(By.xpath("//input[@class='form-control pr-4']"));
			fromCity.sendKeys(fromCityName);
			System.out.println("From city is entered = " + fromCityName);
		
			Thread.sleep(2500);
			
			//AutoSuggestion list handle
			List<WebElement> autoSuggestionList = driver.findElement(By.xpath("//ul[@class='suggestion-box__list']")).findElements(By.tagName("li"));
			System.out.println("Total suggestions are " + autoSuggestionList.size());
			
			if(autoSuggestionList.size() == 0) {
				throw new InterruptedException("Suggestion box is not found");
			}
			
			String cityNeedToSelect = "Bangkok";
			
			for(int i=0;i<autoSuggestionList.size();i++) {
				String citySuggestion = autoSuggestionList.get(i).getText();
				System.out.println(citySuggestion);
				
				if(citySuggestion.contains(cityNeedToSelect)) {
					autoSuggestionList.get(i).click();
					break;
				}
			}
			  Thread.sleep(3000);
			   String toCityName = "LAS";
				WebElement toCity = driver.findElement(By.xpath("(//input[@class='form-control pr-4'])[2]"));
				toCity.sendKeys(toCityName);
				System.out.println("To city is entered = " + toCityName);
				
			    Thread.sleep(3500);
				List<WebElement> toSuggestionList = driver.findElement(By.xpath("(//ul[@class='suggestion-box__list'])[2]")).findElements(By.tagName("li"));
				System.out.println("Total suggestions are = " + toSuggestionList.size());
				
			for(int j=0;j<toSuggestionList.size();j++) {
					String citySuggestionTo = toSuggestionList.get(j).getText();
					System.out.println(citySuggestionTo);
					
					if(citySuggestionTo.contains("Nevada")) {
						toSuggestionList.get(j).click();
						break;
					} 
			}
			
			  //Cal will be open
			  //Select Dates
			WebElement depart = driver.findElement(By.xpath("//input[@placeholder='Pick a date']"));
			depart.click();
			System.out.println("Cal is opened");
			  String a = "//div[@class='calendar__single-month active']/div[3]/div[";
			  int k = 1;
			  String b = "]/div";
			  String xp = a + k + b;
			  String dateNeedToSelect = "29";
			  
			  for(k = 1; k<=42; k++) {
				  xp = a + k + b;
				  
				  try {
					  String dateInCal = driver.findElement(By.xpath(xp)).getText();
					  System.out.println(dateInCal);
					  
					  if(dateInCal.equals(dateNeedToSelect)) {
						  driver.findElement(By.xpath(xp)).click();
						  System.out.println("Date " + dateNeedToSelect + " is selected.");
						  break;
					  }
				  }
				  catch(Exception ex) {
					  System.out.println("No date is present for xpath = " + xp);
				  }
			  }}
		  //on 29 date is not click,need to ask

	
	@AfterMethod
	public void quitBrowser() {
		//driver.quit();
	}
	
}
