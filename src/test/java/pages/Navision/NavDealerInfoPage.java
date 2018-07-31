package pages.Navision;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ui.utility.DriverWaits;

public class NavDealerInfoPage {
	protected static final Logger LOGGER = LoggerFactory.getLogger(NavDealerInfoPage.class);
	private static NavDealerInfoPage NavDealerInfoPageSingleInstance = null;
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Actions Action;
	public static Map<String, String> url_map;
	private static DriverWaits driverWait = DriverWaits.getInstance();
	private static JavascriptExecutor jse;

	private NavDealerInfoPage() {
	}

	public NavDealerInfoPage(WebDriver driver) {
		NavDealerInfoPage.driver = driver;
	}

	public static NavDealerInfoPage getInstance() {
		LOGGER.info("Static method to create instance of Singleton class...");
		if (NavDealerInfoPageSingleInstance == null)
			NavDealerInfoPageSingleInstance = new NavDealerInfoPage(driver);
		return NavDealerInfoPageSingleInstance;
	}

	@FindBy(xpath = "//span[@class='current-tab-caption']")
	public WebElement homelink;
	@FindBy(xpath = "//span[@class='activity-btn__caption'][contains(text(),'App Setup')]")
	public WebElement appSetUplink;
	@FindBy(xpath = "//table[@summary='Dealer information']/tbody/tr/td[4]/a")
	public WebElement ellipsislink;
	@FindBy(xpath = "//html//div[@class='ms-nav-ctxmenu-container']//li[1]/a[1]")
	public WebElement viewlink;

	/**************************** Dealer_General_Tab *******************************/

	@FindBy(xpath = "/html/body/div[2]/div[4]/form[@id='aspnetForm']/div[4]/div[1]/div[3]/div/div[1]/div[2]/div/div[1]/div/span[@class='stringcontrol-read']")
	public WebElement nameFieldTestBoxlink;
	@FindBy(xpath = "//form[@id='aspnetForm']/div[4]/div[1]/div[3]/div/div[1]/div[2]/div/div[2]/div/span[@class='stringcontrol-read']")
	public WebElement addressFieldTestBoxLink;
	@FindBy(xpath = "//form[@id='aspnetForm']/div[4]/div[1]/div[3]/div/div[1]/div[2]/div/div[3]/div/span[1]")
	public WebElement address2FieldTestBoxLink;
	@FindBy(xpath = "//form[@id='aspnetForm']/div[4]/div[1]/div[3]/div/div[1]/div[2]/div/div[4]/div/span")
	public WebElement postCodeFieldTestBoxLink;
	@FindBy(xpath = "//form[@id='aspnetForm']/div[4]/div[1]/div[3]/div/div[1]/div[2]/div/div[5]/div/span")
	public WebElement cityTestBoxLink;
	@FindBy(xpath = "//form[@id='aspnetForm']/div[4]/div[1]/div[3]/div/div[1]/div[2]/div/div[6]/div/span")
	public WebElement countryRegionCodeTestBoxLink;
	@FindBy(xpath = "//form[@id='aspnetForm']/div[4]/div[1]/div[3]/div/div[1]/div[2]/div/div[7]/div/span")
	public WebElement countryTestBoxLink;
	@FindBy(xpath = "//form[@id='aspnetForm']/div[4]/div[1]/div[3]/div/div[1]/div[2]/div/div[8]/div/a[@title='Dial phone number']")
	public WebElement phoneNumberTestBoxLink;
	@FindBy(xpath = "//form[@id='aspnetForm']/div[4]/div[1]/div[3]/div/div[1]/div[2]/div/div[9]/div/span")
	public WebElement vatRegistrationNumTestBoxLink;
	@FindBy(xpath = "//form[@id='aspnetForm']/div[4]/div[1]/div[3]/div/div[1]/div[2]/div/div[10]/div/span")
	public WebElement adveoCountryTestBoxLink;
	@FindBy(xpath = "//form[@id='aspnetForm']/div[4]/div[1]/div[3]/div/div[1]/div[2]/div/div[11]/div/span")
	public WebElement adveoDealerIDTestBoxLink;
	@FindBy(xpath = "//form[@id='aspnetForm']/div[4]/div[1]/div[3]/div/div[1]/div[2]/div/div[12]/div/span")
	public WebElement eSHOPNameTestBoxlink;
	@FindBy(xpath = "//form[@id='aspnetForm']/div[4]/div[1]/div[3]/div/div[1]/div[2]/div/div[13]/div/span")
	public WebElement adveoLocationCodeTestBoxLink;
	@FindBy(xpath = "//form[@id='aspnetForm']/div[4]/div[1]/div[3]/div/div[1]/div[2]/div/div[14]/div/span")
	public WebElement adveoVendorNumberTestBoxLink;

