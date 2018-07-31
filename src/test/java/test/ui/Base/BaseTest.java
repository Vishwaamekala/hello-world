package test.ui.Base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import ui.utility.ReportHelper;

public class BaseTest {
	protected static final Logger LOGGER = LoggerFactory.getLogger(ReportHelper.class);
	public static WebDriverWait wait;
	public static WebDriver driver;
	private static ExtentReports extent;
	private static String filepath;
	protected static ExtentTest parentTest, childTest1, childTest2, childTest3;

	public WebDriver getDriver() {
		return driver;
	}

	@BeforeSuite()
	public ExtentReports initKlovReport() {
		LOGGER.info("Initializing Extent");
		extent = new ExtentReports();
		LOGGER.info("Initializing Extent to get HTML report");
		extent.attachReporter(ReportHelper.getHtmlReporter());
		try {
			LOGGER.info("Initializing Extent to get Klov report");
			extent.attachReporter(ReportHelper.klovReporter());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return extent;

	}

	@Parameters({ "applications" })
	@BeforeClass
	public void launchBrowser(String applications) {
		LOGGER.info("Driver Initialization");
		driver = BrowserFactory.getBrowser("Chrome");
		if (applications.equals("NAVISION")) {
			driver.get(DataProviderFactory.getConfig().getApplicationUrl(applications));
			LOGGER.info("Application URL is up and running");
			parentTest = extent.createTest(getClass().getName()).assignCategory(applications);
		} else if (applications.equals("GNOSS")) {
			driver.get(DataProviderFactory.getConfig().getApplicationUrl(applications));
			LOGGER.info("Application URL is up and running");
			parentTest = extent.createTest(getClass().getName()).assignCategory(applications);
		} else {
			driver.get(DataProviderFactory.getConfig().getApplicationUrl(applications));
			LOGGER.info("Application URL is up and running");
			parentTest = extent.createTest(getClass().getName()).assignCategory(applications);
		}
	}

	@BeforeMethod
	public void driverWait() {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void report(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			childTest1 = parentTest.createNode(result.getMethod().getDescription());
			childTest1.log(Status.INFO, MarkupHelper
					.createLabel("<span style='font-weight:bold;'>" + result.getName() + "</span>", ExtentColor.RED));
			childTest1.log(Status.FAIL, "<span style='font-weight:bold;'>Test case FAILED due to below issues:</span>"
					+ result.getThrowable());
			filepath = ReportHelper.captureScreenshot(driver, result.getName());
			try {
				childTest1.fail("<span style='font-weight:bold;'>Screenshot Attached:</span>")
						.addScreenCaptureFromPath(filepath);
			} catch (IOException e) {
				e.printStackTrace();
			}


		} else if (result.getStatus() == ITestResult.SKIP) {
			childTest1 = parentTest.createNode(result.getMethod().getDescription());
			childTest1.log(Status.INFO, MarkupHelper.createLabel(
					"<span style='font-weight:bold;'>" + result.getName() + "</span>", ExtentColor.YELLOW));
			childTest1.log(Status.SKIP, "Test case Skipped due to below issues:" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			childTest1 = parentTest.createNode(result.getMethod().getDescription());
			childTest1.log(Status.INFO, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));

			childTest1.log(Status.PASS, "<span style='font-weight:bold;'>Test case Passed</span>");
		}

	}

	@AfterClass
	public void closeExtent() {
		LOGGER.info("Generating Extent report with Klov");
		extent.flush();
		BrowserFactory.killbrowser(driver);
	}

	@AfterSuite
	public void CloseBrowser() {
		LOGGER.info("Closing Browser");
		//BrowserFactory.killbrowser(driver);
	}

}
