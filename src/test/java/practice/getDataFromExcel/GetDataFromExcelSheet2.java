package practice.getDataFromExcel;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class GetDataFromExcelSheet2
{
	@Test
	public void getExcelData() throws Throwable
	{
		// Getting diffrent type of data from excel
		FileInputStream fin = new FileInputStream("./data/Book1.xlsx");
		Workbook workbook = WorkbookFactory.create(fin);
		String url = workbook.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		String browser = workbook.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		String username = workbook.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		String password = workbook.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
		double mobileno = workbook.getSheet("Sheet1").getRow(1).getCell(4).getNumericCellValue();
		
		System.out.println(url);
		System.out.println(browser);
		System.out.println(username);
		System.out.println(password);
		System.out.println(mobileno);

	}
}
