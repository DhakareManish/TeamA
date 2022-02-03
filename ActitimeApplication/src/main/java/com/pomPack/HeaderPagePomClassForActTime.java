package com.pomPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPagePomClassForActTime {
	WebDriver driver;
	
	@FindBy(xpath="//a[@class='content tt_selected selected']")
	private WebElement timeTrack;
	
	@FindBy(xpath="//td[@id='enterTTMainContent']//td[@class='pagetitle']")
	private WebElement enterTimeTrack;
	
	
    public HeaderPagePomClassForActTime(WebDriver driver) {
    	
    	PageFactory.initElements(driver, this);
    	this.driver=driver;
    }
	
	public void clickONTimeTrackHeaderItem() throws InterruptedException {
		Thread.sleep(1000);
		timeTrack.click();
		
	}
	
	public String getTextOfEnterTimetrack() {
		
		String Text=enterTimeTrack.getText();
		return Text;
	}
	
	
	
	
	

}
