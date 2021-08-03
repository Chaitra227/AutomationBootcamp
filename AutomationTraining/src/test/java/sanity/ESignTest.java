package sanity;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.InitializeBrowser;
import pages.ESignAuthenticationPage;
import pages.ESignPage;
import pages.EsignContractPage;

public class ESignTest extends InitializeBrowser {
	
	
	@BeforeClass
	public void initialize() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromeDriver\\chromedriver_win32 (2)\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("esignUrl"));
	}
	
	@Test
	public void signIn() {		
		ESignPage esign=new ESignPage(driver);
		esign.titleCheck();
		esign.enterOrderID(prop.getProperty("eSIgnOrderID"));
		ESignAuthenticationPage AuthPage=new ESignAuthenticationPage(driver);
		AuthPage.testPageVisibility();
		AuthPage.pinDetails(prop.getProperty("eSignZip"), prop.getProperty("eSignPin"));
		EsignContractPage contractSign=new EsignContractPage(driver);
		contractSign.contractPageTitle();
		contractSign.acceptingTerms();
	}

}
