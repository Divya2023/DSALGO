package stepdefinitions;



import static org.testng.Assert.assertEquals;

import java.util.List;

import com.factory.DriverFactory;
import com.pages.ArrayPage;
import com.pages.DataStructure_Page;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.RegisterPage;
import com.pages.StartPage;
import com.pages.TryEditorPage;
import com.util.CodeReader;
import com.util.ConfigReader;
import com.util.Loggerload;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Array_SD {
	private static String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private HomePage homePage = HomePage.getInstance(DriverFactory.getDriver());
	//private HomePage homePage = new HomePage(DriverFactory.getDriver());
	//private RegisterPage registerPage = new RegisterPage(DriverFactory.getDriver());
    //private DataStructure_Page DSPage = new DataStructure_Page(DriverFactory.getDriver());
	private TryEditorPage tryEditorPage = new TryEditorPage(DriverFactory.getDriver());
	//private StartPage startPage = new StartPage(DriverFactory.getDriver());
	private ArrayPage arrayPage= new ArrayPage(DriverFactory.getDriver());


	@When("The user selecting Arrays from the drop down menu")
	public void the_user_selecting_arrays_from_the_drop_down_menu() {
		Loggerload.info("User selects Array from drop down");
		homePage.clickdropdown("Arrays");
	}


	@Then("The user should be directed to {string} Page")
	public void the_user_should_be_directed_to_page(String string) {
		Loggerload.info("User enters Array Page");
		String actual_url=DriverFactory.getDriver().getCurrentUrl();
		String expectedurl=ConfigReader.getArrayPageURL();
		assertEquals(actual_url, expectedurl, "Array Page is not displayed");
		Loggerload.error("Assertion error");
	}


	@Given("The user is on the Array page after logged in")
	public void the_user_is_on_the_array_page_after_logged_in() {
		//homePage.clickdropdown("Arrays");
		arrayPage.getArrayPageURL();
	}


	



	@Given("The user is on the Arrays in Python page after logged in")
	public void the_user_is_on_the_arrays_in_python_page_after_logged_in() {
	//	homePage.clickdropdown("Arrays");    
		arrayPage.getArrayinPythonPageURL();
	}
	
	@When("The user clicks Arrays in Python button")
	public void the_user_clicks_arrays_in_python_button() {
		arrayPage.clickon_arraysinpython_link();
	}
	@Then("The user should be directed to ArraysinPython")
	public void the_user_should_be_directed_to_arraysin_python() {
		String ArrayinPythonPageURL=ConfigReader.getArrayinPythonPageURL();
		String ExpectedURL=DriverFactory.getDriver().getCurrentUrl();
		assertEquals(ArrayinPythonPageURL, ExpectedURL, "ArrrayPageURL not matched");
	}

	@When("The user clicks Try Here button on Arrays in Python page")
	public void the_user_clicks_try_here_button_on_arrays_in_python_page() {
		arrayPage.clickon_Try_Here();
	}
	

		@Given("The user is on the Arrays Using List page after logged in")
		public void the_user_is_on_the_arrays_using_list_page_after_logged_in() {
		    arrayPage.getArrayusingListPageURL();
		}


		@When("The user clicks Try Here button on the Arrays Using List page")
		public void the_user_clicks_try_here_button_on_the_arrays_using_list_page() {
		   arrayPage.clickon_Try_Here();
		}

		@When("The user clicks Arrays Using List link")
		public void the_user_clicks_arrays_using_list_link() {
			//homePage.clickdropdown("Arrays");
			arrayPage.clickon_ArraysUsingList_link();
		}


	

		@Then("The user should be redirected to Arrays Using List page")
		public void the_user_should_be_redirected_to_arrays_using_list_page() {
			String ExpectedURL=ConfigReader.getArraysusingListpageurl();
			String ActualURL=DriverFactory.getDriver().getCurrentUrl();
			assertEquals(ActualURL, ExpectedURL, "Arraysusinglist URL not matched");
		}




	@When("The user clicks Practice Questions link")
	public void the_user_clicks_practice_questions_link() {
		arrayPage.clickPracticeQue();
	}
	@Then("The user should be redirected to Practice page")
	public void the_user_should_be_redirected_to_practice_page() {
		 String Title = arrayPage.getArrayPageTitle();
		  assertEquals(Title, "Practice Questions", "Title do not match");
	}


	@Given("The user is on the Practice page after logged in")
	public void the_user_is_on_the_practice_page_after_logged_in() {
		arrayPage.getpracticePageURL();
	}



	@When("The user clicks the Search the array link")
	public void the_user_clicks_the_search_the_array_link() {
		arrayPage.clickSearcharray();
	}
	@Then("The user should be redirected to question page contains an tryEditor with Run and Submit buttons")
	public void the_user_should_be_redirected_to_question_page_contains_an_try_editor_with_run_and_submit_buttons() {
		 String Title = arrayPage.getArrayPageTitle();
			assertEquals(Title, "Assessment", "Title do not match");
	}
  @When("The user enter valid python code in tryEditor from sheet {string} and {int} for the question")
	public void the_user_enter_valid_python_code_in_try_editor_from_sheet_and_for_the_question(String sheetName, Integer RowNumber) {
	  List<String> codeList = CodeReader.getPythonCodeFromSheet(sheetName, RowNumber);
		tryEditorPage.SendCodeonTextArea(codeList);
	}


	@Given("The user is on Question page of Search the array after logged in")
	public void the_user_is_on_question_page_of_search_the_array_after_logged_in() {
		arrayPage.getQuestionsearcharrayurl();
	}



	@When("The user enter invalid python code in tryEditor from sheet {string} and {int} for the question")
	public void the_user_enter_invalid_python_code_in_try_editor_from_sheet_and_for_the_question(String sheetName, Integer RowNumber) {
		 List<String> codeList = CodeReader.getPythonCodeFromSheet(sheetName, RowNumber);
			tryEditorPage.SendCodeonTextArea(codeList);
	}



















}
