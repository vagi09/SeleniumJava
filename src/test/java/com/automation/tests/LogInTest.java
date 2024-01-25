package com.automation.tests;

import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.pages.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.config.properties.ConfigurationReader;
import com.excel.reader.ExcelReader;
import com.yourpackage.reports.ExtentManager;

import come.automation.basepage.BasePage;

public class LogInTest extends BasePage {

	public ConfigurationReader configurationReader = new ConfigurationReader();
	public ExcelReader excelReader = new ExcelReader();

	public LoginPage loginPage;
	public ExtentReports extent = ExtentManager.getInstance();
	public ExtentTest test;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		initializeDriverTimeouts();
		String url = configurationReader.getPageUrl();
		System.out.println(url);
		driver.get(url);
		loginPage = new LoginPage(driver);
		test = ExtentManager.createTest("LoginTest");
	}

	@DataProvider(name = "userData")
	public Object[][] getUserData() {
		List<String[]> userDataSet = excelReader.readUserDataSet();
		Object[][] data = new Object[userDataSet.size()][2];
		for (int i = 0; i < userDataSet.size(); i++) {
			data[i][0] = userDataSet.get(i)[0]; // Username
			data[i][1] = userDataSet.get(i)[1]; // Password
		}
		return data;
	}

	@Test (priority = 2)

	public void submitBtnValidation() {
		
		loginPage.clickLoginButton();

		boolean flag = loginPage.isSubmitButtonEnabled();

		Assert.assertTrue(flag, "Submit button is not enabled");

	}

	@Test(dataProvider = "userData", priority = 1)
	public void loginTest(String username, String password) throws InterruptedException {
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);

		loginPage.enterUserName(username);
		Thread.sleep(2000);
		loginPage.enterPassword(username);
		Thread.sleep(2000);
		loginPage.clickLoginButton();

		// Introduce a wait (you may replace Thread.sleep with a better wait strategy)
		Thread.sleep(2000);

		// Log the overall result for the test
		test.log(Status.PASS, "All login attempts completed successfully");
	}

	@AfterMethod
	public void tearDown() {
		test.log(Status.INFO, "Closing the browser");
		driver.quit();
		extent.flush();
	}
}
