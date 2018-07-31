/**
 *  * @author Priya Verma
 */
package pages.Navision;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ui.utility.DriverWaits;
import ui.utility.FactoryHelper;
import ui.utility.WebServicesHelper;

public class NavCustomer {
	protected static final Logger LOGGER = LoggerFactory.getLogger(NavCustomer.class);
	private static NavCustomer NavCustomerSingleInstance = null;
	private static WebServicesHelper navhelper = WebServicesHelper.getInstance();
	private static FactoryHelper helper = FactoryHelper.getInstance();
	private static DriverWaits driverWait = DriverWaits.getInstance();
	private static WebDriver driver;
	private static String costCenterFieldXpaths;
	private static String addressFieldXpathsDiv1;
	private static String addressFieldXpathsDiv2;
	private static String dealerSettingXpaths;
	private static String customerFields;
	private static Actions actions;

	private NavCustomer() {
	}

	public NavCustomer(WebDriver driver) {
		NavCustomer.driver = driver;
	}

	public static NavCustomer getInstance() {
		LOGGER.info("Static method to create instance of Singleton class...");
		if (NavCustomerSingleInstance == null)
			NavCustomerSingleInstance = new NavCustomer(driver);
		return NavCustomerSingleInstance;
	}

	@FindBy(xpath = "//a[text()='Customers']")
	WebElement LeftCustomerTab;
	@FindBy(xpath = "//th[@abbr='No.']//div[@class='ms-nav-grid-columncaption-ctxmenuarrow']")
	WebElement filterDropDown;
	@FindBy(xpath = "//span[@class='ms-nav-ctxmenu-title'][contains(text(),'Filter...')]")
	WebElement selectFilterToSearchCustomer;
	@FindBy(xpath = "//div[@class='edit-container ms-nav-editcontrol-nocaption ms-nav-editcontrolandonebuttoncontainer']/input")
	WebElement customerIDPopUp;
	@FindBy(xpath = "//span[contains(text(),'OK')]")
	WebElement clickOk;
	@FindBy(xpath = "//table[@summary='Customer List']/tbody/tr/td[3]/a")
	WebElement openCustomerProfile;
	@FindBy(xpath = "//div[@class='dialog-system-actions']//div[@tabindex='0']")
	WebElement customerCardCloseLink;
	@FindBy(xpath = "//*[@id='product-menu-bar']/div[3]/a")
	WebElement dealerProfileButton;
	@FindBy(xpath = "//span[@class='ms-nav-ctxmenu-title'][contains(text(),'Sign out')]")
	WebElement dealerSignOutLink;
	@FindBy(xpath = "//*[@id='ctl00_PHM_SignInAgainLink']")
	WebElement singInAgain;
	@FindBy(xpath = "//div[5]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[contains(@title,'Home')]/a")
	WebElement homeTab;
	@FindBy(xpath = "//div[@class='spa-view spa-normal slide-fadein animate no-animations shown']/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[3][contains(@title,'Navigate')]/a")
	WebElement navigateTab;
	@FindBy(xpath = "//span[contains(text(),'Cost')]")
	WebElement costCenterLink;
	@FindBy(xpath = "//img[contains(@src,'1033_10.0.17501.0_Action_NewDocument_32x32.png')]")
	WebElement addNewCostCenter;
	@FindBy(xpath = "//table[@class='ms-nav-grid ms-nav-grid-edit']//thead//tr//th[@abbr='CustomerID']")
	WebElement filterByCostCenter;
	@FindBy(xpath = "//span[@class='ms-nav-ctxmenu-title'][contains(text(),'Clear Filter')]")
	WebElement clearFilter;
	@FindBy(xpath = "//div[@class='dialog-content ms-nav-scrollable']/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/input[1]")
	WebElement typeCustomerIDCostCenterPopUP;
	@FindBy(xpath = "//a[@draggable='false'][contains(text(),'New')]")
	WebElement createNewCustomerButton;
	@FindBy(xpath = "//input[@type='button']")
	WebElement searchCustomerNo;
	@FindBy(xpath = "//span[@class='ms-nav-ctxmenu-title'][contains(text(),'My Settings')]")
	WebElement dealerMySettingLink;
	@FindBy(xpath = "//span[@class='ms-cui-ctl-mediumlabel'][contains(text(),'Delete')]")
	WebElement deleteCustomerDetailsButton;
	@FindBy(xpath = "//span[@class='ms-nav-columns-caption icon-RightCaret-after'][contains(text(),'Invoicing')]")
	WebElement invoiceDownArrow;
	@FindBy(xpath = "//table[@summary='Customer List']/tbody/tr")
	WebElement customerTableRows;
	@FindBy(xpath = "//span[@class='ms-cui-ctl-largelabel'][contains(text(),'Edit')]")
	WebElement editCustomerDetailsButton;
	@FindBy(xpath = "//div[@class='ms-nav-cardform part-autoheight-lastChild ms-nav-noCommandBar']/div[1]/div[1]/div[1]/div[3]/div[1]/input[1]")
	WebElement dealerDateSettings;
	@FindBy(xpath = "//div[@class='ms-nav-cardform part-autoheight-lastChild']/div[4]/div[1]/div[1]")
	WebElement showMorePaymentFieldLink;
	@FindBy(xpath = "//div[@class='ms-nav-cardform part-autoheight-lastChild ms-nav-noCommandBar']/div[1]/div[1]/div[1]/div[3]/div[1]/input[2]")
	WebElement dealerDatePickerSetting;
	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div[2]/button[2]")
	WebElement okDatePicker;
	@FindBy(xpath = "//div[@class='ms-nav-minimal-content-innerContent']")
	WebElement afterSignOutPageContent;
	@FindBy(xpath = "//span[contains(text(),'Yes')]")
	WebElement deleteOKButton;
	@FindBy(xpath = "//span[@class='ms-nav-columns-caption icon-RightCaret-after'][contains(text(),'Payments')]")
	WebElement paymnetDownArrow;
	@FindBy(xpath = "//span[@class='ms-nav-columns-caption icon-RightCaret-after'][contains(text(),'Shipping')]")
	WebElement shippingDownArrow;
	@FindBy(xpath = "//a[@title='Customers']")
	WebElement Customerstab;
	@FindBy(xpath = "(//span[@class='ms-cui-tt-span'][contains(text(),'Home')])[1]")
	WebElement enablehomebtn;
	@FindBy(xpath = "//a[.='No.']")
	WebElement NoDroprdown;
	@FindBy(xpath = "//span[.='Filter...']")
	WebElement FilterDropdown;
	@FindBy(xpath = "(//div[@class='edit-container ms-nav-editcontrol-nocaption ms-nav-editcontrolandonebuttoncontainer']//input)[1]")
	WebElement EnterCustomerNo;
	@FindBy(xpath = "//span[.='OK']")
	WebElement OkButton;
	@FindBy(xpath = "//table[@summary='Customer List']/tbody/tr/td[3]/a")
	WebElement OpenCustomerRecord;
	@FindBy(xpath = "((//div[@class='multiple-columns-group'])[1]//input)[1]")
	WebElement searchCustomerNo_CustProfile;
	@FindBy(xpath = "((//div[@class='multiple-columns-group'])[1]//input)[3]")
	WebElement searchCustomerName_CustProfile;
	@FindBy(xpath = "//span[text()='Ship-to']")
	WebElement ShiptoAddrees;
	@FindBy(xpath = "(//span[@class='ms-cui-tt-span'][contains(text(),'Home')])[2]")
	WebElement enablehomebtn_shiptoadd;
	@FindBy(xpath = "(//a[text()='New'])[2]")
	WebElement newbutton_shiptoadd;
	@FindBy(xpath = "(//a[text()='Name'and @class='ms-nav-edit-control-caption'])[2]/following-sibling::div/input")
	WebElement getNamevalue_shiptoadd;
	@FindBy(xpath = "(//div[@class='dialog-system-actions'])[3]")
	WebElement closebutton_new_shiptoadd;
	@FindBy(xpath = "(//a[text()='Code'and @class='ms-nav-edit-control-caption'])[2]/following-sibling::div/input")
	WebElement EnterCode_shiptoadd;
	@FindBy(xpath = "(//div[@class='dialog-system-actions'])[3]")
	WebElement closebutton_edit_shiptoadd;
	@FindBy(xpath = "(//span[text()='Edit'])[3]")
	WebElement editbutton_shiptoadd;
	@FindBy(xpath = "(//a[text()='Name'and @class='ms-nav-edit-control-caption'])[2]/following-sibling::div/input")
	WebElement UpdateName_edit_shiptoadd;
	@FindBy(xpath = "(//span[text()='Delete'])[3]")
	WebElement deletebutton_shiptoadd;
	@FindBy(xpath = "//span[contains(text(),'Yes')]")
	WebElement alert_delete_shiptoadd;
	@FindBy(xpath = "(//a[@class='ms-list-itemLink icon-Magnifier'])[2]")
	WebElement searchbox_shiptoadd;
	@FindBy(xpath = "(//a[@class='ms-list-itemLink icon-Magnifier'])[2]/preceding-sibling::div/input")
	WebElement inputvalue_searchbox_shiptoadd;

