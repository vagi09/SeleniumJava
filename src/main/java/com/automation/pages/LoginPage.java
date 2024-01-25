package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import come.automation.basepage.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {

		super();
	}

	public final By usernameInput = By.id("username");
	public final By passwordInput = By.name("password");
	public final By submitButton = By.xpath("//button[@id='submit']");
	public final By displayLogo = By.xpath("//img[@alt='Practice Test Automation']");

	public boolean logoDisplayed() {

		WebElement displayLogoElement = driver.findElement(displayLogo);

		return displayLogoElement.isDisplayed();
	}

	public boolean isSubmitButtonVisible() {

		WebElement submitButtonElement = driver.findElement(submitButton);

		return submitButtonElement.isEnabled();

	}

	public void enterUserName(String username) {
		driver.findElement(usernameInput).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordInput).sendKeys(password);
	}

	public boolean isSubmitButtonEnabled() {

		WebElement submitButtonElement = driver.findElement(submitButton);

		return submitButtonElement.isEnabled();

	}

	public void clickLoginButton() {
		driver.findElement(submitButton).click();
	}

}
