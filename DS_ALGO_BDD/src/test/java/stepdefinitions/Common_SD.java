package stepdefinitions;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.factory.DriverFactory;
import com.pages.DataStructure_Page;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.util.Loggerload;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Common_SD {
	private static String title;
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private HomePage homePage = HomePage.getInstance(DriverFactory.getDriver());
//	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	

	@Given("The user is on Signin page of DS Algo portal")
	public void the_user_is_on_signin_page_of_ds_algo_portal() {
		//startPage.getdsalgopageurl();
		//startPage.StartBtnClick();
	   // homePage.clickOnSignLink();
		Loggerload.info("User sign in on Login Page");
	    loginPage.getLoginPage();
		
		 
	}

	@When("The user enter valid {string} and {string}")
	public void the_user_enter_valid_and(String string, String string2) {
		Loggerload.info("User enter credentials on Login Page");
		loginPage.enterCredentials(string, string2);
	}

	@When("The user click on login button")
	public void the_user_click_on_login_button() {
		Loggerload.info("User clicks login button");
		loginPage.doLogin();

}

	@Then("The user redirected to homepage")
	public void the_user_redirected_to_homepage()
	{ 
		Loggerload.info("User redirected to home Page after successful login");
     String HomePageTitle= homePage.getPageTitle();
		assertEquals(HomePageTitle, "NumpyNinja");
		//DriverFactory.quitDriver();
}
}
