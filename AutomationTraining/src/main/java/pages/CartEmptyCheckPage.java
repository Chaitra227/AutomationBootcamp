package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class CartEmptyCheckPage extends CommonPage {
	WebDriver driver;
	
	public CartEmptyCheckPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='sprint-cart-count font-apple']")  WebElement cartIcon;
	@FindBy(xpath="//span[@aria-label='Remove this item']")  WebElement EmptyCartIcon;
	@FindBy(xpath="//button[@ng-reflect-ng-class='[object Object]']/span[text()='Yes, remove it']") WebElement emptyCartConfirmationButton;
	@FindBy(xpath="//sprint-cart-retrieve[@ng-reflect-is-new-empty-cart-enabled='true']/p[1]")  WebElement CartEmptyText;
	
	public void emptyCartCheck() {
			cartIcon.click();
			eWaitVisibility(EmptyCartIcon);
			EmptyCartIcon.click();
			eWaitClickable(emptyCartConfirmationButton);
			emptyCartConfirmationButton.click();
			eWaitVisibility(CartEmptyText);
			String EmptyCart=CartEmptyText.getText();
			Assert.assertEquals(EmptyCart, "Your Cart Is Empty");
			Reporter.log("Cart Items cleared", true);
	}

}
