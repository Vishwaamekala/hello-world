package ui.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.KlovReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportHelper {
	private static String proDir = System.getProperty("user.dir");
	private static String extentReportPath = proDir + "/Reports/ExtentReports.html";
	private static String screenFolders = proDir + "\\Screenshots\\";
	protected static final Logger LOGGER = LoggerFactory.getLogger(ReportHelper.class);
	private static Properties pro;
	private static String mongoHost;
	private static Integer mongoPort;
	private static File src;
	private static FileInputStream fis;

	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface RetryCountIfFailed {

		int value() default 0;
	}

	private static String actualXpath;

	/* Screenshot capture path */
	public static String captureScreenshot(WebDriver driver, String screenshotName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		src = ts.getScreenshotAs(OutputType.FILE);
		String screenFolder = screenFolders + screenshotName + System.currentTimeMillis() + ".png";
		try {
			FileUtils.copyFile(src, new File(screenFolder));
		} catch (IOException e) {
			LOGGER.info("File location does not exist.Please check the system path given:-", e);
		}
		return screenFolder;
	}

	/* HTML Reporter */
	public static ExtentHtmlReporter getHtmlReporter() {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(extentReportPath);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setProtocol(Protocol.HTTPS);
		htmlReporter.config().setReportName("report-name");
		htmlReporter.config().setDocumentTitle("doc-title");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setJS("js-string");
		htmlReporter.config().setCSS("css-string");
		return htmlReporter;
	}

	/* Klov Reporter */
	public static KlovReporter klovReporter() throws IOException {
		src = new File(System.getProperty("user.dir") + "\\src\\test\\resourse\\propertyFiles\\config_ui.properties");
		fis = new FileInputStream(src);
		pro = new Properties();
		pro.load(fis);
		KlovReporter klov = new KlovReporter();
		if (isMongoPortHostProvided()) {
			klov.initMongoDbConnection(getMongoHost(), getMongoPort());
			String klovProjectName = pro.getProperty("projectName");
			String klovReportName = pro.getProperty("reportName");
			String projectname = klovProjectName;
			String reportname = klovReportName;
			klov.setProjectName(projectname);
			klov.setReportName(reportname);
			klov.setKlovUrl("http://" + getMongoHost() + ":8085");
		}
		return klov;
	}

	/* MongoDB connection */
	private static boolean isMongoPortHostProvided() {
		if (pro.getProperty("MONGODB_SERVER") != null && pro.getProperty("MONGODB_PORT") != null) {
			setMongoHost(pro.getProperty("MONGODB_SERVER"));
			setMongoPort(Integer.parseInt(pro.getProperty("MONGODB_PORT")));
			return true;
		} else {
			setMongoHost("localhost");
			setMongoPort(27017);
			return true;
		}
	}

	private static String getMongoHost() {
		return mongoHost;
	}

	private static void setMongoHost(String mongo) {
		mongoHost = mongo;
	}

	private static Integer getMongoPort() {
		return mongoPort;
	}

	private static void setMongoPort(Integer port) {
		mongoPort = port;
	}
}
