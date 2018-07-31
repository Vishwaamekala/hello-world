package test.ui.Gnoss;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataProvider.ExcelDataProvider;
import factory.DataProviderFactory;
import pages.Gnoss.GnossLogin;
import test.ui.Base.BaseTest;
import ui.utility.ReportHelper;

public class VerifyGnossLoginLogout extends BaseTest {

	protected static final Logger LOGGER = LoggerFactory.getLogger(ReportHelper.class);
	private static String userName = DataProviderFactory.getConfig().getUsername();
	private static String password = DataProviderFactory.getConfig().getPassword();
	private static GnossLogin gnossLogin = GnossLogin.getInstance();
	private static String ActualLogoutmessage;
	private static String ExpectedLogoutmessage;

	@DataProvider
	public Object[][] getData() {
		return ExcelDataProvider.takeData(
				DataProviderFactory.getConfig().getWorkbookPath("testdata.gnoss", "GnossData"),
				DataProviderFactory.getConfig().getSheetname("GnossExpectedHomePageData"));
	}

	/**
	 * This method verify the Login to GNOSS application
	 * 
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "getData", description = "Onboard Dealer , Login to GNOSS application and verify the title of the page")
	public void verifyLoginGnoss(Hashtable<String, String> data) {
		gnossLogin = PageFactory.initElements(driver, GnossLogin.class);
		gnossLogin.login();
		gnossLogin.enterUserName(userName);
		gnossLogin.enterPass(password);
		gnossLogin.singInButton();
		gnossLogin.languageChangeDropDown();
		gnossLogin.myServicePage();
		gnossLogin.accessGnossLink();
		Assert.assertEquals(gnossLogin.getGnossPageTitle(), data.get("PageTitleExpected"),
				"Verification Failed: expectedPageTitle and actualPageTitle are not same.");
	}

	/**
	 * This method verify the Logout to GNOSS
	 * 
	 * @throws InterruptedException
	 */
	@Test(enabled = true, priority = 0, description = "Logout from GNOSS application and verify logout message")
	public void verifyLogoutGnoss() throws InterruptedException {
		gnossLogin.HandleWindow();
		gnossLogin.clickLogoutProfile();
		gnossLogin.clickDisconnectIcon();
		LOGGER.info("Logged Out from GNOSS Application");
		ActualLogoutmessage = "You signed out of your account";
		ExpectedLogoutmessage = gnossLogin.getLogoutMessage();
		Assert.assertEquals(ActualLogoutmessage, ExpectedLogoutmessage,
				"Verification Failed: expectedLogoutmessage and actualLogoutmessage are not same");
		LOGGER.info("Verification of Logout message Test Passed");
	}

}
