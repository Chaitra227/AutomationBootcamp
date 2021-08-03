package utility;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
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
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TestListeners implements ITestListener {
	public ExtentTest extentTest;
	public static WebDriver driver;
	public static File file;
	public static ExtentReports extent=ExtentManager.createInstance();
	
	//when multiple test cases are run in parallel, to keep it Thread safe using below code.
	private static ThreadLocal<ExtentTest> thread= new ThreadLocal<ExtentTest> ();

	public void onTestStart(ITestResult result) {
		 extentTest= extent.createTest(result.getTestClass().getName()+ "::" +result.getMethod().getMethodName());
		 thread.set(extentTest);
		 
	}

	public void onTestSuccess(ITestResult result) {
		String logText="<b>Test Method " + result.getMethod().getMethodName()+"is Success </b>";
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		thread.get().log(Status.PASS, m);
//		test.log(status, markup) --without using thread directly accessing using extentTest		
	}

	public void onTestFailure(ITestResult result) {
		String exceptionMessage=Arrays.toString(result.getThrowable().getStackTrace());
		//Here we are printing the Exception Message
		thread.get().fail("<details><summary><b><font color=red>Exception Occured, click to see details:"+ "</font></b></summary>"+
		exceptionMessage.replaceAll("," , "<br>")+ "</details>\n");
		
		String path=takeSrceenshot(result.getMethod().getMethodName());
		try {
			//Here we are attaching the snapshot
			thread.get().fail("<b><font color =red>" +"Screenshot of failure" +"</font></b>",
					MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
		catch(IOException e){
			thread.get().fail("Test Failed, Cannot attach Screenshot");
		}
		String logText="<b>Test Method " + result.getMethod().getMethodName()+"Failed </b>";
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.RED);
		thread.get().log(Status.FAIL, m);
	}

	public void onTestSkipped(ITestResult result) {
		String logText="<b>Test Method " + result.getMethod().getMethodName()+"got Skipped </b>";
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		thread.get().log(Status.SKIP, m);	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {		
	}

	public void onStart(ITestContext context){
	}

	public void onFinish(ITestContext context){
		if(extent!=null) {
			extent.flush();
		}
	}
	
	public static String takeSrceenshot( String methodName) {
		String fileName=getScreenshotName(methodName);
		String directory=System.getProperty("user.dir")+"/screenshots/";
		file=new File(directory);
		String path=directory+fileName;
		try {
			TakesScreenshot ts=(TakesScreenshot) driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File dstn= new File(path);
			FileUtils.copyFile(src, dstn);
			System.out.println("**********************");
			System.out.println("Screenshot stored at" +path);
			System.out.println("**********************");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return path;
	}
	
	public static String getScreenshotName(String methodName) {
		Date d=new Date();
		String fileName=methodName+"_"+d.toString().replace(":", "_").replace(" ", "_")+".png";
		return fileName;		
	}
}
