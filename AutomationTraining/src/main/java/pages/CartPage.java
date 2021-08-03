package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class CartPage extends CommonPage {
	public WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@id='checkout-cta']")  WebElement CheckoutButton;
	@FindBy(xpath="//button[@id='checkout-cta']/following-sibling::button")  WebElement CPSubmitOrder;
	@FindBy(xpath="//span[text()='PLAN CHANGE']")   WebElement CPCartContent;
	@FindBy(xpath="//a[@class='sprint-menu__root js-nav-link-root sprint-menu__root-link']") WebElement MyAcccountLink;
	@FindBy(xpath="//div[@class='sprint-myaccount-logout']/button") WebElement LogoutButton;
	@FindBy(xpath="//img[@class='cross-sell-carousel-tile-image' and @alt='Bring your device']")  WebElement BYODLinkInCart;
	
	public void cartTitleCheck() {	
//		eWaitVisibility(CheckoutButton);
		String CartTitle=driver.getTitle();
		Assert.assertEquals(CartTitle, "Your Cart | Sprint");
		Reporter.log("Verified Cart Title", true);
	}
	
	public void cpCartCheck() {
		eWaitVisibility(CPCartContent);
		eWaitVisibility(CPSubmitOrder);
	}
	
	public void checkoutClick() {
		//eWaitClickable(CheckoutButton);
		eWaitVisibility(CheckoutButton);
		jsElementHighlight(CheckoutButton);
		CheckoutButton.click();
		Reporter.log("Clicked on Checkout button in cart page", true);
	}
	
	public void logoutFromCart() {
		MyAcccountLink.click();
		LogoutButton.click();
		Reporter.log("Clicking on logout button from cart", true);
	}
	
	public void checkCheckoutEnabled() {
		CheckoutButton.isEnabled();
	}
	
	public void selectBYODFromCart() {
		BYODLinkInCart.click();
		Reporter.log("Selecting BYOD link from Cart Page", true);
	}
}
