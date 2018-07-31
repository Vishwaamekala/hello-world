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
import pages.Gnoss.GnossHome;
import pages.Gnoss.GnossLogin;
import pages.Gnoss.GnossProducts;
import test.ui.Base.BaseTest;
import ui.utility.DriverWaits;

public class VerifyGnossProductsPage extends BaseTest {

	protected static final Logger LOGGER = LoggerFactory.getLogger(VerifyGnossProductsPage.class);
	private static String userName = DataProviderFactory.getConfig().getUsername();
	private static String password = DataProviderFactory.getConfig().getPassword();
	private static DriverWaits driverWait = DriverWaits.getInstance();
	private static GnossLogin gnossLogin = GnossLogin.getInstance();
	private static GnossProducts gnossProduct = GnossProducts.getInstance();
	private static GnossHome gnossHome = GnossHome.getInstance();
	private static String FilterSelectioncategoriesfacet;
	private static String FilterSelectionbrandfacet;
	private static String FilterSelectionClassificationfacet;

	@DataProvider
	public Object[][] getData() {
		return ExcelDataProvider.takeData(
				DataProviderFactory.getConfig().getWorkbookPath("testdata.gnoss", "GnossData"),
				DataProviderFactory.getConfig().getSheetname("GnossExpectedHomePageData"));
	}

	@Test(dataProvider = "getData", priority = 0, description = "Login GNOSS and navigate th Products page, Verify the AdveoCode facet, Search with the valid AdveoCode and verify the same on the product page")
	public void verifyFacetAdveoCode(Hashtable<String, String> data) {
		gnossLogin = PageFactory.initElements(driver, GnossLogin.class);
		gnossProduct = PageFactory.initElements(driver, GnossProducts.class);
		gnossLogin.login();
		gnossLogin.enterUserName(userName);
		gnossLogin.enterPass(password);
		gnossLogin.singInButton();
		gnossLogin.languageChangeDropDown();
		gnossLogin.myServicePage();
		gnossLogin.accessGnossLink();
		gnossProduct.clickProductsCategory();
		gnossProduct.searchAdveoCode(data.get("AdveoCode"));
		gnossProduct.clickProductLink();
		Assert.assertEquals(gnossProduct.getAdveoCode(), data.get("AdveoCode"),
				"Expected product search result does not match with the actual search result for AdveoCode facet");
	}

	@Test(enabled = true, priority = 1, dataProvider = "getData", description = "Login GNOSS and navigate th Products page, Verify the GTIN facet, Search with the valid GTIN and verify the same on the product page")
	public void verifyFacetGTIN(Hashtable<String, String> data) {
		gnossProduct.backToProductPage();
		gnossProduct.searchGtinNumber(data.get("GTINCode"));
		gnossProduct.clickProductLink();
		Assert.assertEquals(gnossProduct.getGTINNumber(), data.get("GTINCode"),
				"Expected product search result does not match with the actual search result for GTIN facet");
	}

	/**
	 * Test case to verify facet-seller
	 */
	@Test(priority = 1, enabled = true, dataProvider = "getData", description = "Verify: facets-(seller)")
	public void verifyFacetSeller(Hashtable<String, String> data) throws InterruptedException {
		gnossLogin = PageFactory.initElements(driver, GnossLogin.class);
		gnossHome = PageFactory.initElements(driver, GnossHome.class);
		gnossProduct = PageFactory.initElements(driver, GnossProducts.class);
		LOGGER.info("Verifying facet seller");
		gnossHome.clickProducts();
		String ExpectedSeller = gnossProduct.getSellerText();
		// gnossProductsPage.typeSellerName(data.get("ExpectedSeller1"));
		gnossProduct.typeSellerName(ExpectedSeller);
		gnossProduct.clickSearch();
		String Actualpriz24 = gnossProduct.getTextPriz24();
		Assert.assertEquals(Actualpriz24, ExpectedSeller, "Verification passed: Seller selected is priz24");
		gnossProduct.clickCleanUpFilter();
		String Expected = gnossProduct.getSeller1Text();
		gnossProduct.clickAmazon();
		String Actualamazon = gnossProduct.getTextamazon();
		Assert.assertEquals(Actualamazon, data.get("ExpectedSeller2"),
				"Verification passed: Seller selected is amazon");
	}

	/**
	 * Test case to verify facet-product with edited price
	 */
	@Test(priority = 3, enabled = true, dataProvider = "getData", description = "Verify: facets-(products with edited price)")
	public void verifyFacetProductsWithEditedPrice(Hashtable<String, String> data) throws InterruptedException {
		LOGGER.info("Verifying facet product with edited price");
		gnossProduct.clickYes();
		String EditedPriceProduct = gnossProduct.getTextYes();
		Assert.assertEquals(EditedPriceProduct, data.get("ExpectedEditedPriceProduct"),
				"Verification passed: There is product with edited price");
		gnossProduct.clickCleanUpFilter();
		String ExpectedCount = gnossProduct.getExpectedCountofEditedPriceProducts();
		LOGGER.info("Expected count of edited price product" + ExpectedCount);
		// gnossProduct.clickonCountofEditedPriceProducts();
		gnossProduct.clickYes();
		String ActualCount = gnossProduct.getActualCountofEditedPriceProducts();
		LOGGER.info("Actual count of edited price product" + ActualCount);
		Assert.assertEquals(ActualCount, ExpectedCount,
				"Verification passed: Expected and Actual Count of Edited price products are same");

	}

