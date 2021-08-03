package regression;

import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import base.InitializeBrowser;
import pages.PhonePage;
import pages.PlanPage;
import pages.CartPage;
import pages.DeliveryPage;
import pages.LoginPage;
import pages.NumberSetupPage;
import pages.PaymentPage;
import pages.PhoneDetailPage;
import pages.ProtectionPage;


public class AuthGATabletIB extends InitializeBrowser  {
	
	@Test(priority=0)
	public void signIn() {
		LoginPage login=new LoginPage(driver);
		login.signClick();
		login.login(prop.getProperty("GA_username"), prop.getProperty("password"));
	}
	
	@Test(priority=1, dependsOnMethods="signIn")
	public void deviceContractSelection() {
		PhonePage phone=new PhonePage(driver);
		phone.selectAAL();
		phone.topNav();
		phone.tabletSelection();
		phone.selectTablet();
		PhoneDetailPage pdp=new PhoneDetailPage(driver);		
		//pdp.SelectContract();
		pdp.clickButtonInPDP();
	}
		
	@Test(priority=2, dependsOnMethods="deviceContractSelection")
	public void serviceSelection() {
		ProtectionPage protection=new ProtectionPage(driver);
		protection.protectionSOC_Select();
		protection.protectSOCButton();
	}
	
	@Test(priority=3, dependsOnMethods="serviceSelection")
	public void planSelection() {
		PlanPage plan=new PlanPage(driver);
		//plan.morePlan();
		//plan.planSelection();
		plan.addtoCart();
	}
	
	@Test(priority=4, dependsOnMethods="planSelection")
	public void cartPage() {
		CartPage cart=new CartPage(driver);
		//cart.cartTitleCheck();
		cart.checkoutClick();
	}
	
	@Test(priority=5, dependsOnMethods="cartPage" )
	public void checkoutStep() {
		NumberSetupPage number=new NumberSetupPage(driver);
		number.titleCheck();
		number.portIn(prop.getProperty("portInNumber"));
		number.continueBtn();
		DeliveryPage delivery=new DeliveryPage(driver);
		delivery.freeShippingDelivery();
		PaymentPage payment=new PaymentPage(driver);		
		payment.acceptTermswithDeviceAgree();
		payment.cardDetails(prop.getProperty("NameOnCard"), prop.getProperty("card"), prop.getProperty("expirationdate"), prop.getProperty("cvv"));
	}
	
}
