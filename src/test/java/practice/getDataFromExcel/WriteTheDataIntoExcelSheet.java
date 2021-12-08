package practice.getDataFromExcel;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class WriteTheDataIntoExcelSheet
{
	@Test
	public void writeDataToExcelSheet() throws Throwable
	{

		FileInputStream file = new FileInputStream("./data/Book1.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet("Sheet1");
		Row row = sheet.createRow(6);
		Cell cell = row.createCell(0);
		cell.setCellValue("Infosys");

		FileOutputStream fout = new FileOutputStream("./data/Book1.xlsx");
		workbook.write(fout);
		workbook.close();
	}
}