	/**
	 * Test case to verify facet-review rating
	 */
	@Test(priority = 4, enabled = true, dataProvider = "getData", description = "Verify: facets-(review ratings)")
	public void verifyFacetRatings(Hashtable<String, String> data) throws InterruptedException {
		LOGGER.info("Verifying facet review rating");
		gnossProduct.clickCleanUpFilter();
		gnossProduct.clickFiveStarLink();
		String Actual = gnossProduct.getTextFiveStar();
		LOGGER.info("Actual count of stars" + Actual);
		LOGGER.info("Expected count of stars" + data.get("ExpectedStars"));
		Assert.assertEquals(Actual, data.get("ExpectedStars"),
				"Verification passed: Expected and Actual stars are same");

	}

	/**
	 * Test case to verify facet-number of reviews
	 */
	@Test(priority = 4, enabled = true, dataProvider = "getData", description = "Verify: facets-( number of reviews)")
	public void verifyFacetsNumOfReviews(Hashtable<String, String> data) throws InterruptedException {
		LOGGER.info("Verifying facet number of reviews");
		gnossProduct.clickCleanUpFilter();
		LOGGER.info("reviews are  " + gnossProduct.getReview());
		gnossProduct.sendLowerReviewLimit(gnossProduct.firstNum());
		gnossProduct.sendUpperReviewLimit(gnossProduct.secondNum());
		String ExpectedRange = gnossProduct.getReview();
		LOGGER.info(ExpectedRange);
		gnossProduct.clickSearchReview();
		String ActualRange = gnossProduct.getTextRange();
		LOGGER.info(ActualRange);
		Assert.assertEquals(ActualRange, ExpectedRange, "Verification passed: Expected and Actual Reviews are same");

		gnossProduct.clickCleanUpFilter();
		String ExpectedRangeData = gnossProduct.getReview();
		gnossProduct.clickReview();
		String ActualRangeData = gnossProduct.getRangeEightToNine();
		LOGGER.info("Actual range of review" + ActualRangeData);
		LOGGER.info("Expected range of review" + ExpectedRangeData);
		Assert.assertEquals(ActualRangeData, ExpectedRangeData,
				"Verification passed: Expected and Actual Reviews are same");
		gnossProduct.clickCleanUpFilter();

		String ExpectedCount = gnossProduct.getExpectedCountofReviewProduct();
		LOGGER.info("Expected count of review products" + ExpectedCount);
		gnossProduct.clickCountRangeEightToNine();
		String ActualCount = gnossProduct.getActualCountofProductinReview8to9();
		LOGGER.info("Actual count of review products" + ActualCount);
		Assert.assertEquals(ActualCount, ExpectedCount,
				"Verification passed: Expected and Actual count of products in Reviews 8 to 10 are same");

	}

	/**
	 * This method verify Categories, Brand and Classification Facets Details on
	 * Products page
	 * 
	 * @throws InterruptedException
	 */
	@Test(enabled = true, priority = 6, description = "Verify Facets details on Products page ")
	public void verifyProductstab() throws InterruptedException {
		gnossLogin = PageFactory.initElements(driver, GnossLogin.class);
		gnossProduct = PageFactory.initElements(driver, GnossProducts.class);
		gnossProduct.clickonProductstab();
		gnossProduct.clickonOfficeStationeryFacet();
		FilterSelectioncategoriesfacet = gnossProduct.getCategoriesfiltervalue();
		Assert.assertTrue((FilterSelectioncategoriesfacet.contains("Office Stationery")));
		LOGGER.info("Verification of Categories Facet Test Passed");
		gnossProduct.clickonCleanupFilter();
		gnossProduct.clickonBrandFacet();
		FilterSelectionbrandfacet = gnossProduct.getFacetsfiltervalue();
		Assert.assertTrue((FilterSelectionbrandfacet.contains("Herlitz")));
		LOGGER.info("Verification of Brand Facet Test Passed");
		gnossProduct.clickonCleanupFilter();
		driverWait.waitSeconds(2);
		gnossProduct.clickonClassificationFacet();
		FilterSelectionClassificationfacet = gnossProduct.getFacetsfiltervalue();
		Assert.assertTrue((FilterSelectionClassificationfacet.contains("A")));
		gnossProduct.clickonCleanupFilter();
		LOGGER.info("Verification of Classification Facet Test Passed");
	}
}
