package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import base.InitializeBrowser;

public class DeliveryPage extends CommonPage {
	public WebDriver driver;
	
	public DeliveryPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[contains(@class, 'ng-touched') and @formcontrolname='address1']")  WebElement AddressOld;
    @FindBy(xpath="//input[starts-with(@id,'address_1')]")  WebElement Address;
    @FindBy(xpath="(//div[@class='pac-item'])[1]") WebElement addressSuggestion;
	@FindBy(xpath="//input[contains(@class,'ng-touched') and @name='zip']")  WebElement zipcode;
	@FindBy(xpath="//input[contains(@class,'ng-dirty ng-valid') and @id='city']")  WebElement City;
	@FindBy(xpath="//button[@class='button button--full-on-mobile button--minwidth-sm button--sm']") WebElement SaveShippingAddress;
	@FindBy(xpath="//input[@value='24']/parent::div/label[@for='shipping-option-0']")   WebElement FreeShipping;
	@FindBy(xpath="//label[@for='shipping-option-1']/div[1]/span") WebElement overnightShipping;
	@FindBy(xpath="//button[@class='button button--tertiary button--full-on-mobile button--minwidth-md' and text()='Continue']")  WebElement ContinueButton;
	
	
	public void shippingAdddress(String AddressName) {
		eWaitVisibility(Address);
		JavascriptExecutor jse=(JavascriptExecutor)  driver;
		jse.executeScript("arguments[0].value="+"'"+AddressName+"'", Address);
		Address.click();
//		Address.sendKeys(AddressName);
		addressSuggestion.click();
		eWaitClickable(SaveShippingAddress);
		SaveShippingAddress.click();
		Reporter.log("Sent address in Delivery Page", true);

	}
	
	public void freeShippingDelivery() {
		FreeShipping.click();
		ContinueButton.click();
		Reporter.log("Selecting Free Shipping option in Delivery Page", true);

	}
	
	public void overnightShipping() {
		overnightShipping.isSelected();
		eWaitVisibility(ContinueButton);
		jsElementHighlight(ContinueButton);
		ContinueButton.click();
		Reporter.log("Selecting Overnight Shipping option in Delivery Page", true);

	}
	
}
