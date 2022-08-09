package com.restassured.step;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.json.JSONObject;
import org.testng.Reporter;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.restassured.runner.Baseclass;
import com.restassured.utilities.GenericMethods;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;

public class CreateBooking_steps extends Baseclass {

	@Given("User prepares a Post request to perform the create Booking with the parameters:{string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void user_prepares_a_post_request_to_perform_the_create_booking_with_the_parameters(String TestcaseName,
			String URL, String firstname, String lastname, String totalprice, String depositpaid, String checkin,
			String checkout, String additionalneeds) {

		try {
			Reporter.log("*******************TestCase is:"+TestcaseName, true);
			Reporter.log("INFO:" + "Scenario started at @Given");
			RestAssured.baseURI = URL;

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

			gRequest = given().contentType("application/json").body(body);
			GenericMethods.cucumberReporterwrite("INFO" + "Request to Create Booking Service:" + gRequest.log().all());
			Reporter.log("INFO" + "@Given:Successful", true);
			/*
			 * System.out.println(gRequest.log().all());
			 */		} catch (Exception e) {
			Reporter.log("Error" + "Exception at @Given", true);
		}

	}

}
