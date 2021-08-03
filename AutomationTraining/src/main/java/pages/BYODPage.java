package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class BYODPage  {
	WebDriver driver;
	CartPage cart;
	CartEmptyCheckPage emptyCart;
	
	public BYODPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		cart=new CartPage(driver);
		emptyCart=new CartEmptyCheckPage(driver);
	}
	
	@FindBy(xpath="//span[@class='sprint-cart-count font-apple']")  WebElement cartIcon;
	@FindBy(xpath="//div[@class='sprint-modal__content']/button[@class='sprint-modal__close']")  WebElement closeCart;
	@FindBy(xpath="//a[@title='Let’s Get Started']")  WebElement letsStartButton;
	@FindBy(xpath="//input[starts-with(@id,'form-element-input_') and @placeholder='IMEI or MEID']")  WebElement ESNField;
	@FindBy(xpath="//label[@for='lblhaveSim']") WebElement ExistingSIM;
	@FindBy(xpath="//label[@for='ZZZ260R070']")  WebElement NewSIM;
	@FindBy(xpath="//button[@id='data-byod-sim-page-continue-button-info']")  WebElement ContinueBtn;
	
	
	public void closePopup() {
		try {
			if(cartIcon.isDisplayed()) {
			String cartItemCount=cartIcon.getText();
			if(!cartItemCount.equalsIgnoreCase(null)) {
				System.out.println("Total number of Cart items: " +cartItemCount);
				int itemCount=Integer.valueOf(cartItemCount);			
				if(itemCount>=1) {
					closeCart.click();
					emptyCart.emptyCartCheck();
					cart.selectBYODFromCart();
					passESNAfterSelectingBYODFromCart();
				}
			}
			}
				else {
					passESN();
					Reporter.log("Cart is empty, hence directly passing ESN", true);
				}
		}catch (NumberFormatException  e) {
			e.printStackTrace();
		}
	}
	
	public void passESNAfterSelectingBYODFromCart() {
		ESNField.sendKeys("356560102579003");
		ESNField.sendKeys(Keys.ENTER);
		Reporter.log("After selecting BYOD link from cart, passing the ESN successfully", true);
	}
	
	public void passESN() {
		letsStartButton.click();
		ESNField.sendKeys("356560102579003");
		ESNField.sendKeys(Keys.ENTER);
		Reporter.log("Sending ESN through Happy Path", true);
	}
	
	public void existingSIMSelected() {
		ExistingSIM.isEnabled();
		Reporter.log("Existing SIM Option is selected", true);
	}
	
	public void NewSIMSelection() {
		NewSIM.click();
		Reporter.log("Selecting New SIM option", true);
	}
	
	public void clickContinueBtn() {
		ContinueBtn.click();
		Reporter.log("Clicking Continue Button from BYOD Page", true);
	}

}
