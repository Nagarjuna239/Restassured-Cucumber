package com.restassured.runner;

import java.util.Map;

import org.testng.Assert;
import org.testng.Reporter;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonArray;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Baseclass {

	public static RequestSpecification gRequest;
	public static Response gResponse;
	public static String CucumberWrite;
	public static int bookingID;
	public static String AccessToken;
	public static String ScenarioName;
	
	public void AssertEquals(int Actual ,int httpStatusCode,String Phase)
	{
		try {
			Assert.assertEquals(Actual, httpStatusCode);
			Reporter.log("INFO:"+Phase+":(Successful-Expected: "+httpStatusCode+ " | Actual:"+Actual+")in "+Phase);
		} catch (Exception e) {
			Reporter.log("ERROR:"+Phase+":(Failed-Expected: "+httpStatusCode+ " | Actual:"+Actual+")in "+Phase);
			e.printStackTrace();
		}
	}
}
