package test.ui.Navision;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
//import org.testng.SkipException;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import dataProvider.ExcelDataProvider;
//import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.Navision.NavisionItem;
import test.ui.Base.BaseTest;
import ui.utility.FactoryHelper;
import ui.utility.ReportHelper;
import ui.utility.WebServicesHelper;

public class VerifyDealerItems extends BaseTest {
	protected static final Logger LOGGER = LoggerFactory.getLogger(ReportHelper.class);
	private static final Map<String, String> expectedItemvalues = new HashMap<>();
	private static final Map<String, String> actualItemvalues = new HashMap<>();
	private static NavisionItem homePage=NavisionItem.getInstance();
	private static FactoryHelper navHelper = FactoryHelper.getInstance();

	@DataProvider
	public Object[][] getData() {
		/*
		 * Read multiple sets of data from navision Excel file and will place
		 * the same in dataprovider object array and will pass the same to the
		 * test method as parameters.
		 */
		LOGGER.info("Reading Navision Excel Data...");
		return ExcelDataProvider.takeData(
				DataProviderFactory.getConfig().getWorkbookPath("testdata.navision", "NavData"),
				DataProviderFactory.getConfig().getSheetname("dealerItemFields"));
	}

	/**
	 * This method verify Item values on Items page against csv
	 * 
	 * @param data
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "getData", priority = 0, description = "Verify Itemtab values on Items page against csv")
	public void validateGeneralDetails(Hashtable<String, String> data) throws InterruptedException {
		homePage = PageFactory.initElements(driver, NavisionItem.class);
		String ActualApplicationTitle = homePage.getApplicationTitle();
		String ExpectedApplicationTitle = "Microsoft Dynamics NAV";
		homePage.clickonItemsstab();
		homePage.clickonhomebutton();
		homePage.clickonNoDropdown_Items();
		homePage.clickonFilter_Items();
		homePage.enterItemNumber(data.get("ItemNo"));
		homePage.clickonOkbutton_Item();
		homePage.Item_DealerProductcheck();

		actualItemvalues.put("ItemNo", NavisionItem.getItemNo_value());
		actualItemvalues.put("Description", NavisionItem.getItem_Description_value());
		actualItemvalues.put("Stock", NavisionItem.getItem_Stock_value());
		actualItemvalues.put("DCP", NavisionItem.getItem_DCP_value());

		expectedItemvalues.put("ItemNo", data.get("ItemNo"));
		expectedItemvalues.put("Description", data.get("Description"));
		expectedItemvalues.put("Stock", navHelper.convertFloatToInt(data.get("Stock")));
		expectedItemvalues.put("DCP", navHelper.convertFloatToInt(data.get("DCP")));

		Assert.assertEquals(ActualApplicationTitle, ExpectedApplicationTitle,
				"Verification Failed-- expectedTiltle and actualTitle are not same.");
		LOGGER.info("Verification of ApplicationTitle Test Passed");
		Assert.assertEquals(actualItemvalues, expectedItemvalues,
				"Verification Failed-- expected Item Values and actual Item Values are not same.");
		LOGGER.info("Verfication of Item values against csv Test Passed");
	}

}
