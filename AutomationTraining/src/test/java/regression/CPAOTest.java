package regression;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.InitializeBrowser;
import pages.AOSelectionFromCartPage;
import pages.CPLandingPage;
import pages.CartPage;
import pages.ChangePlanPage;
import pages.LoginPage;
import pages.PhonePage;

public class CPAOTest extends InitializeBrowser {
	
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
		AOSelectionFromCartPage accessory=new AOSelectionFromCartPage(driver);
		accessory.selectAccessory();	
		accessory.cartErrorCheck();
		accessory.removeAOPackage();
		
	}
}
