package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.factory.DriverFactory;
import com.util.ConfigReader;

public class StackPage {
	WebDriver driver = DriverFactory.getDriver();
	public StackPage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	// StackPage_operationsinstack
		@FindBy(xpath = "//a[@href=\"operations-in-stack\"]")WebElement operationsInStackLink;
		@FindBy(xpath = "//a[@href=\"implementation\"]")WebElement implementationLink;
		@FindBy(xpath = "//a[@href='stack-applications']")WebElement applicationLink;
		@FindBy(xpath = "//a[@class='list-group-item list-group-item-light text-info']")WebElement practiceQuestionLink;

		@FindBy(xpath = "//a[@href='/tryEditor']")WebElement TryHereLink;
		@FindBy(xpath = "//textarea[@tabindex='0']")WebElement editorInput;
		@FindBy(xpath = "//*[@id='answer_form']/button")WebElement runButton;
		@FindBy(id = "output")WebElement output;
		

		

		String homepage = ConfigReader.getHomePageUrl();
		String stackurl = ConfigReader.getStackUrl();
		String OperationsinStackpageurl = ConfigReader.OpearationStackpageURL();
		String StackImplementationURL = ConfigReader.ImplemenationStackpageURL();
		
		public void getOperationsInStackLink() {
			driver.get(OperationsinStackpageurl);
		}

		
		public void getstackPageURL()
		{
			driver.get(stackurl);
		}
		
		public void getstackOperationPageURL()
		{
			driver.get(OperationsinStackpageurl);
		}
		public void getstackImplementationPageURL()
		{
			driver.get(StackImplementationURL);
		}
		
		public void clickOperationsinStack()
		{
			operationsInStackLink.click();
		}
		public void clickimplementationLink()
		{
			implementationLink.click();
		}

		public void clicktryherbtn()
		{
			TryHereLink.click();
		}


}
