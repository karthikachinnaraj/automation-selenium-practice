import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {
    public static void main(String[] args) {

        FileInputStream file=new FileInputStream("D:\Programming\myproject-git\Testdata-saucedemo.xlsx");
        Workbook workbook= WorkbookFactory.create(file);
        Sheet sheet=workbook.getSheet("Sheet1");
        int row-count=sheet.getPhysicalNumberOfRows();
        int col-count=sheet.getRow(0).getLastCellNum();
        Object[] data=[row-count-1][col-count];
        for(int i=1;i<row-count;i++) {
        	Row row=sheet.getRow(i);
        	for(int j=0;j<col-count;j++) {
        		Cell cell=sheet.getRow(i).getCell(j);
        		System.out.println(cell);
        	}
        }
    }
}
