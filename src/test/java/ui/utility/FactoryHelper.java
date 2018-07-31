package ui.utility;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FactoryHelper {
	private static FactoryHelper helperSingleInstance = null;
	private static JavascriptExecutor jse;
	private static Actions action;
	private static Select select;

	private FactoryHelper() {
	}

	// static method to create instance of Singleton class
	public static FactoryHelper getInstance() {
		if (helperSingleInstance == null)
			helperSingleInstance = new FactoryHelper();
		return helperSingleInstance;
	}

	public void performAction(WebElement element, WebDriver driver) {
		action = new Actions(driver);
		action.click(element).perform();
	}

	public void performMoveToElementAction(WebElement element, WebDriver driver) {
		action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
	}

	public void performActionDoubleClick(WebElement element, WebDriver driver) {
		action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	public void scrollJS(WebElement element, WebDriver driver) {
		jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", element);
		element.click();
	}

	public void sendKeysJS(WebElement element, WebDriver driver, String setText) {
		jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value = '" + setText + "';", element);
	}

	public void sendKeysJS(String locator, WebDriver driver, String setText) {
		jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value = '" + setText + "';", driver.findElement(By.xpath(locator)));
	}

	public void clickJS(WebElement element, WebDriver driver) {
		jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", element);
	}

	public void click(WebElement element) {
		element.click();
	}

	public String getAttribute(String locator, WebDriver driver) {
		return driver.findElement(By.xpath(locator)).getAttribute("value");
	}

	public String getElementText(WebElement element, WebDriver driver) {
		return element.getText();
	}

	public void sendKeysData(String locator, String setText, WebDriver driver) {
		driver.findElement(By.xpath(locator)).sendKeys(setText);
	}

	public void sendKeys(String locator, WebDriver driver) {
		driver.findElement(By.xpath(locator)).sendKeys(Keys.END);
	}

	public void sendKeysEnter(WebElement locator, WebDriver driver) {
		locator.sendKeys(Keys.ENTER);
	}

	public void sendKeysData(WebElement element, String setText) {
		element.sendKeys(setText);
	}

	public void sendById(String locatorId, WebDriver driver, String setText) {
		jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('#locator').setAttribute('value', " + setText + ")");
	}

	public void clearInput(String locator, WebDriver driver) {
		driver.findElement(By.xpath(locator)).clear();
	}

	public void clearInput(WebElement element, WebDriver driver) {
		element.clear();
	}

	public void selectDropDownByVisibleText(String locator, WebDriver driver, String setText) {
		select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByVisibleText(setText);
	}

	public String selectDropDownByOption(String locator, WebDriver driver) {
		select = new Select(driver.findElement(By.xpath(locator)));
		return select.getFirstSelectedOption().getText();
	}

	public void selectDropDownByVisibleText(WebElement element, WebDriver driver, String setText) {
		select = new Select(element);
		select.selectByVisibleText(setText);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public void windowsHandler(WebDriver driver) {
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(0));
		driver.close();
		driver.switchTo().window(tabs2.get(1));
	}

	public String Windowhandling(WebDriver driver) {
		String parent = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String child : allWindows) {
			if (!parent.equals(child)) {
				driver.switchTo().window(child);
			}
		}
		return parent;
	}

	public String gettingfirstText(WebElement element) {
		String nixSampleLine = element.getText();
		String[] lines = nixSampleLine.split("\\r?\\n");
		return lines[0];
	}

	public String getCountValue(WebElement element, WebDriver driver) {
		jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView()", element);
		String s = element.getText();
		String numbers = s.replaceAll("[^0-9]", "");
		return numbers;

	}

	public String getnumFromString(String str) {
		String numbers = str.replaceAll("[^0-9]", "");
		char firstNum = numbers.charAt(0);
		char secondNum = numbers.charAt(1);
		String pattern = Character.toString(firstNum) + "-" + Character.toString(secondNum);
		return pattern;
	}

	public String getFirstNum(String str) {
		String numbers = str.replaceAll("[^0-9]", "");
		char firstNum = numbers.charAt(0);
		return Character.toString(firstNum);
	}

	public String getSecondNum(String str) {
		String numbers = str.replaceAll("[^0-9]", "");
		char secondNum = numbers.charAt(1);
		return Character.toString(secondNum);
	}

	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void backPage(WebDriver driver) {
		driver.navigate().back();
	}

	public String convertFloatToInt(String formatInt) {
		return formatInt.replaceAll("(?<=^\\d+)\\.0*$", "");
	}

	public String leftPadZeros(String str) {
		return str.replace(".0", ".00");
	}
}
