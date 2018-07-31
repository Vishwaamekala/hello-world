package pages.Navision;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ui.utility.DriverWaits;

public class NavisionItem {
	public static WebDriver driver;
	protected static final Logger LOGGER = LoggerFactory.getLogger(NavDealerInfoPage.class);
	DriverWaits driverWaits = DriverWaits.getInstance();
	private static NavisionItem NavisionItemSingleInstance = null;
	private static Actions actions;

	public NavisionItem(WebDriver driver) {
		NavisionItem.driver = driver;
	}

	private NavisionItem() {
	}

	public static NavisionItem getInstance() {
		LOGGER.info("Static method to create instance of Singleton class...");
		if (NavisionItemSingleInstance == null)
			NavisionItemSingleInstance = new NavisionItem(driver);
		return NavisionItemSingleInstance;
	}

	@FindBy(xpath = "(//a[text()='Code'and @class='ms-nav-edit-control-caption'])[2]/following-sibling::div/input")
	static WebElement getCodevalue_shiptoadd;

	@FindBy(xpath = "(//a[text()='Name'and @class='ms-nav-edit-control-caption'])[2]/following-sibling::div/input")
	static WebElement EnterName_shiptoadd;

	@FindBy(xpath = "//div[@class='message-dialog two_columns_title']/descendant::span[text()='Yes']")
	WebElement alert_edit_shiptoadd;

	@FindBy(xpath = "(//table[@summary='Ship-to Address List'])[2]/following-sibling::div[2]/span")
	static WebElement text_shiptoadd;

	@FindBy(xpath = "//a[@title='Items']")
	WebElement Itemsstab;

	@FindBy(xpath = "//a[.='No.']")
	WebElement NoDroprdown_Items;

	@FindBy(xpath = "//span[.='Filter...']")
	WebElement FilterDropdown_Items;

	@FindBy(xpath = "(//div[@class='edit-container ms-nav-editcontrol-nocaption ms-nav-editcontrolandonebuttoncontainer']//input)[1]")
	WebElement EnterItemNo;

	@FindBy(xpath = "//span[.='OK']")
	WebElement OkButton_Items;

	@FindBy(xpath = "//table[@summary='Retail Item List']/tbody/tr/td[3]/span")
	static WebElement ItemNo_value;

	@FindBy(xpath = "//table[@summary='Retail Item List']/tbody/tr/td[5]")
	static WebElement Item_Description_value;

	@FindBy(xpath = "//table[@summary='Retail Item List']/tbody/tr/td[6]/a")
	static WebElement Item_Stock_value;

	@FindBy(xpath = "//table[@summary='Retail Item List']/tbody/tr/td[7]")
	static WebElement Item_DCP_value;

	@FindBy(xpath = "//table[@summary='Retail Item List']/tbody/tr/td[9]")
	static WebElement Item_DealerProductbutton;
	@FindBy(xpath = "(//span[@class='ms-cui-tt-span'][contains(text(),'Home')])[1]")
	WebElement enablehomebtn;

	/**
	 * This method clicks on Home button after landing to Customers page
	 */
	public void clickonhomebutton() {
		Actions oAction = new Actions(driver);
		oAction.moveToElement(enablehomebtn);
		oAction.click(enablehomebtn).build().perform();
	}

	public void clickonalert_edit_shiptoadd() {
		actions = new Actions(driver);
		actions.moveToElement(alert_edit_shiptoadd);
		actions.click(alert_edit_shiptoadd).build().perform();
	}

	public void clickonItemsstab() {
		Itemsstab.click();
	}

	public void clickonNoDropdown_Items() {
		actions = new Actions(driver);
		actions.moveToElement(NoDroprdown_Items);
		actions.contextClick(NoDroprdown_Items).build().perform();
	}

	public void clickonFilter_Items() {
		FilterDropdown_Items.click();
		driverWaits.waitSeconds(1);
	}

	public void enterItemNumber(String data) {
		EnterItemNo.sendKeys(data);
	}

	public void clickonOkbutton_Item() {
		OkButton_Items.click();
	}

	public String getApplicationTitle() {
		return driver.getTitle();
	}

	public static String getItemNo_value() {
		return ItemNo_value.getText();
	}

	public static String getItem_Description_value() {
		return Item_Description_value.getText();
	}

	public static String getItem_Stock_value() {
		return Item_Stock_value.getText();
	}

	public static String getItem_DCP_value() {
		return Item_DCP_value.getText();

	}

	public boolean Item_DealerProductcheck() {
		return Item_DealerProductbutton.isSelected();
	}

}
