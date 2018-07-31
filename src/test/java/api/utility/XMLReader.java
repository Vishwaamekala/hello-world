package api.utility;

import dataProvider.ConfigApiDataProvider;

public class XMLReader {
	private static String xml;
	private static String dealerID;
	private static String userName;
	private static String password;
	private static String accountNumber;
	private static String blankFied;
	ConfigApiDataProvider config = new ConfigApiDataProvider();

	public String readXMLValidDealer(String authRequest) {
		dealerID = config.getDealerID("dealerID1");
		userName = config.getuserName("userName1");
		password = config.getPassword("password1");
		accountNumber = config.getaccountNumber("accountNumber1");
		xml = authRequest.replace("{dealerID}", dealerID).replace("{userName}", userName)
				.replace("{password}", password).replace("{accountNumber}", accountNumber);
		return xml;
	}

	public String readXMLBlankDealerRequest(String authRequest) {
		dealerID = config.getDealerID("dealerID2");
		userName = config.getuserName("userName2");
		password = config.getPassword("password2");
		accountNumber = config.getaccountNumber("accountNumber2");
		blankFied = authRequest.replace("{dealerID}", dealerID).replace("{userName}", userName)
				.replace("{password}", password).replace("{accountNumber}", accountNumber);
		xml = blankFied.replace("null", "");
		return xml;
	}

	public String readXMLBlankuserNameRequest(String authRequest) {
		dealerID = config.getDealerID("dealerID3");
		userName = config.getuserName("userName3");
		password = config.getPassword("password3");
		accountNumber = config.getaccountNumber("accountNumber3");
		blankFied = authRequest.replace("{dealerID}", dealerID).replace("{userName}", userName)
				.replace("{password}", password).replace("{accountNumber}", accountNumber);
		xml = blankFied.replace("null", "");
		return xml;
	}

	public String readXMLBlankPasswordRequest(String authRequest) {
		dealerID = config.getDealerID("dealerID4");
		userName = config.getuserName("userName4");
		password = config.getPassword("password4");
		accountNumber = config.getaccountNumber("accountNumber4");
		blankFied = authRequest.replace("{dealerID}", dealerID).replace("{userName}", userName)
				.replace("{password}", password).replace("{accountNumber}", accountNumber);
		xml = blankFied.replace("null", "");
		return xml;
	}

	public String readXMLBlankAccountNumberRequest(String authRequest) {
		dealerID = config.getDealerID("dealerID5");
		userName = config.getuserName("userName5");
		password = config.getPassword("password5");
		accountNumber = config.getaccountNumber("accountNumber5");
		blankFied = authRequest.replace("{dealerID}", dealerID).replace("{userName}", userName)
				.replace("{password}", password).replace("{accountNumber}", accountNumber);
		xml = blankFied.replace("null", "");
		return xml;
	}

	public String testBlankFieldsRequest(String authRequest) {
		dealerID = config.getDealerID("dealerID6");
		userName = config.getuserName("userName6");
		password = config.getPassword("password6");
		accountNumber = config.getaccountNumber("accountNumber6");
		blankFied = authRequest.replace("{dealerID}", dealerID).replace("{userName}", userName)
				.replace("{password}", password).replace("{accountNumber}", accountNumber);
		xml = blankFied.replace("null", "");
		return xml;
	}

	public String testinvaliddealerIDRequest(String authRequest) {
		dealerID = config.getDealerID("dealerID7");
		userName = config.getuserName("userName7");
		password = config.getPassword("password7");
		accountNumber = config.getaccountNumber("accountNumber7");
		blankFied = authRequest.replace("{dealerID}", dealerID).replace("{userName}", userName)
				.replace("{password}", password).replace("{accountNumber}", accountNumber);
		return xml;
	}

	public String testInvalidaccountNumberRequest(String authRequest) {
		dealerID = config.getDealerID("dealerID8");
		userName = config.getuserName("userName8");
		password = config.getPassword("password8");
		accountNumber = config.getaccountNumber("accountNumber8");
		blankFied = authRequest.replace("{dealerID}", dealerID).replace("{userName}", userName)
				.replace("{password}", password).replace("{accountNumber}", accountNumber);
		return xml;
	}
}