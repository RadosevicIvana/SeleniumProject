package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

public class ExcelReader {

	File file;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	String value; 

	public ExcelReader(String filepath) throws IOException {
		this.file = new File(filepath);
		this.fis = new FileInputStream(file);
		this.wb = new XSSFWorkbook(fis);
	}

	public String getData(String sheetName, int columnNumber, int rowNumber) {
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNumber - 1);
		cell = row.getCell(columnNumber - 1);
		if (cell.getCellType() == CellType.NUMERIC) { 
			value = String.valueOf((int) cell.getNumericCellValue());
		} else {
			value = cell.getStringCellValue();
		}
		return value;
	}
	
	public void asserting(String sheetName, int columne, int row, String textFromPage) {
		String textFromExcel = getData(sheetName, columne, row);
		Assert.assertEquals(textFromPage, textFromExcel);

	}
}
