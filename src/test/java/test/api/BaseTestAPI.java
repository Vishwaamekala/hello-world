package test.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import test.ui.Base.BaseTest;
import ui.utility.ReportHelper;

public class BaseTestAPI {
	protected static ExtentTest logger;
	private static ExtentReports extent;
	protected static final Logger LOGGER = LoggerFactory.getLogger(ReportHelper.class);

	@BeforeSuite
	public ExtentReports initKlovReport() {
		extent = new BaseTest().initKlovReport();
		return extent;
	}

	@BeforeMethod
	public void loadRequestXML() {
		LOGGER.info("I request to access the dealer Authentication and Migration API-");

	}

	@AfterMethod
	public void report(ITestResult result) {
		logger = extent.createTest(result.getMethod().getConstructorOrMethod().getName());
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, "Testcase Fail");
			LOGGER.info("TestCase Failed for API run");
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP, "Testcase Skipped");
			LOGGER.info("TestCase Skipped for API run");
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, "Testcase Passed");
			LOGGER.info("TestCase Passed for API run");
		}

	}

	@AfterClass
	public void closeExtent() {
		extent.flush();

	}
}
