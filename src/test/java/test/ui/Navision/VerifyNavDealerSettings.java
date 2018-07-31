/**
 *  * @author Priya Verma
 */
package test.ui.Navision;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataProvider.ExcelDataProvider;
import factory.DataProviderFactory;
import pages.Navision.NavCustomer;
import test.ui.Base.BaseTest;
import ui.utility.ReportHelper;

public class VerifyNavDealerSettings extends BaseTest {
	protected static final Logger LOGGER = LoggerFactory.getLogger(ReportHelper.class);
	private static NavCustomer navhome = NavCustomer.getInstance();

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
				DataProviderFactory.getConfig().getSheetname("dealerCustomerFields"));
	}

	@Test(retryAnalyzer = ui.utility.Retry.class, enabled = false, priority = 0, description = "Verify that dealer is able to see and update his settings")
	/* This Test Script is in hold as defect is not fixed */
	public void editDealerSettings() throws InterruptedException {
		navhome = PageFactory.initElements(driver, NavCustomer.class);
		navhome.dealerProfileButton();
		navhome.dealerMySettingLink();
		navhome.dealerLanguage();
		navhome.dealerDateSettings();
		navhome.dealerRegion();
		navhome.dealerTimeZone();
		navhome.dealerProfileButton();
		navhome.dealerSignOutLink();
		navhome.singInAgain();
	}

	@Test(retryAnalyzer = ui.utility.Retry.class, enabled = true, dataProvider = "getData", priority = 1, description = "Verify that dealer is able to logout from navision application")
	public void navDealerLogout(Hashtable<String, String> data) {
		navhome = PageFactory.initElements(driver, NavCustomer.class);
		navhome.dealerProfileButton();
		navhome.dealerSignOutLink();
		String actualSignOutContent = navhome.afterSignOutPageContent();
		LOGGER.info("Verifying that dealer navigates to SignoutPage after signOut...");
		Assert.assertEquals(actualSignOutContent, data.get("SignOutContent"),
				"Verification Failed: expectedCostCenterFields and actualCostCenterFields are not same.");

	}

}
