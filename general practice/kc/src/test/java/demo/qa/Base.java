package demo.qa;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
public class Base {

	public WebDriver driver;
	public JavascriptExecutor js;
	@BeforeTest
	public void BrowserSetup() {
		

		 System.setProperty("webdriver.chrome.driver","D:\\Programming\\selenium\\chromedriver-win64\\chromedriver.exe");
		 driver=new ChromeDriver();
		  this.js = (JavascriptExecutor) driver;
		 driver.get("https://demoqa.com/");
		 driver.manage().window().maximize();
		 System.out.println("Demoqa launched successfully");
	}
	//@AfterTest
	public void Close() {
		driver.close();
		driver.quit();
	}
	
	public void Implicitlywait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	}
	
	public void Explicitlywait(WebElement Element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOf(Element));
	}
	
	public void AlertpresentExpliclitlywait() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(6));
		wait.until(ExpectedConditions.alertIsPresent());
	}
}
