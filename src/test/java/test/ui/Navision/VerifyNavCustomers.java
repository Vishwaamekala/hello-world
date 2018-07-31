/**
 *  * @author Priya Verma
 */
package test.ui.Navision;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

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
import ui.utility.DriverWaits;
import ui.utility.FactoryHelper;
import ui.utility.WebServicesHelper;

public class VerifyNavCustomers extends BaseTest {
	protected static final Logger LOGGER = LoggerFactory.getLogger(VerifyNavCustomers.class);
	private static NavCustomer navhome = NavCustomer.getInstance();
	private static WebServicesHelper Navhelper = WebServicesHelper.getInstance();
	private static FactoryHelper helper = FactoryHelper.getInstance();
	private static DriverWaits driverWait = DriverWaits.getInstance();
	private static final Map<String, String> expectedCustomerFields = new HashMap<>();
	private static final Map<String, String> actualCustomerFields = new HashMap<>();
	private static final Map<String, String> expectedCostCenterFields = new HashMap<>();
	private static final Map<String, String> actualCostCenterFields = new HashMap<>();
	private static final Map<String, String> expectedCreateCustomerCard = new HashMap<>();
	private static final Map<String, String> actualCreateCustomerCard = new HashMap<>();
	private static final Map<String, String> expectedCustomervalues = new HashMap<>();
	private static final Map<String, String> actualCustomervalues = new HashMap<>();
	private static final Map<String, String> expectednewshiptoaddress = new HashMap<>();
	private static final Map<String, String> actualnewshiptoaddress = new HashMap<>();
	private static String customerID;
	private static String expectedCustomerName;
	private static String actualCustomerName;
	private static String getData;
	private static String Actualname_shiptoaddress;
	private static String EditedName_shiptoaddress;
	private static String codevaluefromrandom;

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

	@Test(retryAnalyzer = ui.utility.Retry.class, enabled = true, dataProvider = "getData", priority = 1, description = "Verify Address & Contact section in Customer page against csv after login navision application")
	public void verifyCustomerAddressDeatils(Hashtable<String, String> data) {
		navhome = PageFactory.initElements(driver, NavCustomer.class);
		navhome.clickOnLeftCustomerTab();
		navhome.clickToFilterDropDown();
		navhome.clickFilterToSearchCustomer();
		navhome.typeCustomerIDPopUp(data.get("CustomerID"));
		navhome.clickCustomerProfile();
		expectedCustomerFields.put("Address1", data.get("Address1"));
		expectedCustomerFields.put("Address2", data.get("Address2"));
		expectedCustomerFields.put("PostCode", helper.convertFloatToInt(data.get("PostCode")));
		expectedCustomerFields.put("City", data.get("City"));
		expectedCustomerFields.put("Country", data.get("Country"));
		expectedCustomerFields.put("PhoneNo", data.get("PhoneNo"));
		expectedCustomerFields.put("Email", data.get("Email"));

		actualCustomerFields.put("Address1", navhome.add1());
		actualCustomerFields.put("Address2", navhome.add2());
		actualCustomerFields.put("PostCode", navhome.postCode());
		actualCustomerFields.put("City", navhome.city());
		actualCustomerFields.put("Country", navhome.countryID());
		actualCustomerFields.put("PhoneNo", navhome.phoneNo());
		actualCustomerFields.put("Email", data.get("Email"));
		customerID = navhome.getCustomerID();
		navhome.customerCardCloseLink();
		navhome.dealerProfileButton();
		navhome.dealerSignOutLink();
		navhome.singInAgain();
		LOGGER.info("Verifying of Customer Card Address Fields data matches...");
		Assert.assertEquals(actualCustomerFields, expectedCustomerFields,
				"Verification Failed: expectedCustomerFields and actualCustomerFields are not same.");
	}

