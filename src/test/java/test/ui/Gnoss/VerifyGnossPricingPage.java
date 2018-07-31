package test.ui.Gnoss;

import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import factory.DataProviderFactory;
import pages.Gnoss.GnossLogin;
import pages.Gnoss.GnossPricing;
import test.ui.Base.BaseTest;
import ui.utility.ReportHelper;
import ui.utility.DriverWaits;

public class VerifyGnossPricingPage extends BaseTest {

	protected static final Logger LOGGER = LoggerFactory.getLogger(ReportHelper.class);
	private static String userName = DataProviderFactory.getConfig().getUsername();
	private static String password = DataProviderFactory.getConfig().getPassword();
	DriverWaits driverWait = DriverWaits.getInstance();
	private static GnossLogin gnossLogin=GnossLogin.getInstance();
	private static GnossPricing gnossPricing=GnossPricing.getInstance();
	String ActualTextvalueofBycategorytab;
	String ActualTextvalueofBybrandtab;
	String ActualTextvalueofBysenstivetab;
	String ActualTextvalueofInfotab = "Info";
	String ExpectedTextvalueofBycategorytab;
	String ExpectedTextvalueofBybrandtab;
	String ExpectedTextvalueofBysenstivetab;
	String ExpectedTextvalueofInfotab;

	/**
	 * This method verify Pricing Profile Details
	 * 
	 * @throws InterruptedException
	 */
	@Test(enabled = true, priority = 0, description = "Verify Pricing Profile details ")
	public void verifyPricingProfile() throws InterruptedException {
		gnossLogin = PageFactory.initElements(driver, GnossLogin.class);
		gnossPricing = PageFactory.initElements(driver, GnossPricing.class);
		gnossLogin.login();
		gnossLogin.enterUserName(userName);
		gnossLogin.enterPass(password);
		gnossLogin.singInButton();
		gnossLogin.languageChangeDropDown();
		gnossLogin.myServicePage();
		gnossLogin.accessGnossLink();
		gnossLogin.HandleWindow();
		gnossPricing.clickonPricingProfile();
		gnossPricing.clickonBycategorytab();
		gnossPricing.clickonBybrandtab();
		gnossPricing.clickonBysensitivetab();
		gnossPricing.clickonInfotab();
		gnossPricing.clickonEditButton();
		gnossPricing.clickonPricingRole();
		gnossPricing.clickonSaveButton();
		gnossPricing.clickonPricingProfileTitletag();

		ActualTextvalueofBycategorytab = "By category";
		ActualTextvalueofBybrandtab = "By brand";
		ActualTextvalueofBysenstivetab = "By sensitive";
		ActualTextvalueofInfotab = "Info";
		ExpectedTextvalueofBycategorytab = gnossPricing.getBycategorytabvalue();
		ExpectedTextvalueofBybrandtab = gnossPricing.getBybrandtabvalue();
		ExpectedTextvalueofBysenstivetab = gnossPricing.getBysenstivetabvalue();
		ExpectedTextvalueofInfotab = gnossPricing.getInfotabvalue();

		Assert.assertEquals(ActualTextvalueofBycategorytab, ExpectedTextvalueofBycategorytab,
				"Verification Failed: Expectedtextvalue and Actualtextvalue of ByCategorytab is not matching ");
		LOGGER.info("Verification of Bycategorytab Test Passed");
		driverWait.waitSeconds(1);
		Assert.assertEquals(ActualTextvalueofBybrandtab, ExpectedTextvalueofBybrandtab,
				"Verification Failed: Expectedtextvalue and Actualtextvalue of ByBrandtab is not matching ");
		LOGGER.info("Verification of Bybrandtab Test Passed");
		Assert.assertEquals(ActualTextvalueofBysenstivetab, ExpectedTextvalueofBysenstivetab,
				"Verification Failed: Expectedtextvalue and Actualtextvalue of BySenstivetab is not matching ");
		LOGGER.info("Verification of Bysenstivetab Test Passed");
		Assert.assertEquals(ActualTextvalueofInfotab, ExpectedTextvalueofInfotab,
				"Verification Failed: Expectedtextvalue and Actualtextvalue of Infotab is not matching ");
		LOGGER.info("Verification of Infotab Test Passed");
		driverWait.waitSeconds(1);
		String ValueofPricingAlgorithm = (gnossPricing.getPricingAlgorithmvalue());
		Assert.assertTrue(ValueofPricingAlgorithm.contains("aggressive"));
		LOGGER.info("Verification of PricingAlgorithm Test Passed");
	}
}
