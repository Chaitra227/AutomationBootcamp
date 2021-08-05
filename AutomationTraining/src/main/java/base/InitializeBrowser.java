package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import utility.ExcelDataMap;
import utility.ExcelUtil_ForOneDataSet;
import utility.Test_POJO;

public class InitializeBrowser {
	public static WebDriver driver;
	public Properties prop;
	public static WebDriverWait wt;
	public static WebElement element;
	public JavascriptExecutor js ;

	public InitializeBrowser() {	
		try {
			prop=new Properties();
			FileInputStream fip=new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//property//data.properties");
			try {
				prop.load(fip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}


	@BeforeTest(alwaysRun=true)
	public void initialize(ITestContext contextc) {
		System.setProperty("webdriver.chrome.driver", "C:\\chromeDriver\\chromedriver_win32 (2)\\chromedriver.exe");
		driver=new ChromeDriver();
		contextc.setAttribute("WebDriver", driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

	@DataProvider(name="customDataMap")
	public Test_POJO[] ExcelData(Method method) {
		Map<String, Test_POJO> testData= ExcelDataMap.getExcelData("DataWithPOJO");
		Test_POJO pojo=testData.get(method.getName());
		Test_POJO[] pojoArray=new Test_POJO[1];
		pojoArray[0]=pojo;
		return pojoArray;
		//instead of 3 lines above, use just 1 line below
		//		return new Test_POJO[] {pojo};
	}

	//	@DataProvider(name="dataFile")
	//	public Object[] ExcelData(Method method) {
	//		System.out.println("Method name is: "+ method.getName());
	//		Test_POJO data=null;
	//		try {
	//			FileInputStream fip=new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//property//DataExcel.xlsx");
	//			try {
	//				XSSFWorkbook workbook=new XSSFWorkbook(fip);
	//				XSSFSheet sheet=workbook.getSheetAt(0);
	//				XSSFRow row;
	//
	//				for(int i=1;i<=sheet.getLastRowNum();i++) {
	//					row=sheet.getRow(i);
	//					if(row.getCell(0).toString().equals(method.getName())) {
	//
	//						data=new Test_POJO(row.getCell(1).toString(),row.getCell(2).toString(), row.getCell(3).toString(), 
	//								row.getCell(4).toString(), row.getCell(5).toString(), row.getCell(6).toString(), row.getCell(7).toString());
	//
	//					}
	//				}
	//			} catch (IOException e) {
	//				e.printStackTrace();
	//			}
	//		} catch (FileNotFoundException e) {
	//			e.printStackTrace();
	//		}
	//		Object[] obj=new Object[1];
	//		obj[0]=data;
	//		return obj;		
	//
	//		//Instead of this we can write above 3 lines
	//		//			return new Object[] {data};
	//	}

	@DataProvider(name="test data")
	public static Object[][] chaitra(Method method) {	
		FileInputStream fip=null;
		XSSFWorkbook workbook=null;

		//		public static Object[][] excelData() {
		System.out.println("Method name is: "+ method.getName());
		Map<String, String> map=new HashMap<String, String>();

		try {
			fip=new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//property//DataExcel.xlsx");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			workbook = new XSSFWorkbook(fip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		XSSFSheet sheet=workbook.getSheet("DataWithPOJO");
		XSSFRow row=null;

		int rowCount = sheet.getLastRowNum() ;
		int cellCount = sheet.getRow(0).getLastCellNum();
		Object[][] obj = new Object[rowCount][1];


		for(int i=0;i<=sheet.getLastRowNum();i++) {
			if(sheet.getRow(i+1).getCell(0).toString().equals(method.getName())) {
				for(int j=0;j<row.getLastCellNum();j++) {
					String Key=sheet.getRow(0).getCell(j+1).toString();
					String Value=sheet.getRow(i+1).getCell(j+1).toString();
					map.put(Key, Value);
					obj[i][0]=map;
					System.out.println(obj[i][0]);

				}			
			}
		}

		return obj;

	}

	@DataProvider
	public Object[][] earlyUpgradeData() {		
		Object[][] data=ExcelUtil_ForOneDataSet.readExcel("EarlyUPG");		
		return data;
	}

	@DataProvider
	public Object[][] changePlanData() {		
		Object[][] data=ExcelUtil_ForOneDataSet.readExcel("CP");		
		return data;
	}

	@DataProvider
	public Object[][] jumpUpgradeData() {		
		Object[][] data=ExcelUtil_ForOneDataSet.readExcel("JumpUpgrade");		
		return data;
	}

	@AfterClass(alwaysRun=true)
	public void close() {
		driver.quit();
	}

}
