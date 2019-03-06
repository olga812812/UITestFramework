package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingComPage extends BasePage{
	
	String pageUrl="https://booking.com";
	
	By fieldTripDates = By.cssSelector("[class='xp__dates xp__group']");
	
	//buttons
	By buttonOpenCalendar = By.xpath("//button[@aria-label='Открыть календарь']");

	public BookingComPage(WebDriver driver) {
		super(driver);
		loadPage(pageUrl);
	}
	
	
	public void enterDates() {
		sleep(3000);
		clickElement(buttonOpenCalendar);
		//inputTextToField(fieldTripDates, "12.02.2019-22.02.2019");
		sleep(3000);
		
	}

}
