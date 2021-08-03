package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import base.InitializeBrowser;

public class LoginPage extends CommonPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//p[text()='Sign In']")    WebElement SignInLink;
	@FindBy(xpath="//div[@class='spcmp-header__main']/following-sibling::div/descendant::span[@title='Sign In']")  WebElement SignInAfterSignout;
	@FindBy(xpath="//a[text()='My Account']")  WebElement MyAccountLink;
	@FindBy(xpath="//div[@class='spcmp-cta spcmp-cta-primary']/a/span[text()='My Account']") WebElement AccountLinkAfterLogout;
	@FindBy(xpath="//div[@class='soar-input mb-10 loginUser']/descendant::input[@name='USER']") WebElement Username;
	@FindBy(xpath="//div[@class='soar-input mb-10 loginPass']/descendant::input[@name='PASSWORD']") WebElement Password;
	@FindBy(xpath="//button[@id='loginHeaderButton']") WebElement Submit;
	@FindBy(xpath="//a[@title='Open cart']") WebElement CartIcon;
	
	public void signClick() {
		jsElementHighlight(SignInLink);
		SignInLink.click();
		jsElementHighlight(MyAccountLink);
		MyAccountLink.click();
		Reporter.log("Clicked on Sign In Link", true);

	}
	
	public void login(String uname, String pwd) {
		jsElementHighlight(Username);
		Username.sendKeys(uname);
		jsElementHighlight(Password);
		Password.sendKeys(pwd);
		Submit.click();	
		Reporter.log("Sending username and password", true);

	}
	
	public void loginAfterLogoutFromCart() {
		SignInAfterSignout.click();
		AccountLinkAfterLogout.click();	
	}
	
	public void clickonCartIcon() {
		CartIcon.click();
		Reporter.log("Clicked on Cart Icon", true);

	}

}
