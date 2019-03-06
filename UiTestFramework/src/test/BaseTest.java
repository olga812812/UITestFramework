package test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {

	WebDriver driver=initDriver("chrome");
	
	
	//@Parameters ("browser")
	@BeforeClass
	public void beforeAll() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	
	private WebDriver initDriver(String browser) {
		
		switch(browser) {
		case "chrome" :
			WebDriverManager.chromedriver().setup();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			return driver= new ChromeDriver(options);
		default: return null;
		}
		
	}
	
	@AfterClass
	public void close() {
		driver.close();
	}

}
