package ui.utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import test.ui.Base.BaseTest;

public class Retry implements IRetryAnalyzer {
	BaseTest base = new BaseTest();
	private int count = 0;
	private static int maxTry = 1; // Run the failed test 2 times

	@Override
	public boolean retry(ITestResult iTestResult) {
		if (!iTestResult.isSuccess()) { // Check if test not succeed
			if (count < maxTry) { // Check if maxtry count is reached
				count++; // Increase the maxTry count by 1
				// iTestResult.setStatus(ITestResult.FAILURE); // Mark test as
				// failed and take
				// base64Screenshot
				base.report(iTestResult); // ExtentReports fail operations
				return true; // Tells TestNG to re-run the test
			}
		} else {
			iTestResult.setStatus(ITestResult.SUCCESS); // If test passes,TestNG
														// marks it as passed

		}
		return false;
	}

}
