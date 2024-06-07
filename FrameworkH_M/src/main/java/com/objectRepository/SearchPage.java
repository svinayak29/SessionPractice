package com.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class SearchPage {
    AndroidDriver driver;
    
	public SearchPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//android.widget.TextView[@text=\"Search\"]")
	private WebElement GiveData;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"jeans\"]")
	private WebElement jeansProd;

	public WebElement getJeansProd() {
		return jeansProd;
	}

	public WebElement getGiveData() {
		return GiveData;
	}
	
	public void searchAndAdd(String text) throws InterruptedException {
		GiveData.sendKeys(text);
		Thread.sleep(2000);
		jeansProd.click();
	}
	
	
}
