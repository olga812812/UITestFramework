package main;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexMarketPage extends BasePage{
		String pageUrl = "https://market.yandex.ru/";
	
		//events
		By searchFinished = By.xpath("//div[@class='i-bem n-pager-more n-pager-more_js_inited' and not(@style[contains(text(),'none')])]");		
		
		//fields
		By searchField = By.id("header-search");
		
		//links
		By sortByPrice = By.xpath("//a[contains(text(),'по цене')]");
		By firstLinkAfterSorting = By.xpath("//div[@class='n-snippet-card2 i-bem b-zone b-spy-visible b-spy-visible_js_inited b-zone_js_inited'][1]/descendant::div[@class='n-snippet-card2__title']/a");
		By characteristicsOfProduct = By.xpath("//a[contains(text(),'Характеристики')]");

	public YandexMarketPage(WebDriver driver) {
		super(driver);
		loadPage(pageUrl);
	}
	
	public void findProduct(String product) {
		inputTextToField(searchField, product+"\n");
		waitOfPresence(sortByPrice);					
			
	}
	
	public void sortByAscending() {
		clickElement(sortByPrice);
		waitOfVisibility(searchFinished);
		
	}
	
	public void selectProductWithMinimalPrice() {
		clickElement(firstLinkAfterSorting);
	}
	
	public boolean isCharacteristicsOfProductHere() {
		return isElementHere(characteristicsOfProduct);
		
	}

}
