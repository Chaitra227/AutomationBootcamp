package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;


public class ESignPage {
	public WebDriver driver;
	
	public ESignPage(WebDriver driver) {		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='txtOrder']")  WebElement OrderIDInput;
	@FindBy(xpath="//span[text()='Next']")   WebElement NextBtn;
	
	public void titleCheck() {
		String eSignTitle= driver.getTitle();
		Assert.assertEquals(eSignTitle, "eSign order | Sprint");
		Reporter.log("Verifying eSign Page title", true);

	}
	
	public void enterOrderID(String orderkey) {
		OrderIDInput.sendKeys(orderkey);
		NextBtn.click();
		Reporter.log("Sent eSign Order ID successfully", true);

	}
	
	
	
}
