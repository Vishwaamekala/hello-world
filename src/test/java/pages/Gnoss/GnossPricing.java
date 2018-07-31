package pages.Gnoss;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ui.utility.DriverWaits;
import ui.utility.FactoryHelper;

public class GnossPricing {
	public static WebDriver driver;
	FactoryHelper helper = FactoryHelper.getInstance();
	DriverWaits driverWaits = DriverWaits.getInstance();
	private static GnossPricing gnossPricingSingleInstance = null;

	public GnossPricing(WebDriver driver) {
		GnossPricing.driver = driver;
	}

	private GnossPricing() {
	}

	// static method to create instance of Singleton class
	public static GnossPricing getInstance() {
		if (gnossPricingSingleInstance == null)
			gnossPricingSingleInstance = new GnossPricing();
		return gnossPricingSingleInstance;
	}

	@FindBy(xpath = "//a[@href='http://preadveoazure.gnoss.com/my-pricing-profile'][contains(text(),'Pricing Profile')]")
	WebElement PricingProfile;
	@FindBy(xpath = "//div[@class='list-tabs']//li[2]")
	static WebElement Bycategorytab;
	@FindBy(xpath = "//div[@class='list-tabs']//li[3]")
	static WebElement Bybrandtab;
	@FindBy(xpath = "//div[@class='list-tabs']//li[4]")
	static WebElement Bysensitivetab;
	@FindBy(xpath = "//div[@class='list-tabs']//li[1]")
	static WebElement Infotab;
	@FindBy(xpath = "//span[@class='btn btn-azul'][contains(text(),'Edit')]")
	WebElement EditButton;
	@FindBy(xpath = "//label[@for='aggressive-dealerInfo']")
	WebElement PricingRole;
	@FindBy(xpath = "//div[@id='wrap-dealer-info']//div[@class='actionButtons']//input[@type='submit']")
	WebElement SaveButton;
	@FindBy(xpath = "//h1[contains(text(),'Pricing profile')]")
	WebElement PricingProfileTitletag;
	@FindBy(xpath = "//div[@class='fila'][4]")
	WebElement PricingAlgorithmvalue;

	public void clickonPricingProfile() {
		helper.click(PricingProfile);
	}

	public void clickonBycategorytab() {
		helper.click(Bycategorytab);
	}

	public void clickonBybrandtab() {
		helper.click(Bybrandtab);
	}

	public void clickonBysensitivetab() {
		helper.click(Bysensitivetab);
	}

	public void clickonInfotab() {
		helper.click(Infotab);
	}

	public void clickonEditButton() {
		helper.click(EditButton);
	}

	public void clickonPricingRole() {
		helper.click(PricingRole);
		driverWaits.waitSeconds(2);
	}

	public void clickonSaveButton() {

		helper.scrollJS(SaveButton, driver);
		driverWaits.waitSeconds(1);
	}

	public void clickonPricingProfileTitletag() {

		helper.scrollJS(PricingProfileTitletag, driver);
	}

	/**
	 * This method return value of Bycategory tab on Pricing Page
	 * 
	 * @return valueofBycategorytab
	 */
	public String getBycategorytabvalue() {
		String valueofBycategorytab = Bycategorytab.getText();
		return valueofBycategorytab;
	}

	/**
	 * This method return value of Bybrand tab on Pricing Page
	 * 
	 * @return valueofBybrandtab
	 */
	public String getBybrandtabvalue() {
		String valueofBybrandtab = Bybrandtab.getText();
		return valueofBybrandtab;
	}

	/**
	 * This method return value of Bysensitive tab on Pricing Page
	 * 
	 * @return valueofBysenstivetab
	 */
	public String getBysenstivetabvalue() {
		String valueofBysensitivetab = Bysensitivetab.getText();
		return valueofBysensitivetab;
	}

	/**
	 * 
	 * This method return value of Information tab on Pricing Page
	 * 
	 * @return valueofInfotab
	 */
	public String getInfotabvalue() {
		String valueofInfotab = Infotab.getText();
		return valueofInfotab;
	}

	/**
	 * This method return value of Defaultpricingalgorithm
	 * 
	 * @return valueofpricingalgorithm
	 */
	public String getPricingAlgorithmvalue() {
		String valueofpricingalgorithm = PricingAlgorithmvalue.getText();
		return valueofpricingalgorithm;
	}
}
