package actions;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel {
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static XSSFRow row;
	
	public static void uploadFile(File excelpath) {
		try {
			wb = new XSSFWorkbook(excelpath);
		} catch (InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Object[][] uploadSheet(String sheetname) {
		sheet = wb.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum();
		int columncount= sheet.getRow(0).getLastCellNum();
		Object [][] data = new Object[rowcount][columncount];
		for (int i=1; i<=rowcount;i++) {
			for (int j=0;j<columncount;j++) {
				data[i-1][j]= sheet.getRow(i).getCell(j).toString();
			}
		}
		return data;
	}	
	}

