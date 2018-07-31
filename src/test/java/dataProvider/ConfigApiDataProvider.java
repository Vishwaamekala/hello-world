package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.StringWriter;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import ui.utility.ReportHelper;

public class ConfigApiDataProvider {

	private static Properties pro;
	private static String url;
	protected static final Logger LOGGER = LoggerFactory.getLogger(ReportHelper.class);
	private static String apiConfigPath = System.getProperty("user.dir")
			+ "\\src\\test\\resourse\\propertyFiles\\config_api.properties";
	private static String xmlFileLoader = System.getProperty("user.dir");
	private static String xmlToString = null;

	public ConfigApiDataProvider() {
		try {
			File src = new File(apiConfigPath);
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/* Rest API Methods */
	public String getDealerAuthUrl(String key) {
		LOGGER.info("Application Title does not matched inside");
		url = pro.getProperty(key);
		return url;
	}

	public String getDealerID(String key) {
		url = pro.getProperty(key);
		return url;
	}

	public String getuserName(String key) {
		url = pro.getProperty(key);
		return url;
	}

	public String getPassword(String key) {
		url = pro.getProperty(key);
		return url;
	}

	public String getaccountNumber(String key) {
		url = pro.getProperty(key);
		return url;
	}

	public String loadFile(String file) {
		String xmlFile = xmlFileLoader + "\\src\\test\\resourse\\apixmls\\" + file + ".xml";
		try {

			try {
				DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
				InputSource is = new InputSource(xmlFile);
				Document document = docBuilderFactory.newDocumentBuilder().parse(is);
				StringWriter sw = new StringWriter();
				Transformer serializer = TransformerFactory.newInstance().newTransformer();
				serializer.transform(new DOMSource(document), new StreamResult(sw));
				xmlToString = sw.toString();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} finally {
			System.out.println("File loaded Succesfully");
		}
		return xmlToString;
	}
}