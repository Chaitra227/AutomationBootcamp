package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class NumberSetupPage extends CommonPage {
	public WebDriver driver;
	
	public NumberSetupPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[starts-with(@id,'portInNumber-ci')]")   WebElement portInInput;
	@FindBy(xpath="//label[starts-with(@for,'port-in-radio-ci')]")  WebElement LCA;
//	@FindBy(xpath="//button[@value='DEVICE_FINANCING' and @type='button']")  WebElement ContinueBtn;
	@FindBy(xpath="//button[@value='DELIVERY_PAYMENTS']/preceding::button[1]") WebElement ContinueBtn;
	
	public void titleCheck() {
		String NumberTitle=driver.getTitle();
		Assert.assertEquals(NumberTitle, "Checkout");
	}
	
	public void portIn(String portNum) {
		portInInput.sendKeys(portNum);
		eWaitVisibility(ContinueBtn);	
		Reporter.log("Selected Portin in Number setup page", true);

	}
	
	public void selectLCA() {
		eWaitVisibility(LCA);
		LCA.click();
		Reporter.log("Selected LCA in Number setup page", true);

	}
	
	public void continueBtn() {
		eWaitClickable(ContinueBtn);
		ContinueBtn.click();
		Reporter.log("Clicked on Continue Button in Number Setup Page", true);

	}

}
