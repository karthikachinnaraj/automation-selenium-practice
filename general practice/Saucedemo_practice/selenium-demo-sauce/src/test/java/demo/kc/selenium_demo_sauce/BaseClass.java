package demo.kc.selenium_demo_sauce;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.apache.commons.io.FileUtils;

public class BaseClass {
	
	WebDriver driver;
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
	
	public void Screenshot(String testName)  {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			 String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		     String fileName = "D:\\Programming\\java\\general practice\\Saucedemo_snapshot\\" + testName + "_" + timestamp + ".png";
		        
		        FileUtils.copyFile(src, new File(fileName));
		        System.out.println("Screenshot saved: " + fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
		public void ExplicitlyWait(WebElement Element) {
			
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOf(Element));
		}
		
		public void ImplicitlyWait() {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		}
	}
	

	


