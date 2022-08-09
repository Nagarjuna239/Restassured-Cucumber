package com.restassured.utilities;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.testng.Reporter;

import com.restassured.runner.Baseclass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class GenericMethods extends Baseclass {
	

	@Given("Generate AccessToken:{string},{string},{string}")
	public void generate_access_token(String AuthURL, String username, String password) {
		
		RestAssured.baseURI=AuthURL;
		Map<String,Object> body = new HashMap<>();
		body.put("username", username);
		body.put("password", password);
		
		gRequest = given().contentType("application/json").body(body);
		gResponse= gRequest.post(AuthURL);
		AccessToken= gResponse.jsonPath().get("token");
		Reporter.log("Access Token is:"+AccessToken, true);
		
	}
	
	
	@When("Post is triggered to the Endpoint:{string}")
	public void post_is_triggered_to_the_endpoint(String Endpoint) {

		try {
			Reporter.log("INFO" + "@when : post request to be triggered", true);
			
			gResponse = gRequest.post(Endpoint);
			
			Reporter.log("INFO" + "@when :Successful");
				} catch (Exception e) {
			Reporter.log("ERROR" + " Exception", true);
			Reporter.log("ERROR" + "StackTrace:" + e.toString(), true);
			e.printStackTrace();
			throw e;
		}

	}

	@Then("verify the post statuscode: {string}")
	public void verify_the_statuscode(String httpstatusCode) {

		Reporter.log("INFO" + "@Then: HTTPStatus" + httpstatusCode + "to be verified", true);
		
		  Reporter.log("INFO" + "Response:" + gResponse.prettyPrint(), true);
		 		Reporter.log("Response headers are " + gResponse.headers(), true);

		int httpstatusCode1 = Integer.parseInt(httpstatusCode);
		int httpStatus = gResponse.statusCode();
		if(httpStatus==200)
		{
			bookingID = gResponse.jsonPath().get("bookingid");
			System.out.println("Booking id is :"+ bookingID);
		}
		
		AssertEquals(httpStatus, httpstatusCode1, "Assertion of HTTP Status code");
	}

	public static void cucumberReporterwrite(String writeInfo) {
		try {
			CucumberWrite = CucumberWrite + "\n" + writeInfo;
		} catch (Exception e) {

		}
	}

	@When("Get is triggered to the Endpoint:{string}")
	public void get_is_triggered_to_the_endpoint(String Endpoint) {
		try {
			Reporter.log("INFO" + "@when : get request to be triggered", true);
			gResponse = gRequest.get(Endpoint);
			Reporter.log("INFO" + "@when :Successful");
			int httpStatus = gResponse.statusCode();
			
			  Reporter.log("INFO" + "Response:" + gResponse.prettyPrint(), true);
			 		Reporter.log("Response headers are " + gResponse.headers(), true);		
			 		} catch (Exception e) {
			Reporter.log("ERROR" + " Exception", true);
			Reporter.log("ERROR" + "StackTrace:" + e.toString(), true);
			e.printStackTrace();
			throw e;
		}
	}
	@Then("verify the get statuscode: {string}")
	public void verify_the_get_statuscode(String httpstatusCode) {

		Reporter.log("INFO" + "@Then: HTTPStatus" + httpstatusCode + "to be verified", true);
	

		int httpstatusCode1 = Integer.parseInt(httpstatusCode);
		int httpStatus = gResponse.statusCode();
	
		  AssertEquals(httpStatus, httpstatusCode1, "Assertion of HTTP Status code");
	}
	
	@When("Put is triggered to the Endpoint:{string}")
	public void Put_is_triggered_to_the_endpoint(String Endpoint) {

		try {
			Reporter.log("INFO" + "@when : post request to be triggered", true);
			gResponse = gRequest.put(Endpoint);
			Reporter.log("INFO" + "@when :Successful");
				} catch (Exception e) {
			Reporter.log("ERROR" + " Exception", true);
			Reporter.log("ERROR" + "StackTrace:" + e.toString(), true);
			e.printStackTrace();
			throw e;
		}

	}
	
	@Then("verify the put statuscode: {string}")
	public void verify_the_put_statuscode(String httpstatusCode) {

		try {
			Reporter.log("INFO" + "@Then: HTTPStatus" + httpstatusCode + "to be verified", true);
			
			  Reporter.log("INFO" + "Response:" + gResponse.prettyPrint(), true);
			 		Reporter.log("Response headers are " + gResponse.headers(), true);

			int httpstatusCode1 = Integer.parseInt(httpstatusCode);
			int httpStatus = gResponse.statusCode();
			AssertEquals(httpStatus, httpstatusCode1, "Assertion of HTTP Status code");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	@When("Patch is triggered to the Endpoint:{string}")
	public void patch_is_triggered_to_the_endpoint(String Endpoint) {
		try {
			Reporter.log("INFO" + "@when : post request to be triggered", true);
			gResponse = gRequest.patch(Endpoint);
			Reporter.log("INFO" + "@when :Successful");
				} catch (Exception e) {
			Reporter.log("ERROR" + " Exception", true);
			Reporter.log("ERROR" + "StackTrace:" + e.toString(), true);
			e.printStackTrace();
			throw e;
		}
	}
	@Then("verify the patch statuscode: {string}")
	public void verify_the_patch_statuscode(String httpstatusCode) {

		try {
			Reporter.log("INFO" + "@Then: HTTPStatus" + httpstatusCode + "to be verified", true);
			
			  Reporter.log("INFO" + "Response:" + gResponse.prettyPrint(), true);
			 		Reporter.log("Response headers are " + gResponse.headers(), true);

			int httpstatusCode1 = Integer.parseInt(httpstatusCode);
			int httpStatus = gResponse.statusCode();
			AssertEquals(httpStatus, httpstatusCode1, "Assertion of HTTP Status code");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	
	@When("Delete is triggered to the Endpoint:{string}")
	public void delete_is_triggered_to_the_endpoint(String Endpoint) {
		try {
			Reporter.log("INFO" + "@when : post request to be triggered", true);
			gResponse = gRequest.delete(Endpoint);
			Reporter.log("INFO" + "@when :Successful");
				} catch (Exception e) {
			Reporter.log("ERROR" + " Exception", true);
			Reporter.log("ERROR" + "StackTrace:" + e.toString(), true);
			e.printStackTrace();
			throw e;
		}
		
		
	}
	@Then("verify the Delete statuscode and Responsemessage: {string},{string}")
	public void verify_the_delete_statuscode_and_responsemessage(String httpstatusCode, String Responsemessage) {
		
		try {
			Reporter.log("INFO" + "@Then: HTTPStatus" + httpstatusCode + "to be verified", true);
			
			  Reporter.log("INFO" + "Response:" + gResponse.prettyPrint(), true);
			 		Reporter.log("Response headers are " + gResponse.headers(), true);

			int httpstatusCode1 = Integer.parseInt(httpstatusCode);
			int httpStatus = gResponse.statusCode();
			if(httpStatus==201)
			{
				String responseMessage = gResponse.getBody().asString();
				Reporter.log("Delete Response: "+responseMessage,true);
				org.testng.Assert.assertEquals(responseMessage, Responsemessage);
			}
			
			AssertEquals(httpStatus, httpstatusCode1, "Assertion of HTTP Status code");
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	    
	}
	
	@And("verify the booking id are present:{string},{string}")
	public void verify_the_booking_id_are_present(String bookingIDpresent1, String bookingIDpresent2) {
		
		int bookingIDone = Integer.parseInt(bookingIDpresent1);
		int bookingIDTwo = Integer.parseInt(bookingIDpresent2);

		ArrayList<Integer> bookingIds = gResponse.jsonPath().get("bookingid");

		for (int bookingID : bookingIds) {
			
			 Reporter.log("All Booking id's Are : "+bookingID, true); 
				if(bookingID==bookingIDone)
				{
					Reporter.log(bookingIDone+"is present",true);
				}
				if(bookingID==bookingIDTwo)
				{
					Reporter.log(bookingIDTwo+"is present",true);
				}
		}
	}
	
	
}
