package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import base.InitializeBrowser;

public class ChangePlanPage extends CommonPage {
	WebDriver driver;
	
	public ChangePlanPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='My Account']") WebElement MyAccountLink;
	@FindBy(xpath="//a[contains(text(),'Change Plan')]")  WebElement CP;
	@FindBy(xpath="//label[@for='plan-LPDSMGNTA_43525610221-0']")  WebElement selectFirstPhonetoCP;
	@FindBy(xpath="//label[@for='plan-LPDSA0574_62325610221-0']") WebElement selectSecondPhonetoCP;
	@FindBy(xpath="//div[@class='col-xs-12 col-sm-variable mb-20 mt-20 align-center']/button")   WebElement ContinueButtonMorePTNs;
	@FindBy(xpath="//div[@class='col-xs-12 col-sm-variable my-20']/button") WebElement ContinueButton;
	@FindBy(xpath="//strong[text()='Selecting a New Plan']")   WebElement NewPlanContent;
	@FindBy(xpath="//strong[text()='Unlimited Premium']")  WebElement NewPlanSelection;
	@FindBy(xpath="//button[@class='button button--minwidth-md button--full-on-mobile']")  WebElement NewPlanContinueBtn;
	@FindBy(xpath="//h2[text()='Additional Services']")  WebElement ServiceWallContent;
	@FindBy(xpath="//button[@class='button button--full-on-mobile button--minwidth-md']")  WebElement SaveBtn;
		
	public void cpSelection() {
		MyAccountLink.click();
		CP.click();
		//eWaitVisibility(ContinueButton);
//		String CPPage=driver.getTitle();
//		Assert.assertEquals(CPPage, "Change Plans");
		Reporter.log("Selceted Change Plan from My Account dropdown", true);
	}
	
	public void selectDeviceOneForCP() {
		selectFirstPhonetoCP.click();
		eWaitClickable(ContinueButtonMorePTNs);
		ContinueButtonMorePTNs.click();
		Reporter.log("Selecting first device to perform CP", true);
	}
	
	public void selectDeviceTwoForCP() {
		selectSecondPhonetoCP.click();
		eWaitClickable(ContinueButtonMorePTNs);
		ContinueButtonMorePTNs.click();
		Reporter.log("Selecting second device to perform CP+CP", true);
	}
	
	public void cpCurrentPlanPage() {
		eWaitClickable(ContinueButton);
		ContinueButton.click();
	}
	
	public void cpNewPlan() {
		eWaitVisibility(NewPlanContent);
		NewPlanSelection.click();
		NewPlanContinueBtn.click();	
		Reporter.log("Selected the New Plan for CP", true);
	}
	
	public void selectContinueinNewPlanPage() {
		NewPlanContinueBtn.click();	
	}
	
	public void serviceWall() {
		eWaitVisibility(ServiceWallContent);
		SaveBtn.click();
		Reporter.log("Proceeding from Service page", true);
	}
	
}
