package pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class EsignContractPage extends CommonPage {
	WebDriver driver;
	
	public EsignContractPage(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='chkElectronical']")  WebElement eTerms;
	@FindBy(xpath="//*[@id='chkWirelessTerms']")  WebElement wirelessTerms;
	@FindBy(xpath="//*[@id='chkPdfAgreement_lease']")  WebElement deviceTerms;
	@FindBy(xpath="//*[@id='contract0']")  WebElement devicepdf;
	@FindBy(xpath="//*[text()='Finish and submit']")  WebElement SubmitBtn;
	
	public void contractPageTitle() {
		String ContractTitle=driver.getTitle();
		Assert.assertEquals(ContractTitle, "Sign IB Contract");
	}
	
	public void acceptingTerms() {		
		eTerms.click();
		wirelessTerms.click();
		deviceTerms.click();
		devicepdf.click();
		switchWindow();
		eWaitClickable(SubmitBtn);
		//SubmitBtn.click();
		Reporter.log("Accepted eAgreement in eSign flow", true);

	}
	
	public void switchWindow() {
		String parentwin=driver.getWindowHandle();
		Set<String> handles=driver.getWindowHandles();
		for(String childwin:handles){
			if(!childwin.equalsIgnoreCase(parentwin)) {
				driver.switchTo().window(parentwin);
				Reporter.log("Switched to parent window", true);
			}
		}
	}

}
