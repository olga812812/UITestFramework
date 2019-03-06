package main;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import test.BaseTest;

public class TechPortRu extends BasePage{
	String pageUrl="https://www.techport.ru/";
	//fields
	By searchField = By.xpath("//input[@class='tcp-input-control__input tcp-input-control__input_lg tcp-input-control__input_bold']");
	By nameField = By.id("order_name");
	By emailField = By.id("order_email");
	By phoneField = By.id("order_phone");

	//buttons	
	By buttonFindProduct = By.id("desktop_search_submit"); 
	By buttonBuyProduct = By.cssSelector("[class='tcp-button tcp-button_orange tcp-button_xlg btn_buy']");
	By buttonMakeOrder = By.xpath("//span[@class='tcp-button__text tcp-button__text_big tcp-button__text_flex']");
	By buttonMakeOrderFinishStep = By.xpath("//span[contains(text(),'Оформить')]");
	By buttonNext = By.xpath("//span[contains(text(),'Продолжить')]");
	By buttonDeliveryType= By.xpath("//label[@for='order_delivery_type_pickup']/descendant::span[@class='tcp-radio-big__indicator']");
	By buttonPaymentType=By.xpath("//label[@for='order_payment_option_1']/descendant::span[@class='tcp-radio-big__indicator']");
	
	//titles	
	By titleSearchResults = By.xpath("//h1[contains(text(),'Результаты поиска')]");
	By titleWriteContactInformation = By.xpath("//div[contains(., 'Укажите контактную информацию') and @class='tcp-section-header__title']");
	By titleGruming =By.xpath("//h1[contains(text(),'Груминг')]"); 
	
	//links
	By allProducts = By.xpath("//span[contains(text(),'Тостер') and @class='ellip']");
	By menuIcon = By.xpath("//div[@class='tcp-burger tcp-burger_white']");
	By categoryZooProducts=By.xpath("//a[@href='/katalog/products/zootovary']");
	By subCategoryGruming = By.xpath("//a[@href='/katalog/products/zootovary/koshki/gruming']");
	
	
	public TechPortRu(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		loadPage(pageUrl);
		driver.manage().window().maximize(); 
	}
	
	public void findProduct(String product){
		
		inputTextToField(searchField, product);
		clickElement(buttonFindProduct);
		waitOfPresence(titleSearchResults);
	}
	
	public void chooseRandomProduct() {
		
		WebElement firstProduct = findAllElements(allProducts).get(0);
		System.out.println("Web elements size"+findAllElements(allProducts).size() +"  "+firstProduct.getText()+"  "+firstProduct.getTagName());
		waitOfElementToBeClickable(firstProduct);
		clickElement(firstProduct);
		waitOfElementToBeClickable(buttonBuyProduct);
	}
	
	public void buyProduct() {
		clickElement(buttonBuyProduct);
		waitOfElementToBeClickable(buttonMakeOrder);
		clickElement(buttonMakeOrder);
		waitOfElementToBeClickable(buttonMakeOrderFinishStep);
		clickElement(buttonMakeOrderFinishStep);
		waitOfPresence(titleWriteContactInformation);
		inputTextToField(nameField, "Ivan Ivanov");
		inputTextToField(emailField, "ivan234@mail.ru");
		inputTextToField(phoneField, "9265678596");
		clickElement(buttonNext);
		clickElement(buttonDeliveryType);
		clickElement(buttonNext);
		waitOfElementToBeClickable(buttonPaymentType);
		clickElement(buttonPaymentType);		
		
	}
	
	public void pointMenuIcon(){	
		moveToElement(menuIcon);			
	}
	
	public void pointProductCatedory() {
		moveToElement(categoryZooProducts);		
	}
	
	public void pointProductSubCategory() {
		moveToElementAndClick(subCategoryGruming);
		
	}
	
	public boolean isSubCategoryOpened(){
		return isElementHere(titleGruming);
	}

}
