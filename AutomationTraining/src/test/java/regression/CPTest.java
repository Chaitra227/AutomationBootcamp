package regression;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.CPLandingPage;

public class CPTest {
	WebDriver driver;
	
	@Test
	public void changePlanAfterLogin() {
		CPLandingPage cpl=new CPLandingPage(driver);
		cpl.selectAAL();
		cpl.cpSelection();
	}

}
