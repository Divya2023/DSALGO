package testrunners;

import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"FeatureFiles"},
		glue = {"stepdefinitions", "AppHooks"},
		tags = " ",
		monochrome=false,

		dryRun=false,
	   
		plugin = {"pretty",
				"json:target/JSONReports/report.json",
				"junit:target/JunitReports/report.xml",
				"html:target/HTMLReports/report.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
		}
		
		)  
public class MyTestRunner {

}
	
	




