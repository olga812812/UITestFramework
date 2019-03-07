package test;

import org.testng.annotations.Test;
 import static org.testng.Assert.*;

import main.TechPortRu;

public class TechportRuTests extends BaseTest {
	
	TechPortRu page= new TechPortRu(driver);
	
	@Test(enabled=false)
	public void byProduct() {		
		page.findProduct("тостер");
		page.chooseRandomProduct();
		page.buyProduct();
		
	}
	
	@Test
	public void chooseProductCategoryInMenu() {
		page.pointMenuIcon();
		page.pointProductCatedory();
		page.pointProductSubCategory();
		assertTrue(page.isSubCategoryOpened());
	}

	@Test (dependsOnMethods="chooseProductCategoryInMenu")
	public void filterProductsInCategory(){
		page.filterProducers();
		page.filterPrice();
		page.clickApplyFilters();
		
	}
}
