package dataProviders;
import java.io.IOException;

import org.testng.annotations.DataProvider;

import utilities.*;
public class TestDataProvider {

		@DataProvider(name="Exceldata")
		public static Object[][] getExcelReaderData() throws IOException{
			return Utilities.ExcelReader("D:\\Programming\\myproject-git\\Testdata-saucedemo.xlsx", "Sheet1");			
		}
}
