package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.factory.DriverFactory;
import com.util.ConfigReader;


	public class DataStructure_Page {
		private WebDriver driver;
		private WebDriverWait wait;

		
			
		@FindBy (xpath="//a[@href='data-structures-introduction']")WebElement dataStrucIntroLink;
		@FindBy (xpath="//a[@href='time-complexity']")WebElement timeComplexitylink;
		@FindBy(linkText = "Try here>>>")
		WebElement TryHere;		
			
			@FindBy(xpath ="//button[text()='Run']")
			WebElement runBtn;
			
			String dsIntroURL=ConfigReader.getDSIntroPageurl();
			String timecomplexityURL=ConfigReader.getTimeComplexityPageurl();
			public DataStructure_Page (WebDriver driver) {
				this.driver =driver;
				PageFactory.initElements(driver, this);
			}

			public void getStarted_DS() {

				//Loggerload.info("click " + dataStrucIntroLink.getText() + " link on home page");
				dataStrucIntroLink.click();
			}

			public String getPageTitle() {
				String title = driver.getTitle();
				return title;
			}

			public void clickOnTimeComplexitylink() {
				timeComplexitylink.click();

			}
			public void clickon_Try_Here()
			{
				TryHere.click();
				//return new TryEditorPage( driver);
			}
			public void clickon_Run()
			{
				runBtn.click();
			}
			public void navigatetointroPage()
			{
				driver.get(dsIntroURL);
				
			}
			public void navigatetotimecomplexityPage()
			{
				driver.get(timecomplexityURL);
				
			}
	}
			


