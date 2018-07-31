package test.ui.Gnoss;

import java.util.HashSet;
import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataProvider.ExcelDataProvider;
import factory.DataProviderFactory;
import pages.Gnoss.GnossHome;
import pages.Gnoss.GnossLogin;
import pages.Gnoss.GnossProducts;
import test.ui.Base.BaseTest;
import ui.utility.ReportHelper;

public class VerifyGnossHomePage extends BaseTest {

	protected static final Logger LOGGER = LoggerFactory.getLogger(ReportHelper.class);
	private static String userName = DataProviderFactory.getConfig().getUsername();
	private static String password = DataProviderFactory.getConfig().getPassword();
	private static GnossLogin gnossLogin = GnossLogin.getInstance();
	private static GnossHome gnossHome = GnossHome.getInstance();
	private static GnossProducts gnossProduct = GnossProducts.getInstance();
	private static HashSet<String> expectedProductDetails = new HashSet<String>();
	private static HashSet<String> actualProductDetails = new HashSet<String>();

	@DataProvider
	public Object[][] getData() {
		return ExcelDataProvider.takeData(
				DataProviderFactory.getConfig().getWorkbookPath("testdata.gnoss", "GnossData"),
				DataProviderFactory.getConfig().getSheetname("GnossExpectedHomePageData"));
	}

	@Test(dataProvider = "getData", description = "Search product with productName, Verify dealer should navigate to Product page")
	public void searchProduct(Hashtable<String, String> data) {
		gnossLogin = PageFactory.initElements(driver, GnossLogin.class);
		gnossHome = PageFactory.initElements(driver, GnossHome.class);
		gnossProduct = PageFactory.initElements(driver, GnossProducts.class);
		gnossLogin.login();
		gnossLogin.enterUserName(userName);
		gnossLogin.enterPass(password);
		gnossLogin.singInButton();
		gnossLogin.languageChangeDropDown();
		gnossLogin.myServicePage();
		gnossLogin.accessGnossLink();
		gnossHome.clickProductSearch(data.get("ProductName"));
		gnossProduct.editPrice(data.get("PriceUpdate"));
		gnossProduct.clickEditProductOK();
		gnossProduct.clickProductLink();
		actualProductDetails.add(gnossProduct.getEditedSellPrice());
		actualProductDetails.add(gnossProduct.getCalculatedMarginPercentage());
		expectedProductDetails.add(data.get("PriceUpdate"));
		expectedProductDetails.add(data.get("Margin"));
		Assert.assertEquals(actualProductDetails, expectedProductDetails,
				"Product Details does not matches to the expected Edited price");
	}

	/**
	 * Test case to verify categories
	 */
	@Test(priority = 1, enabled = true, dataProvider = "getData", description = "Verify: categories")
	public void verifyCategories(Hashtable<String, String> data) throws InterruptedException {
		gnossHome = PageFactory.initElements(driver, GnossHome.class);
		LOGGER.info("Verifying categories");
		gnossHome.clickHomePage();
		String ActualHome = gnossHome.getHome();
		Assert.assertEquals(ActualHome, data.get("ExpectedHome"),
				"Verification passed: expectedHome and actualHome are same.");
		String CategoriesRank = gnossHome.getCategoriesRanking();
		Assert.assertEquals(CategoriesRank, data.get("ExpectedRank"),
				"Verification passed: expectedCategoriesRank and actualCategoriesRank are same.");
		String ActualProducts = gnossHome.getProducts1();
		Assert.assertEquals(ActualProducts, data.get("ExpectedProducts"),
				"Verification passed: expectedProducts and actualProducts are same.");
		String ActualPricingProfile = gnossHome.getPricingProfile();
		Assert.assertEquals(ActualPricingProfile, data.get("ExpectedPricing"),
				"Verification passed: expectedPricingProfile and actualPricingProfile  are same.");

	}

	/**
	 * Test case to verify languages either English or Spanish
	 */
	@Test(priority = 2, enabled = true, dataProvider = "getData", description = "Verify: Languages")
	public void verifyLanguage(Hashtable<String, String> data) throws InterruptedException {
		LOGGER.info("Verifying Language Change");
		String ActualEnglish = gnossHome.getEnglishText();
		Assert.assertEquals(ActualEnglish, data.get("ExpectedEnglish"), "Verification passed:Language is English");
		gnossHome.clickArrowDown();
		gnossHome.clickEspanol();
		String Actualspanish = gnossHome.getSpanishText();
		Assert.assertEquals(Actualspanish, data.get("ExpectedSpanish"), "Verification passed: Language is Spanish");
	}

}
