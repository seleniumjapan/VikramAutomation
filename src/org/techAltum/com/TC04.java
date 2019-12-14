package org.techAltum.com;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import basePack.BaseClass;

public class TC04 extends BaseClass{

	@Test
	public void testCase04() throws InterruptedException {
		
		driver.get("http://www.onetravel.com");
		
		//Enter source city name
		String originCityName = "BANG";
		WebElement cityName = driver.findElement(By.xpath("//input[@class='form-control pr-4']"));
		cityName.clear();
		cityName.sendKeys(originCityName);
        System.out.println("From city is entered = " + originCityName);
		
		Thread.sleep(2500);
		
		//Auto Suggestion list
		List<WebElement>autoSuggestionList = driver.findElement(By.xpath("//ul[@class='suggestion-box__list']")).findElements(By.tagName("li"));
		System.out.println("Total Suggestion are : " + autoSuggestionList.size());
		
		String cityNeedToSelect = "Bangkok";
		
		for(int i=0; i<autoSuggestionList.size();i++) {
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
		//Open Cal
	/*	WebElement departCal = driver.findElement(By.xpath("//input[@placeholder='Depart']"));
		departCal.click();
		System.out.println("Calender io open"); */
		//Select Dates
				String a = "//div[@class='calendar__single-month active']/div[3]/div[";
				int i = 1;
				String b = "]/div";
				String dateNeedToSelect = "30";
				
				String xp = a + i + b;
				
				for(i = 1; i<=42; i++) {
					xp = a + i + b;
					
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
						System.out.println("No date found for xpath = " + xp);
					}
	}
	}
}