	/************************* Dealer_Communication_Tab ************************************/

	@FindBy(xpath = "//a[@title='Send email message']")
	public WebElement emailFieldUnderCommunicationLink;
	@FindBy(xpath = "//a[@title='Open in new browser window']")
	public WebElement homePageFieldUnderCommunicationLink;

	/****************************** Dealer_Language ***************************************/

	@FindBy(xpath = "//span[contains(@class,'ms-cui-ctl-largelabel')][contains(text(),'Languages')]")
	public WebElement languageFieldLink;
	@FindBy(xpath = "//form[@class='form-no-factboxes ms-nav-listform in-edit-mode']/div/div/div/div/div[2]/ul/li/a/span[contains(text(),'Home')]")
	public WebElement Homelink;
	@FindBy(xpath = "//span[contains(@class,'ms-cui-ctl-largelabel')][contains(text(),'New')]")
	public WebElement addingNewlanguageFieldLink;
	@FindBy(xpath = "//span[contains(@class,'ms-cui-ctl-largelabel')][contains(text(),'Delete')]")
	public WebElement deletingLanguageFieldLink;
	@FindBy(xpath = "//table[@summary='Languages']/tbody/tr[1]/td[3]/input[@type='text']")
	public WebElement firstLangCodeBox;
	@FindBy(xpath = "//button[@title='Yes']/span[contains(text(),'Yes')]")
	public WebElement yesBox;
	@FindBy(xpath = "//tr/td[3][contains(@class,'edit-container ms-nav-has-validation-error')]/input")
	public WebElement blankBoxField;
	@FindBy(xpath = "//div[@tabindex='0'][@title='Save and close the page.']")
	public WebElement closeAndSaveLink;
	@FindBy(xpath = "//div[@class='content-header-actions']/div[2]/a[@class='ms-list-itemLink icon-Magnifier']")
	public WebElement searchLink;
	@FindBy(xpath = "//form[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/input[@type='text']")
	public WebElement extendedSearchBox;
	@FindBy(xpath = "//table[@summary='Languages']/tbody/tr[1]/td[3]/input[@class='cursorinherit stringcontrol-edit']")
	public WebElement searchBoxLink;

	/************************* PostCode ***********************************/

	@FindBy(xpath = "//span[contains(@class,'ms-cui-ctl-largelabel')][contains(text(),'Post')]")
	public WebElement postCodeLink;
	@FindBy(xpath = "//tr/td[3][contains(@class,'edit-container ms-nav-has-validation-error')]/input")
	public WebElement firstBlankBox;
	@FindBy(xpath = "//tr/td[5][contains(@class,'edit-container ms-nav-has-validation-error')]/input")
	public WebElement secondBlankBox;
	@FindBy(xpath = "//table[@summary='Post Codes']/tbody/tr[1]/td[3]/input[@class='cursorinherit stringcontrol-edit']")
	public WebElement finalSearchPostCode;
	@FindBy(xpath = "//table[@summary='Post Codes']/tbody/tr[1]/td[3]/input[@type='text']")
	public WebElement FirstPostCodeBox;

	public void clickonHomeLink() throws InterruptedException {
		homelink.click();
	}

	public void clickonAppSetUpLink() {
		driverWait.waitSeconds(1);
		appSetUplink.click();
	}

	public void clickonEllipsisLink() throws InterruptedException {
		driverWait.waitSeconds(1);
		ellipsislink.click();
	}

