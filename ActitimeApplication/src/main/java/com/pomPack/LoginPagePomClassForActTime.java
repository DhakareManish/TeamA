package com.pomPack;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityPack.Utility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

 

public class LoginPagePomClassForActTime{
	WebDriver driver;
	
	
	@FindBy(xpath = "//input [@name='username']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@name='pwd']")
	private WebElement password;
	
	@FindBy(xpath = "//a[@id='loginButton']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//a[@id='loginButton']//div")
	private WebElement loginButtonText;
	
	@FindBy(xpath="(//div[@id='ServerSideErrorMessage']//td)[3]//span")
	private WebElement errormsg;
	
	public LoginPagePomClassForActTime(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;

	}

	public void sendLoginCorrectCred() throws EncryptedDocumentException, IOException {

		String Uname = Utility.getUserNameDataFromSheet(1, 0);
		String Pwd = Utility.getPassDataFromSheet(1, 0);
		username.sendKeys(Uname);
		password.sendKeys(Pwd);

	}

	public void sendLoginInCorrectCred() throws EncryptedDocumentException, IOException {
		String Uname = Utility.getUserNameDataFromSheet(2, 0);
		String Pwd = Utility.getPassDataFromSheet(2, 0);
		username.sendKeys(Uname);
		password.sendKeys(Pwd );

	}

	public String getErrorTextWhileInValidCred() {

		String errorMessage = errormsg.getText();
		return errorMessage;
	}

	public void hitTheLoginButton() {

		loginButton.click();
	}

	public String verifyLoginButtonText() {

		String Text = loginButtonText.getText();

		return Text;
	}

}