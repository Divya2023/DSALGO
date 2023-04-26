package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.util.ConfigReader;

public class StartPage{

	private WebDriver driver;

	@FindBy(xpath="//button[text()='Get Started']")
	WebElement startbtn;
	
	private ConfigReader cg;
	//String App_URL = cg.init_prop().getProperty("url");
	String App_URL = ConfigReader.getApplicationUrl();

	// Initializing the Page Objects:
	public StartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public String verifyStartPageTitle(){
		return driver.getTitle();
	}

	// to load the portal page link
	public void getdsalgopageurl() {

		driver.get(App_URL);

	}

	/*public HomePage StartBtnClick() {
		// TODO Auto-generated method stub
		startbtn.click();
		return new HomePage	}*/
	public HomePage StartBtnClick() {
		// TODO Auto-generated method stub
		HomePage homePage = HomePage.getInstance(driver);
	     startbtn.click();
		return homePage;
	}


}
