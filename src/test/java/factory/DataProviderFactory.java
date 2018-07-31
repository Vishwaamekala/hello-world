package factory;

import dataProvider.ConfigUiDataProvider;
import dataProvider.ExcelDataProvider_old;

public class DataProviderFactory {

	public static ConfigUiDataProvider getConfig() {
		ConfigUiDataProvider config = new ConfigUiDataProvider();
		return config;
	}

	public static ExcelDataProvider_old getExcel(String excelName) {
		ExcelDataProvider_old excel = new ExcelDataProvider_old(excelName);
		return excel;

	}

}
