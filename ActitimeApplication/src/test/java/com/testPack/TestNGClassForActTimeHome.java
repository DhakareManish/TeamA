package com.testPack;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.pomPack.LoginPagePomClassForActTime;

import Base.BaseClass;
import UtilityPack.Utility;

public class TestNGClassForActTimeHome extends BaseClass{
	
	private WebDriver driver;
	private LoginPagePomClassForActTime loginPagePomClassForActTime;
	private SoftAssert softAssert;
	private int TestId;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	@BeforeSuite
	public void beforeSuit() {
		System.out.println("Before Suit ");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("BeforeClass");
		
	}
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) {
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		if (browser.equals("chrome")) {

			driver = openChromeBrowser();

		}
		if (browser.equals("firefox")) {

			driver = openMozillaBrowser();
		}
		System.out.println("BrowserLaunchSuccessfully");
	}
	@BeforeMethod 
	public void beforeMethod() {
		System.out.println("Before method ");
		softAssert=new SoftAssert();
		        
	}
	@Test(priority=1)
	public void loginTextVerification() throws EncryptedDocumentException, IOException {
		 TestId=102;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginPagePomClassForActTime = new LoginPagePomClassForActTime(driver);

		loginPagePomClassForActTime.sendLoginCorrectCred();

		String TextToMatch = loginPagePomClassForActTime.verifyLoginButtonText();

		// true =PASS=string equal
		// false=FAIL=String not equal
		softAssert.assertEquals(TextToMatch, "Login");
		//loginPagePomClassForActTime.hitTheLoginButton();

		softAssert.assertAll();
		
	}
	
	@Test(priority=2)
	public void loginCredVerification() throws EncryptedDocumentException, IOException {
		 TestId=103;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		loginPagePomClassForActTime.sendLoginInCorrectCred();
		//Username or Password is invalid. Please try again.
		loginPagePomClassForActTime.hitTheLoginButton();
		
		               
		String errormsgText=loginPagePomClassForActTime.getErrorTextWhileInValidCred();
		String expectedERRMesg="Username or Password is invalid. Please try again.";
		Assert.assertEquals(errormsgText, expectedERRMesg);
		
		
		String url="http://localhost/user/submit_tt.do";
		
		String actualURL=driver.getCurrentUrl();
		Assert.assertNotEquals(actualURL, url);
		System.out.println("login on corret page");
					
	}
	@AfterMethod
	public void afterMethod() throws IOException {
	     Utility.savescreenshot(driver, TestId);
		System.out.println("After method ");
	}
	@AfterClass
	public void afterClass() {
		
		System.out.println("After class");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("After Test ");
	}
	@AfterSuite
	public void afterSuit() {
		
		System.out.println("After Suit");
	}
	
	

}