	@Test(retryAnalyzer = ui.utility.Retry.class, enabled = true, dataProvider = "getData", priority = 2, description = "Verify dimension values of cost centres against csv fields")
	public void verifyCostCentreFields(Hashtable<String, String> data) throws InterruptedException {
		navhome = PageFactory.initElements(driver, NavCustomer.class);
		navhome.clickOnLeftCustomerTab();
		navhome.clickToFilterDropDown();
		navhome.clickFilterToSearchCustomer();
		navhome.typeCustomerIDPopUp(customerID);
		navhome.clickCustomerProfile();
		navhome.navigateTab();
		navhome.costCenterLink();
		navhome.homeTab();
		navhome.addNewCostCenter();
		navhome.filterCostCenter();
		navhome.typeCustomerNoPopUpCostCenter(customerID);
		expectedCostCenterFields.put("Code", helper.convertFloatToInt(data.get("Code")));
		expectedCostCenterFields.put("Name", data.get("Name"));
		expectedCostCenterFields.put("CostCentreID", helper.convertFloatToInt(data.get("CostCentreID")));
		expectedCostCenterFields.put("PONumberMask", helper.convertFloatToInt(data.get("PONumberMask")));
		expectedCostCenterFields.put("BudgetAccess", helper.convertFloatToInt(data.get("BudgetAccess")));
		expectedCostCenterFields.put("AnnualBudget", helper.leftPadZeros(data.get("AnnualBudget")));
		expectedCostCenterFields.put("MinOrderValue", helper.leftPadZeros(data.get("MinOrderValue")));
		expectedCostCenterFields.put("Active", data.get("Active"));
		expectedCostCenterFields.put("ALCCostCentreID", helper.convertFloatToInt(data.get("ALCCostCentreID")));
		expectedCostCenterFields.put("DeletionDate", helper.convertFloatToInt(data.get("DeletionDate")));
		expectedCostCenterFields.put("LanguageID", helper.convertFloatToInt(data.get("LanguageID")));
		expectedCostCenterFields.put("NameALT", data.get("NameALT"));
		expectedCostCenterFields.put("LanguageIDALT", helper.convertFloatToInt(data.get("LanguageIDALT")));

		actualCostCenterFields.put("Code", navhome.costCenterCode());
		actualCostCenterFields.put("Name", navhome.costCenterName());
		actualCostCenterFields.put("CostCentreID", navhome.costCenterID());
		actualCostCenterFields.put("PONumberMask", navhome.costCenterPONumberMask());
		actualCostCenterFields.put("BudgetAccess", navhome.costCenterBudgetAccess());
		actualCostCenterFields.put("AnnualBudget", navhome.costCenterAnnualBudget());
		actualCostCenterFields.put("MinOrderValue", navhome.costCenterMinOrderValue());
		actualCostCenterFields.put("Active", navhome.costCenterActive());
		actualCostCenterFields.put("ALCCostCentreID", navhome.costCenterALCCostCentreID());
		actualCostCenterFields.put("DeletionDate", navhome.costCenterDeletionDate());
		actualCostCenterFields.put("LanguageID", navhome.costCenterLanguageID());
		actualCostCenterFields.put("NameALT", navhome.costCenterNameALT());
		actualCostCenterFields.put("LanguageIDALT", navhome.costCenterLanguageIDALT());
		navhome.dealerProfileButton();
		navhome.dealerSignOutLink();
		navhome.singInAgain();
		LOGGER.info("Verifying Cost Center Fields data matches with the expected fieldss...");
		Assert.assertEquals(actualCostCenterFields, expectedCostCenterFields,
				"Verification Failed: expectedCostCenterFields and actualCostCenterFields are not same.");
	}

