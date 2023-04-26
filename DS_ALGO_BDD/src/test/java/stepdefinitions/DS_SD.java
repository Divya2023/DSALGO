package stepdefinitions;

import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import com.factory.DriverFactory;
import com.pages.DataStructure_Page;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.RegisterPage;
import com.pages.StartPage;
import com.pages.TryEditorPage;
import com.util.CodeReader;
import com.util.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DS_SD {
	private static String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private HomePage homePage = HomePage.getInstance(DriverFactory.getDriver());
	//private HomePage homePage = new HomePage(DriverFactory.getDriver());
	private TryEditorPage tryEditorPage = new TryEditorPage(DriverFactory.getDriver());
	private DataStructure_Page DSPage = new DataStructure_Page(DriverFactory.getDriver());

	
	/*@Given("The user is on Signin page of DS Algo portal")
	public void the_user_is_on_signin_page_of_ds_algo_portal() {
		//startPage.getdsalgopageurl();
		//startPage.StartBtnClick();
	   // homePage.clickOnSignLink();
	    loginPage.getLoginPage();
		
		 
	}

	@When("The user enter valid {string} and {string}")
	public void the_user_enter_valid_and(String string, String string2) {
		loginPage.enterCredentials(string, string2);
	}

	@When("The user click on login button")
	public void the_user_click_on_login_button() {
		loginPage.doLogin();
	}*/

	

	@Given("The user is on the home page after logged in")
		public void the_user_is_on_the_home_page_after_logged_in() {
		
			//startPage.StartBtnClick();
		    homePage.gethomepageurl();
		}

	@When("The user clicks the {string} button in Data Structure Page introduction Panel")
	public void the_user_clicks_the_button_in_data_structure_page_introduction_panel(String string) {
		Loggerload.info("User clicks on Data structures portal" );
		homePage.clickongetstart_DS();
	}

	@Then("The user be directed to {string} page")
	public void the_user_be_directed_to_page(String string) {
	   String title= DriverFactory.getDriver().getTitle();
	   assertEquals(title, "Data Structures-Introduction");
	}

	@Given("The user is on the Data Structures Introduction after logged in")
	public void the_user_is_on_the_data_structures_introduction_after_logged_in() {
		DSPage.navigatetointroPage();
		String title= DriverFactory.getDriver().getTitle();
	}

	@When("The user clicks Time Complexity link")
	public void the_user_clicks_time_complexity_link() {
		
	    DSPage.clickOnTimeComplexitylink();
	}

	@Then("The user should be redirected to Time Complexity page")
	public void the_user_should_be_redirected_to_time_complexity_page() {
		String title= DriverFactory.getDriver().getTitle();
		   assertEquals(title, "Time Complexity");
	}

	@Given("The user is on the Time Complexity after logged in")
	public void the_user_is_on_the_time_complexity_after_logged_in() {
		String title= DriverFactory.getDriver().getTitle();
		DSPage.navigatetotimecomplexityPage();
	}

	@When("The user clicks Try Here button on Time Complexity page")
	public void the_user_clicks_try_here_button_on_time_complexity_page() {
	   DSPage.clickon_Try_Here();
	}

	@Then("The user should be redirected to a page having an tryEditor with a Run button to test")
	public void the_user_should_be_redirected_to_a_page_having_an_try_editor_with_a_run_button_to_test() {
		String title= DriverFactory.getDriver().getTitle();
		   assertEquals(title, "Assessment");
	}

	@Given("The user is in a page having an tryEditor with a Run button to test")
	public void the_user_is_in_a_page_having_an_try_editor_with_a_run_button_to_test() {
		tryEditorPage.getTotryEditorURL();
	}

	@When("The user enter valid python code in tryEditor from sheet {string} and {int}")
	public void the_user_enter_valid_python_code_in_try_editor_from_sheet_and(String Sheetname, Integer RowNumber) {
		List<String> codeList = CodeReader.getPythonCodeFromSheet(Sheetname, RowNumber);
		tryEditorPage.SendCodeonTextArea(codeList);
	}

	@When("The user clicks on run button")
	public void the_user_clicks_on_run_button() {
		DSPage.clickon_Run();
	}

	@Then("The user should be presented with Run result")
	public void the_user_should_be_presented_with_run_result() {
		assertTrue(tryEditorPage.isResultdisplayed(), "Result is not displayed");
		tryEditorPage.getResult();
		System.out.println("#######Result message######");
	}

	@When("The user enter python code with invalid syntax in tryEditor from sheet {string} and {int}")
	public void the_user_enter_python_code_with_invalid_syntax_in_try_editor_from_sheet_and(String Sheetname, Integer RowNumber) {
		List<String> codeList = CodeReader.getPythonCodeFromSheet(Sheetname, RowNumber);
		tryEditorPage.SendCodeonTextArea(codeList);
	}

	@Then("The user should be presented with error message")
	public void the_user_should_be_presented_with_error_message() {
		assertFalse(tryEditorPage.getErrorMessage().isEmpty(), "error message is empty");
		
	}


}
