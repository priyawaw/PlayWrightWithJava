package PlayWrightSessions;

import Utilities.ExcelReader;

public class ExcelReaderReport {

	public static void main(String[] args) {
		
		//Importing excel utilities
		
		ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\Excel\\TestData.xlsx");
		
		// Creating sheet object
		
		String sheetName = "LoginTest";
		
		// Getting data from sheet
		
		System.out.println(excel.getRowCount(sheetName));
		System.out.println(excel.getColumnCount(sheetName));
		
		



	}

}
