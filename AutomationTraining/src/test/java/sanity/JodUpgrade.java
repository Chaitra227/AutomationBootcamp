package sanity;

import java.util.List;
import java.util.Map;

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
import utility.ExcelHandling_ExcelDataTo_ListOfMap;

public class JodUpgrade extends InitializeBrowser {
	
	@Test
	public void jodUpgrade() {
		List<Map<String,String>> testDatainMap=ExcelHandling_ExcelDataTo_ListOfMap.readExcel(this.getClass().getSimpleName(), "MultipleTest");
		LoginPage login=new LoginPage(driver);
		login.signClick();
		login.login(testDatainMap.get(0).get("UserName"), testDatainMap.get(0).get("Password"));
		
		PhonePage phone=new PhonePage(driver);
		phone.selectUPG();
		
		PTNSelectorPage ptnselector=new PTNSelectorPage(driver);
		ptnselector.pageTitleCheck();
		ptnselector.sendPTNInSearchBar(testDatainMap.get(0).get("PTN"));
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
		payment.cardDetails(testDatainMap.get(0).get("CardName"), testDatainMap.get(0).get("CardNumber"), testDatainMap.get(0).get("ExpiryDate"), testDatainMap.get(0).get("CVV"));

}
}
