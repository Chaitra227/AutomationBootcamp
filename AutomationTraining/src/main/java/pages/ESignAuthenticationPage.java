package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ESignAuthenticationPage extends CommonPage{
	
	public ESignAuthenticationPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h3[text()='Account verification']")  WebElement PageContent;
	@FindBy(xpath="//input[@id='radKnowPin']")  WebElement pinRadioBtn;
	@FindBy(xpath="//*[@id='txtKnowBillingZip']")  WebElement zipcode;
	@FindBy(xpath="//*[@id='txtPIN']")  WebElement pin;
	@FindBy(xpath="//span[text()='Next']")   WebElement NextBtn;
	
	public void testPageVisibility() {
		eWaitVisibility(PageContent);
	}
	
	public void pinDetails(String zip, String passcode) {
		pinRadioBtn.click();
		zipcode.sendKeys(zip);
		pin.sendKeys(passcode);
		NextBtn.click();
		Reporter.log("Sent zipcode & pin in eSign flow", true);

	}

}
