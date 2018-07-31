package test.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.utility.ApiHelper;
import api.utility.XMLReader;
import dataProvider.ConfigApiDataProvider;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class verifyDealerAuthReq extends BaseTestAPI {
	protected static final Logger LOGGER = LoggerFactory.getLogger(ApiHelper.class);
	private static String actualResponseBody;
	private static String authRequest;
	private static int actualStatusCode;
	private final int expectedStatusCode = 200;
	private static ConfigApiDataProvider config = new ConfigApiDataProvider();
	private static String expectedAuthSuccessResponse = config.loadFile("dealerSuccessAuthResponse").replace(
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>",
			"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
	private static String expectedAuthFailedResponse = config.loadFile("dealerFailedAuthResponse").replace(
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>",
			"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
	private static String uri = new ApiHelper().getBaseApiURL("dealerAuthURL");
	private static String requestXML = new ApiHelper().loadRequestXML("dealerAuthXML");
	XMLReader readXml = new XMLReader();

	@Test(priority = 1, description = "verify SUCCESS response when api request have valid request for dealer authentication")
	public void testValidDealerRequest() {
		authRequest = readXml.readXMLValidDealer(requestXML);
		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given().given().auth().basic("migrationtool", "amt123").and()
				.contentType("application/xml").body(authRequest);
		Response response = httpRequest.request(Method.POST);
		actualResponseBody = response.getBody().asString();
		actualStatusCode = response.getStatusCode();
		Assert.assertEquals(actualStatusCode, expectedStatusCode, "Status Code mismatch");
		Assert.assertEquals(actualResponseBody, expectedAuthSuccessResponse, "Response mismatch");
	}

	@Test(priority = 2, description = "verify FAILURE response when api request have invalid requet with blank dealerID field")
	public void testBlankDealerRequest() {
		authRequest = readXml.readXMLBlankDealerRequest(requestXML);
		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given().given().auth().basic("migrationtool", "amt123").and()
				.contentType("application/xml").body(authRequest);
		Response response = httpRequest.request(Method.POST);
		actualResponseBody = response.getBody().asString();
		actualStatusCode = response.getStatusCode();
		Assert.assertEquals(actualStatusCode, expectedStatusCode, "Status Code mismatch");
		Assert.assertEquals(actualResponseBody, expectedAuthFailedResponse, "Response mismatch");
	}

	@Test(priority = 3, description = "verify FAILURE response when apirequest have invalid request with blank userName field")

	public void testBlankuserNameRequest() {
		authRequest = readXml.readXMLBlankuserNameRequest(requestXML);
		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given().given().auth().basic("migrationtool", "amt123").and()
				.contentType("application/xml").body(authRequest);
		Response response = httpRequest.request(Method.POST);
		actualResponseBody = response.getBody().asString();
		actualStatusCode = response.getStatusCode();
		Assert.assertEquals(actualStatusCode, expectedStatusCode, "Status Code mismatch");
		Assert.assertEquals(actualResponseBody, expectedAuthFailedResponse, "Response mismatch");
	}

	@Test(priority = 4, description = "verify FAILURE response when apirequest have invalid request with blank password field")

	public void testBlankpasswordRequest() {
		authRequest = readXml.readXMLBlankPasswordRequest(requestXML);
		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given().given().auth().basic("migrationtool", "amt123").and()
				.contentType("application/xml").body(authRequest);
		Response response = httpRequest.request(Method.POST);
		actualResponseBody = response.getBody().asString();
		actualStatusCode = response.getStatusCode();
		Assert.assertEquals(actualStatusCode, expectedStatusCode, "Status Code mismatch");
		Assert.assertEquals(actualResponseBody, expectedAuthFailedResponse, "Response mismatch");
	}

	@Test(priority = 5, description = "verify FAILURE response when apirequest have invalid requet with blank accountNumber field")

	public void testBlankaccountNumberRequest() {
		authRequest = readXml.readXMLBlankAccountNumberRequest(requestXML);
		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given().given().auth().basic("migrationtool", "amt123").and()
				.contentType("application/xml").body(authRequest);
		Response response = httpRequest.request(Method.POST);
		actualResponseBody = response.getBody().asString();
		actualStatusCode = response.getStatusCode();
		Assert.assertEquals(actualStatusCode, expectedStatusCode, "Status Code mismatch");
		Assert.assertEquals(actualResponseBody, expectedAuthFailedResponse, "Response mismatch");
	}

	@Test(priority = 6, description = "verify FAILURE response when apirequest have invalid request without mandatory fields")

	public void testBlankFieldsRequest() {
		authRequest = readXml.testBlankFieldsRequest(requestXML);
		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given().given().auth().basic("migrationtool", "amt123").and()
				.contentType("application/xml").body(authRequest);
		Response response = httpRequest.request(Method.POST);
		actualResponseBody = response.getBody().asString();
		actualStatusCode = response.getStatusCode();
		Assert.assertEquals(actualStatusCode, expectedStatusCode, "Status Code mismatch");
		Assert.assertEquals(actualResponseBody, expectedAuthFailedResponse, "Response mismatch");
	}

	@Test(priority = 7, description = "verify FAILURE response when apirequest have invalid dealerID in payload")

	public void testInvalidDealerIDRequest() {
		authRequest = readXml.testinvaliddealerIDRequest(requestXML);
		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given().given().auth().basic("migrationtool", "amt123").and()
				.contentType("application/xml").body(authRequest);
		Response response = httpRequest.request(Method.POST);
		actualResponseBody = response.getBody().asString();
		actualStatusCode = response.getStatusCode();
		Assert.assertEquals(actualStatusCode, expectedStatusCode, "Status Code mismatch");
		Assert.assertEquals(actualResponseBody, expectedAuthFailedResponse, "Response mismatch");
	}

	@Test(priority = 8, description = "verify FAILURE response when apirequest have invalid accountNumber in payload")

	public void testInvaliaccountNumberRequest() {
		authRequest = readXml.testInvalidaccountNumberRequest(authRequest);
		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given().given().auth().basic("migrationtool", "amt123").and()
				.contentType("application/xml").body(authRequest);
		Response response = httpRequest.request(Method.POST);
		actualResponseBody = response.getBody().asString();
		actualStatusCode = response.getStatusCode();
		Assert.assertEquals(actualStatusCode, expectedStatusCode, "Status Code mismatch");
		Assert.assertEquals(actualResponseBody, expectedAuthFailedResponse, "Response mismatch");
	}

}
