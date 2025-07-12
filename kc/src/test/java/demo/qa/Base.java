package demo.qa;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
public class Base {

	WebDriver driver;
	@BeforeTest
	public void BrowserSetup() {
		

		 System.setProperty("webdriver.chrome.driver","D:\\Programming\\selenium\\chromedriver-win64\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.get("https://demoqa.com/");
		 driver.manage().window().maximize();
		 System.out.println("Demoqa launched successfully");
	}
	
}
