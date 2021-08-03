package regression;

import org.testng.Assert;
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

public class JumpUpgradeTest extends InitializeBrowser {
	
	@Test(dataProvider="jumpUpgradeData", groups= {"Sanity"})
	public void jumpUpgrade(String uname, String pwd, String PTN, String cardname, String cardnumber, String Expdate, String CVV) {
		LoginPage login=new LoginPage(driver);
		login.signClick();
		login.login(uname,pwd);
		
		PhonePage phone=new PhonePage(driver);
		phone.selectUPG();
		
		PTNSelectorPage ptnselector=new PTNSelectorPage(driver);
		ptnselector.pageTitleCheck();
		ptnselector.sendPTNInSearchBar(PTN);
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
//		cart.cartTitleCheck();
		cart.checkoutClick();
		
		DeliveryPage delivery=new DeliveryPage(driver);
		delivery.overnightShipping();
		
		PaymentPage payment=new PaymentPage(driver);		
		payment.acceptTermswithDeviceAgree();
		payment.cardDetails(cardname, cardnumber, Expdate, CVV);

}
}
