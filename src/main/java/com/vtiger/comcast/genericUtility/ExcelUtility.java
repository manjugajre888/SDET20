package com.vtiger.comcast.genericUtility;





import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * it is developed using Apache POi libraries which is used to handle excel sheets
 * @author Manju
 *
 */

public class ExcelUtility {
	/**
	 * it is used to read the data from excel based on below arguments 
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return data
	 * @throws Throwable
	 */
	
	public String getDataFromExcel(String sheetName,int rowNum,int celNum) throws Throwable {
	FileInputStream fis=new FileInputStream("./Data/testscriptData8.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		 String data= row.getCell(celNum).getStringCellValue();
		return data;
	}
	/**
	 * it is used to get last row number on specified sheet
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
		
	public int getRowCount(String SheetName) throws Throwable {
		FileInputStream fis1=new FileInputStream("./Data/testscriptData8.xlsx");
		Workbook wb1=WorkbookFactory.create(fis1);
		Sheet sh1 = wb1.getSheet(SheetName);
		wb1.close();
		return sh1.getLastRowNum();
	}
	/**
	 * it is used to write the data to excel based on below arguments
	 * @param SheetName
	 * @param rowNum
	 * @param celNum
	 * @param Data
	 * @throws Throwable
	 * @throws IOException
	 */
		
	public void setDataExcel(String SheetName,int rowNum,int celNum,String Data) throws Throwable {
		FileInputStream fis2=new FileInputStream("./Data/testscriptData8.xlsx");
		Workbook wb=WorkbookFactory.create(fis2);
		Sheet sh = wb.getSheet(SheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.createCell(celNum);
		cel.setCellValue(Data);
		FileOutputStream fos=new FileOutputStream("./Data/testscriptData8.xlsx");
		wb.write(fos);
		wb.close();
	}
}



