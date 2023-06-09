package stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.factory.DriverFactory;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.StartPage;

import AppHooks.ApplicationHooks;

import com.pages.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Home_SD {
	private HomePage homePage = HomePage.getInstance(DriverFactory.getDriver());
	//private HomePage homePage = new HomePage(DriverFactory.getDriver());
	private StartPage startPage = new StartPage(DriverFactory.getDriver());
	private RegisterPage registerPage= new RegisterPage(DriverFactory.getDriver());
	private static final Logger LOGGER=LogManager.getLogger(Home_SD.class);


	@Given("The user opens DS Algo portal link")
	public void the_user_opens_ds_algo_portal_link() {
		LOGGER.info("User opens the first portal Page");
		System.out.println("User opens the first portal Page");
		startPage.getdsalgopageurl();

	}

	@When("The user clicks the {string} button")
	public void the_user_clicks_the_button(String string) {
		LOGGER.info("User click on the get started button in the portal page");
		startPage.StartBtnClick();
	}

	@Then("The user should be redirected to homepage")
	public void the_user_should_be_redirected_to_homepage() {
		LOGGER.info("****User redirected to home page from portal page******");
		String expectedUrl = homePage.verifyHomePageURL();
		String actualUrl = DriverFactory.getDriver().getCurrentUrl();
		assertEquals(actualUrl, expectedUrl, "User is redirected to home Page correctly ");
	}

	@Given("The user is on Home page")
	public void the_user_is_on_home_page() {
		LOGGER.info("User is landed on Home Page and check the title");
		// DriverFactory.getDriver().get("https://example.com/homepage");
		homePage.gethomepageurl();
		String expectedTitle = homePage.verifyHomePageURL();
		String actualTitle = DriverFactory.getDriver().getCurrentUrl();
		assertEquals(expectedTitle, actualTitle);

	}

	@When("The user clicks on Get Started link on homepage {string} without login")
	public void the_user_clicks_on_get_started_link_on_homepage_without_login(String string) {
		LOGGER.info("User clicks on get started button after landing without login ");
		homePage.getStarted_home(string);

	}

	@Then("The user get warning message {string}")
	public void the_user_get_warning_message(String warningmsg) {
		LOGGER.info("###############User gets warning page, to login first#######" +warningmsg );
		String errormsg=  homePage.getUserNotLoginMsg();
		assertEquals(warningmsg, errormsg);
	}

	@When("The user clicks on dropdown {string} without login")
	public void the_user_clicks_on_dropdown_without_login(String string) {
		LOGGER.info("User clicks on drop down without login");
		homePage.clickdropdown(string);

	}

	@Given("The user opens Home Page")
	public void the_user_opens_home_page() {
		LOGGER.info("User is on Home Page , this is to test the sign in and register links");
		// DriverFactory.getDriver().get("https://example.com/homepage");
		homePage.gethomepageurl();
	}


	@When("The user clicks {string}")
	public void the_user_clicks(String linkclick) {
		LOGGER.info("User clicks on Sign in link from Home Page");
		if (linkclick.equalsIgnoreCase("Sign in")) {
			homePage.clickOnSignLink();
		} else if (linkclick.equalsIgnoreCase("Register")) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			homePage.clickOnRegisterLink();
			
		} else if (linkclick.equalsIgnoreCase("Sign out"))
		{
			homePage.clickonSignOutLink();
		}else {
			throw new IllegalArgumentException("Invalid button name: " + linkclick);
		}

		

	}

	@Then("The user should be redirected to Sign in page")
	public void the_user_should_be_redirected_to_sign_in_page() {
		LOGGER.info("User redirected to sign in page from Home Page");
		String expectedTURL=homePage.verifySigninPageURL();
		String actualURL=DriverFactory.getDriver().getCurrentUrl();
		assertTrue(actualURL.contains(expectedTURL));
	}


	@Then("The user should be redirected to Register form")
	public void the_user_should_be_redirected_to_register_form() {
		LOGGER.info("User is on register Page from Home Page");
		String expectedTURL=registerPage.validateRegisterPageURL();
		String actualURL=DriverFactory.getDriver().getCurrentUrl();
		assertTrue(actualURL.contains(expectedTURL));
		
	}
}