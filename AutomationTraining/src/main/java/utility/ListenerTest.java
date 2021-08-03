package utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ListenerTest implements ITestListener {
	static ExtentReports extentReport=ExtentReport.reportGeneration();
	static ExtentTest extentTest;
	public static WebDriver driver;

	public void onTestStart(ITestResult result) {
		extentTest=extentReport.createTest(result.getTestClass().getName()+":"+result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, MarkupHelper.createLabel(result.getMethod().getMethodName()+" PASSED ", ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {
		ITestContext context=result.getTestContext();
		driver=(WebDriver)context.getAttribute("WebDriver");
		String screenshotpath=takeScreenshot(result.getMethod().getMethodName());
		try {
			extentTest.fail("Screenshot of failure", MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath).build());
		} catch (IOException e) {
			e.printStackTrace();
		}

		extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getMethod().getMethodName()+ " FAILED ", ExtentColor.RED));
		//		extentTest.fail(result.getThrowable());
		extentTest.log(Status.FAIL, result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.SKIP, MarkupHelper.createLabel(result.getMethod().getMethodName()+ " FAILED ", ExtentColor.PINK));
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		extentReport.flush();
	}

	public static String takeScreenshot(String Methodname) {
		String filenam= getScreenshotName(Methodname);
		String directory=System.getProperty("user.dir")+"/Screenshots/";
		String path=directory+filenam;
		TakesScreenshot ts=(TakesScreenshot) driver;
		System.out.println("Before getScreenshot");
		File src=ts.getScreenshotAs(OutputType.FILE);
		System.out.println("After getScreenshot");
		File dstn=new File(path);
		try {
			FileUtils.copyFile(src, dstn);
		} catch (IOException e) {
			e.printStackTrace();
		}	 
		return path;
	}

	public static String getScreenshotName(String Methodname) {
		Date d= new Date();
		String fileName=Methodname+d.toString().replace(":", "_")+".png";
		return fileName;
	}
}
