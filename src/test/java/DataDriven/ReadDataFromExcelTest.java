package DataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		FileInputStream fis=new FileInputStream("./Data/testScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		Row row = sh.getRow(1);
		Cell cell = row.getCell(2);
		String data = cell.getStringCellValue();
		System.out.println(data);
		wb.close();
	}

}
