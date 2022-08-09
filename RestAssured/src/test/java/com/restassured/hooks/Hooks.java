package com.restassured.hooks;

import org.testng.Reporter;

import com.restassured.runner.Baseclass;

import io.cucumber.core.logging.Logger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends Baseclass {

	@Before
	public void setup(Scenario scenario) {
		
		ScenarioName=scenario.getName();
		Reporter.log("*****************Test Scenario is********************"+ScenarioName, true);

		
	}

	@After
	public void tearDown(Scenario scenario) {
		ScenarioName = scenario.getName();

		try {
			boolean Result = scenario.isFailed();
			if (Result == false) {
				Reporter.log("Test Case status is:" + "Passed",true);
			} else {
				Reporter.log("Test Case status is:" + "Failed",true);
			}

		} catch (Exception e) {
			Reporter.log("ERROR:" + "Exception at Hooks @After",true);
			e.printStackTrace();
			throw e;

		}
		Reporter.log("******************* End Test ****************"+ScenarioName,true);

	}

}
