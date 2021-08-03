package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ContractTerminationPage extends CommonPage {
	WebDriver driver;
	
	public ContractTerminationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@value='LOAN_GIVE_BACK']/parent::div/descendant::span[text()='Return it']")  WebElement LoanGB;
	@FindBy(xpath="//label[@for='upgradeResolutionOption-LOAN_PAY_OFF']")  WebElement LoanPayoff;
	@FindBy(xpath="//label[@for='upgradeResolutionOption-LEASE_PAY_OFF']")  WebElement LeasePayoff;
	@FindBy(xpath="//label[@for='upgradeResolutionOption-LEASE_TURN_IN']")  WebElement LeaseTurnIn;
	@FindBy(xpath="//div[@class='sprint-modal__content']/descendant::button[text()='I Agree']")  WebElement AcceptTerms;
	//label[@for='upgradeResolutionOption-LOAN_GIVE_BACK']
	
	public void selectLoanGB() {
		scroll();
		LoanGB.click();
		Reporter.log("Selected Loan Giveback termination option", true);
	}
	
	public void selectLeaseTurnIn() {
		scroll();
		jsElementHighlight(LeaseTurnIn);
		LeaseTurnIn.click();
		Reporter.log("Selected Lease TurnIn termination option", true);
	}
	
	public void selectLoanPayoff() {
		scroll();
		eWaitClickable(LoanPayoff);
		LoanPayoff.click();
		Reporter.log("Selected Loan Payoff termination option", true);

	}
	
	public void selectLeasePayoff() {
		scroll();
		eWaitClickable(LeasePayoff);
		LeasePayoff.click();
		Reporter.log("Selected Lease Payoff termination option", true);

	}
	
	public void acceptTurnInTerms() {
		AcceptTerms.click();
		Reporter.log("Accepted TurnIn terms in PDP Page", true);

	}

}
