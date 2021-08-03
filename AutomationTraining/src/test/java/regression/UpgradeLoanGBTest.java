package regression;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import base.InitializeBrowser;
import pages.CartPage;
import pages.ContractTerminationPage;
import pages.DeliveryPage;
import pages.LoginPage;
import pages.PTNSelectorPage;
import pages.PaymentPage;
import pages.PhoneDetailPage;
import pages.PhonePage;
import pages.ProtectionPage;

public class UpgradeLoanGBTest extends InitializeBrowser {
	
	@Test
	public void upgradeLoanGB() {
		LoginPage login=new LoginPage(driver);
		login.signClick();
		login.login(prop.getProperty("UPG_LoanGB_Username"), prop.getProperty("password"));
		PhonePage phone=new PhonePage(driver);
		phone.selectUPG();
		
		PTNSelectorPage ptnselector=new PTNSelectorPage(driver);
		ptnselector.pageTitleCheck();
		ptnselector.selectGiveBackPTN();
		phone.selectiPh12Pro();
		
		ContractTerminationPage closeoutOption=new ContractTerminationPage(driver);
		closeoutOption.selectLoanGB();
		closeoutOption.acceptTurnInTerms();
		
		PhoneDetailPage pdp=new PhoneDetailPage(driver);
		pdp.selectIBContract();
		pdp.clickButtonInPDP();
		
		ProtectionPage protect=new ProtectionPage(driver);
		protect.UPGAddtoCartBtn();
		CartPage cart=new CartPage(driver);
		cart.cartTitleCheck();
		cart.checkoutClick();
		
		DeliveryPage delivery=new DeliveryPage(driver);
		delivery.shippingAdddress(prop.getProperty("Address"));
		delivery.freeShippingDelivery();
		PaymentPage payment=new PaymentPage(driver);		
		payment.acceptTermswithDeviceAgree();
		payment.addressInPayment(prop.getProperty("Address"));
		payment.cardDetails(prop.getProperty("NameOnCard"), prop.getProperty("card"), prop.getProperty("expirationdate"), prop.getProperty("cvv"));
		
		
	}
	

}
