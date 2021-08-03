package regression;

import org.testng.annotations.Test;

import base.InitializeBrowser;
import pages.CartPage;
import pages.ContractTerminationPage;
import pages.LoginPage;
import pages.PTNSelectorPage;
import pages.PhoneDetailPage;
import pages.PhonePage;
import pages.ProtectionPage;

public class PersistentCart extends InitializeBrowser {
	
	@Test(dataProvider="jodUpgradeData")
	public void jodUpgrade(String uname, String pwd, String PTN, String cardname, String cardnumber, String Expdate, String CVV) {
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
		closeoutOption.selectLeasePayoff();
		
		PhoneDetailPage pdp=new PhoneDetailPage(driver);
		pdp.selectIBContract();
		pdp.clickButtonInPDP();
		
		ProtectionPage protect=new ProtectionPage(driver);
		protect.UPGAddtoCartBtn();
		
		CartPage cart=new CartPage(driver);
		cart.cartTitleCheck();
		cart.logoutFromCart();
		driver.manage().deleteAllCookies();
		
		login.loginAfterLogoutFromCart();
		login.login(uname,pwd);
		login.clickonCartIcon();
		
		cart.checkCheckoutEnabled();
		
	}
}
