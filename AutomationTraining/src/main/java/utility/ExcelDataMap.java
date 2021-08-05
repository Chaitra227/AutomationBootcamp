package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelDataMap {
	static Workbook workbook;
	static Sheet sheet;
	static FileInputStream fip;
	
	public static Map<String, Test_POJO> getExcelData(String SheetName){
		Map<String, Test_POJO> testData=new HashMap<String, Test_POJO>();
		Test_POJO pojodata = new Test_POJO();
		try {
			File file=new File(System.getProperty("user.dir")+"//src//main//resources//property//DataExcel.xlsx");
			fip=new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook=WorkbookFactory.create(fip);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sheet=workbook.getSheet(SheetName);
		int rowCount= sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		System.out.println(rowCount);
		System.out.println(columnCount);
		
		for(int i=1;i<=rowCount;i++) {
		Row row=sheet.getRow(i);
		String Key=row.getCell(0).getStringCellValue();
//		pojodata.setTestMethod(Key);  --this is optional, as we don't do any get operation
		pojodata.setUsername(row.getCell(1).getStringCellValue());
		pojodata.setPassword(row.getCell(2).toString());
		pojodata.setPTN(row.getCell(3).toString());
		pojodata.setCardName(row.getCell(4).getStringCellValue());
		pojodata.setCardNumber(row.getCell(5).toString());
		pojodata.setExpDate(row.getCell(6).toString());
		pojodata.setCVV(row.getCell(7).toString());

		testData.put(Key, pojodata);
		
//		for(Map.Entry<String, Test_POJO> entry: testData.entrySet()) {
//			System.out.println(entry.getKey()+ " : " +entry.getValue());
//		}
		
		System.out.println(testData);
		}	
		return testData;
		
	}

}
