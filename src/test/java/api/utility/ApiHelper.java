package api.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dataProvider.ConfigApiDataProvider;

public class ApiHelper {
	private static String uri;
	ConfigApiDataProvider config = new ConfigApiDataProvider();
	protected static final Logger LOGGER = LoggerFactory.getLogger(ApiHelper.class);
	private static String request;

	public String getBaseApiURL(String baseURI) {
		if (baseURI.equals("dealerAuthURL")) {
			uri = config.getDealerAuthUrl("post.uri.dealer.auth");
		} else if (baseURI.equals("dearlerMigURL")) {
			uri = config.getDealerAuthUrl("post.uri.dealer.migration");
		}
		LOGGER.info("Dealer Auth/Migration api up and running");
		return uri;
	}

	public String loadRequestXML(String dealerXML) {
		if (dealerXML.equals("dealerAuthXML")) {
			request = config.loadFile("dealerAuthRequest");
		} else if (dealerXML.equals("dealerMigrationXML")) {
			request = config.loadFile("dealerMigrationRequest");
		}
		LOGGER.info("Loading dealer request XML to send post request");
		return request;
	}
}
