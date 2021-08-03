package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil_POJO {
	static Method method;
	static FileInputStream fip;
	static XSSFWorkbook workbook;

	public static Object[][] excelData() {
		System.out.println("Method name is: "+ method.getName());
		Map<String, String> map=new HashMap<String, String>();

		try {
			FileInputStream fip=new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//property//DataExcel.xlsx");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			workbook = new XSSFWorkbook(fip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		XSSFSheet sheet=workbook.getSheet("Dummy");
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

				}			
			}
		}

		return obj;
	}
}
