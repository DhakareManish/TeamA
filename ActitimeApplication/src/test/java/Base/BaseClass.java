package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	
	public WebDriver openChromeBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "E:\\velocity\\AutomationPractice\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost/login.do");
		return driver;
	}
	
	public WebDriver openMozillaBrowser() {
		
		System.setProperty("webdriver.gecko.driver", "E:\\velocity\\AutomationPractice\\geckodriver-v0.29.1-win64\\geckodriver.exe");

		 WebDriver driver = new FirefoxDriver();
		 driver.get("http://localhost/login.do");
		 return driver;
		
	}
	

}
