package main;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public  class BasePage {
	WebDriver driver;
	public BasePage(WebDriver driver) {
		this.driver = driver;
	};
	
	public void loadPage(String pageUrl) {
		
		driver.get(pageUrl);
		
	}
	
	public void sleep(int time) {
		try {
			Thread.sleep(time);
		}
		catch (Exception ex) {ex.printStackTrace();}
	}
	
	public void clickElement(By elementLocator) {
		driver.findElement(elementLocator).click();
	}
	
	public void clickElement(WebElement webElement) {
		webElement.click();
	}
	
	public void inputTextToField(By elementLocator, String text) {
		WebElement element = driver.findElement(elementLocator);	
		element.clear();
		element.sendKeys(text);
		
	}
	
	public void waitSelectionStateOfElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeSelected(locator));
			}
	
	public void waitOfPresence(By locator)
	{	
		WebDriverWait waitG = new WebDriverWait(driver, 10);					
		waitG.until(ExpectedConditions.presenceOfElementLocated(locator));		
	}
	
	public void waitOfVisibility(By locator)
	{	
		WebDriverWait waitG = new WebDriverWait(driver, 10);	
		waitG.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));	
	}
	
	public void waitOfElementToBeClickable(By locator) {
		WebDriverWait waitG = new WebDriverWait(driver, 10);	
		waitG.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void waitOfElementToBeClickable(WebElement element) {
		WebDriverWait waitG = new WebDriverWait(driver, 20);	
		waitG.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitOfInvisibilityOfElement(By locator) {
		
		WebDriverWait waitG = new WebDriverWait(driver, 20);	
		waitG.until(ExpectedConditions.invisibilityOf(findElement(locator)));
	}
	
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	
	
	public List<WebElement> findAllElements(By locator) {
		return driver.findElements(locator);
	}
	
	public void moveToElement(By locator){
		WebElement element = driver.findElement(locator);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}
	
	public void moveToElementAndClick(By locator){
		WebElement element = driver.findElement(locator);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click();
		actions.perform();
	}
	
	public void ClickElementAndSlideByOffset(By locator, int offSetX, int ossSetY){
		WebElement element = driver.findElement(locator);	
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(element, offSetX, ossSetY);
		actions.perform();
	}
	
	public boolean isElementHere(By locator){
		try { 
			findElement(locator);
			return true;}
			catch (NoSuchElementException ex) {return false;}
		
	}
	

}
