package pages.Gnoss;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ui.utility.DriverWaits;
import ui.utility.FactoryHelper;

public class GnossProducts {
	FactoryHelper helper = FactoryHelper.getInstance();
	DriverWaits driverWaits = DriverWaits.getInstance();
	private static GnossProducts gnossProductsSingleInstance = null;

	private GnossProducts() {
	}

	// static method to create instance of Singleton class
	public static GnossProducts getInstance() {
		if (gnossProductsSingleInstance == null)
			gnossProductsSingleInstance = new GnossProducts();
		return gnossProductsSingleInstance;
	}

	private static JavascriptExecutor jse;
	public static WebDriver driver;
	@FindBy(xpath = "//div[@class='datos']//div[@class='dato editable']//span[@class='value']")
	WebElement highlightEditPriceField;
	@FindBy(xpath = "//div[@class='dato editable editando']//input[@type='number']")
	WebElement editPriceInput;
	@FindBy(xpath = "//div[@class='botones']/span[1]")
	WebElement clickEditProductOK;
	@FindBy(xpath = "//a[@href='http://preadveoazure.gnoss.com/resource/g05443/b1bd05f5-a5c5-416b-9f2d-ca385cceba90']")
	WebElement clickProductLink;
	@FindBy(xpath = "//div[@class='dato dato-precio editable']//span[@class='value']")
	WebElement getEditedPrice;
	@FindBy(xpath = "//div[@class='dato dato-margen']//span[@class='value']")
	WebElement getMarginPercentage;
	@FindBy(xpath = "//ul[@class='principal']/li/a[contains(text(),'Products')]")
	WebElement productALink;
	@FindBy(xpath = "//div[@id='adveo_productCountry---gr_hasGTIN-14']/div[1]/input[1]")
	WebElement gtinFacetSearch;
	@FindBy(xpath = "//div[@id='adveo_productCountry---adveo_code']/div[1]/input[1]")
	WebElement adeveoCodeFacetSearch;
	@FindBy(xpath = "//div[@class='dato adveocode']//span[@class='value']")
	WebElement getAdveoCode;
	@FindBy(xpath = "//div[@class='dato gtin']//span[@class='value']")
	WebElement getGTINNumber;
	@FindBy(xpath = "//a[@href='http://preadveoazure.gnoss.com/my-products']")
	WebElement Productstab;
	@FindBy(xpath = "//span[@class='textoFaceta'][contains(text(),'Office Stationery')]")
	WebElement OfficeStationeryFacet;
	@FindBy(xpath = "//ul[@id='panListadoFiltros']//li[@class='http://adveo.gnoss.com/items/adveocat_000000000106']")
	WebElement Categoriesfiltervalue;
	@FindBy(xpath = "//a[@class='borrarFiltros']")
	WebElement CleanupFilter;
	@FindBy(xpath = "//span[@class='textoFaceta'][contains(text(),'Herlitz')]")
	WebElement BrandFacet;
	@FindBy(xpath = "//div[@id='panFiltros']")
	WebElement Facetsfiltervalue;
	@FindBy(xpath = "(//span[@class='textoFaceta'][contains(text(),'A')])[6]")
	WebElement ClassificationFacet;
	@FindBy(xpath = "//input[@title='Seller'][@type='text']")
	WebElement sellerBox;
	@FindBy(xpath = "//a[@id='adveo_productCountry---adveo_productDemandInfo---adveo_offering---adveo_seller---gr_namefbotonBuscar'][@class='searchButton']")
	WebElement searchIcon;
	@FindBy(xpath = "//ul[@id='panListadoFiltros']//li")
	WebElement priz24Box;
	@FindBy(xpath = "//span[@class='textoFaceta'][contains(text(),'priz24')]")
	WebElement priz24link;
	@FindBy(xpath = "//a[@class='borrarFiltros'][contains(text(),'Clean up filters')]")
	public WebElement cleanUpFilter;
	// @FindBy(xpath =
	// "//span[@class='textoFaceta'][contains(text(),'amazon')]")
	@FindBy(xpath = "//div[4]/div[2]/ul[1]/li[2]/label[1]/a[1]/span[1]")
	WebElement amazonlink;
	@FindBy(xpath = "//ul[@id='panListadoFiltros']//li")
	WebElement amazonBox;
	@FindBy(xpath = "//span[@class='textoFaceta'][contains(text(),'Yes')]")
	WebElement yesLink;
	@FindBy(xpath = "//ul[@id='panListadoFiltros']//li[@class='true']")
	WebElement yesBox;
	@FindBy(xpath = "//label[contains(@for,'chkFaceta')]//a[@rel='nofollow'][@name='adveo:isDealerPrice=true']//span[2]")
	WebElement countOfEditedPriceProducts;
	@FindBy(xpath = "//p[@id='panNumResultados']/strong")
	WebElement actualCountOfEditedPriceProducts;
	@FindBy(xpath = "//label//a[@rel='nofollow'][@name='adveo:productCountry@@@adveo:starsNumber=5']//div[@class='dato votos']//span[@class='label']")
	WebElement fiveStarlink;
	@FindBy(xpath = "//ul[@id='panListadoFiltros']//li[@class='5']")
	WebElement fiveStarBox;
	@FindBy(xpath = "//input[@placeholder='From'][@id='adveo_productCountry---adveo_numberOfReviewsf1']")
	WebElement reviewsrangefrom;
	@FindBy(xpath = "//input[@placeholder='To'][@id='adveo_productCountry---adveo_numberOfReviewsf2']")
	WebElement reviewsrangeto;
	@FindBy(xpath = "//a[@name='adveo:productCountry@@@adveo:numberOfReviews'][@class='searchButton']")
	WebElement searchReview;
	@FindBy(xpath = "//ul[@id='panListadoFiltros']//li")
	WebElement rangeboxzerotofour;
	@FindBy(xpath = "//span[@class='textoFaceta'][contains(text(),'From 8 to 10')]")
	WebElement rangeeighttonine;
	@FindBy(xpath = "//ul[@id='panListadoFiltros']//li")
	WebElement rangeboxeighttonine;
	@FindBy(xpath = "//div[@class='facetedSearch']/div[3]/ul/li[1]/label/a/span[2]")
	WebElement productCountInRangeEighttoNine;
	@FindBy(xpath = "//div[@class='facetedSearch']/div[3]/ul/li[1]/label/a/span[1]")
	WebElement ReviewText;
	@FindBy(xpath = "//div[4]/div[2]/ul[1]/li[1]/label[1]/a[1]/span[1]")
	WebElement sellerText;

