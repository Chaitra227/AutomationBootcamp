	package regression;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

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
import utility.Test_POJO;

//@Listeners(utility.ListenerTest.class) -- One way of calling listener at class level
public class JodUpgradePayoff extends InitializeBrowser {
	
	@Test(dataProvider="customDataMap", groups= "Sanity")
	public void jodUpgradePayoff(Test_POJO test) {
		LoginPage login=new LoginPage(driver);
		login.signClick();
		login.login(test.getUsername(), test.getPassword());
		
		PhonePage phone=new PhonePage(driver);
		phone.selectUPG();
		Assert.assertEquals(true, false);
		
		PTNSelectorPage ptnselector=new PTNSelectorPage(driver);
		ptnselector.pageTitleCheck();
		ptnselector.sendPTNInSearchBar(test.getPTN());
		phone.selectiPh12Pro();
		
		ContractTerminationPage closeoutOption=new ContractTerminationPage(driver);
		closeoutOption.selectLeasePayoff();
		
		PhoneDetailPage pdp=new PhoneDetailPage(driver);
		pdp.selectIBContract();
		pdp.clickButtonInPDP();
		
		ProtectionPage protect=new ProtectionPage(driver);
		protect.UPGAddtoCartBtn();
		
		CartPage cart=new CartPage(driver);
//		cart.cartTitleCheck();
		cart.checkoutClick();
		
		DeliveryPage delivery=new DeliveryPage(driver);
		delivery.overnightShipping();
		
		PaymentPage payment=new PaymentPage(driver);		
		payment.acceptTermswithDeviceAgree();
		payment.cardDetails(test.getcardName(), test.getcardNumber(), test.getexpDate(), test.getCVV());

}
}