	@Test(retryAnalyzer = ui.utility.Retry.class, enabled = true, dataProvider = "getData", priority = 3, description = "Verify that dealer is able to create new customer")
	public void createCustomerCard(Hashtable<String, String> data, Method method) throws InterruptedException {
		navhome = PageFactory.initElements(driver, NavCustomer.class);
		navhome.clickOnLeftCustomerTab();
		navhome.createNewCustomerButton();
		expectedCreateCustomerCard.put("customerName", navhome.customerName(Navhelper.randomAlphaNumericString()));
		expectedCreateCustomerCard.put("customerCreditLimit", navhome.customerCreditLimit(data.get("LCY")));
		expectedCreateCustomerCard.put("customerBlocked", navhome.customerBlocked(data.get("Blocked")));
		expectedCreateCustomerCard.put("invoiceVATNumber", navhome.invoiceVATNumber(Navhelper.randomNumericString()));
		expectedCreateCustomerCard.put("invoiceQteFrom", navhome.invoiceQteFrom(data.get("QteFrom")));
		expectedCreateCustomerCard.put("invoiceGenPostingGroup",
				navhome.invoiceGenPostingGroup(data.get("GenPostingGroup")));
		expectedCreateCustomerCard.put("invoicePriceGroup", navhome.invoicePriceGroup(data.get("CustomerPriceGroup")));
		expectedCreateCustomerCard.put("invoiceCustomerPostingGroup",
				navhome.invoiceCustomerPostingGroup(data.get("CustomerPostingGroup")));
		getData = helper.convertFloatToInt(data.get("PrepaymentPerc"));
		expectedCreateCustomerCard.put("prePaymentPercentage", navhome.prePaymentPercentage(getData));
		expectedCreateCustomerCard.put("applicationMethod", navhome.applicationMethod(data.get("ApplicationMethod")));
		expectedCreateCustomerCard.put("partnerType", navhome.partnerType(data.get("PartnerType")));
		expectedCreateCustomerCard.put("paymentTermsCode", navhome.paymentTermsCode(data.get("PaymentTermsCode")));
		expectedCreateCustomerCard.put("paymentMethodCode", navhome.paymentMethodCode(data.get("PaymentMethodCode")));
		expectedCreateCustomerCard.put("paymentDayCode", navhome.paymentDayCode(data.get("PaymentDayCode")));
		expectedCreateCustomerCard.put("NonPaymtCode", navhome.NonPaymtCode(data.get("Non-PaymtCode")));
		getData = helper.convertFloatToInt(data.get("LastStatementNo."));
		expectedCreateCustomerCard.put("lastStatementCode", navhome.lastStatementCode(getData));
		expectedCreateCustomerCard.put("shippingLocationCode", navhome.shippingLocationCode(data.get("LocationCode")));
		expectedCreateCustomerCard.put("shippingCode", navhome.shippingCode(data.get("ShipmentCode")));

		actualCreateCustomerCard.put("customerName", navhome.getCustomerName());
		actualCreateCustomerCard.put("customerCreditLimit", navhome.getCreditLimit());
		actualCreateCustomerCard.put("customerBlocked", navhome.getCustomerBlocked());
		actualCreateCustomerCard.put("invoiceVATNumber", navhome.getInvoiceVATNumber());
		actualCreateCustomerCard.put("invoiceQteFrom", navhome.getInvoiceQteFrom());
		actualCreateCustomerCard.put("invoiceGenPostingGroup", navhome.getinvoiceGenPostingGroup());
		actualCreateCustomerCard.put("invoicePriceGroup", navhome.getInvoicePriceGroup());
		actualCreateCustomerCard.put("invoiceCustomerPostingGroup", navhome.getInvoiceCustomerPostingGroup());
		actualCreateCustomerCard.put("prePaymentPercentage", navhome.getPrePaymentPercentage());
		actualCreateCustomerCard.put("applicationMethod", navhome.getApplicationMethod());
		actualCreateCustomerCard.put("partnerType", navhome.getPartnerType());
		actualCreateCustomerCard.put("paymentTermsCode", navhome.getPaymentTermsCode());
		actualCreateCustomerCard.put("paymentMethodCode", navhome.getPaymentMethodCode());
		actualCreateCustomerCard.put("paymentDayCode", navhome.getPaymentDayCode());
		actualCreateCustomerCard.put("NonPaymtCode", navhome.getNonPaymtCode());
		actualCreateCustomerCard.put("lastStatementCode", navhome.getLastStatementCode());
		actualCreateCustomerCard.put("shippingLocationCode", navhome.getshippingLocationCode());
		actualCreateCustomerCard.put("shippingCode", navhome.getShippingCode());
		customerID = navhome.getCustomerID();
		navhome.customerCardCloseLink();
		navhome.dealerProfileButton();
		navhome.dealerSignOutLink();
		navhome.singInAgain();
		LOGGER.info("Verifying if dealer is able to create Customer Card...");
		Assert.assertEquals(actualCreateCustomerCard, expectedCreateCustomerCard,
				"Verification Failed: expectedCostCenterFields and actualCostCenterFields are not same.");
	}

	@Test(retryAnalyzer = ui.utility.Retry.class, enabled = true, priority = 4, description = "Verify that dealer is able to update customer's Name,Address,Invoicing,Payments and shipping details in Customer page after login to Navision application")
	public void updateCustomerCard() throws InterruptedException {
		navhome = PageFactory.initElements(driver, NavCustomer.class);
		navhome.clickOnLeftCustomerTab();
		navhome.clickToFilterDropDown();
		navhome.clickFilterToSearchCustomer();
		navhome.typeCustomerIDPopUp(customerID);
		navhome.clickCustomerProfile();
		expectedCustomerName = navhome.editCustomerName(Navhelper.randomAlphaNumericString());
		actualCustomerName = navhome.getCustomerName();
		navhome.customerCardCloseLink();
		navhome.dealerProfileButton();
		navhome.dealerSignOutLink();
		navhome.singInAgain();
		LOGGER.info("Verifying if dealer is able to update Customer Card fields...");
		Assert.assertEquals(actualCustomerName, expectedCustomerName,
				"Verification Failed: Customer Name is not Edited");
	}

	@Test(retryAnalyzer = ui.utility.Retry.class, enabled = true, priority = 5, description = "Verify that dealer is able to delete customer's Name,Address,Invoicing,Payments and shipping details in Customer page after login to Navision application")
	public void deleteCustomerCard() throws InterruptedException {
		navhome = PageFactory.initElements(driver, NavCustomer.class);
		navhome.clickOnLeftCustomerTab();
		navhome.clickToFilterDropDown();
		navhome.clickFilterToSearchCustomer();
		navhome.typeCustomerIDPopUp(customerID);
		navhome.clickCustomerProfile();
		navhome.deleteCustomerDetailsButton();
		navhome.deleteOKButton();
		navhome.clickToFilterDropDown();
		navhome.clickFilterToSearchCustomer();
		navhome.typeCustomerIDPopUp(customerID);
		navhome.dealerProfileButton();
		navhome.dealerSignOutLink();
		navhome.singInAgain();
		LOGGER.info("Verifying if dealer is able to delete Customer Card...");
		Assert.assertEquals(navhome.customerTableRows(), false, "Verification Failed: Customer Profile is not deleted");

	}

