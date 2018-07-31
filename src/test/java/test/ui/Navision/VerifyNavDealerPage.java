package test.ui.Navision;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataProvider.ExcelDataProvider;
import factory.DataProviderFactory;
import pages.Navision.NavDealerInfoPage;
import test.ui.Base.BaseTest;
import ui.utility.DriverWaits;
import ui.utility.WebServicesHelper;

public class VerifyNavDealerPage extends BaseTest {
	protected static final Logger LOGGER = LoggerFactory.getLogger(VerifyNavDealerPage.class);
	private static NavDealerInfoPage navDealerHomePage = NavDealerInfoPage.getInstance();
	private static WebServicesHelper navHelper = WebServicesHelper.getInstance();
	private static DriverWaits driverWaits = DriverWaits.getInstance();
	public static String s = String.valueOf(navHelper.generatePswd());
	public static String postcode = String.valueOf(navHelper.generatePswd());
	public static String city = String.valueOf(navHelper.generatePswd());
	public static String extra = String.valueOf(navHelper.generatePswd());
	public static Map<String, String> Excel_map = new HashMap<String, String>();
	public static Map<String, String> url_map = new HashMap<String, String>();
	public static Actions Action;
	public static String Full = s + extra;
	public static String FullPostCode = postcode + extra;

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
				DataProviderFactory.getConfig().getSheetname("dealerInfo"));
	}

	/**
	 * Test case to verify General Info Of dealer
	 */
	@Test(priority = 1, enabled = true, dataProvider = "getData", description = "Verify - General Info of Dealer is same as given by CSV")
	public void verifyValidDataFromCSV(Hashtable<String, String> data) throws InterruptedException {

		navDealerHomePage = PageFactory.initElements(driver, NavDealerInfoPage.class);
		LOGGER.info("Verifying general tab of dealer");
		navDealerHomePage.clickonHomeLink();
		navDealerHomePage.isElementLoaded(navDealerHomePage.appSetUplink);
		navDealerHomePage.clickonAppSetUpLink();
		navDealerHomePage.isElementLoaded(navDealerHomePage.ellipsislink);
		navDealerHomePage.clickonEllipsisLink();
		navDealerHomePage.clickonViewLink();

		url_map.put("Name", navDealerHomePage.getDataonNameFiedTextBoxLink());
		url_map.put("Address", navDealerHomePage.getDataonAddressTextBoxLink());
		url_map.put("Address2", navDealerHomePage.getDataonAddress2TextBoxLink());
		url_map.put("Post Code", navDealerHomePage.getDataonPostCodeTextBoxLink());
		url_map.put("City", navDealerHomePage.getDataonCityTextBoxLink());
		url_map.put("Country/RegionCode", navDealerHomePage.getDataonCountryRegionTextBoxLink());
		url_map.put("Country", navDealerHomePage.getDataonCountryTextBoxLink());
		url_map.put("Phone No", navDealerHomePage.getDataonPhoneNoTextBoxLink());
		url_map.put("VAT Registration No.", navDealerHomePage.getDataonVATTextBoxLink());
		url_map.put("Adveo Country", navDealerHomePage.getDataonAdveoCountryTextBoxLink());
		url_map.put("Adveo Dealer Acc. Number", navDealerHomePage.getDataonAdveoIDTextBoxLink());
		url_map.put("eShop Name", navDealerHomePage.getDataoneSHOPTextBoxLink());
		url_map.put("ADVEO Location Code", navDealerHomePage.getDataonLocationCodeTextBoxLink());
		url_map.put("Adveo Vendor No.", navDealerHomePage.getDataonVendorNoTextBoxLink());

		Excel_map.put("Name", data.get("Name"));
		Excel_map.put("Address", data.get("Address"));
		Excel_map.put("Address2", data.get("Address2"));
		Excel_map.put("Post Code", data.get("Post Code"));
		Excel_map.put("City", data.get("City"));
		Excel_map.put("Country/RegionCode", data.get("Country/Region Code"));
		Excel_map.put("Country", data.get("Country"));
		Excel_map.put("Phone No", data.get("Phone No."));
		Excel_map.put("VAT Registration No.", data.get("VAT Registration No."));
		Excel_map.put("Adveo Country", data.get("Adveo Country"));
		Excel_map.put("Adveo Dealer Acc. Number", data.get("Adveo Dealer Acc. Number"));
		Excel_map.put("eShop Name", data.get("eShop Name"));
		Excel_map.put("ADVEO Location Code", data.get("ADVEO Location Code"));
		Excel_map.put("Adveo Vendor No.", data.get("Adveo Vendor No."));
		Assert.assertEquals(url_map, Excel_map,
				"Verification Failed-- expected dealer general info Values and actual Dealer general info Values are not same.");
	}

	/**
	 * Test case to verify Communication fields Of dealer
	 */
	@Test(priority = 2, enabled = true, dataProvider = "getData", description = "Verify Communication fields of dealer w.r.t Navision")
	public void verifyCommunicationFieldsOfDealer(Hashtable<String, String> data) throws InterruptedException {
		navDealerHomePage = PageFactory.initElements(driver, NavDealerInfoPage.class);
		LOGGER.info("Verifying communication tab of dealer");
		driverWaits.waitSeconds(5);

		Assert.assertTrue(navDealerHomePage.getDataonEmailFieldUnderCommunicationTextBoxLink()
				.equalsIgnoreCase(data.get("Email")));
		Assert.assertTrue(navDealerHomePage.getDataonHomePageFieldUnderCommunicationTextBoxLink()
				.equalsIgnoreCase(data.get("HomePage")));

	}

	/**
	 * Test case to verify Creating of new language
	 */
	@Test(priority = 3, enabled = true, description = "Verify - Create a new Language")
	public void verifyCreateNewLanguage() throws InterruptedException {
		navDealerHomePage = PageFactory.initElements(driver, NavDealerInfoPage.class);
		LOGGER.info("Verifying creation of new language");
		navDealerHomePage.isElementLoaded(navDealerHomePage.languageFieldLink);
		navDealerHomePage.clickonLanguageLink();
		navDealerHomePage.isElementLoaded(navDealerHomePage.Homelink);
		navDealerHomePage.clickonHomeLanguageLink();
		navDealerHomePage.clickonAddingnewLanguageLink1();
		navDealerHomePage.isElementLoaded(navDealerHomePage.blankBoxField);
		navDealerHomePage.clickonblankboxLink(s);
		navDealerHomePage.isElementLoaded(navDealerHomePage.closeAndSaveLink);
		navDealerHomePage.saveAndCloseLink();
		navDealerHomePage.clickonLanguageLink1();
		navDealerHomePage.languageSearchLink1();
		navDealerHomePage.sendCodeinextendedSearchBox1(s);
		String actual = navDealerHomePage.searchLink();
		Assert.assertTrue(s.equalsIgnoreCase(actual));
	}

	/**
	 * Test case to verify Editing of new language
	 */
	@Test(priority = 4, enabled = true, description = "Verify - Edit a new Language")
	public void verifyEditNewLanguage() throws InterruptedException {
		navDealerHomePage = PageFactory.initElements(driver, NavDealerInfoPage.class);
		LOGGER.info("Verifying edition of new language");
		String LangcodealreadyinBox = navDealerHomePage.searchLink();
		Full = LangcodealreadyinBox + extra;

		navDealerHomePage.isElementLoaded(navDealerHomePage.searchBoxLink);
		navDealerHomePage.sendExtrainLangCodeForEdit(Full);
		navDealerHomePage.saveAndCloseLink();
		navDealerHomePage.clickonYes();
		navDealerHomePage.saveAndCloseLink();
		navDealerHomePage.clickonLanguageLink1();
		navDealerHomePage.isElementLoaded(navDealerHomePage.searchLink);
		navDealerHomePage.languageSearchLink1();
		navDealerHomePage.isElementLoaded(navDealerHomePage.extendedSearchBox);
		navDealerHomePage.sendCodeinextendedSearchBox1(Full);
		Assert.assertTrue(Full.equalsIgnoreCase(navDealerHomePage.searchLink()));

	}

	/**
	 * Test case to verify Deleting of new language
	 */
	@Test(priority = 5, enabled = true, description = "Verify - Delete a new Language")
	public void verifyDeleteNewLanguage() throws InterruptedException {
		navDealerHomePage = PageFactory.initElements(driver, NavDealerInfoPage.class);
		LOGGER.info("Verifying deletion of new language");
		navDealerHomePage.clickonDeleteLanguageLink();
		navDealerHomePage.clickonYes();
		Assert.assertEquals(navDealerHomePage.searchLink(), "");
		navDealerHomePage.saveAndCloseLink();
		navDealerHomePage.isElementLoaded(navDealerHomePage.postCodeLink);
		navDealerHomePage.clickOnPostCodeLink();
	}

	/**
	 * Test case to verify creation of new PostCode
	 */
	@Test(priority = 6, enabled = true, description = "Verify - Create a new PostCode")
	public void verifyNewPostcode() throws InterruptedException {
		navDealerHomePage = PageFactory.initElements(driver, NavDealerInfoPage.class);
		LOGGER.info("Verifying creation of new postcode");
		driverWaits.waitSeconds(1);
		navDealerHomePage.clickonHomeLanguageLink();
		driverWaits.waitSeconds(1);
		navDealerHomePage.clickonAddingnewLanguageLink();
		navDealerHomePage.sendCodeinFirstbox(postcode);
		navDealerHomePage.sendCodeinSecondbox(city);
		driverWaits.waitSeconds(1);
		navDealerHomePage.saveAndCloseLink();
		navDealerHomePage.clickOnPostCodeLink();
		navDealerHomePage.languageSearchLink1();
		navDealerHomePage.sendCodeinextendedSearchBox1(postcode);
		Assert.assertTrue(postcode.equalsIgnoreCase(navDealerHomePage.searchPostCode()));

	}

	/**
	 * Test case to verify edition of new PostCode
	 */
	@Test(priority = 7, enabled = true, description = "Verify - Edit a new PostCode")
	public void verifyEditNewPostcode() throws InterruptedException {
		navDealerHomePage = PageFactory.initElements(driver, NavDealerInfoPage.class);
		LOGGER.info("Verifying edition of new postcode");
		String postcodealreadyinBox = navDealerHomePage.searchPostCode();
		String FullPostCode = postcodealreadyinBox + extra;
		navDealerHomePage.sendExtrainPostCodeForEdit(FullPostCode);
		navDealerHomePage.saveAndCloseLink();
		navDealerHomePage.clickonYes();
		navDealerHomePage.clickOnPostCodeLink();
		navDealerHomePage.languageSearchLink1();
		navDealerHomePage.sendCodeinextendedSearchBox1(FullPostCode);
		Assert.assertTrue(FullPostCode.equalsIgnoreCase(navDealerHomePage.searchPostCode()));

	}

	/**
	 * Test case to verify deletion of new PostCode
	 */
	@Test(priority = 8, enabled = true, description = "Verify - Delete a new PostCode")
	public void verifyDeleteNewPostcode() throws InterruptedException {
		navDealerHomePage = PageFactory.initElements(driver, NavDealerInfoPage.class);
		LOGGER.info("Verifying deletion of new postcode");
		driverWaits.waitSeconds(1);
		navDealerHomePage.clickonDeleteLanguageLink();
		navDealerHomePage.clickonYes();
		Assert.assertEquals(navDealerHomePage.searchPostCode(), "");
	}
}
