package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class PTNSelectorPage extends CommonPage {
	WebDriver driver;
	
	public PTNSelectorPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='name']")   WebElement PTNSearchBar;
	@FindBy(xpath="//a[@data-upgrade-ptn='518-253-8233']")  WebElement LoanGBPTNSelection;
	
	public void pageTitleCheck() {
	String PTNPage=driver.getTitle();
	Assert.assertEquals(PTNPage, "upgrade-step-1");
	Reporter.log("PTN Selector Page title verified", true);
	}
	
	public void sendPTNInSearchBar(String PTN) {
		jsElementHighlight(PTNSearchBar);
		PTNSearchBar.sendKeys(PTN);
		Reporter.log("Searching the PTN in search bar", true);

	}
	
	public void selectGiveBackPTN() {
		scrolltoView(LoanGBPTNSelection);
		eWaitClickable(LoanGBPTNSelection);
		LoanGBPTNSelection.click();
		Reporter.log("Loan Upgrade PTN selected", true);

	}
}
