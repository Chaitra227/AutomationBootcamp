package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import base.InitializeBrowser;

public class ProtectionPage extends CommonPage {
	public WebDriver driver;
	
	public ProtectionPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//strong[text()='Choose Protection']")   WebElement ProtectionPageValidation;
	@FindBy(xpath="//img[@alt='Sprint Complete']")   WebElement ProtecSelection;
	@FindBy(xpath="//label[@for='protection_opt_out']")   WebElement NoThanks;
	@FindBy(xpath="//div[@id='sprint-modal-newtep-description']/descendant::button[@id='cancelProtection']") WebElement DeclineProtection;
	@FindBy(xpath="//div[@class='protection-tnt-addtocart pdp-sticky-readout__btn']/descendant::button[text()='Continue']")
	WebElement ProtectSOCButton;
	@FindBy(xpath="//div[@class='protection-tnt-addtocart pdp-sticky-readout__btn']/button")  WebElement AddtoCartUPG;
	@FindBy(xpath="//button[@id='data-byod-protection-page-continue-button-info']")  WebElement ContinueButtonBYOD;
	
	public void protectionSOC_Select() {
		eWaitVisibility(ProtectionPageValidation);
		ProtecSelection.click();
		Reporter.log("Protection Service is selected", true);
	}
	
	public void noThanksSelection() {
		eWaitVisibility(NoThanks);
		NoThanks.click();
		DeclineProtection.click();
		Reporter.log("Declined protection", true);

	}
	
	public void protectSOCButton() {
		ProtectSOCButton.click();
	}
	
	public void UPGAddtoCartBtn() {
		jsElementHighlight(AddtoCartUPG);
		AddtoCartUPG.click();
		Reporter.log("Add to cart button click in Upgrade flow", true);

	}
	
	public void BYODContinueButton() {
		ContinueButtonBYOD.click();
	}
}
