package dataProvider;

import java.util.Hashtable;

import ui.utility.ExcelReader;

public class ExcelDataProvider {
	public static Object[][] takeData(String excelPath, String sheetName) {

		ExcelReader excel = new ExcelReader(excelPath);
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		System.out.println("Rows: " + rows);
		System.out.println("Cols: " + cols);
		Object[][] data = new Object[1][cols - 1];
		Hashtable<String, String> hashTable = null;
		System.out.println("*************************");
		for (int colNum = 1; colNum < cols; colNum++) {
			hashTable = new Hashtable<String, String>();
			for (int rowNum = 1; rowNum <= rows; rowNum++) {
				hashTable.put(excel.getCellData(sheetName, 0, rowNum), excel.getCellData(sheetName, colNum, rowNum));
				data[0][colNum - 1] = hashTable;
			}
		}
		return data;
	}
}
