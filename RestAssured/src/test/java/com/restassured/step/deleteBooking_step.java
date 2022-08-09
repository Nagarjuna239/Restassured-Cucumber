package com.restassured.step;

import static io.restassured.RestAssured.given;

import org.testng.Reporter;

import com.restassured.runner.Baseclass;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class deleteBooking_step extends Baseclass{
	
	
	@When("User prepares a Delete request to perform the create Booking with the parameters:{string},{string}")
	public void user_prepares_a_delete_request_to_perform_the_create_booking_with_the_parameters(String TestcaseName,String URL) {
	    try {
			RestAssured.baseURI=URL;
			Reporter.log("Test case name is:"+TestcaseName, true);
			gRequest = given().contentType("application/json").header("Cookie","token="+AccessToken);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
