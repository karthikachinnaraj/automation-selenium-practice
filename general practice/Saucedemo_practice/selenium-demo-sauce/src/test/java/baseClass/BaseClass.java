package baseClass;


import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseClass {
	
	protected WebDriver driver;
	@BeforeMethod
	public void OpenUrl() {
		final Map<String, Object> chromePrefs = new HashMap<>();
		chromePrefs.put("credentials_enable_service", false);
		chromePrefs.put("profile.password_manager_enabled", false);
		chromePrefs.put("profile.password_manager_leak_detection", false); // <======== This is the important one

		final ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("prefs", chromePrefs);

		 System.setProperty("webdriver.chrome.driver","D:\\Programming\\selenium\\chromedriver-win64\\chromedriver.exe");
		 driver=new ChromeDriver(chromeOptions);
		 driver.get("https://www.saucedemo.com/");
	
	
	}
	
	@AfterMethod
	public void closeUrl() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
	
	}
	

	


