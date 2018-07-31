package test.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import api.utility.ApiHelper;
import api.utility.XMLReader;
import dataProvider.ConfigApiDataProvider;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import test.ui.Base.BaseTest;

public class verifyDealerMigrationReq extends BaseTestAPI {
	private static String migrationRequest;
	private static String actualResponseBody;
	private static int actualStatusCode;
	private final int expectedStatusCode = 200;
	private static ConfigApiDataProvider config = new ConfigApiDataProvider();
	private static String expectedMigSuccessResponse = config.loadFile("dealerSuccessMigrationResponse").replace(
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>",
			"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
	private static String expectedMigFailedResponse = config.loadFile("dealerFailedMigrationResponse").replace(
			"<?xml version=\"1.0\" encoding=\"UTF-8\"?>",
			"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
	private static String uri = new ApiHelper().getBaseApiURL("dearlerMigURL");
	private static String requestXML = new ApiHelper().loadRequestXML("dealerMigrationXML");
	XMLReader readXml = new XMLReader();

	@Test(priority = 1, description = "verify SUCCESS response when api request have valid request for dealer authentication")
	public void testValidDealerRequest() {
		migrationRequest = readXml.readXMLValidDealer(requestXML);
		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given().given().auth().basic("migrationtool", "amt123").and()
				.contentType("application/xml").body(migrationRequest);
		Response response = httpRequest.request(Method.POST);
		actualResponseBody = response.getBody().asString();
		actualStatusCode = response.getStatusCode();
		Assert.assertEquals(actualStatusCode, expectedStatusCode, "Status Code mismatch");
		Assert.assertEquals(actualResponseBody, expectedMigSuccessResponse, "Response mismatch");
	}

	@Test(priority = 2, description = "verify FAILURE response when api request have invalid request with blank dealerID field")
	public void testBlankDealerRequest() {
		migrationRequest = readXml.readXMLBlankDealerRequest(requestXML);
		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given().given().auth().basic("migrationtool", "amt123").and()
				.contentType("application/xml").body(migrationRequest);
		Response response = httpRequest.request(Method.POST);
		actualResponseBody = response.getBody().asString();
		actualStatusCode = response.getStatusCode();
		Assert.assertEquals(actualStatusCode, expectedStatusCode, "Status Code mismatch");
		Assert.assertEquals(actualResponseBody, expectedMigFailedResponse, "Response mismatch");
	}

	@Test(priority = 3, description = "verify FAILURE response when api request have invalid request with blank userName field")
	public void testBlankuserNameRequest() {
		migrationRequest = readXml.readXMLBlankuserNameRequest(requestXML);
		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given().given().auth().basic("migrationtool", "amt123").and()
				.contentType("application/xml").body(migrationRequest);
		Response response = httpRequest.request(Method.POST);
		actualResponseBody = response.getBody().asString();
		actualStatusCode = response.getStatusCode();
		Assert.assertEquals(actualStatusCode, expectedStatusCode, "Status Code mismatch");
		Assert.assertEquals(actualResponseBody, expectedMigFailedResponse, "Response mismatch");
	}

	@Test(priority = 4, description = "verify FAILURE response when api request have invalid request with blank password field")
	public void testBlankpasswordRequest() {
		migrationRequest = readXml.readXMLBlankPasswordRequest(requestXML);
		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given().given().auth().basic("migrationtool", "amt123").and()
				.contentType("application/xml").body(migrationRequest);
		Response response = httpRequest.request(Method.POST);
		actualResponseBody = response.getBody().asString();
		actualStatusCode = response.getStatusCode();
		Assert.assertEquals(actualStatusCode, expectedStatusCode, "Status Code mismatch");
		Assert.assertEquals(actualResponseBody, expectedMigFailedResponse, "Response mismatch");
	}

	@Test(priority = 5, description = "verify FAILURE response when api request have invalid request with blank accountNumber field")
	public void testBlankaccountNumberRequest() {
		migrationRequest = readXml.readXMLBlankAccountNumberRequest(requestXML);
		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given().given().auth().basic("migrationtool", "amt123").and()
				.contentType("application/xml").body(migrationRequest);
		Response response = httpRequest.request(Method.POST);
		actualResponseBody = response.getBody().asString();
		actualStatusCode = response.getStatusCode();
		Assert.assertEquals(actualStatusCode, expectedStatusCode, "Status Code mismatch");
		Assert.assertEquals(actualResponseBody, expectedMigFailedResponse, "Response mismatch");
	}

	@Test(priority = 6, description = "verify FAILURE response when api request have invalid request without mandatory fields")
	public void testBlankFieldsRequest() {
		migrationRequest = readXml.testBlankFieldsRequest(requestXML);
		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given().given().auth().basic("migrationtool", "amt123").and()
				.contentType("application/xml").body(migrationRequest);
		Response response = httpRequest.request(Method.POST);
		actualResponseBody = response.getBody().asString();
		actualStatusCode = response.getStatusCode();
		Assert.assertEquals(actualStatusCode, expectedStatusCode, "Status Code mismatch");
		Assert.assertEquals(actualResponseBody, expectedMigFailedResponse, "Response mismatch");
	}

	@Test(priority = 7, description = "verify FAILURE response when api request have invalid dealerID in payload")
	public void testInvalidDealerIDRequest() {
		migrationRequest = readXml.testinvaliddealerIDRequest(requestXML);
		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given().given().auth().basic("migrationtool", "amt123").and()
				.contentType("application/xml").body(migrationRequest);
		Response response = httpRequest.request(Method.POST);
		actualResponseBody = response.getBody().asString();
		actualStatusCode = response.getStatusCode();
		Assert.assertEquals(actualStatusCode, expectedStatusCode, "Status Code mismatch");
		Assert.assertEquals(actualResponseBody, expectedMigFailedResponse, "Response mismatch");
	}

	@Test(priority = 8, description = "verify FAILURE response when api request have invalid accountNumber in payload")
	public void testInvaliaccountNumberRequest() {
		migrationRequest = readXml.testInvalidaccountNumberRequest(requestXML);
		RestAssured.baseURI = uri;
		RequestSpecification httpRequest = RestAssured.given().given().auth().basic("migrationtool", "amt123").and()
				.contentType("application/xml").body(migrationRequest);
		Response response = httpRequest.request(Method.POST);
		actualResponseBody = response.getBody().asString();
		actualStatusCode = response.getStatusCode();
		Assert.assertEquals(actualStatusCode, expectedStatusCode, "Status Code mismatch");
		Assert.assertEquals(actualResponseBody, expectedMigFailedResponse, "Response mismatch");
	}

}
