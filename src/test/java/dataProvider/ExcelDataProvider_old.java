package dataProvider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider_old {

	private static XSSFWorkbook wb;
	private static File src;
	private static FileInputStream fis;
	private static String data;

	public ExcelDataProvider_old(String excelName)
	{
		try {
			if (excelName.contains("ApiData")) {
				src = new File("./ApplicationTestData/ApiData.xlsx");
				fis = new FileInputStream(src);
				wb = new XSSFWorkbook(fis);
			} else if (excelName.contains("AppData")) {
				src = new File("./ApplicationTestData/AppData.xlsx");
				fis = new FileInputStream(src);
				wb = new XSSFWorkbook(fis);
			} else {
				System.out.println("File does not exist");
			}

		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getData(int sheetIndex, int row, int column) {
		data = wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
		return data;

	}

	public String getData(String sheetName, int row, int column) {
		data = wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		return data;

	}
}
