package com.restassured.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/com/restassured/features",glue= {"com.restassured.step","com.restassured.hooks","com.restassured.utilities"},
tags="@UpdateBooking",plugin= {"pretty", "html:target/cucumber-html-report",
		"json:target/Reports/report.json","junit:target/Reports/report.xml","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},publish = true,monochrome=true,dryRun=false)

public class TestRunner {

}