	public void clickOnEllipsisByJavaScript() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ellipsislink);
	}

	public void clickonViewLink() {
		viewlink.click();
	}

	/****************** GeneralTab ***************/

	public String getDataonNameFiedTextBoxLink() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/div[2]/div[4]/form[@id='aspnetForm']/div[4]/div[1]/div[3]/div/div[1]/div[2]/div/div[1]/div/span[@class='stringcontrol-read']")));
		return nameFieldTestBoxlink.getText();
	}

	public String getDataonAddressTextBoxLink() {
		return addressFieldTestBoxLink.getText();
	}

	public String getDataonAddress2TextBoxLink() {
		return address2FieldTestBoxLink.getText();
	}

	public String getDataonPostCodeTextBoxLink() {
		return postCodeFieldTestBoxLink.getText();
	}

	public String getDataonCityTextBoxLink() {
		return cityTestBoxLink.getText();
	}

	public String getDataonCountryRegionTextBoxLink() {
		return countryRegionCodeTestBoxLink.getText();
	}

	public String getDataoneSHOPTextBoxLink() {
		return eSHOPNameTestBoxlink.getText();
	}

	public String getDataonPhoneNoTextBoxLink() {
		return phoneNumberTestBoxLink.getText();
	}

	public String getDataonVATTextBoxLink() {
		return vatRegistrationNumTestBoxLink.getText();
	}

	public String getDataonAdveoCountryTextBoxLink() {
		return adveoCountryTestBoxLink.getText();
	}

	public String getDataonAdveoIDTextBoxLink() {
		return adveoDealerIDTestBoxLink.getText();
	}

	public String getDataonVendorNoTextBoxLink() {
		return adveoVendorNumberTestBoxLink.getText();
	}

	public String getDataonLocationCodeTextBoxLink() {
		return adveoLocationCodeTestBoxLink.getText();
	}

	public String getDataonCountryTextBoxLink() {
		return countryTestBoxLink.getText();
	}

	/*****************************************************************/

	public String getDataonEmailFieldUnderCommunicationTextBoxLink() {
		return emailFieldUnderCommunicationLink.getText();
	}

	public String getDataonHomePageFieldUnderCommunicationTextBoxLink() {
		return homePageFieldUnderCommunicationLink.getText();
	}

	public void clickonLanguageLink() {
		jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", languageFieldLink);
	}

	public void clickonLanguageLink1() throws InterruptedException {
		driverWait.waitSeconds(1);
		languageFieldLink.click();
	}

	public void clickOnPostCodeLink() {
		driverWait.waitSeconds(5);
		Actions Action = new Actions(driver);
		Action.click(postCodeLink).perform();
	}

	public void clickonHomeLanguageLink() {
		jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", Homelink);
	}

	public void clickonAddingnewLanguageLink() {
		jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", addingNewlanguageFieldLink);
	}

	public void clickonAddingnewLanguageLink1() {
		driverWait.waitSeconds(1);
		addingNewlanguageFieldLink.click();
	}

	public void clickonDeleteLanguageLink() {
		jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", deletingLanguageFieldLink);
	}

	public void clickonYes() {
		yesBox.click();
	}

	public String getlangCodefromfirstrow() {
		return firstLangCodeBox.getAttribute("value");
	}

	public String getPostCodefromfirstrow() {
		return FirstPostCodeBox.getAttribute("value");

	}

	public void sendExtrainPostCodeForEdit(String Edit) {
		finalSearchPostCode.click();
		finalSearchPostCode.sendKeys(Edit);
	}

	public void sendExtrainLangCodeForEdit(String Edit) throws InterruptedException {
		searchBoxLink.click();
		driverWait.waitSeconds(2);
		searchBoxLink.sendKeys(Edit);

	}

	public void clickonblankboxLink(String langCode) throws InterruptedException {
		blankBoxField.click();
		driverWait.waitSeconds(2);
		blankBoxField.sendKeys(langCode);
	}

	public void sendCodeinFirstbox(String Postcode) throws InterruptedException {
		firstBlankBox.click();
		driverWait.waitSeconds(1);
		firstBlankBox.sendKeys(Postcode);
	}

	public void sendCodeinSecondbox(String City) throws InterruptedException {
		secondBlankBox.click();
		driverWait.waitSeconds(1);
		secondBlankBox.sendKeys(City);
	}

	public void saveAndCloseLink() {
		jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", closeAndSaveLink);
	}

	public void languagesearchLink() {
		jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", searchLink);
	}

	public void languageSearchLink1() throws InterruptedException {
		driverWait.waitSeconds(1);
		searchLink.click();
	}

	public void sendCodeinextendedSearchBox(String searchlangCode) {
		jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value = '" + searchlangCode + "';", driver.findElement(
				By.xpath("//form[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/input[@type='text']")));
	}

	public void sendCodeinextendedSearchBox1(String searchlangCode) throws InterruptedException {
		driverWait.waitSeconds(1);
		extendedSearchBox.sendKeys(searchlangCode);

	}

	public String searchLink() throws InterruptedException {
		driverWait.waitSeconds(1);
		return searchBoxLink.getAttribute("value");

	}

	public String searchPostCode() throws InterruptedException {
		driverWait.waitSeconds(2);
		return finalSearchPostCode.getAttribute("value");

	}

	public WebElement isElementLoaded(WebElement elementToBeLoaded) {
		wait = new WebDriverWait(driver, 100);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(elementToBeLoaded));
		return element;

	}

}
