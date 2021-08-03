package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class CPLandingPage {
	WebDriver driver;
	WebDriverWait wt;
	
	public CPLandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Add New Device')]")   WebElement GA;
	@FindBy(xpath="//span[text()='My Account']") WebElement MyAccountLink;
	@FindBy(xpath="//a[contains(text(),'Change Plan')]")  WebElement CP;
	@FindBy(xpath="//div[@class='col-xs-12 col-sm-variable my-20']/button") WebElement ContinueButton;
	
	public void selectAAL() {
		GA.click();	
		Reporter.log("Selected AAL from popup", true);
	}
	
	public void cpSelection() {
		MyAccountLink.click();
		CP.click();
		wt=new WebDriverWait(driver,30);
		wt.until(ExpectedConditions.visibilityOf(ContinueButton));
		String CPPage=driver.getTitle();
		Assert.assertEquals(CPPage, "Change Plans");
	}

}
