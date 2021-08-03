package utility;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extentReport;
	
	//creating a method with ExtentReports return type
	public static ExtentReports reportGeneration() {
		String filec=reportName();
		String directory=System.getProperty("user.dir")+"/reports/";
//		File file=new File(directory);
		String path=directory+filec;
//		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"//reports//AutomationReport.html");
		htmlReporter=new ExtentHtmlReporter(path);
		htmlReporter.config().setReportName("Automation Report");
		htmlReporter.config().setDocumentTitle("Automation Status");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extentReport=new ExtentReports();
		extentReport.attachReporter(htmlReporter);
		extentReport.setSystemInfo("Tester", "Chaitra");
		extentReport.setSystemInfo("Browser", "Chrome");
		extentReport.setSystemInfo("OS", "WINDOWS");
				
		return extentReport;		
	}
	
	public static String reportName() {
		Date d=new Date();
		//converting : is mandatory here, as that is invalid syntax
		String filename="AutomationReport_"+ d.toString().replace(":", "_")+".html";
		return filename;
	}
	
}
