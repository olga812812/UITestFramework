package test;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

import main.YandexMarketPage;

public class YandexMarketPageTests extends BaseTest{
	YandexMarketPage page = new YandexMarketPage(driver);
	String product="тостер";
	
	@Test
	public void findProductWithMinimalPrice() {
		page.findProduct(product);
		page.sortByAscending();
		page.selectProductWithMinimalPrice();
		assertTrue(page.isCharacteristicsOfProductHere());
		
		
	}

}
