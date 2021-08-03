package regression;

import org.testng.annotations.Test;

import base.InitializeBrowser;
import pages.BYODPage;
import pages.CartEmptyCheckPage;
import pages.LoginPage;
import pages.PhonePage;

public class EmptyCart extends InitializeBrowser {
	
	@Test(dataProvider="jumpUpgradeData")
	public static void clearCartContents(String uname, String pwd, String PTN, String cardname, String cardnumber, String Expdate, String CVV) {
		LoginPage login=new LoginPage(driver);
		login.signClick();
		login.login(uname,pwd);
		
		PhonePage phone=new PhonePage(driver);
		phone.selectBYOD();
		
		BYODPage byod=new BYODPage(driver);
		byod.closePopup();
		
		CartEmptyCheckPage emptyCart=new CartEmptyCheckPage(driver);
		emptyCart.emptyCartCheck();
	}
}
