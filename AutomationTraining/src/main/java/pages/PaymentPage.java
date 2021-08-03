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

import base.InitializeBrowser;

public class PaymentPage extends CommonPage {
	public WebDriver driver;
	
	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Modify Delivery']")  WebElement DeliveryEditLink;
	@FindBy(xpath="//label[@for='chkESignContentTerms']")  WebElement electronicTC;
	@FindBy(xpath="//label[@for='chkAgreePurchaseTerms']")  WebElement wirelessTC;
	@FindBy(xpath="//label[@for='chkDeviceAgreement']")  WebElement DeviceTC;
	@FindBy(xpath="//input[@id='paymentName']")  WebElement PayeeName;
	@FindBy(xpath="//input[@id='creditCardNumber']")  WebElement cardNum;
	@FindBy(xpath="//input[@id='expiration-date-input']")  WebElement expDate;
	@FindBy(xpath="//input[@id='paymentCVV']")  WebElement CVV;
	@FindBy(xpath="//button[contains(text(),'Submit Order')]")  WebElement SubmitOrder;
    @FindBy(xpath="//input[starts-with(@id,'address_1')]")  WebElement Address;
    @FindBy(xpath="(//div[@class='pac-item'])[1]") WebElement addressSuggestion;
    @FindBy(xpath="//label[@for='chkturnInForLeaseTerms']")  WebElement TurnInTerms;


	public void acceptTermswithDeviceAgree() {
		eWaitVisibility(DeliveryEditLink);
		jsElementHighlight(electronicTC);
		electronicTC.click();
		jsElementHighlight(wirelessTC);
		wirelessTC.click();
		jsElementHighlight(DeviceTC);
		DeviceTC.click();	
		scroll();
		Reporter.log("Accepted terms with Device Agreements", true);
	}
	
	public PaymentPage acceptTurnInTerms() {
		jsElementHighlight(TurnInTerms);
		TurnInTerms.click();
		return this;
	}
	
	public void acceptTermswithoutDeviceAgree() {
		eWaitVisibility(DeliveryEditLink);
		electronicTC.click();
		wirelessTC.click();	
		scroll();
		Reporter.log("Accepting terms for non IB Device", true);
	}
	
	public void existingSIMTerms() {
		electronicTC.click();
		wirelessTC.click();	
		scroll();
		Reporter.log("Accepted terms for Existing SIM", true);
	}
	
	public void cardDetails(String cardname,String cardnum,String expdate,String cvvnum) {
		jsElementHighlight(PayeeName);
		PayeeName.sendKeys(cardname);
		jsElementHighlight(cardNum);
		cardNum.sendKeys(cardnum);
		jsElementHighlight(expDate);
		expDate.sendKeys(expdate);
		jsElementHighlight(CVV);
		CVV.sendKeys(cvvnum);	
		eWaitClickable(SubmitOrder);
		Assert.assertTrue(SubmitOrder.isEnabled(), "SubmitOrder Button enabled");
		Reporter.log("Sent Card details successfully", true);
	}
	
	public void addressInPayment(String AddressName) {
		eWaitVisibility(Address);
		JavascriptExecutor jse=(JavascriptExecutor)  driver;
		jse.executeScript("arguments[0].value="+"'"+AddressName+"'", Address);
		Address.click();
		addressSuggestion.click();
		Reporter.log("Sent address in payment page", true);
	}
	
	public void orderPlacement() {
		SubmitOrder.click();
		Reporter.log("Clicked on Submit Order Button", true);
	}


}
