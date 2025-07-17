package demo.qa;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.Scrollable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class UIElementTests extends Base {

	
	public void ElementStart() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement elem=driver.findElement(By.xpath("//div[@class='card-body']/h5[contains(text(),'Elements')]"));
		js.executeScript("arguments[0].scrollIntoView(true);",elem);
		elem.click();	
	
	}
	@Test
	public void ElementPractice() {
		Customer cus=new Customer("karthika","asd@gmail.com","chennai");
		ElementStart();	

		//css selector -> tag#id.class
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,0);");
		driver.findElement(By.xpath("//li/span[contains(text(),'Text Box')]")).click();
		//xpath -> with contains attribute placeholder
		driver.findElement(By.xpath("//input[contains(@placeholder,'Full Name')]")).sendKeys(cus.Getname());
		driver.findElement(By.xpath("//input[contains(@placeholder,'name@example.com')]")).sendKeys(cus.Getemail());
		driver.findElement(By.xpath("//div/textarea[contains(@placeholder,'Current Address')]")).sendKeys(cus.Getaddress());
		//css -> tag#id
		driver.findElement(By.cssSelector("textarea#permanentAddress")).sendKeys(cus.Getaddress());
		// linked text Anchor
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		js.executeScript("window.scrollBy(0,350)");
		
		WebElement submit=driver.findElement(By.cssSelector("button#submit"));
		
		submit.click();
		//css -> #id
		String Verifyname=driver.findElement(By.cssSelector("#name")).getText();
		String Verifyemail=driver.findElement(By.cssSelector("#email")).getText();
		String Verifyaddress=driver.findElement(By.cssSelector("#permanentAddress.mb-1")).getText();
		
		if(cus.Getname().equals(Verifyname.replace("Name:", ""))&& cus.Getaddress().equals(Verifyaddress.replace("Permananet Address :", ""))
				&& cus.Getemail().equals(Verifyemail.replace("Email:", ""))) {
			System.out.println("Details are: " + Verifyname + " | " + Verifyemail + " | " + Verifyaddress);
		}
		else {
			
			System.out.println("Address or name or email mismatch");
			}
				
				
			
		}
	@Test
	public void CheckboxPractice() {
		ElementStart();
		driver.findElement(By.xpath("//li/span[contains(text(),'Check Box')]")).click();
		js.executeScript("scrollBy(0,250)");
		driver.findElement(By.xpath("//span[@class='rct-text']/button")).click();
		WebElement home=driver.findElement(By.cssSelector("span.rct-checkbox"));
		home.click();
		System.out.println(home+ " is selected ");
		home.clear();		
		
		
		
	}
}
