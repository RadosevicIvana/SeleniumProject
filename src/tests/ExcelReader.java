package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	File file;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;

	public ExcelReader(String filepath) throws IOException {
		this.file = new File(filepath);
		this.fis = new FileInputStream(file);
		this.wb = new XSSFWorkbook(fis);
	}

	public String getStringData(String sheetName, int rowNumber, int columnNumber) {
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNumber - 1);
		cell = row.getCell(columnNumber - 1);
		return cell.getStringCellValue();
	}

	public int getIntData(String sheetName, int rowNumber, int columnNumber) {
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNumber - 1);
		cell = row.getCell(columnNumber - 1);
		return (int) cell.getNumericCellValue();
	}
}
