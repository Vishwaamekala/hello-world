package pages.Gnoss;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ui.utility.DriverWaits;
import ui.utility.FactoryHelper;

public class GnossHome {
	private static GnossHome gnossHomeSingleInstance = null;
	FactoryHelper helper = FactoryHelper.getInstance();
	public static WebDriver driver;
	private static JavascriptExecutor jse;

	public GnossHome(WebDriver driver) {
		GnossHome.driver = driver;
	}

	private GnossHome() {
	}

	// static method to create instance of Singleton class
	public static GnossHome getInstance() {
		if (gnossHomeSingleInstance == null)
			gnossHomeSingleInstance = new GnossHome();
		return gnossHomeSingleInstance;
	}

	@FindBy(xpath = "//input[@id='txtBusquedaPrincipal']")
	WebElement searchInputBox;
	@FindBy(xpath = "//a[@href='#']//span[@class='material-icons'][contains(text(),'keyboard_arrow_down')]")
	WebElement keyBoardArrowDown;
	@FindBy(xpath = "//a[@lang='es'][@title='Español']")
	WebElement espanol;
	@FindBy(xpath = "//h2[contains(text(),'New recommended prices')]")
	WebElement englishText;
	@FindBy(xpath = "//h2[contains(text(),'Nuevos precios recomendados')]")
	WebElement spanishText;
	@FindBy(xpath = "//div[@class='bloque-listado']")
	WebElement textbox;
	@FindBy(xpath = "//a[@href='http://preadveoazure.gnoss.com'][contains(text(),'Home')]")
	WebElement home;
	@FindBy(xpath = "//a[@href='http://preadveoazure.gnoss.com/my-categories-ranking'][contains(text(),'CategoriesRanking')]")
	WebElement categoriesRanking;
	@FindBy(xpath = "//ul[@class='principal']/li/a[contains(text(),'Products')]")
	WebElement products;
	@FindBy(xpath = "//a[@href='http://preadveoazure.gnoss.com/my-pricing-profile'][contains(text(),'Pricing Profile')]")
	WebElement pricingProfile;
	@FindBy(xpath = "//*[@id='header']/div[1]/div[3]/ul/li[1]/a")
	WebElement homePageLink;

	public void clickHomePage() {
		helper.click(homePageLink);
	}

	public void clickProductSearch(String setText) {
		DriverWaits.waitForPageToLoad(3);
		helper.windowsHandler(driver);
		helper.sendKeysJS(searchInputBox, driver, setText);
		helper.sendKeysEnter(searchInputBox, driver);
	}

	public String windowHandling() {
		return helper.Windowhandling(driver);
	}

	public void clickArrowDown() throws InterruptedException {
		keyBoardArrowDown.click();
	}

	public void clickEspanol() throws InterruptedException {
		espanol.click();
	}

	public String getEnglishText() {
		jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].scrollIntoView();", textbox);
		return englishText.getText();
	}

	public String getSpanishText() {
		jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].scrollIntoView();", spanishText);
		return spanishText.getText();
	}

	public String getHome() throws InterruptedException {
		return home.getText();
	}

	public String getCategoriesRanking() throws InterruptedException {
		return categoriesRanking.getText();
	}

	public String getProducts1() throws InterruptedException {
		return products.getText();
	}

	public String getPricingProfile() throws InterruptedException {
		return pricingProfile.getText();
	}

	public void clickProducts() {
		products.click();
	}

}
