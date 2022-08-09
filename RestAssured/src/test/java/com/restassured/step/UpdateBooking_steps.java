package com.restassured.step;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.Reporter;

import com.restassured.runner.Baseclass;
import com.restassured.utilities.GenericMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class UpdateBooking_steps extends Baseclass {

	@When("User prepares a Put request to perform the create Booking with the parameters:{string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void user_prepares_a_put_request_to_perform_the_create_booking_with_the_parameters(String TestcaseName,String URL,
			String firstname, String lastname, String totalprice, String depositpaid, String checkin, String checkout,
			String additionalneeds) {
		try {
			Reporter.log("INFO:" + "Scenario started at @Given");
			RestAssured.baseURI = URL;
			Reporter.log("Test case:"+TestcaseName, true);

			Boolean dp = Boolean.valueOf(depositpaid);

			Map<String, Object> bookingdates = new HashMap<>();
			bookingdates.put("checkin", checkin);
			bookingdates.put("checkout", checkout);

			Map<String, Object> body = new HashMap<>();
			body.put("firstname", firstname);
			body.put("lastname", lastname);
			body.put("totalprice", Integer.parseInt(totalprice));
			body.put("depositpaid", dp);
			body.put("bookingdates", bookingdates);
			body.put("additionalneeds", additionalneeds);
			Reporter.log("Access Token is :"+AccessToken,true);
			
			  gRequest = given().contentType("application/json").header("Cookie","token="+AccessToken).body(body);
			 			GenericMethods.cucumberReporterwrite("INFO" + "Request to Create Booking Service:" + gRequest.log().all());
			Reporter.log("INFO" + "@Given:Successful", true);
		} catch (Exception e) {
			Reporter.log("Error" + "Exception at @Given", true);
		}
	}

}