	public GnossProducts(WebDriver driver) {
		GnossProducts.driver = driver;
	}

	public void editPrice(String priceUpdate) {
		helper.performMoveToElementAction(highlightEditPriceField, driver);
		helper.clearInput(editPriceInput, driver);
		helper.sendKeysData(editPriceInput, priceUpdate);
	}

	public void clickEditProductOK() {
		helper.clickJS(clickEditProductOK, driver);
	}

	public void clickProductLink() {
		driverWaits.waitSeconds(2);
		helper.clickJS(clickProductLink, driver);
	}

	public String getEditedSellPrice() {
		return helper.getElementText(getEditedPrice, driver);
	}

	public String getCalculatedMarginPercentage() {
		return helper.getElementText(getMarginPercentage, driver);
	}

	public void clickProductsCategory() {
		DriverWaits.waitForPageToLoad(3);
		helper.windowsHandler(driver);
		helper.click(productALink);
	}

	public void searchGtinNumber(String data) {
		helper.sendKeysData(gtinFacetSearch, data);
		helper.sendKeysEnter(gtinFacetSearch, driver);
	}

	public void searchAdveoCode(String data) {
		helper.sendKeysData(adeveoCodeFacetSearch, data);
		helper.sendKeysEnter(adeveoCodeFacetSearch, driver);
	}

	public String getAdveoCode() {
		return helper.getElementText(getAdveoCode, driver);
	}

	public String getGTINNumber() {
		return helper.getElementText(getGTINNumber, driver);
	}

	public void backToProductPage() {
		helper.backPage(driver);
	}

	public void clickonProductstab() {
		helper.click(Productstab);
		driverWaits.waitSeconds(2);
	}

	/**
	 * This method clicks on OfficeSationery sub division under Categories facet
	 */
	public void clickonOfficeStationeryFacet() {
		helper.click(OfficeStationeryFacet);
		driverWaits.waitSeconds(2);
	}

