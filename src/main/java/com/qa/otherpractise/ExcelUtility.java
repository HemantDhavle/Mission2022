package com.qa.otherpractise;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	private final static String EXCEL_SHEET_PATH ="";
	private Workbook book;
	private Sheet sheet;
	public void getData(String sheetName)
	{
		Object[][] excelData = null;
		try {
			FileInputStream fs = new FileInputStream(EXCEL_SHEET_PATH);
			book = WorkbookFactory.create(fs);
			sheet = book.getSheet(sheetName);
		} catch (InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		excelData = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i = 0;i<sheet.getLastRowNum();i++)
		{
			for(int j = 0;j<sheet.getRow(0).getLastCellNum();j++)
			{
				sheet.getRow(i+1).getCell(j).toString();
			}
		}
		
		
	}

}
