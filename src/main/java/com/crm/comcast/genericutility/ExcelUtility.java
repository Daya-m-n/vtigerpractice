package com.crm.comcast.genericutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * It is developed using apache POI libraries , which used to handle microsoft
 * excel sheet.
 * 
 * @author Dayananda M N
 *
 */
public class ExcelUtility
{
	/**
	 * This method is used to read the data from excel based on below arguments.
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws Throwable
	{
		FileInputStream fin = new FileInputStream("./data/TestData.xlsx");
		Workbook workbook = WorkbookFactory.create(fin);
		String data = workbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		workbook.close();
		return data;

	}

	/**
	 * This method is used to get the last row number on specified sheet.
	 * 
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable
	{
		FileInputStream fin = new FileInputStream("./data/TestData.xlsx");
		Workbook workbook = WorkbookFactory.create(fin);
		Sheet sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		return rowCount;
	}

	/**
	 * This method is used to write a data into the specified cell of an excel
	 * sheet.
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @param data
	 * @throws Throwable
	 */
	public void setDataExcel(String sheetName, int rowNum, int celNum, String data) throws Throwable
	{
		FileInputStream fin = new FileInputStream("./data/TestData.xlsx");
		Workbook workbook = WorkbookFactory.create(fin);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.createCell(celNum);
		cell.setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./data/TestData.xlsx");
		workbook.write(fos);
		workbook.close();
	}
}
