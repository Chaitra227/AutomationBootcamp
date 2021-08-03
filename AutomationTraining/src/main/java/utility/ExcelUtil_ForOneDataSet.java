package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil_ForOneDataSet {
	static Workbook workbook;
	static Sheet sheet;
	static FileInputStream fip;
	
	public static Object[][] readExcel(String sheetName) {
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
		
		sheet=workbook.getSheet(sheetName);
		int rowCount= sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		System.out.println(rowCount);
		System.out.println(columnCount);
		
		Object[][] data = new Object[rowCount][columnCount];
		for(int i=0;i<rowCount;i++) {
			for(int j=0;j<columnCount;j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				System.out.println(data[i][j]);
			}
		}
		return data;
		
	}

}
