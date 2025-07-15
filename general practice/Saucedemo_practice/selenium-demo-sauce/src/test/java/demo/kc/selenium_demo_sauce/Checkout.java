package demo.kc.selenium_demo_sauce;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Checkout extends LoginFunctionality{
	@Test
	public void checkout() {
		
		List<WebElement> products=driver.findElements(By.xpath("//div[@class=\"inventory_item_description\"]/div[2]/button"));
			for(int i=0;i<2;i++) {
				products.get(i).click();
		}
			System.out.println("2 products are added to cart");
			driver.findElement(By.className("shopping_cart_link")).click();
			driver.findElement(By.id("checkout")).click();
			
			Customer cus1=new Customer("karthika","chinnaraj","600051");
			driver.findElement(By.id("first-name")).sendKeys(cus1.getFirstname());
			driver.findElement(By.id("last-name")).sendKeys(cus1.getLastname());
			driver.findElement(By.id("postal-code")).sendKeys(cus1.getPostalcode());
			driver.findElement(By.id("continue")).click();
			
			List<WebElement>itemprice=driver.findElements(By.className("inventory_item_price"));
			
			String price1=itemprice.get(0).getText();
			String price2=itemprice.get(1).getText();
			double price11=Double.parseDouble(price1.replace('$',' '));
			double price21=Double.parseDouble(price2.replace('$',' '));
			double total=price11+price21;
			String mess=driver.findElement(By.className("summary_subtotal_label")).getText();
			
			double itemtotal=Double.parseDouble(mess.replace("Item total: $", "  "));
			
			if(total==itemtotal){
				System.out.println("Total is correct");
			}
			else {
				System.out.println("Mistake in total");
			}
	}
	
	


	}