	public boolean checkmessage() {
		try {
			driver.findElement(
					By.xpath("(//table[@summary='Ship-to Address List'])[2]/following-sibling::div[2]/span"));
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public void inputValueSearchButton(String data) {
		inputvalue_searchbox_shiptoadd.sendKeys(data);
		driverWait.waitSeconds(1);
	}

	public void clickonSearchButton() {
		searchbox_shiptoadd.click();
		driverWait.waitSeconds(1);
	}

	public void clickonalertDeleteShiptoadd() {
		actions = new Actions(driver);
		actions.moveToElement(alert_delete_shiptoadd);
		actions.click(alert_delete_shiptoadd).build().perform();
		driverWait.waitSeconds(1);
	}

	public void clickondeleteShiptoAdd() {
		deletebutton_shiptoadd.click();
		driverWait.waitSeconds(1);
	}

	public String UpdatenameNewShiptoadd(String data) {
		UpdateName_edit_shiptoadd.clear();
		UpdateName_edit_shiptoadd.sendKeys(data);
		return data;
	}

	public void clickonEditShiptoAdd() {
		editbutton_shiptoadd.click();
		driverWait.waitSeconds(1);
	}

	public void closebutton_edit_shiptoadd() {
		actions = new Actions(driver);
		actions.moveToElement(closebutton_edit_shiptoadd);
		actions.click(closebutton_edit_shiptoadd).build().perform();
	}

	/**
	 * This method return value of Code from Ship To Address Page
	 * 
	 * @return Codevalue
	 */
	public String getCodevalue_new_shiptoadd() {
		String Codevalue = EnterCode_shiptoadd.getAttribute("value");
		driverWait.waitSeconds(3);
		return Codevalue;
	}

	public String Entercode_new_shiptoadd(String setText) {
		EnterCode_shiptoadd.sendKeys(setText);
		driverWait.waitSeconds(3);
		return setText;
	}

	public void closebuttonNewShiptoadd() {
		actions = new Actions(driver);
		actions.moveToElement(closebutton_new_shiptoadd);
		actions.click(closebutton_new_shiptoadd).build().perform();
	}

	/**
	 * This method return value of Name from Ship To Address Page
	 * 
	 * @return Namevalue
	 */
	public String getNamevalueNewShiptoadd() {
		String Namevalue = getNamevalue_shiptoadd.getAttribute("value");
		return Namevalue;
	}

	public void addNewShiptoadd() {
		newbutton_shiptoadd.click();
		driverWait.waitSeconds(1);
	}

	/**
	 * This method clicks on Home button after landing to Ship To Address page
	 */
	public void clickonHomebuttonShiptoadd() {
		actions = new Actions(driver);
		actions.moveToElement(enablehomebtn_shiptoadd);
		actions.click(enablehomebtn_shiptoadd).build().perform();
		driverWait.waitSeconds(3);
	}

	/*
	 * This method clicks on the specific Customer Record no and open the
	 * results for that Customer
	 */
	public void clickonShiptoAddtab() {
		ShiptoAddrees.click();
		driverWait.waitSeconds(1);
	}

	/**
	 * This method return value of Customer name from Customer Page
	 * 
	 * @return customername
	 */
	public String getCustomerNames() {
		return searchCustomerName_CustProfile.getAttribute("value");
	}

	/**
	 * This method return value of Customer number from Customer Page
	 * 
	 * @return customerno
	 */
	public String getCustomerNo() {
		return searchCustomerNo_CustProfile.getAttribute("value");
	}

	public void clickonCustomerRecordNo() {
		OpenCustomerRecord.click();
		driverWait.waitSeconds(1);
	}

	public void clickonOkbutton() {
		OkButton.click();
		driverWait.waitSeconds(1);
	}

	public void enterCustomerNumber(String data) {
		EnterCustomerNo.sendKeys(data);
		driverWait.waitSeconds(1);
	}

	public void clickonFilter() {
		FilterDropdown.click();
		driverWait.waitSeconds(1);
	}

	public void clickonNoDropdown() {
		actions = new Actions(driver);
		actions.moveToElement(NoDroprdown);
		actions.contextClick(NoDroprdown).build().perform();
	}

	/**
	 * This method clicks on Home button after landing to Customers page
	 */
	public void clickonhomebutton() {
		actions = new Actions(driver);
		actions.moveToElement(enablehomebtn);
		actions.click(enablehomebtn).build().perform();
	}

	public void clickonCustomerstab() {
		Customerstab.click();
		driverWait.waitSeconds(1);
	}

	public void deleteOKButton() {
		helper.click(deleteOKButton);
	}

	public void deleteCustomerDetailsButton() {
		driverWait.waitSeconds(5);
		helper.scrollJS(deleteCustomerDetailsButton, driver);
	}

	public void editCustomerDetailsButton() {
		helper.click(editCustomerDetailsButton);
	}

	public String afterSignOutPageContent() {
		return afterSignOutPageContent.getText();
	}

	public String shippingLocationCode(String setText) {
		helper.scrollJS(shippingDownArrow, driver);
		customerFields = navhelper.xpathBuilder(0, "Shipment");
		driverWait.waitSeconds(3);
		helper.sendKeysData(customerFields, setText, driver);
		helper.sendKeys(customerFields, driver);
		return setText;
	}

	public String getshippingLocationCode() {
		customerFields = navhelper.xpathBuilder(0, "Shipment");
		driverWait.getWhenVisible(By.xpath(customerFields), 100);
		return helper.getAttribute(customerFields, driver);
	}

	public String shippingCode(String setText) {
		customerFields = navhelper.xpathBuilder(1, "Shipment");
		driverWait.waitSeconds(3);
		helper.sendKeysData(customerFields, setText, driver);
		helper.sendKeys(customerFields, driver);
		return setText;
	}

	public String getShippingCode() {
		customerFields = navhelper.xpathBuilder(1, "Shipment");
		driverWait.getWhenVisible(By.xpath(customerFields), 100);
		return helper.getAttribute(customerFields, driver);
	}

	public String shippingTime(String setText) {
		customerFields = navhelper.xpathBuilder(2, "Shipment");
		helper.sendKeysData(customerFields, setText, driver);
		return setText;
	}

	public String getShippingTime() {
		customerFields = navhelper.xpathBuilder(2, "Shipment");
		driverWait.getWhenVisible(By.xpath(customerFields), 100);
		return helper.getAttribute(customerFields, driver);
	}

	public String prePaymentPercentage(String setText) {
		customerFields = navhelper.xpathBuilder(0, "PaymentBlock");
		helper.scrollJS(paymnetDownArrow, driver);
		driverWait.waitSeconds(1);
		helper.click(showMorePaymentFieldLink);
		driverWait.waitSeconds(1);
		helper.clearInput(customerFields, driver);
		// driverWait.waitSeconds(2);
		helper.sendKeysJS(customerFields, driver, setText);
		helper.sendKeys(customerFields, driver);
		return setText;
	}

	public String getPrePaymentPercentage() {
		customerFields = navhelper.xpathBuilder(0, "PaymentBlock");
		driverWait.getWhenVisible(By.xpath(customerFields), 100);
		return helper.getAttribute(customerFields, driver);
	}

	public String applicationMethod(String setText) {
		customerFields = navhelper.xpathBuilder(2, "PaymentBlock");
		driverWait.waitSeconds(2);
		((JavascriptExecutor) driver).executeScript(
				"var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[1]){ select.options[i].selected = true; } }",
				driver.findElement(By.xpath(customerFields)), setText);
		return setText;
	}

	public String getApplicationMethod() {
		customerFields = navhelper.xpathBuilder(2, "PaymentBlock");
		driverWait.getWhenVisible(By.xpath(customerFields), 100);
		return helper.selectDropDownByOption(customerFields, driver);
	}

	public String partnerType(String setText) {
		customerFields = navhelper.xpathBuilder(3, "PaymentBlock");
		((JavascriptExecutor) driver).executeScript(
				"var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[1]){ select.options[i].selected = true; } }",
				driver.findElement(By.xpath(customerFields)), setText);
		return setText;
	}

	public String getPartnerType() {
		customerFields = navhelper.xpathBuilder(3, "PaymentBlock");
		driverWait.getWhenVisible(By.xpath(customerFields), 100);
		return helper.selectDropDownByOption(customerFields, driver);
	}

	public String paymentTermsCode(String setText) {
		customerFields = navhelper.xpathBuilder(4, "PaymentBlock");
		helper.sendKeysJS(customerFields, driver, setText);
		helper.sendKeys(customerFields, driver);
		return setText;
	}

	public String getPaymentTermsCode() {
		customerFields = navhelper.xpathBuilder(4, "PaymentBlock");
		driverWait.getWhenVisible(By.xpath(customerFields), 100);
		return helper.getAttribute(customerFields, driver);
	}

	public String paymentMethodCode(String setText) {
		customerFields = navhelper.xpathBuilder(5, "PaymentBlock");
		helper.sendKeysJS(customerFields, driver, setText);
		helper.sendKeys(customerFields, driver);
		return setText;
	}

	public String getPaymentMethodCode() {
		customerFields = navhelper.xpathBuilder(5, "PaymentBlock");
		driverWait.getWhenVisible(By.xpath(customerFields), 100);
		return helper.getAttribute(customerFields, driver);
	}

	public String paymentDayCode(String setText) {
		customerFields = navhelper.xpathBuilder(6, "PaymentBlock");
		helper.sendKeysJS(customerFields, driver, setText);
		helper.sendKeys(customerFields, driver);
		return setText;
	}

	public String getPaymentDayCode() {
		customerFields = navhelper.xpathBuilder(6, "PaymentBlock");
		driverWait.getWhenVisible(By.xpath(customerFields), 100);
		return helper.getAttribute(customerFields, driver);
	}

	public String NonPaymtCode(String setText) {
		customerFields = navhelper.xpathBuilder(7, "PaymentBlock");
		helper.sendKeysJS(customerFields, driver, setText);
		helper.sendKeys(customerFields, driver);
		return setText;
	}

	public String getNonPaymtCode() {
		customerFields = navhelper.xpathBuilder(7, "PaymentBlock");
		driverWait.getWhenVisible(By.xpath(customerFields), 100);
		return helper.getAttribute(customerFields, driver);
	}

	public String lastStatementCode(String setText) {
		customerFields = navhelper.xpathBuilder(8, "PaymentBlock");
		helper.sendKeysJS(customerFields, driver, setText);
		helper.sendKeys(customerFields, driver);
		return setText;
	}

	public String getLastStatementCode() {
		customerFields = navhelper.xpathBuilder(8, "PaymentBlock");
		driverWait.getWhenVisible(By.xpath(customerFields), 100);
		return helper.getAttribute(customerFields, driver);
	}

	public String invoiceVATNumber(String setText) {
		helper.scrollJS(invoiceDownArrow, driver);
		customerFields = navhelper.xpathBuilder(0, "InvoiceBlockLeft");
		helper.sendKeysJS(customerFields, driver, setText);
		driverWait.waitSeconds(2);
		return setText;
	}

	public String getInvoiceVATNumber() {
		customerFields = navhelper.xpathBuilder(0, "InvoiceBlockLeft");
		driverWait.getWhenVisible(By.xpath(customerFields), 100);
		return helper.getAttribute(customerFields, driver);
	}

	public String invoiceQteFrom(String setText) {
		customerFields = navhelper.xpathBuilder(1, "InvoiceBlockLeft");
		((JavascriptExecutor) driver).executeScript(
				"var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[1]){ select.options[i].selected = true; } }",
				driver.findElement(By.xpath(customerFields)), setText);
		return setText;
	}

	public String getInvoiceQteFrom() {
		customerFields = navhelper.xpathBuilder(1, "InvoiceBlockLeft");
		driverWait.getWhenVisible(By.xpath(customerFields), 100);
		return helper.selectDropDownByOption(customerFields, driver);
	}

	public String invoiceGenPostingGroup(String setText) {
		customerFields = navhelper.xpathBuilder(0, "InvoiceBlockRight");
		helper.sendKeysJS(customerFields, driver, setText);
		helper.sendKeys(customerFields, driver);
		return setText;
	}

	public String getinvoiceGenPostingGroup() {
		customerFields = navhelper.xpathBuilder(0, "InvoiceBlockRight");
		driverWait.getWhenVisible(By.xpath(customerFields), 100);
		return helper.getAttribute(customerFields, driver);
	}

	public String invoicePriceGroup(String setText) {
		customerFields = navhelper.xpathBuilder(1, "InvoiceBlockRight");
		helper.sendKeysJS(customerFields, driver, setText);
		helper.sendKeys(customerFields, driver);
		return setText;
	}

	public String getInvoicePriceGroup() {
		customerFields = navhelper.xpathBuilder(1, "InvoiceBlockRight");
		driverWait.getWhenVisible(By.xpath(customerFields), 100);
		return helper.getAttribute(customerFields, driver);
	}

	public String invoiceCustomerPostingGroup(String setText) {
		customerFields = navhelper.xpathBuilder(2, "InvoiceBlockRight");
		helper.sendKeysJS(customerFields, driver, setText);
		helper.sendKeys(customerFields, driver);
		return setText;
	}

	public String getInvoiceCustomerPostingGroup() {
		customerFields = navhelper.xpathBuilder(2, "InvoiceBlockRight");
		driverWait.getWhenVisible(By.xpath(customerFields), 100);
		return helper.getAttribute(customerFields, driver);
	}

	public String customerID(String setText) {
		customerFields = navhelper.xpathBuilder(0, "GeneralBlock");
		helper.sendKeysJS(customerFields, driver, setText);
		helper.sendKeys(customerFields, driver);
		return setText;
	}

	public WebElement newCustomerPopUp() {
		return clickOk;
	}

	public WebElement mySettingOk() {
		return clickOk;
	}

	public String dealerRegion() {
		dealerSettingXpaths = navhelper.xpathBuilder(0, "dealerSetting");
		return driver.findElement(By.xpath(dealerSettingXpaths)).getText();
	}

	public String dealerLanguage() {
		dealerSettingXpaths = navhelper.xpathBuilder(1, "dealerSetting");
		return driver.findElement(By.xpath(dealerSettingXpaths)).getText();
	}

	public String dealerTimeZone() {
		dealerSettingXpaths = navhelper.xpathBuilder(2, "dealerSetting");
		return driver.findElement(By.xpath(dealerSettingXpaths)).getText();
	}

	public String dealerDateSettings() {
		driverWait.waitSeconds(1);
		helper.click(dealerDatePickerSetting);
		dealerDateSettings.sendKeys("25-05-2018");
		helper.click(okDatePicker);
		String date = dealerDateSettings.getAttribute("value");
		return date;
	}

	public void dealerMySettingLink() {
		dealerMySettingLink.click();
	}

	public void searchCustomer(String data) {
		searchCustomerNo.sendKeys(data);
	}

	public String customerName(String setText) {
		customerFields = navhelper.xpathBuilder(1, "GeneralBlock");
		driverWait.waitSeconds(2);
		driverWait.getWhenVisible(By.xpath(customerFields), 100);
		helper.sendKeysData(customerFields, setText, driver);
		helper.sendKeys(customerFields, driver);
		return setText;
	}

	public String editCustomerName(String setText) {
		customerFields = navhelper.xpathBuilder(1, "GeneralBlock");
		driverWait.getWhenVisible(By.xpath(customerFields), 100);
		helper.clearInput(customerFields, driver);
		helper.sendKeysJS(customerFields, driver, setText);
		helper.sendKeys(customerFields, driver);
		return setText;
	}

	public String getCustomerName() {
		customerFields = navhelper.xpathBuilder(1, "GeneralBlock");
		driverWait.getWhenVisible(By.xpath(customerFields), 100);
		return helper.getAttribute(customerFields, driver);
	}

	public String customerCreditLimit(String setText) {
		customerFields = navhelper.xpathBuilder(2, "GeneralBlock");
		driverWait.getWhenVisible(By.xpath(customerFields), 100);
		helper.clearInput(customerFields, driver);
		helper.sendKeysJS(customerFields, driver, setText);
		helper.sendKeys(customerFields, driver);
		return setText;
	}

	public String getCreditLimit() {
		customerFields = navhelper.xpathBuilder(2, "GeneralBlock");
		driverWait.getWhenVisible(By.xpath(customerFields), 100);
		return helper.getAttribute(customerFields, driver);
	}

	public String customerBlocked(String setText) {
		customerFields = navhelper.xpathBuilder(3, "GeneralBlock");
		driverWait.getWhenVisible(By.xpath(customerFields), 100);
		helper.selectDropDownByVisibleText(customerFields, driver, setText);
		return setText;
	}

	public String getCustomerBlocked() {
		customerFields = navhelper.xpathBuilder(3, "GeneralBlock");
		driverWait.getWhenVisible(By.xpath(customerFields), 100);
		return helper.selectDropDownByOption(customerFields, driver);
	}

	public void createNewCustomerButton() {
		driverWait.waitSeconds(1);
		helper.scrollJS(createNewCustomerButton, driver);
	}

	public String costCenterCode() {
		costCenterFieldXpaths = navhelper.xpathBuilder(0, "CostCenter");
		driverWait.waitSeconds(1);
		return helper.getAttribute(costCenterFieldXpaths, driver);
	}

	public String costCenterName() {
		costCenterFieldXpaths = navhelper.xpathBuilder(1, "CostCenter");
		driverWait.waitSeconds(1);
		return helper.getAttribute(costCenterFieldXpaths, driver);
	}

	public String costCenterID() {
		costCenterFieldXpaths = navhelper.xpathBuilder(2, "CostCenter");
		driverWait.waitSeconds(1);
		return helper.getAttribute(costCenterFieldXpaths, driver);
	}

	public String costCenterPONumberMask() {
		costCenterFieldXpaths = navhelper.xpathBuilder(3, "CostCenter");
		driverWait.waitSeconds(1);
		return helper.getAttribute(costCenterFieldXpaths, driver);
	}

	public String costCenterBudgetAccess() {
		costCenterFieldXpaths = navhelper.xpathBuilder(4, "CostCenter");
		driverWait.waitSeconds(1);
		return helper.getAttribute(costCenterFieldXpaths, driver);
	}

	public String costCenterAnnualBudget() {
		costCenterFieldXpaths = navhelper.xpathBuilder(5, "CostCenter");
		driverWait.waitSeconds(1);
		return helper.getAttribute(costCenterFieldXpaths, driver);
	}

	public String costCenterMinOrderValue() {
		costCenterFieldXpaths = navhelper.xpathBuilder(6, "CostCenter");
		driverWait.waitSeconds(1);
		return helper.getAttribute(costCenterFieldXpaths, driver);
	}

	public String costCenterActive() {
		costCenterFieldXpaths = navhelper.xpathBuilder(7, "CostCenter");
		driverWait.waitSeconds(1);
		return helper.getAttribute(costCenterFieldXpaths, driver);
	}

	public String costCenterALCCostCentreID() {
		costCenterFieldXpaths = navhelper.xpathBuilder(8, "CostCenter");
		driverWait.waitSeconds(1);
		return helper.getAttribute(costCenterFieldXpaths, driver);
	}

	public String costCenterDeletionDate() {
		costCenterFieldXpaths = navhelper.xpathBuilder(9, "CostCenter");
		driverWait.waitSeconds(1);
		return helper.getAttribute(costCenterFieldXpaths, driver);
	}

	public String costCenterLanguageID() {
		costCenterFieldXpaths = navhelper.xpathBuilder(10, "CostCenter");
		driverWait.waitSeconds(1);
		return helper.getAttribute(costCenterFieldXpaths, driver);
	}

	public String costCenterNameALT() {
		costCenterFieldXpaths = navhelper.xpathBuilder(11, "CostCenter");
		driverWait.waitSeconds(1);
		return helper.getAttribute(costCenterFieldXpaths, driver);
	}

	public String costCenterLanguageIDALT() {
		costCenterFieldXpaths = navhelper.xpathBuilder(12, "CostCenter");
		driverWait.waitSeconds(1);
		return helper.getAttribute(costCenterFieldXpaths, driver);
	}

	public void typeCustomerNoPopUpCostCenter(String setText) {
		helper.sendKeysJS(typeCustomerIDCostCenterPopUP, driver, setText);
		helper.click(clickOk);
	}

	public void filterCostCenter() {
		driverWait.waitSeconds(1);
		helper.scrollJS(filterByCostCenter, driver);
		driverWait.waitSeconds(1);
		helper.click(clearFilter);
		driverWait.waitSeconds(1);
		helper.scrollJS(filterByCostCenter, driver);
		driverWait.waitSeconds(1);
		helper.click(selectFilterToSearchCustomer);
	}

	public void addNewCostCenter() {
		Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				addNewCostCenter);
		if (!ImagePresent) {
			System.out.println("Image not displayed.");
		} else {
			System.out.println("Image displayed.");
			addNewCostCenter.click();
		}
	}

	public void homeTab() {
		helper.scrollJS(homeTab, driver);
	}

	public void costCenterLink() {
		helper.click(costCenterLink);
	}

	public void navigateTab() {
		helper.click(navigateTab);
	}

	public void singInAgain() {
		helper.click(singInAgain);
	}

	public void dealerSignOutLink() {
		driverWait.waitSeconds(1);
		helper.click(dealerSignOutLink);
	}

	public void dealerProfileButton() {
		driverWait.waitSeconds(2);
		helper.scrollJS(dealerProfileButton, driver);
	}

	public void customerCardCloseLink() {
		helper.scrollJS(customerCardCloseLink, driver);
	}

	public String getCustomerID() {
		customerFields = navhelper.xpathBuilder(0, "GeneralBlock");
		return helper.getAttribute(customerFields, driver);
	}

	public String add1() {
		addressFieldXpathsDiv1 = navhelper.xpathBuilder(0, "AddressBlockLeft");
		return helper.getAttribute(addressFieldXpathsDiv1, driver);
	}

	public String add2() {
		addressFieldXpathsDiv1 = navhelper.xpathBuilder(1, "AddressBlockLeft");
		return helper.getAttribute(addressFieldXpathsDiv1, driver);
	}

	public String postCode() {
		addressFieldXpathsDiv1 = navhelper.xpathBuilder(2, "AddressBlockLeft");
		return helper.getAttribute(addressFieldXpathsDiv1, driver);
	}

	public String city() {
		addressFieldXpathsDiv1 = navhelper.xpathBuilder(3, "AddressBlockLeft");
		return helper.getAttribute(addressFieldXpathsDiv1, driver);
	}

	public String countryID() {
		addressFieldXpathsDiv1 = navhelper.xpathBuilder(4, "AddressBlockLeft");
		return helper.getAttribute(addressFieldXpathsDiv1, driver);
	}

	public String phoneNo() {
		addressFieldXpathsDiv2 = navhelper.xpathBuilder(0, "AddressBlockRight");
		return helper.getAttribute(addressFieldXpathsDiv2, driver);
	}

	public String email() {
		addressFieldXpathsDiv2 = navhelper.xpathBuilder(1, "AddressBlockRight");
		return helper.getAttribute(addressFieldXpathsDiv2, driver);
	}

	public void clickCustomerProfile() {
		helper.clickJS(openCustomerProfile, driver);
	}

	public void typeCustomerIDPopUp(String setText) {
		helper.sendKeysJS(customerIDPopUp, driver, setText);
		helper.click(clickOk);
	}

	public void clickFilterToSearchCustomer() {
		helper.scrollJS(selectFilterToSearchCustomer, driver);
	}

	public void clickToFilterDropDown() {
		driverWait.waitSeconds(2);
		helper.scrollJS(filterDropDown, driver);
		helper.performAction(filterDropDown, driver);
	}

	public void clickOnLeftCustomerTab() {
		driverWait.waitSeconds(1);
		helper.scrollJS(LeftCustomerTab, driver);
	}

	public boolean customerTableRows() {
		try {
			driver.findElement(By.xpath("//table[@summary='Customer List']/tbody/tr"));
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public String getApplicationTitle() {
		return driver.getTitle();
	}
}
