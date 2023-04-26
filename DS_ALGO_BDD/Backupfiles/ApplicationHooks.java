
package AppHooks;

import java.io.ByteArrayInputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;


public class ApplicationHooks {
    private static DriverFactory driverFactory;
    private static WebDriver driver;
    private ConfigReader configReader;
    private static Properties prop;
    private static boolean isBrowserInitialized  = false;
    private static final Logger LOGGER=LogManager.getLogger(ApplicationHooks.class);

    public static synchronized DriverFactory getDriverFactory() {
        if (driverFactory == null) {
            driverFactory = new DriverFactory();
        }
        return driverFactory;
    }

    @Before(order = 0)
    public void getProperty() {
        LOGGER.info("Instantiation of Config Reader");
        ConfigReader.init_prop();
    }

    @Before(order = 1)
    public void launchBrowser() {
        LOGGER.info("Instantiation of Driver Factory");
        if (driver == null) {
            driver = getDriverFactory().getDriver();
        }
    }

    @After(order = 0)
    public void quitBrowser() {
        LOGGER.info("Browser quit");
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        LOGGER.info("Taking Screenshot of failed test case");
        if (scenario.isFailed()) {
            // take screenshot:
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
    }

    public static Properties getProp() {
        return prop;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}