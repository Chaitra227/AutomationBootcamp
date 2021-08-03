package regression;

import org.testng.annotations.Test;

import base.InitializeBrowser;
import pages.LoginPage;

public class GALoginDataProvider extends InitializeBrowser {
		
		@Test(dataProvider="getLoginData")
		public void signIn(String uname, String pwd) {
			LoginPage login=new LoginPage(driver);
			login.signClick();
			login.login(uname, pwd);
		}
		


}