package com.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class AddToCartPage {
     AndroidDriver driver;
     
	public AddToCartPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//android.widget.TextView[@text=\"L\"]")
	private WebElement drySize;
	
	@FindBy(xpath="//android.widget.Button")
	private WebElement AddInCartwithsize;
	
	@FindBy(id="com.hm.goe:id/hm_shoppingbag_count")
	private WebElement countBag;

	public WebElement getDrySize() {
		return drySize;
	}

	public WebElement getAddInCartwithsize() {
		return AddInCartwithsize;
	}

	public WebElement getCountBag() {
		return countBag;
	}
	
	public void proceedToCartDry() throws InterruptedException {
		drySize.click();
		AddInCartwithsize.click();
		Thread.sleep(2000);
		countBag.click();
		Thread.sleep(2000);
	}
	
}
