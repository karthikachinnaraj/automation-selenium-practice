package demo.qa;

import java.util.List;

import javax.swing.Scrollable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class UIElementTests extends Base {
	@Test
	public void ElementPractice() {
		Customer cus=new Customer("karthika","asd@gmail.com","chennai");
		List<WebElement>menu=driver.findElements(By.xpath("//div[@class='card-up']/following-sibling::div[2]"));
		
		for(int i=0;i<menu.size();i++) {
			
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			//((JavascriptExecutor)driver).executeScript("argument[0].scrolltoview(true)",elem);
			((JavascriptExecutor)driver).executeScript("window.scrollBy(0,0);");
			menu.get(i).click();
			
		}
		//css selector -> tag#id.class
		((JavascriptExecutor)driver).executeScript("window.scrollBy(250,0);");
		driver.findElement(By.cssSelector("li#item-0.btn btn-light active")).click();
		//xpath -> with contains attribute placeholder
		driver.findElement(By.xpath("//input[contains(@placeholder,\"Full Name\")]")).sendKeys(cus.Getname());
		driver.findElement(By.xpath("//input[contains(@placeholder,\"name@example.com\")]")).sendKeys(cus.Getemail());
		driver.findElement(By.xpath("//div/textarea[contains(@placeholder,\"Current Address\")]")).sendKeys(cus.Getaddress());
		//css -> tag#id
		driver.findElement(By.cssSelector("textarea#permanentAddress")).sendKeys(cus.Getaddress());
		// linked text Anchor
		driver.findElement(By.linkText("Submit")).click();
		//css -> #id
		String Verifyname=driver.findElement(By.cssSelector("#name")).getText();
		String Verifyemail=driver.findElement(By.cssSelector("#email")).getText();
		String Verifyaddress=driver.findElement(By.cssSelector("#permanentAddress.mb-1")).getText();
		if(cus.Getname().equals(Verifyname)) {
			if(cus.Getemail().equals(Verifyemail)) {
				if(cus.Getaddress().equals(Verifyaddress)) {
					System.out.printf("Details are : " ,Verifyname ,Verifyemail,Verifyaddress);
				}
				else {
					System.out.println("Address or name or email mismatch");
					}
				
				}
			
		}
	}
}
