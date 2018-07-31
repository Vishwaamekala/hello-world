package pages.Gnoss;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ui.utility.DriverWaits;
import ui.utility.FactoryHelper;

public class GnossLogin {
	public static WebDriver driver;
	private static GnossLogin gnossLoginSingleInstance = null;
	FactoryHelper helper = FactoryHelper.getInstance();
	DriverWaits driverWaits = DriverWaits.getInstance();

	public GnossLogin(WebDriver driver) {
		GnossLogin.driver = driver;
	}

	private GnossLogin() {
	}

	// static method to create instance of Singleton class
	public static GnossLogin getInstance() {
		if (gnossLoginSingleInstance == null)
			gnossLoginSingleInstance = new GnossLogin();
		return gnossLoginSingleInstance;
	}

	@FindBy(xpath = "//*[@id='ButtonBuyNow']")
	WebElement ButtonBuyNow;
	@FindBy(xpath = "//a[@class='padding-15']")
	WebElement LoginButton;
	@FindBy(xpath = "//a[text()='My Services']")
	WebElement myServicePageLink;
	@FindBy(xpath = "//*[@id='i0118']")
	WebElement enterPassword;
	@FindBy(xpath = "//div[@class='col-xs-24 no-padding-left-right form-group no-margin-bottom button-container']/div[1]/input[1]")
	WebElement singInButton;
	@FindBy(xpath = "//*[@id='DropDownList1']")
	WebElement languageChangeDropDown;
	@FindBy(xpath = "//*[@id='i0116']")
	WebElement enterUserName;
	@FindBy(xpath = "//*[@id='MainContent_LinkButtonUrlGNOSS']")
	WebElement accessGnossLink;
	@FindBy(xpath = "//span[@class='imagen']")
	WebElement LogoutProfile;
	@FindBy(xpath = "//a[@href='http://preadveoazure.gnoss.com/signout/redirect/community/adveo']")
	WebElement DisconnectIcon;
	@FindBy(xpath = "//div[@id='login_workload_logo_text']")
	WebElement LogoutMessage;

	public String getGnossPageTitle() {
		return helper.getPageTitle(driver);

	}

	public void accessGnossLink() {
		driverWaits.waitSeconds(3);
		helper.clickJS(accessGnossLink, driver);
		DriverWaits.waitForPageToLoad(3);
	}

	public void languageChangeDropDown() {
		helper.performActionDoubleClick(languageChangeDropDown, driver);
		helper.selectDropDownByVisibleText(languageChangeDropDown, driver, "En");
	}

	public void singInButton() {
		driverWaits.waitSeconds(3);
		helper.clickJS(singInButton, driver);
		helper.clickJS(singInButton, driver);
	}

	public void enterPass(String password) {
		helper.sendKeysData(enterPassword, password);
		enterPassword.sendKeys(Keys.ENTER);
	}

	public void enterUserName(String userName) {
		helper.sendKeysData(enterUserName, userName);
	}

	public void myServicePage() {
		helper.click(myServicePageLink);
	}

	public void login() {
		helper.click(LoginButton);
	}

	public void clickButtonBuyNow() {
		helper.click(ButtonBuyNow);
	}

	public void HandleWindow() {
		driverWaits.waitSeconds(1);
		helper.windowsHandler(driver);

	}

	public void clickLogoutProfile() throws InterruptedException {
		helper.performMoveToElementAction(LogoutProfile, driver);
		driverWaits.waitSeconds(2);
	}

	public void clickDisconnectIcon() {
		helper.click(DisconnectIcon);
		driverWaits.waitSeconds(2);
	}

	public String getLogoutMessage() {
		String valueofLogoutMessage = LogoutMessage.getText();
		return valueofLogoutMessage;

	}

}
