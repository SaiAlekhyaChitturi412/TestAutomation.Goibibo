package com.qa.utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtility 
{

	public  static Object[][] getData(String Filename,String Sheet) throws IOException
	{
		FileInputStream FileLoc = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\qa\\testdata\\" + Filename + ".xlsx");
		XSSFWorkbook WorkBook = new XSSFWorkbook(FileLoc);
		XSSFSheet sheet = WorkBook.getSheet(Sheet);
		int last = sheet.getLastRowNum();
		XSSFRow row = sheet.getRow(0);
		int column = row.getLastCellNum();
		Object[][] data  = new Object[last][column];
		for(int i=1;i<=last;i++)
		{
			XSSFRow row1 = sheet.getRow(i);
			for(int j=0;j<column;j++)
			{
				String value = row1.getCell(j).toString();
				data[i-1][j] = value;
			}
		}		
		return data;
	}

}
