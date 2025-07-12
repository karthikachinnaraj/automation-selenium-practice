package demo.kc.selenium_demo_sauce;




import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.Assert;

import org.testng.annotations.Test;

public class LoginFunctionality extends BaseClass {
	

//	Automate login using valid vcredentials → verify Products page title → print the title.
	@Test
	public void ValidLogin() {
	
		ImplicitlyWait();
		driver.findElement(By.id("user-name")).sendKeys("visual_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		String Title=driver.findElement(By.xpath("//div[@id='header_container']/div[2]/span")).getText();
		Screenshot("ValidLogin");
		if(Title.contains("Products")) {
			System.out.println("Page Title is : "+Title);
	
		}
	}
	
	@Test
	public void InvalidLogin()  {
		ImplicitlyWait();
		
		driver.findElement(By.id("user-name")).sendKeys("user");
		driver.findElement(By.id("password")).sendKeys("secrete");
		driver.findElement(By.id("login-button")).click();
		String ActualError=driver.findElement(By.xpath("//div[@class='error-message-container error']/h3")).getText();
		Screenshot("ValidLogin");
		System.out.println("Error message is : "+ActualError);
		Assert.assertTrue(ActualError.contains("Username and password do not match"),"Expected error message was not shown!");
		
		
	}
	
	@Test
	public void LogOut() {
		
		ImplicitlyWait();
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		WebElement logout=driver.findElement(By.id("react-burger-menu-btn"));
		ExplicitlyWait(logout);
		logout.click();
		Screenshot("Logout");
		driver.findElement(By.id("logout_sidebar_link")).click();
		Screenshot("Logout");
		ImplicitlyWait();
		String Actual=driver.findElement(By.id("login-button")).getAttribute("value");
		Assert.assertEquals(Actual, "Login", "Logout successful");

		
		
	}
		
	
	
	
}
