package com.ijmeet.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".\\src\\test\\resources\\Features", glue = { "com.ijmeet.stepdefinitions"} ,
				tags = {"@SmokeTest" }, monochrome = true, 
				plugin = { "pretty", "junit:target/JunitReports/report.xml",
						"json:target/JsonReports/report.json", 
						"html:target/HtmlReports/report.html" })
		public class SuitRunner {

}


