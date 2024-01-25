package com.excel.reader;

import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		// Create an instance of the ExcelReader class
		ExcelReader excelReader = new ExcelReader();

		// Call the readUserDataSet method to get the list of user data
		List<String[]> userDataSet = excelReader.readUserDataSet();

		// Iterate through the userDataSet and print the data
		for (String[] userData : userDataSet) {
			System.out.println("Username: " + userData[0] + ", Password: " + userData[1]);
		}
	}
}
