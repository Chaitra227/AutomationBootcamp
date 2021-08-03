package regression;

import org.testng.annotations.Test;

import base.InitializeBrowser;
import pages.CartPage;
import pages.ChangePlanPage;
import pages.LoginPage;
import pages.PhonePage;

public class ChangePlanDualTest extends InitializeBrowser {
//   rtb1_100215971	Sprint@01

	@Test(dataProvider="changePlanData")
	public void changePlan(String username, String password) {
		LoginPage login=new LoginPage(driver);
		login.signClick();
		login.login(username,password);
		PhonePage pdp=new PhonePage(driver);
		pdp.selectAAL();
		ChangePlanPage cp=new ChangePlanPage(driver);
		cp.cpSelection();
		cp.selectDeviceOneForCP();
		cp.cpCurrentPlanPage();
		cp.cpNewPlan();
		cp.serviceWall();
		CartPage cart=new CartPage(driver);				
		cart.cpCartCheck();
		cart.cartTitleCheck();	
		cp.cpSelection();
		cp.selectDeviceTwoForCP();
		cp.cpCurrentPlanPage();
		cp.selectContinueinNewPlanPage();		
		cart.cpCartCheck();
		cart.cartTitleCheck();
}
}
