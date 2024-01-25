package come.automation.basepage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class BasePage {
	public static WebDriver driver;

	public BasePage() {
		

	}

	public static void initializeDriverTimeouts() {

		driver.manage().window().maximize();
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
	}

}