	/**
	 * This method verify CustomerID and CustomerName values on Customer page
	 * against csv after login into nav application
	 * 
	 * @param data
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "getData", priority = 6, description = "Verify CustomerID & CustomerName values on Customer page against csv after login into nav application")
	public void validateGeneralDetails(Hashtable<String, String> data) throws InterruptedException {
		navhome = PageFactory.initElements(driver, NavCustomer.class);
		String ActualApplicationTitle = navhome.getApplicationTitle();
		String ExpectedApplicationTitle = "Microsoft Dynamics NAV";
		Assert.assertEquals(ActualApplicationTitle, ExpectedApplicationTitle,
				"Verification Failed-- expectedTiltle and actualTitle are not same.");
		LOGGER.info("Verification of Application Title Test Passed");
		navhome.clickonCustomerstab();
		navhome.clickonhomebutton();
		navhome.clickonNoDropdown();
		navhome.clickonFilter();
		navhome.enterCustomerNumber(data.get("CustomerID"));
		navhome.clickonOkbutton();
		navhome.clickonCustomerRecordNo();
		expectedCustomervalues.put("CustomerID", data.get("CustomerID"));
		expectedCustomervalues.put("CustomerName", data.get("CustomerName"));
		actualCustomervalues.put("CustomerID", navhome.getCustomerNo());
		actualCustomervalues.put("CustomerName", navhome.getCustomerNames());
		Assert.assertEquals(actualCustomervalues, expectedCustomervalues,
				"Verification Failed-- expected Customer Values and actual Customer Values are not same.");
		driverWait.waitSeconds(3);
		LOGGER.info("Verification of Customer ID and Customer name against csv Test Passed");
	}

	/**
	 * This method adds new shipping address for a customer
	 * 
	 * @param data
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "getData", priority = 7, description = "Verify that dealer is able to add new shiptoaddress ")
	public void addnewShipToAddresDetails(Hashtable<String, String> data) throws InterruptedException {
		navhome.clickonShiptoAddtab();
		navhome.clickonHomebuttonShiptoadd();
		navhome.addNewShiptoadd();
		codevaluefromrandom = navhome.Entercode_new_shiptoadd(Navhelper.randomAlphaNumericString());
		String namevalue = navhome.getNamevalueNewShiptoadd();
		navhome.closebuttonNewShiptoadd();
		actualnewshiptoaddress.put("NameValue", data.get("NameValue"));
		expectednewshiptoaddress.put("NameValue", namevalue);
		Assert.assertEquals(actualnewshiptoaddress, expectednewshiptoaddress,
				"Verification Failed--expected shiptoaddress Values and actual shiptoaddress Values are not same.");
		driverWait.waitSeconds(3);
		LOGGER.info("Verification of addition of new shiiping address Test Passed");
	}

	/**
	 * This method edits the shipping address for a customer
	 * 
	 * @throws InterruptedException
	 */
	@Test(enabled = true, priority = 8, description = "Verify that dealer is able to edit shiptoaddress ")
	public void editShipToAddresDetails() throws InterruptedException {
		navhome.clickonEditShiptoAdd();

		Actualname_shiptoaddress = navhome.getNamevalueNewShiptoadd();
		EditedName_shiptoaddress = navhome.UpdatenameNewShiptoadd(Navhelper.randomAlphaNumericString());
		navhome.closebutton_edit_shiptoadd();
		Assert.assertNotEquals(Actualname_shiptoaddress, EditedName_shiptoaddress,
				"Verification Failed--Name value of ship to address is not edited.");
		driverWait.waitSeconds(3);
		LOGGER.info("Verfication of updating existing shipping address Test Passed");
	}

	/**
	 * This method deletes the shipping address for a customer
	 * 
	 * @throws InterruptedException
	 */
	@Test(enabled = true, priority = 9, description = "Verify that dealer is able to delete shiptoaddress ")
	public void deleteShipToAddresDetails() throws InterruptedException {
		navhome.clickondeleteShiptoAdd();
		navhome.clickonalertDeleteShiptoadd();
		navhome.clickonSearchButton();
		navhome.inputValueSearchButton(codevaluefromrandom);
		Assert.assertEquals(navhome.checkmessage(), false, "Shipping address not deleted please verify");
		LOGGER.info("Verification of deleting shipping address Test Passed");
	}
}
