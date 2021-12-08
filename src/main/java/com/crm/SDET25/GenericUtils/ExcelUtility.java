package com.crm.SDET25.GenericUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains generic methods for reading and writing data from excel
 * sheet.
 * 
 * @author Dayananda M N
 *
 */
public class ExcelUtility
{
	/**
	 * This method will return string values from excel sheet
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public String getStringExcelData(String sheetName, int rowNum, int cellNum) throws Throwable
	{
		FileInputStream file = new FileInputStream(IpathConstants.EXCEL_PATH);
		Workbook workbook = WorkbookFactory.create(file);
		return workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
	}

	/**
	 * This method will return numeric values from excel sheet
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public double getNumericExcelData(String sheetName, int rowNum, int cellNum) throws Throwable
	{
		FileInputStream file = new FileInputStream(IpathConstants.EXCEL_PATH);
		Workbook workbook = WorkbookFactory.create(file);
		return workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getNumericCellValue();
	}

	/**
	 * This method will return string values from excel sheet
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public String getExcelData(String sheetName, int rowNum, int cellNum) throws Throwable
	{
		FileInputStream file = new FileInputStream(IpathConstants.EXCEL_PATH);
		Workbook workbook = WorkbookFactory.create(file);
		return workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).toString();
	}

	/**
	 * This method will write the data into the excel sheet.
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param valueToWrite
	 * @throws Throwable
	 */
	public void writeDataToExcel(String sheetName, int rowNum, int cellNum, String valueToWrite) throws Throwable
	{
		FileInputStream file = new FileInputStream(IpathConstants.EXCEL_PATH);
		Workbook workbook = WorkbookFactory.create(file);
		workbook.createSheet(sheetName).createRow(rowNum).createCell(cellNum).setCellValue(valueToWrite);

		FileOutputStream file2 = new FileOutputStream(IpathConstants.EXCEL_PATH);
		workbook.write(file2);
	}

	/**
	 * This method will return multiple set of values from excel sheet
	 * 
	 * @return
	 * @throws Throwable
	 */
	public Object[][] getMultipleData() throws Throwable
	{
		FileInputStream fin = new FileInputStream(IpathConstants.EXCEL_PATH2);
		Workbook workbook = WorkbookFactory.create(fin);
		Sheet sheet = workbook.getSheet("Sheet1");

		int rowNum = sheet.getPhysicalNumberOfRows();
		//int rowNum = sheet.getLastRowNum();
		int cellNum = sheet.getRow(0).getLastCellNum();
		System.out.println(rowNum + " " + cellNum);

		Object[][] data = new Object[rowNum][cellNum];

		for (int i = 0; i < rowNum; i++)
		{
			for (int j = 0; j < cellNum; j++)
			{
				data[i][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		return data;
	}
}
