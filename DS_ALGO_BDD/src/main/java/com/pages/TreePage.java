package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.util.ConfigReader;
import com.util.Loggerload;

public class TreePage {
	private WebDriver driver;
	private ConfigReader cg;    
	
	public TreePage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//*[@href='overview-of-trees']")
	WebElement overviewOfTreesLink;
	@FindBy(linkText ="Binary Trees")
	WebElement BinaryTreeLink;
	@FindBy(linkText ="Try here>>>")
	WebElement TryhereLink;
	
	String TreePage_URL = ConfigReader.getTreepageURL();
	String OverviewTreePage_URL = ConfigReader.getOverviewTreepageURL();
	String BinaryTreePage_URL = ConfigReader.getBinaryTreepageURL();
	
	public String getTreePageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public void clickOnoverviewOfTreesPage() {
		Loggerload.info("click " + overviewOfTreesLink.getText() + " On Trees page");
		overviewOfTreesLink.click();
		Loggerload.info(" Title of the page " + driver.getTitle());
	}
	
	public void clickOnBinaryTreesPage() {
		Loggerload.info("click " + BinaryTreeLink.getText() + " On Trees page");
		BinaryTreeLink.click();
		Loggerload.info(" Title of the page " + driver.getTitle());
	}
	public void clickOnTryhere() {
		Loggerload.info("click " + TryhereLink.getText() + " On Trees page");
		TryhereLink.click();
		Loggerload.info(" Title of the page " + driver.getTitle());
	}
	public void getTreePageURL()
	{
		driver.get(TreePage_URL);
	}
	public void getOverviewTreePageURL()
	{
		driver.get(OverviewTreePage_URL);
	}
	public void getBinaryTreePageURL()
	{
		driver.get(BinaryTreePage_URL);
	}



}
