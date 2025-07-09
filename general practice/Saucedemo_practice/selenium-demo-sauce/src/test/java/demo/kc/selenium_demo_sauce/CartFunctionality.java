package demo.kc.selenium_demo_sauce;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;



public class CartFunctionality extends LoginFunctionality {
	
	
 
    @Test
	public void AddAllProducts() {
    	
		
		
		ValidLogin();
		List<WebElement> products=driver.findElements(By.xpath("//div[@class=\"inventory_item_description\"]/div[2]/button"));
		
		for(WebElement link : products) {
			link.click();
		}
		
		ImplicitlyWait();
		String Count=driver.findElement(By.xpath("//div[@id=\"shopping_cart_container\"]/a/span")).getText();
		System.out.println(Count);
		List<WebElement> pdtname=driver.findElements(By.xpath("//div[@class=\"inventory_list\"]/div/div[2]/div/a/div"));
		for(WebElement name : pdtname) {
			System.out.println(name.getText());
		}
		
		
	}
    
    @Test
    public void RemovePdt() {
    	
    	AddAllProducts();
    	List<WebElement> Removepdt=driver.findElements(By.xpath("//button[text()='Remove']"));
    	for(int i=0;i<2;i++) {
    		Removepdt.get(i).click();
    	}
    	ImplicitlyWait();
    	String cartcount=driver.findElement(By.xpath("//div[@id=\"shopping_cart_container\"]/a/span")).getText();
    	if(cartcount.equals("4")) {
    		System.out.println("4 items are remaining in the cart");
    	}
    	else {
    		System.out.println("Expected 4, but found " + cartcount);
    	}
		
    

}
}

