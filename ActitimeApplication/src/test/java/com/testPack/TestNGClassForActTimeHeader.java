package com.testPack;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.pomPack.HeaderPagePomClassForActTime;
import com.pomPack.LoginPagePomClassForActTime;

import Base.BaseClass;
import UtilityPack.Utility;

public class TestNGClassForActTimeHeader extends BaseClass{
	
	private WebDriver driver;
	private  HeaderPagePomClassForActTime headerPagePomClassForActTime;
	private SoftAssert softAssert;
	private LoginPagePomClassForActTime loginPagePomClassForActTime;
	private int TestId;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	@BeforeSuite
	public void beforeSuit() {
		System.out.println("Before Suit2 ");
	}
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) {
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		System.out.println("beforeTest2");
		
		if(browser.equals("chrome")) {
			
			   this.driver =openChromeBrowser();
			
		}
		if (browser.equals("firefox")) {

			driver = openMozillaBrowser();
		}
		
	}
	
	@BeforeClass
	public void beforeClass() {
		
		System.out.println("Before Class2");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BeforeMethod2");
		
	}
	@Test
	public void verifyThatTimeTrackText() throws EncryptedDocumentException, IOException, InterruptedException {
		System.out.println("header1stTest");
		 TestId=101;
        headerPagePomClassForActTime=new HeaderPagePomClassForActTime(driver);
        loginPagePomClassForActTime =new LoginPagePomClassForActTime(driver);
        
        loginPagePomClassForActTime.sendLoginCorrectCred();
        
        loginPagePomClassForActTime.hitTheLoginButton();
        
        headerPagePomClassForActTime.clickONTimeTrackHeaderItem();
        
        String textToVerify = headerPagePomClassForActTime.getTextOfEnterTimetrack();
        
        softAssert=new SoftAssert();
        
        softAssert.assertEquals(textToVerify,"Enter Time-Track");
        
        softAssert.assertAll();
		
	}
	@AfterMethod
	public void afterMethod() throws IOException {
		Utility.savescreenshot(driver, TestId);
		System.out.println("afterMethod2");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test2 ");
	}
	@AfterSuite
	public void afterSuit() {
		
		System.out.println("After Suit2 method");
	}
	
	
}
