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

public class PlanPage extends CommonPage{
	public WebDriver driver;
	
	public PlanPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[@id='mainHeadingPlan']")   WebElement PlanPageValidation;
	//@FindBy(xpath="//button[@aria-label='Next Plan']")  WebElement planCurosal;
	@FindBy(xpath="//button[@id='navPlan']")   WebElement MoreTab;
	@FindBy(xpath="//strong[text()='Sprint Unlimited Premium']")   WebElement UnlimtitedPlan;
	@FindBy(xpath="//button[@id='continueToCart']")  WebElement AddCart;
	@FindBy(xpath="//button[@id='data-byod-plan-page-continue-button-info']")  WebElement AddtoCartBYOD;
	
	public void morePlan() {
		eWaitVisibility(PlanPageValidation);
		MoreTab.click();
		Reporter.log("Clicking on More Tab in Plan Page", true);

	}
	
	public void planSelection() {
		UnlimtitedPlan.click();
		Reporter.log("Selected Unlimited Plan from Plan page", true);
	}
	
	public void addtoCart() {
		AddCart.click();
		Reporter.log("Clicked Add to Cart Button", true);
	}
	
	public void addtoCartBYOD() {
		AddtoCartBYOD.click();
		Reporter.log("Clicked Add to Cart Button in BYOD flow", true);

	}
	
}
