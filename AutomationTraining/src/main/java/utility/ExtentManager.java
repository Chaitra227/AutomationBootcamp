package utility;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	
	public static ExtentReports createInstance() {
		String fileName=getReportName();
		String directory=System.getProperty("user.dir")+"/reports/";
		File file=new File(directory);
		String path=directory+fileName;		
		htmlReporter=new ExtentHtmlReporter(path);
		htmlReporter.config().setDocumentTitle("Automation Status");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent=new ExtentReports();
		extent.setSystemInfo("Tester", "Chaitra");
		extent.setSystemInfo("Browser", "Chrome");
		extent.attachReporter(htmlReporter);
		return extent;		
	}
	//Helps to give dynamic name to report
	public static String getReportName() {
		Date d=new Date();
		String fileName="AutomationReport_"+d.toString().replace(":", "_").replace(" ", "_")+".html";
		return fileName;
		
	}

}
