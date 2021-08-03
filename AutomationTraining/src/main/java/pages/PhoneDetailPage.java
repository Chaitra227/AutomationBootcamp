package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class PhoneDetailPage extends CommonPage {
	public WebDriver driver;
	
	public PhoneDetailPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[text()='View Product Features']")   WebElement PDPPageValidation;
	@FindBy(xpath="//span[contains(text(),'  Pay the full price to own the device today.')]")  WebElement SRPContractTerm;
	@FindBy(xpath="//label[@for='payment_option_0-yr-ib-30months']") WebElement IBContractTerm;
//	@FindBy(xpath="//input[@value='0-yr-ib-30months']/parent::div/descendant::strong[text()=' 30-Month Financing']")   WebElement IBContractTerm;
	@FindBy(xpath="//button[@id='continueToProtection']")   WebElement PDPButton;
	
	public void selectSRPContract() {
		eWaitVisibility(PDPPageValidation);
		jsClick(SRPContractTerm);
		Reporter.log("Selected SRP contract term from PDP", true);
	}
	
	public void selectIBContract() {
		scroll();
		eWaitVisibility(PDPPageValidation);
		jsElementHighlight(IBContractTerm);
		IBContractTerm.click();
		Reporter.log("Selected IB contract term from PDP", true);
	}
	
	public void clickButtonInPDP() {
		eWaitVisibility(PDPButton);
		//jsClick(PDPButton);
		jsElementHighlight(PDPButton);
		PDPButton.click();
		Reporter.log("Selected Continue Button from PDP Page", true);

	}
}
