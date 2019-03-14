package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexMap  extends BasePage{
	String pageUrl = "https://yandex.ru/maps/";
	String pointA="Осенний бульвар, 16к1";
	String pointB="Осенний бульвар, 23";
	
	//Buttons	
	By buttonBuildRoute = By.cssSelector("[class='small-search-form-view__icon _type_route']");
	
	//icons
	By iconMosTransport = By.xpath("//div[@class='route-form-view__travel-mode _mode_masstransit']/descendant::span[@class='route-form-view__travel-icon']");
	
	//fields
	By fieldPointA = By.xpath("//div[@class='route-field-view _index_0']/descendant::input[@class='input_medium__control']");
	By fieldPointB = By.xpath("//div[@class='route-field-view _index_1']/descendant::input[@class='input_medium__control']");
	
	//others	
	By suggestionPointA= By.xpath("//div[@class='route-suggest-item-view__title']/descendant::em[contains(text(),'16к1')]");
	By suggestionPointB= By.xpath("//div[@class='route-suggest-item-view__title']/descendant::em[contains(text(),'23')]");
	By labelRouteTime = By.xpath("//div[@class='masstransit-route-view__route-title-primary' and contains(text(),'мин')]");

	public YandexMap(WebDriver driver) {
		super(driver);
		loadPage(pageUrl);
	}
	
	public void clickBuildRoute() {
		clickElement(buttonBuildRoute);		
	}

	public void chooseRouteType(){
		clickElement(iconMosTransport);	
	}
	
	public void inputABPoints(){
		inputTextToField(fieldPointA, pointA);		
		waitOfPresence(suggestionPointA);
		clickElement(suggestionPointA);
		inputTextToField(fieldPointB, pointB);
		waitOfPresence(suggestionPointB);
		clickElement(suggestionPointB);		
	}
	
	public boolean findRouteTime() {	
		return isElementHere(labelRouteTime);
		
	}
}
