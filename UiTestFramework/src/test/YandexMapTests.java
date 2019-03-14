package test;

import main.YandexMap;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class YandexMapTests extends BaseTest{
	
	YandexMap page = new YandexMap(driver);
	
	@Test
	public void buildRoute() {
		page.clickBuildRoute();
		page.chooseRouteType();
		page.inputABPoints();
	    assertTrue(page.findRouteTime());
		
		
	}

}
