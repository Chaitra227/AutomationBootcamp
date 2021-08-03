package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class AOSelectionFromCartPage extends CommonPage{
	WebDriver driver;
	
	public AOSelectionFromCartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[contains(text(),'Accessory')]")  WebElement AOSelect;
	@FindBy(xpath="//a[@id='accessory-item-SUPM51056']")  WebElement AppleCase;
	@FindBy(xpath="//div[@class='sprint-full-cart-tag']/p[text()='ACCESSORIES']") WebElement AOHeadingInCart;
	@FindBy(xpath="//div[@class='sprint-cart-error__item container']")   WebElement CPAOError;
	@FindBy(xpath="//div[@class='remove-package']")  WebElement EmptyBinAO;
	@FindBy(xpath="//button[@ng-reflect-ng-class='[object Object]']/span[text()='Yes, remove it']") WebElement emptyCartConfirmationButton;

	
	public void selectAccessory() {
		scroll();
		eWaitVisibility(AOSelect);
		AOSelect.click();
		AppleCase.click();
		Reporter.log("Selecting accessory", true);
	}
	
	public void cartErrorCheck() {
		eWaitVisibility(AOHeadingInCart);
		String cartErrorMsg=CPAOError.getText();
		System.out.println(cartErrorMsg);
		Assert.assertEquals(cartErrorMsg, "System does not allow change plan order mixed with other types of orders. User shall remove the other pacakges in order to proceed with plan change");
		Reporter.log("Validated CP+AO Error message in Cart Page", true);
	}
	
	public void removeAOPackage() {
		scrollbyPixel();
		EmptyBinAO.click();
		emptyCartConfirmationButton.click();
	}

}
