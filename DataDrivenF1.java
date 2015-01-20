package com.webdriver1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.selenium.SeleneseTestCase;

public class DataDrivenF1 extends SeleneseTestCase 
{
	//Declare variables
	public String vLoan, vTerm, vRate, vMonth,vYear,vPtax,vPMI;
	public String vURL1,VURL2;
	public int xRows, xCols;
	public String xData[][];
	@Before
	public void setUp() throws Exception
	{
		String xpath = "";
		xlRead(xpath);
		
	}
	@Test
	public void testMc5()
	{
		String vApp1,vApp2,vResult;//Output variables
		vURL1 = "";
		VURL2 = "";
		for(int i =1; i<xRows; i++)
		{
			if(xData[i][10].equals("Y"))
			{
				myprint("Reading data for Row " + i);
				vLoan=xData[i][0];
				vTerm = xData[i][1];
				vRate = xData[i][2];
				vMonth = xData[i][3];
				vYear = xData[i][4];
				vPtax = xData[i][5];
				vPMI = xData[i][6];
			}
		}
	}
	@After
	public void tearDown()
	{
	String xRPath="";
	xlwrite(xRPath,xData);
	selenium.stop();
	}
	public String app1()
	{
		myprint("Inside the App1 Fun");
		selenium.open(vURL);
		selenium.type("", vLoan);
		selenium.type("", vTerm);
		selenium.type("", vRate);
		selenium.select("", vMonth);
		selenium.select("",vYear);
		selenium.type("", vPMI);
		selenium.click("");
		selenium.waitForPageToLoad("");
		String mc1 = selenium.getText("");
		System.out.println("value from app1 is " + mc1);
		return mc1;	
	}
	public String app2()
	{
		myprint("Inside the App2 Fun");
		selenium.open(VURL2);
		selenium.type("", vLoan);
		selenium.type("", vTerm);
		selenium.type("", vRate);
		selenium.select("", vMonth);
		selenium.select("", vMonth);
		selenium.type("", vPtax);
		selenium.type("", vPMI);
		selenium.click("");
		selenium.waitForPageToLoad("");
		String mc2 = selenium.getText("");
		System.out.println("value from app2 si " + mc2);
	}
	public void xlRead(String sPath) throws Exception
	{
		File myxl = new File(sPath);
		FileInputStream myStream = new FileInputStream(myxl);
		HSSFWorkbook myWB = new HSSFWorkbook(myStream);
		HSSFSheet mySheet = myWB.getSheetAt(1);
		xRows=mySheet.getLastRowNum()+1;
		xCols=mySheet.getRow(0).getLastCellNum();
		myprint("Rows are "+ xRows);
		muprint("Cols are "+xCols);
		xData = new String[xRows][xCols];
		for(int i=0; i<xRows; i++)
		{
			HSSFRow row = mySheet.getRow(i);
			for(int j=0; j<xCols; j++)
			{
				HSSFCell cell = row.getCell(j);
				String value = cellToString(cell);
				value = xData[i][j];
				System.out.println(value);
				System.out.print("@@@@@@@@@@@@@@@@");
				
			}
		}
		public static String cellToString(HSSFCell cell){
			// This function will convert an object of type excel cell to a string value
			int type = cell.getCellType();
			Object result;
			switch(type){
			case HSSFCell.CELL_TYPE_NUMERIC://0
				result = cell.getNumericCellValue();
				break;
			case HSSFCell.CELL_TYPE_STRING://1
				result = cell.getStringCellValue();
				break;
			case HSSFCell.CELL_TYPE_FORMULA://2
				throw new RuntimeException("We can't evaluate formulas in Java");
				break;
			case HSSFCell.CELL_TYPE_BLANK://3
				result = "";
				break;
			case HSSFCell.CELL_TYPE_BOOLEAN://4
				result = cell.getBooleanCellValue();
				break;
			case HSSFCell.CELL_TYPE_ERROR://5
				throw new Exception("This cell has an error");
				default:
					throw new RuntimeException("We don't support this cell type: "+ type);	
			}
			return result.toString();
		}
		public void xlwrite(String slPath, String[][] xldata){
			System.out.println("Inside XL Write");
			File outFile = new File(xlPath);
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet osheet = wb.createSheet("TESTRESULTS");
			//create row at index 0
			for(int myrow = 0; myrow<xRows; myrow++){
				HSSFRow row = osheet.createRow(myrow);
				for(int mycol=0; mycol<xCols; mycol++){
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					//Type some content
					cell.setCellValue(xldara[myrow][mycol]);
					//System.out.print("....."+ xldata[myrow][mycol]);
					}
				FileOutputStream fOut = new FileOutputStream(outfile);
				//write the XL sheet
				wb.write(fOut);
				//Done deal
				fOut.close();
				
			}
			
		
		public void myprint(String mymessage){
			System.out.println(mymessage);
			System.out.println("~~~~~~~~~~~~~~~");
		}
		
			
		}
}

}
