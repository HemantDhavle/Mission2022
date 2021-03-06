package com.leaftaps.qa.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils 
{
	private static final  String INT_EXCEL_SHEET_PATH ="./src/test/resources/testData/int_leaftaps_testdata.xlsx";
	private static final  String QA_EXCEL_SHEET_PATH ="./src/test/resources/testData/qa_leaftaps_testdata.xlsx";
	private static final  String PROD_EXCEL_SHEET_PATH ="./src/test/resources/testData/prod_leaftaps_testdata.xlsx";
	private static  FileInputStream fs;
	private static Workbook book;
	private static Sheet sheet;
	
	
	public static Object[][] getExcelData(String sheetName)
	{
		Object[][] data = null;
		String env = System.getProperty("env");
		try {
			switch (env) {
			case "qa":
				fs = new FileInputStream(QA_EXCEL_SHEET_PATH);
				break;
			case "int":
				fs = new FileInputStream(INT_EXCEL_SHEET_PATH);
			default:
			case "prod":
				fs = new FileInputStream(PROD_EXCEL_SHEET_PATH);
				break;
			}
			book = WorkbookFactory.create(fs); //it is used to read the excel sheet ->this will be return InvalidFormatException
			sheet = book.getSheet(sheetName);
			}
		 catch (FileNotFoundException e1) 
		{
			 e1.printStackTrace();
		}
		catch (InvalidFormatException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		data = new Object[rows][cols];
		for(int i = 0;i<rows;i++)
		{
			for(int j = 0;j<cols;j++)
			{
				data[i][j]= sheet.getRow(i+1).getCell(j).toString();
			}
		
		}

		return data;
		
		
		
	}
	
	
	
	

}
