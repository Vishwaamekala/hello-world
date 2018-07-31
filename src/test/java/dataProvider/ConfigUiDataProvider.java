package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigUiDataProvider {

	private static Properties pro;
	private static String uiConfigPath = System.getProperty("user.dir")
			+ "\\src\\test\\resourse\\propertyFiles\\config_ui.properties";
	private static String url;
	private static String userName;
	private static String password;
	private static String workbookpath;
	private static String sheetname;

	public ConfigUiDataProvider() {
		try {
			File src = new File(uiConfigPath);
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getApplicationUrl(String appURL) {
		if (appURL.equals("NAVISION")) {
			String navUrl = pro.getProperty("url.navision");
			userName = pro.getProperty("navUsername");
			password = pro.getProperty("navPassword");
			url = "https://" + userName + ":" + password + "@" + navUrl;
		} else if (appURL.equals("GNOSS")) {
			url = pro.getProperty("url.gnoss");
		}
		return url;
	}

	public String getUsername() {
		userName = pro.getProperty("gnossUsername");
		return userName;
	}

	public String getPassword() {
		password = pro.getProperty("gnossPassword");
		return password;
	}

	public String getChromePath() {
		url = pro.getProperty("chromepath");
		return url;
	}

	public String getWorkbookPath(String excelPath, String fileName) {
		if (excelPath.equals("testdata.navision") && fileName.equals("NavData")) {
			workbookpath = pro.getProperty("workbookpath");
			workbookpath = workbookpath.replace("{folderName}", excelPath).replace("{fileName}", fileName);
		} else if (excelPath.equals("testdata.gnoss") && fileName.equals("GnossData")) {
			workbookpath = pro.getProperty("workbookpath");
			workbookpath = workbookpath.replace("{folderName}", excelPath).replace("{fileName}", fileName);
			System.out.println("workbookPath2" + workbookpath);
		} else {
			workbookpath = pro.getProperty("workbookpath");
		}
		return workbookpath;
	}

	public String getSheetname(String sheetName) {
		if (sheetName.equals("dealerInfo")) {
			sheetname = pro.getProperty("sheetname3");
		} else if (sheetName.equals("dealerCustomerFields")) {
			sheetname = pro.getProperty("sheetname1");
		} else if (sheetName.equals("dealerItemFields")) {
			sheetname = pro.getProperty("sheetname2");
		} else if (sheetName.equals("GnossExpectedHomePageData")) {
			sheetname = pro.getProperty("sheetname4");
			System.out.println("SheetNAme+" + sheetname);
		} else {
			sheetname = pro.getProperty("sheetname1");
		}

		return sheetname;
	}
}
