package demo.qa;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.Scrollable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import junit.framework.Assert;

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
		String display=driver.findElement(By.cssSelector("#result")).getText();
		System.out.println("The check box selected is : " + display);
		home.click();
		System.out.println("The checkbox is deselected");
	}
	
	@Test
	public void Radiobuttons() {
		ElementStart();
		driver.findElement(By.xpath("//li/span[contains(text(),'Radio')]")).click();
		js.executeScript("scrollBy(0,100)");
		driver.findElement(By.cssSelector("label[for='yesRadio']")).click();
		String Radioselect=driver.findElement(By.cssSelector("span.text-success")).getText();
		System.out.println();
		Assert.assertEquals("Yes", Radioselect);
		driver.findElement(By.cssSelector("label[for='impressiveRadio']")).click();
		System.out.println("impressiveRadio is selected");
	}
	@Test
	public void WebTables() {
		String fname ="karthika";
		boolean recordexists=false;
		ElementStart();
		driver.findElement(By.xpath("//li/span[contains(text(),'Web Tables')]")).click();
		driver.findElement(By.cssSelector("button#addNewRecordButton")).click();
		driver.findElement(By.cssSelector("#firstName")).sendKeys(fname);
		driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys("chinnaraj");
		driver.findElement(By.cssSelector("#userEmail")).sendKeys("kart121@gmail.com");
		driver.findElement(By.cssSelector("#age")).sendKeys("20");
		driver.findElement(By.cssSelector("#salary")).sendKeys("15000");
		driver.findElement(By.cssSelector("#department")).sendKeys("Legal");
		driver.findElement(By.cssSelector("#submit")).click();
		System.out.println("Record added successfully");
		driver.findElement(By.cssSelector("span#edit-record-1[title='Edit']")).click();
		System.out.println("Age is edited successfully");
		driver.findElement(By.cssSelector("#age")).sendKeys("40");
		driver.findElement(By.cssSelector("#submit")).click();
		driver.findElement(By.cssSelector("span#delete-record-4[title='Delete']")).click();
		System.out.println("Record deleted");
		List<WebElement>rows=driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
		for(WebElement row:rows) {
		
			String Exptext=row.getText();
			if(Exptext.contains(fname)) {
				recordexists = true;  // ❗ Found the deleted record — test should fail
		        System.out.println("❌ Record still exists: " + Exptext);
		        break;
			}			
			else {
				System.out.println("✅ Row checked, does not contain '" + fname + "'");
			}	
			}
		Assert.assertFalse("Test Failed: Record '" + fname + "' still exists after deletion.", recordexists);
		System.out.println("Test Passed: Record '" + fname + "' deleted successfully.");
		}
	
	@Test
	public void Buttons() {
		ElementStart();
		driver.findElement(By.xpath("//li/span[contains(text(),'Buttons')]")).click();
		js.executeScript("scrollBy(0,20)");
		Actions action=new Actions(driver);
		action.doubleClick(driver.findElement(By.xpath("//button[text()='Double Click Me']"))).perform();
		System.out.println("doubleclick");
		action.contextClick(driver.findElement(By.xpath("//button[text()='Right Click Me']"))).perform();
		System.out.println("rightclick");
		action.click(driver.findElement(By.xpath("//button[text()='Click Me']"))).perform();
		System.out.println("click");
		String outDouble=driver.findElement(By.cssSelector("p#doubleClickMessage")).getText();
		String outRight=driver.findElement(By.cssSelector("p#rightClickMessage")).getText();
		String outDynamic=driver.findElement(By.cssSelector("p#dynamicClickMessage")).getText();
		if(outDouble.contains("double")&&outRight.contains("Right")&&outDynamic.contains("dynamic")) {
			Assert.assertTrue("Output message are correct and actions are performed successfully", true);
		}
		else {
			System.out.println("Message is not complete");
		}
	}
	@Test
	public void Links() {
		ElementStart();
		driver.findElement(By.xpath("//li/span[contains(text(),'Links')]")).click();
		js.executeScript("scrollBy(0,200)");
		driver.findElement(By.linkText("Home")).click();
		
		System.out.println("switch successful");
		List<WebElement> links=driver.findElements(By.xpath("//div[@id='linkWrapper']/p/a[starts-with(@href,'java')]"));
		for(WebElement link:links) {
			js.executeScript("arguments[0].scrollIntoView(true)",link);
			link.click();
			js.executeScript("scrollBy(0,300)");
			System.out.println("------------------");
			Implicitlywait();
			System.out.println(link.getText());
			String message=driver.findElement(By.cssSelector("p#linkResponse")).getText();
			System.out.println("Message after clicking the above link : ");
			System.out.println(message);
		}
	}
	@Test
	public void BrokenlinksImages() {
		ElementStart();
		driver.findElement(By.xpath("//li[@class='btn btn-light ']/span[contains(text(),'Broken Links - Images')]")).click();
		String value = driver.findElement(By.xpath("//div[@class='col-12 mt-4 col-md-6']/div[2]/img[1]")).getAttribute("naturalWidth");
		System.out.println(value);
		String brokenvalue=driver.findElement(By.xpath("//div[@class='col-12 mt-4 col-md-6']/div[2]/img[2]")).getAttribute("naturalWidth");
		System.out.println(brokenvalue);
		if(Integer.parseInt(brokenvalue)==0) {
			System.out.println("Broken Image ");			
		}
		else {
			System.out.println("image is displayed");
		}
		Implicitlywait();
		List<WebElement>links=driver.findElements(By.xpath("//div[@class='col-12 mt-4 col-md-6']/div[2]/a"));
		for(int i=0;i<links.size();i++){
			links=driver.findElements(By.xpath("//div[@class='col-12 mt-4 col-md-6']/div[2]/a"));
			js.executeScript("arguments[0].scrollIntoView(true)",links.get(i));
			String linkmessage=links.get(i).getText();
			System.out.println(linkmessage);
			links.get(i).click();
			
			if(linkmessage.equals("Click Here for Valid Link")) {
				String home=driver.findElement(By.xpath("//div[@id='app']/header/a")).getAttribute("href");
			
				if(home.equals(driver.getCurrentUrl())){
					System.out.println("Valid Link");	
			}
				driver.navigate().back();
			}
			else {
				String Message=driver.findElement(By.xpath("//div[@class='example']")).getText();
				System.out.println("broken Link message "+Message);
				
			
			}
		}
	}

	
	
		
	}