	/**
	 * This method returns value of filter after selection of subdivisions under
	 * categories facet
	 * 
	 * @return valueofCategoriesfilter
	 */
	public String getCategoriesfiltervalue() {
		String valueofCategoriesfilter = Categoriesfiltervalue.getText();
		driverWaits.waitSeconds(1);
		return valueofCategoriesfilter;
	}

	/**
	 * This method cleans all the filters selected
	 */
	public void clickonCleanupFilter() {
		helper.click(CleanupFilter);
		driverWaits.waitSeconds(2);
	}

	/**
	 * This method clicks on sub division under Brand facet
	 */
	public void clickonBrandFacet() {
		helper.click(BrandFacet);
		driverWaits.waitSeconds(1);
	}

	/**
	 * This method returns value of filter after selection of subdivisions under
	 * Brand and Classification facet
	 * 
	 * @return valueofCategoriesfilter
	 */
	public String getFacetsfiltervalue() {
		String valueofFacetsfilter = Facetsfiltervalue.getText();
		driverWaits.waitSeconds(1);
		return valueofFacetsfilter;
	}

	/**
	 * This method clicks on sub division under Classification facet
	 */
	public void clickonClassificationFacet() {
		helper.click(ClassificationFacet);
		driverWaits.waitSeconds(2);
	}

	public void typeSellerName(String s) throws InterruptedException {
		driverWaits.waitSeconds(5);
		sellerBox.sendKeys(s);
	}

	public void clickSearch() {
		searchIcon.click();
	}

	public String getTextPriz24() {
		return helper.gettingfirstText(priz24Box);
	}

	public void clickCleanUpFilter() {
		driverWaits.waitSeconds(5);
		cleanUpFilter.click();
	}

	public void clickPriz24() {
		helper.scrollJS(priz24link, driver);
	}

	public void clickAmazon() throws InterruptedException {
		driverWaits.waitSeconds(5);
		helper.scrollJS(amazonlink, driver);
	}

	public String getTextamazon() throws InterruptedException {
		driverWaits.waitSeconds(5);
		return helper.gettingfirstText(amazonBox);
	}

	public void clickYes() {
		helper.scrollJS(yesLink, driver);
	}

	public String getTextYes() throws InterruptedException {
		return helper.gettingfirstText(yesBox);
	}

	public String getExpectedCountofEditedPriceProducts() {
		return helper.getCountValue(countOfEditedPriceProducts, driver);

	}

	public void clickonCountofEditedPriceProducts() {
		helper.scrollJS(countOfEditedPriceProducts, driver);
	}

	public String getActualCountofEditedPriceProducts() {
		return actualCountOfEditedPriceProducts.getText();
	}

	public void clickFiveStarLink() {
		helper.scrollJS(fiveStarlink, driver);

	}

	public String getTextFiveStar() {
		return helper.gettingfirstText(fiveStarBox);
	}

	public void sendLowerReviewLimit(String s) {
		jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].scrollIntoView();", reviewsrangefrom);
		reviewsrangefrom.sendKeys(s);

	}

	public void sendUpperReviewLimit(String s) {
		jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].scrollIntoView();", reviewsrangeto);
		reviewsrangeto.sendKeys(s);

	}

	public void clickSearchReview() {
		searchReview.click();
	}

	public String getTextRange() {
		return helper.gettingfirstText(rangeboxzerotofour);
	}

	public void clickRangeEightToNine() {
		helper.scrollJS(rangeeighttonine, driver);
	}

	public String getRangeEightToNine() {
		return helper.gettingfirstText(rangeboxeighttonine);
	}

	public void clickCountRangeEightToNine() {
		helper.scrollJS(productCountInRangeEighttoNine, driver);
	}

	public String getExpectedCountofReviewProduct() {
		return helper.getCountValue(productCountInRangeEighttoNine, driver);
	}

	public String getActualCountofProductinReview8to9() {
		return actualCountOfEditedPriceProducts.getText();
	}

	public void clickReview() {
		ReviewText.click();
	}

	public String getReview() {
		return helper.getnumFromString(ReviewText.getText());
	}

	public String firstNum() {
		return helper.getFirstNum(ReviewText.getText());
	}

	public String secondNum() {
		return helper.getSecondNum(ReviewText.getText());
	}

	public String getSellerText() {
		return sellerText.getText();
	}

	public String getSeller1Text() {
		return amazonlink.getText();
	}

}
