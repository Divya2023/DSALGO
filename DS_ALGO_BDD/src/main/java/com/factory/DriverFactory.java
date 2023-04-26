package com.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.util.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
     //this class is used to initialize the driver and the driver will be initialized only for one time, so keep the driver variable in static and check if its not null->singleton 
	//keeping the driver as static, and accessing the driver using public getdriver method. 
	    private static WebDriver driver;

	    public static WebDriver getDriver() {
	        if (driver == null) {
	            String browserName = ConfigReader.getBrowser();
	            if (browserName.equalsIgnoreCase("chrome")) {
	                WebDriverManager.chromedriver().setup();
	                driver = new ChromeDriver();
	            } else if (browserName.equalsIgnoreCase("firefox")) {
	                WebDriverManager.firefoxdriver().setup();
	                driver = new FirefoxDriver();
	            }
	            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	            driver.manage().window().maximize();
	        }
	        return driver;
	    }
	   public static void quitDriver() {
	        if (driver != null) {
	            driver.quit();
	           driver = null;
	        }
	    }
}




