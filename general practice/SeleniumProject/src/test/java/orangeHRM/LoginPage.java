/*
 * package orangeHRM;
 * 
 * import java.time.Duration;
 * 
 * import org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.support.ui.ExpectedConditions; import
 * org.openqa.selenium.support.ui.WebDriverWait; import
 * org.testng.annotations.Test;
 * 
 * 
 * public class LoginPage {
 * 
 * @Test public void Login() { System.setProperty("webdriver.chrome.driver",
 * "D:\\Programming\\selenium\\chromedriver-win64\\chromedriver.exe");
 * 
 * WebDriver driver=new ChromeDriver();
 * 
 * driver.get("https://opensource-demo.orangehrmlive.com/");
 * driver.manage().window().maximize(); WebDriverWait wait =new
 * WebDriverWait(driver,Duration.ofSeconds(20));
 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
 * "//input[@name='username']"))).sendKeys("Admin");
 * driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123"
 * ); driver.findElement(By.xpath("//button[@type='submit']")).click();
 * 
 * 
 * WebElement profile =
 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
 * "//p[contains(@class,'oxd-userdropdown-name')]")))
 * 
 * // driver.quit(); }
 * 
 * }
 */

package orangeHRM;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LoginPage {

	@Test
	public void Login() throws IllegalStateException, IOException {
		
		FileInputStream file=new FileInputStream("D:\\Programming\\myproject-git\\Testdata-saucedemo.xlsx\\");
        Workbook workbook= WorkbookFactory.create(file);
        Sheet sheet=workbook.getSheet("Sheet1");
        int row_count=sheet.getPhysicalNumberOfRows();
        int col_count=sheet.getRow(0).getLastCellNum();
        Object[] data=new Object[row_count-1][col_count];
        for(int i=1;i<row_count;i++) {
        	Row row=sheet.getRow(i);
        	for(int j=0;j<col_count;j++) {
        		Cell cell=sheet.getRow(i).getCell(j);
        		System.out.println(cell);
        	}
        }
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "D:\\Programming\\selenium\\chromedriver-win64\\chromedriver.exe");
		 * 
		 * WebDriver driver = new ChromeDriver();
		 * 
		 * driver.get("https://opensource-demo.orangehrmlive.com/");
		 * driver.manage().window().maximize();
		 * 
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		 * 
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))
		 * ).sendKeys("Admin");
		 * driver.findElement(By.name("password")).sendKeys("admin123");
		 * driver.findElement(By.cssSelector("button[type='submit']")).click();
		 * 
		 * WebElement profile = wait.until(ExpectedConditions
		 * .visibilityOfElementLocated(By.xpath(
		 * "//p[contains(@class,'oxd-userdropdown-name')]")));
		 * System.out.println("Logged in user: " + profile.getText());
		 * 
		 * driver.quit();
		 */

	}
}
