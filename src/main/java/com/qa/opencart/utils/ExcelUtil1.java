package com.qa.opencart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil1 {
	
	private static String TEST_DATA_SHEET = "./src/test/resources/testdata/OpenCartTestData.xlsx";
	private static Workbook book;
	private static Sheet sheet;

	public static Object[][] gettestdata(String sheetName) {
		
		Object[][] data=null;
		try {
			FileInputStream fis = new FileInputStream(TEST_DATA_SHEET);
			try {
				book=WorkbookFactory.create(fis);
				sheet=book.getSheet(sheetName);
				
				
				 data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
				
				for (int i=0;i<sheet.getLastRowNum();i++) {
					for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
						data[i][j]=sheet.getRow(i+1).getCell(j).toString();
					}
				}
			
				
				
				
			} catch (InvalidFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		return data;
		
	}
	
	

}
