package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class BYODEditCartPage extends CommonPage {
	WebDriver driver;
	
	public BYODEditCartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@aria-label='Edit this item']")  WebElement editCartButton;
	@FindBy(xpath="//label[@for='payment_option_PDSA574AS']")  WebElement editPlan;
	@FindBy(xpath="//button[@class='button float-right button--link']")  WebElement updateButton;
	
	public void editCart() {
		editCartButton.click();	
		Reporter.log("Clicking on Edit Cart link in cart page", true);
	}
	
	public void planSelect() {
		scroll();
		editPlan.click();
		Reporter.log("Plan updation is successfull", true);
	}
	
	public void updatePlan() {
		updateButton.click();
		Reporter.log("Clicking on Update button after editing cart items", true);
	}
}
