package test;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import main.BookingComPage;

public class BookingComTests extends BaseTest{
	BookingComPage page  = new BookingComPage(driver);
	
	
	
	@Test 
	public void enterDates() {
		page.enterDates();
	}

}
