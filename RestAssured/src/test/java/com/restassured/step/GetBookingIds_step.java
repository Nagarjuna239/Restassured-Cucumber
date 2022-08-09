package com.restassured.step;

import static io.restassured.RestAssured.given;

import org.testng.Reporter;

import com.restassured.runner.Baseclass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GetBookingIds_step extends Baseclass {
	@Given("User prepares a Get request to perform the create Booking with the parameters:{string},{string}")
	public void user_prepares_a_get_request_to_perform_the_create_booking_with_the_parameters(String TestcaseName,String URL) {
	   
		try {
			Reporter.log("Testcase is:"+TestcaseName, true);
			RestAssured.baseURI=URL;
			gRequest = given().contentType(ContentType.JSON);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
