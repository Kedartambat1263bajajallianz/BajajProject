package RequestCall;

import java.io.File;
import java.math.BigDecimal;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.WebElement;

public class TestDatasheet {
	 private static final String CellType = null;




	@SuppressWarnings("deprecation")
	public static String formatNumber(double row) {

	        // Remove scientific notation and ensure full number representation
		 String cellValueStr = Double.toString(row);
		
			 // Split the scientific notation 
			 String[] parts = cellValueStr.toLowerCase().split("e");
			 // Parse the base number and exponent 
			 
			 BigDecimal baseNumber = new BigDecimal(parts[0]); 
			 int exponent = Integer.parseInt(parts[1]);
			 // Use BigDecimal for precise conversion 
			 BigDecimal bigDecimal = baseNumber.multiply(BigDecimal.valueOf(Math.pow(10, exponent)));
			 // Convert to string without scientific notation 
				
			 return bigDecimal.stripTrailingZeros().setScale(0, BigDecimal.ROUND_UNNECESSARY).toPlainString();
			 }
		 

	

	public static void main(String[] args) throws IOException {
		/*
		 * File file = new File("D:\\Daily Task Report\\ExcelSheet.xlsx");
		 * FileInputStream fis = new FileInputStream(file); XSSFWorkbook workbook = new
		 * XSSFWorkbook(fis); XSSFSheet sheet = workbook.getSheetAt(0); XSSFRow col=
		 * sheet.getRow(1); XSSFCell row=col.getCell(1); System.out.println(row); double
		 * cellvalue=row.getNumericCellValue(); if (col != null ) { double cellValue =
		 * ((Cell) col).getNumericCellValue(); String formattedNumber =
		 * formatNumber(cellValue); System.out.println("Perfect Number: " +
		 * formattedNumber); } System.out.println("Perfect Number: " +
		 * formatNumber(cellvalue));
		 */
		 // Set the path for the ChromeDriver 
		
		// Read the Excel file
		File file = new File("D:\\Daily Task Report\\ExcelSheet.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis); 
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow col = sheet.getRow(0);
		XSSFCell cell = col.getCell(1);
		if (cell != null && cell.getCellType() == cell.CELL_TYPE_NUMERIC) { 
			double cellValue = cell.getNumericCellValue();
			String formattedNumber = formatNumber(cellValue);
			System.out.println("Perfect Number: " + formattedNumber);
			} 
		else { System.out.println("Cell is not numeric or is empty."); }
	}
	}
		
	


	

