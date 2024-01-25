package com.excel.reader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	private static final Logger logger = LogManager.getLogger(ExcelReader.class);

	// Method to read multiple sets of usernames and passwords from Excel
	public List<String[]> readUserDataSet() {
		List<String[]> userDataSet = new ArrayList<>();

		try {
			// Specify the path to your Excel file
			String excelFilePath = "src/main/java/com/excel/reader/login_page_data.xlsx";

			// Open the Excel file using FileInputStream
			FileInputStream fis = new FileInputStream(excelFilePath);

			// Create a workbook instance from the Excel file
			XSSFWorkbook workbook = new XSSFWorkbook(fis);

			// Assuming your data is in the first sheet, change the index if needed
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each row in the sheet, starting from the second row
			for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
				Row row = sheet.getRow(rowIndex);

				// Get the cell in the first column (index 0) - Assuming it contains usernames
				Cell usernameCell = row.getCell(0);

				// Get the cell in the second column (index 1) - Assuming it contains passwords
				Cell passwordCell = row.getCell(1);

//				System.out.println("Username: " + usernameCell.getStringCellValue());
//				System.out.println("Password: " + passwordCell.getStringCellValue());

				// Check if both username and password cells are not null
				if (usernameCell != null && passwordCell != null) {
					// Store the username and password in the list
					String[] userData = { usernameCell.getStringCellValue(), passwordCell.getStringCellValue() };
					userDataSet.add(userData);

				}
			}

			// Close the workbook and file input stream
			workbook.close();
			fis.close();

		} catch (IOException e) {
			// Log an error message if an exception occurs
			logger.error("An error occurred:", e);
		}

		// Return the list containing arrays of usernames and passwords
		return userDataSet;
	}
}
