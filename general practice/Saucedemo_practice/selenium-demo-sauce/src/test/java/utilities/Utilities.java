package utilities;
import baseClass.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {
	public static void Screenshot(WebDriver driver,String testName)  {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			 String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		     String fileName = "D:\\Programming\\java\\general practice\\Saucedemo_snapshot\\" + testName + "_" + timestamp + ".png";
		        
		        FileUtils.copyFile(src, new File(fileName));
		        System.out.println("Screenshot saved: " + fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
		public static void ExplicitlyWait(WebDriver driver,WebElement Element) {
			
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOf(Element));
		}
		
		public static void ImplicitlyWait(WebDriver driver) {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			}
		
		
		 public static Object[][] ExcelReader(String filePath, String sheetName) throws IOException {
			 
			FileInputStream file=new FileInputStream(filePath);
			Workbook workbook =  WorkbookFactory.create(file);
			Sheet sheet=workbook.getSheet(sheetName);
			int row_count=sheet.getPhysicalNumberOfRows();
			int col_count=sheet.getRow(0).getLastCellNum();
			Object[][] data= new Object[row_count-1][col_count];
			for(int i=1;i<row_count;i++) {
				Row row=sheet.getRow(i);
				for(int j=0;j<col_count;j++) {
					Cell cell=row.getCell(j);
					(data[i-1][j])=(cell==null)?"":cell.toString();
				}
			}
		 workbook.close();
		 file.close();
		return data;
			 
		}
}
