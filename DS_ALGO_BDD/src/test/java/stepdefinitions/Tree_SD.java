package stepdefinitions;

import static org.testng.Assert.assertEquals;

import com.factory.DriverFactory;
import com.pages.HomePage;
import com.pages.TreePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.util.Loggerload;

public class Tree_SD {
	private HomePage homePage = HomePage.getInstance(DriverFactory.getDriver());
	private TreePage treePage= new TreePage(DriverFactory.getDriver());
	
	@When("The user clicks the Tree item from the drop down menu")
	public void the_user_clicks_the_tree_item_from_the_drop_down_menu() {
		Loggerload.info("User clicks Tree dropdown");
	    homePage.clickdropdown("Tree");
	}

	@Then("The user be directed to Tree Page")
	public void the_user_be_directed_to_tree_page() {
		Loggerload.info("User checks Tree Title");
	    assertEquals(DriverFactory.getDriver().getTitle(),"Tree","Tree Page Titile not Matched" );
	}

	@Given("The user is on the Tree Page")
	public void the_user_is_on_the_tree_page() {
		Loggerload.info("User is in TreePage");
	   treePage.getTreePageURL();
	}

	@When("The user clicks Overview of Trees link on Tree page")
	public void the_user_clicks_overview_of_trees_link_on_tree_page() {
	   treePage.clickOnoverviewOfTreesPage();
	}

	@Then("The user should be redirected to Operations in Tree page")
	public void the_user_should_be_redirected_to_operations_in_tree_page() {
		 assertEquals(DriverFactory.getDriver().getTitle(),"Overview of Trees","Overview-Tree Page Titile not Matched" );
	}

	@Given("The user navigates to overview of Tress in Tree page")
	public void the_user_navigates_to_overview_of_tress_in_tree_page() {
	   treePage.getOverviewTreePageURL();
	}

	@When("The user clicks on Tryhere link in Operations in Tree Page")
	public void the_user_clicks_on_tryhere_link_in_operations_in_tree_page() {
	    treePage.clickOnTryhere();
	}

	@Given("The user in editor page and navigates to the Overview of Trees in Tree page")
	public void the_user_in_editor_page_and_navigates_to_the_overview_of_trees_in_tree_page() {
	    treePage.getOverviewTreePageURL();
	}

	@Given("The user is in Binary Tree page")
	public void the_user_is_in_binary_tree_page() {
		Loggerload.info("User is in Binary TreePage");
		   treePage.getBinaryTreePageURL();
	}




	@When("The user clicks on Binary Trees link")
	public void the_user_clicks_on_binary_trees_link() {
	   treePage.clickOnBinaryTreesPage();
	}

	@Then("The user should be redirected to Binary Tree page")
	public void the_user_should_be_redirected_to_binary_tree_page() {
		 assertEquals(DriverFactory.getDriver().getTitle(),"Binary Trees","Binary Tree Page Titile not Matched" );
	}

	@When("The user clicks on Tryhere link on Binary Tree page")
	public void the_user_clicks_on_tryhere_link_on_binary_tree_page() {
	    treePage.clickOnTryhere();
	}


}
