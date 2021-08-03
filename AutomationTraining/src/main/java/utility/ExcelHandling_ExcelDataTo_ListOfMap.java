package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelHandling_ExcelDataTo_ListOfMap {
	static Workbook workbook;
	static Sheet sheet;
	static Row row;
	static FileInputStream fip;
	static Cell cell;
	
	
//	public static HashMap<String, String> readData(String sheetName){
//		try {
//			File file=new File(System.getProperty("user.dir")+"//src//main//resources//property//DataExcel.xlsx");
//			fip=new FileInputStream(file);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		try {
//			workbook=WorkbookFactory.create(fip);
//		} catch (InvalidFormatException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		sheet=workbook.getSheet(sheetName);
//		int rowCount= sheet.getLastRowNum();
//		int columnCount = sheet.getRow(0).getLastCellNum();
//		
//		DataFormatter formatter = new DataFormatter();
//		HashMap<String, String> data=new HashMap<String, String>();
//		
//		for(int i=0;i<columnCount;i++) {
//			String Key=formatter.formatCellValue(sheet.getRow(0).getCell(i));
//			System.out.println(Key);
//		}
//			for(int j=1;j<=rowCount;j++) {
//				for(int k=0;k<columnCount;k++) {
//					String Value=formatter.formatCellValue(sheet.getRow(j).getCell(k));	
//					System.out.println(Value);
////					data.put(Key, Value);
//					for(Entry<String, String> m:data.entrySet()) {
//						if(m.getKey().)
//						System.out.println("Chaitra");
//						System.out.println(m.getKey()+ "  "+m.getValue());
//					}
//			}
//		}
//		
//		
//		
//		return data;	
//		
//	}
	
	public static List<Map<String,String>> readExcel(String className, String sheetName) {
		List<Map<String,String>> testDataAllRows=null;
		Map<String,String> testData=null;
//		System.out.println(method.getName());
//		String methodName=method.getName();
		
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
//		try {
		sheet=workbook.getSheet(sheetName);
		int rowCount= sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		System.out.println(rowCount);
		System.out.println(columnCount);
		
		List list= new ArrayList();
		for(int i=0;i<columnCount;i++) {
			Row row=sheet.getRow(0);
			Cell cell=row.getCell(i);
			String RowHeader=cell.getStringCellValue().trim();
			list.add(RowHeader);
		}
		DataFormatter formatter = new DataFormatter();
		
		testDataAllRows=new ArrayList<Map<String,String>>();
		testData=new HashMap<String,String>();
		for(int i=1;i<=rowCount;i++) {
			String caseName=formatter.formatCellValue(sheet.getRow(i).getCell(0));
			if((caseName.toString().trim()).equals(className.toString().trim())) {
//				for(int j=1;j<=rowCount;j++) {
					Row row=sheet.getRow(i);		
					for(int k=1;k<columnCount;k++) {
						Cell cell=row.getCell(k);
						String colValue=formatter.formatCellValue(cell);
						//adding values to HashMap
						testData.put( (String) list.get(k), colValue);
					}
					//Adding Map to list of Map
					testDataAllRows.add(testData);
					
					//Printing Keys & values from Map
					System.out.println(testData.keySet());
					System.out.println(testData.values());
					
					//printing values from list
					System.out.println(testDataAllRows.size());
					for(int a=0;a<testDataAllRows.size();a++) {
						System.out.println(testDataAllRows.get(a));
					}

				}
			}
	
		return testDataAllRows;
		
	}
}
