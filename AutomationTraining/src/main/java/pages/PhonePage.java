package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import base.InitializeBrowser;

public class PhonePage extends CommonPage{
	WebDriver driver;
	public Actions action;
	
	public PhonePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Add New Device')]")   WebElement GA;
	@FindBy(xpath="//a[contains(text(),'Upgrade Current Device')]") WebElement UPG;
	@FindBy(xpath="//a[contains(text(),'Bring Your Own Device')]") WebElement BYOD;
	@FindBy(xpath="//span[@class='sprint-menu-item-name display-flex']/a[contains(text(),' Devices')]")  WebElement DevicesTopNav;
	@FindBy(xpath="//ul[@class='sprint-menu__submenu-children new-submenu-children']/descendant::li/a[contains(text(),'Tablets')]")  WebElement TabletLink;
	@FindBy(xpath="//a[@title=' New iPad Pro 11-inch']/descendant::strong[text()='View device']")  WebElement TabletDevice;
	@FindBy(xpath="//li[@data-sku='141300249']")  WebElement Apple12Pro;
	
	public void selectAAL() {
		GA.click();	
		Reporter.log("Selecting AAL from popup", true);
	}
	
	public void selectUPG() {
		jsElementHighlight(UPG);
		UPG.click();
		Reporter.log("Selecting Upgrade from popup", true);

	}
	
	public void selectBYOD() {
		BYOD.click();
		Reporter.log("Selecting BYOD from popup", true);

	}
	
	public void topNav() {
		action=new Actions(driver);
		action.moveToElement(DevicesTopNav).build().perform();
		Reporter.log("Mouse Hover on Devices Menu in Top Nav Bar", true);
	}
	
	public void tabletSelection() {	
		eWaitClickable(TabletLink);
		TabletLink.click();
		scroll();
		Reporter.log("Selecting Tablets from Devices Menu", true);

	}
	
	public void selectTablet() {
		eWaitVisibility(TabletDevice);
		scrolltoView(TabletDevice);
		TabletDevice.click();
		Reporter.log("Selected Tablet from Device Page", true);
	}
	
	public void selectiPh12Pro() {
		jsElementHighlight(Apple12Pro);
		Apple12Pro.click();
		Reporter.log("Selected iPhone12 Pro from Device Page", true);
	}

}
