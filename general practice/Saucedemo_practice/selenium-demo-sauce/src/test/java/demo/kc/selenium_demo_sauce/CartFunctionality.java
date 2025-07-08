package demo.kc.selenium_demo_sauce;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class CartFunctionality extends BaseClass {
	
	LoginFunctionality loginhelper;
	@BeforeMethod
	public void setup() {
		OpenUrl();
		loginhelper=new LoginFunctionality(driver);
	}
 
    @Test
	public void AddAllProducts() {
    	
		
		
		loginhelper.ValidLogin();
		List<WebElement> products=driver.findElements(By.linkText("Add to cart"));
		for(WebElement link : products) {
			link.click();
		}
		System.out.println(products);
		String Count=driver.findElement(By.xpath("//div[@id=\"shopping_cart_container\"]/a/span")).getText();
		System.out.println(Count);
		
		
	}

}
