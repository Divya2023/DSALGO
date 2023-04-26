package stepdefinitions;

import static org.testng.Assert.assertEquals;

import com.factory.DriverFactory;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.StackPage;
import com.pages.TryEditorPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stack_SD {
	private static String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
//	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	private HomePage homePage = HomePage.getInstance(DriverFactory.getDriver());
	private TryEditorPage tryEditorPage = new TryEditorPage(DriverFactory.getDriver());
	private StackPage stackPage = new StackPage(DriverFactory.getDriver());

@When("The user clicks the Stack item from the drop down menu")
public void the_user_clicks_the_stack_item_from_the_drop_down_menu() {
    homePage.clickdropdown("Stack");
}

@Then("The user be directed to Stack Page")
public void the_user_be_directed_to_stack_page() {
    assertEquals(DriverFactory.getDriver().getTitle(), "Stack", "StackURL not matched");
}

@Given("The user is on the Stack Page")
public void the_user_is_on_the_stack_page() {
    // Write code here that turns the phrase above into concrete actions
	stackPage.getstackPageURL();
}

@When("The user clicks Operations in Stack link on Stack page")
public void the_user_clicks_operations_in_stack_link_on_stack_page() {
    stackPage.clickOperationsinStack();
}

@Then("The user should be redirected to Operations in Stack page")
public void the_user_should_be_redirected_to_operations_in_stack_page() {
	assertEquals(DriverFactory.getDriver().getTitle(), "Operations in Stack", "StackoperationsURL not matched");
}

@Given("The user navigates to Operations in Stack page")
public void the_user_navigates_to_operations_in_stack_page() {
   stackPage.getOperationsInStackLink();
}

@When("The user clicks on Tryhere link in Operations in Stack Page")
public void the_user_clicks_on_tryhere_link_in_operations_in_stack_page() {
    // Write code here that turns the phrase above into concrete actions
    stackPage.clicktryherbtn();
}

@Given("The user in editor page and navigates to the Operations in Stack page")
public void the_user_in_editor_page_and_navigates_to_the_operations_in_stack_page() {
    stackPage.getOperationsInStackLink();
}

@When("The user clicks on Implementation link")
public void the_user_clicks_on_implementation_link() {
   stackPage.getstackImplementationPageURL();
}

@Then("The user should be redirected to Implementation page")
public void the_user_should_be_redirected_to_implementation_page() {
	 assertEquals(DriverFactory.getDriver().getTitle(), "Implementation", "implementationURL not matched");
}

@Given("The user is in Implementation page")
public void the_user_is_in_implementation_page() {
    stackPage.getstackImplementationPageURL();
}

@When("The user clicks on Tryhere link on Implementation representations page")
public void the_user_clicks_on_tryhere_link_on_implementation_representations_page() {
    stackPage.clicktryherbtn();
}


}
