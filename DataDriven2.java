package com.webdriver1;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.selenium.SeleneseTestCase;

public class DataDriven2 extends SeleneseTestCase
{
	//declare variables
	public String vIncome, vBudge, vExpense, vDebit, vCredit;
	public int xRows, xCols;
	public String xData[][];
	@Before 
	public void setUp() throws Exception
	{
		String xPath="C:\\Users\\Anwara Begum\\Desktop\\Datasheet3.xls";
		
	}
	@Test
	public void xlRead(String sPath) throws Exception
	{
		File file = new File(sPath);
		FileInputStream fis = new FileInputStream(file);
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet sheet = wb.getSheetAt(1);
		xRows = sheet.getLastRowNum()+1;
		xCols = sheet.getRow(0).getLastCellNum();
		myprint("Rows are "+ xRows);
		myprint("Cols are "+ xCols);
		xData= new String[xRows][xCols];
		for(int i=0; i<xRows; i++)
		{
			HSSFRow row = sheet.getRow(i);
			for(int j=0; j<xCols; j++)
			{
			HSSFCell cell = row.getCell(j);
			String value = cellToString(cell);
			xData[i][j]= value;
			System.out.println("@@@@@@@");
			}
			System.out.println("");
		}
	}
		private String cellToString(HSSFCell cell) 
		{
			//This method will convert an object of type excel cell to a string value
			int type=  cell.getCellType();
			Object result;
			switch(type)
			{
			case HSSFCell.CELL_TYPE_NUMERIC:
				result= cell.getNumericCellValue();
				break;
			case HSSFCell.CELL_TYPE_STRING:
				result= cell.getStringCellValue();
				break;
			case HSSFCell.CELL_TYPE_BOOLEAN:
				result = cell.getBooleanCellValue();
				break;
			case HSSFCell.CELL_TYPE_BLANK:
				result="_";
				break;
			case HSSFCell.CELL_TYPE_ERROR:
				throw new RuntimeException("This cell has an error");
				default:
					throw new RuntimeException("We don't support this cell type: "+type);
				
			}
			return result.toString();

		}	
	public void myprint(String message)
	{
		System.out.println(message);
		System.out.println("~~~~~~~~~~");
	}
}


