package sanity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import base.InitializeBrowser;
import pages.BYODPage;
import pages.CartPage;
import pages.ContractTerminationPage;
import pages.DeliveryPage;
import pages.LoginPage;
import pages.NumberSetupPage;
import pages.PTNSelectorPage;
import pages.PaymentPage;
import pages.PhoneDetailPage;
import pages.PhonePage;
import pages.PlanPage;
import pages.ProtectionPage;
import utility.ExcelHandling_ExcelDataTo_ListOfMap;

public class BYODNewSIM  extends InitializeBrowser{
	
	@Test(groups="Sanity")
	public void NewSIM() {
		
		List<Map<String,String>> testDatainMap=ExcelHandling_ExcelDataTo_ListOfMap.readExcel(this.getClass().getSimpleName(), "MultipleTest");
//		HashMap<String, String> data=ExcelHandling.readData("JumpUpgrade");
		LoginPage login=new LoginPage(driver);
		login.signClick();
		login.login(testDatainMap.get(0).get("UserName"), testDatainMap.get(0).get("Password"));
		
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
		
		CartPage cart=new CartPage(driver);
//		cart.cartTitleCheck();
		cart.checkoutClick();
		
		NumberSetupPage number=new NumberSetupPage(driver);
		number.selectLCA();
		number.continueBtn();
		
		DeliveryPage delivery=new DeliveryPage(driver);
		delivery.freeShippingDelivery();
		
		PaymentPage payment=new PaymentPage(driver);
		payment.acceptTermswithoutDeviceAgree();
		payment.cardDetails(testDatainMap.get(0).get("CardName"), testDatainMap.get(0).get("CardNumber"), testDatainMap.get(0).get("ExpiryDate"), testDatainMap.get(0).get("CVV"));


}
}
