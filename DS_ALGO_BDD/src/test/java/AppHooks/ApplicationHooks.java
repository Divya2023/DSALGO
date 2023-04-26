
package AppHooks;

import java.io.ByteArrayInputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
//import io.qameta.allure.Allure;



public class ApplicationHooks {
    
    private static WebDriver driver;
    private static Properties prop;
     private static final Logger LOGGER=LogManager.getLogger(ApplicationHooks.class);

    @BeforeAll
    public static void launchBrowser() {
    	LOGGER.info("Instantiation of Config Reader");
    	ConfigReader.init_prop();
        LOGGER.info("Instantiation of Driver Factory");
        //DriverFactory driverFactory = new DriverFactory();
        driver = DriverFactory.getDriver();
    }
    @Before
    public void before(Scenario scenario)
    {
    	LOGGER.info("Entering the Scenario : " +scenario.getName());
    	
    }

    @AfterAll
    public static void quitBrowser() {
        LOGGER.info("Browser quit");
        if (driver != null) {
        	 LOGGER.info("Browser Quit after testing a feature");
        	driver.quit();
        driver = null;
        }
    }
    

  /*  @Before
    public void getProperty() {
        LOGGER.info("Instantiation of Config Reader");
        ConfigReader.init_prop();
    }*/

    @After
    public void tearDown(Scenario scenario) {
        LOGGER.info("Taking Screenshot of failed test case");
        if (scenario.isFailed()) {
            // take screenshot:
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
          //  Allure.addAttachment("Myscreenshot",
				//	new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));;
        }
    }
    

   /* public static WebDriver getDriver() {
        return driver;
    }*/
}