
package sanity;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.InitializeBrowser;
import pages.CartPage;
import pages.ChangePlanPage;
import pages.ChangePlanPage;
import pages.LoginPage;
import pages.PhonePage;

public class ChangePlanTest extends InitializeBrowser{
	
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
	}
	
}