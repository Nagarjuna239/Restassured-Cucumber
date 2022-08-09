package com.restassured.step;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.Reporter;

import com.restassured.runner.Baseclass;
import com.restassured.utilities.GenericMethods;

import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class partialUpdateBooking_step extends Baseclass {
	@When("User prepares a Patch request to perform the create Booking with the parameters:{string},{string},{string},{string}")
	public void user_prepares_a_patch_request_to_perform_the_create_booking_with_the_parameters(String TestcaseName,
			String URL, String firstname, String lastname) {

		try {
			RestAssured.baseURI = URL;

			Reporter.log("Test case name:"+TestcaseName, true);

			Map<String, Object> body = new HashMap<>();

			body.put("firstname", firstname);
			body.put("lastname", lastname);

			gRequest = given().contentType("application/json").header("Cookie", "token=" + AccessToken).body(body);
			GenericMethods.cucumberReporterwrite("INFO" + "Request to Create Booking Service:" + gRequest.log().all());
			Reporter.log("INFO" + "@Given:Successful", true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
