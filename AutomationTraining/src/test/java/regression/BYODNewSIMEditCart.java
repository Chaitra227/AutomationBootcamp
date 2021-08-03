package regression;

import org.testng.annotations.Test;

import base.InitializeBrowser;
import pages.BYODEditCartPage;
import pages.BYODPage;
import pages.CartPage;
import pages.DeliveryPage;
import pages.LoginPage;
import pages.NumberSetupPage;
import pages.PaymentPage;
import pages.PhonePage;
import pages.PlanPage;
import pages.ProtectionPage;
import utility.Test_POJO;


public class BYODNewSIMEditCart extends InitializeBrowser{
	
	@Test(dataProvider="dataFile")
	public void newSIMEditCart(Test_POJO test) {
	LoginPage login=new LoginPage(driver);
	login.signClick();
	login.login(test.getUsername(), test.getPassword());
	
	PhonePage phone=new PhonePage(driver);
	phone.selectBYOD();
	
	BYODPage byod=new BYODPage(driver);
	byod.closePopup();
	byod.NewSIMSelection();
	byod.clickContinueBtn();
	
	ProtectionPage protect=new ProtectionPage(driver);
	protect.BYODContinueButton();
	
	PlanPage plan=new PlanPage(driver) ;
	plan.addtoCartBYOD();
	
//	CartPage cart=new CartPage(driver);
//	cart.cartTitleCheck();
//	cart.checkoutClick();
	
	BYODEditCartPage editCart=new BYODEditCartPage(driver);
	editCart.editCart();
	editCart.planSelect();
	editCart.updatePlan();

	}
}
