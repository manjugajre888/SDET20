package DataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadAllRowDataFromExcelSheetTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis=new FileInputStream("./Data/testScriptData.xlsx");
	    Workbook wb= WorkbookFactory.create(fis);
	    Sheet sh = wb.getSheet("Sheet3");
	    
	    int count = sh.getLastRowNum();
	    
	    for(int i=0;i<count;i++) {
	    	Row row = sh.getRow(i);
	        String firstColData = row.getCell(0).getStringCellValue();
	        String secondColData = row.getCell(1).getStringCellValue();
	        System.out.println(firstColData + "\t" + secondColData);
	    }

	}

}
