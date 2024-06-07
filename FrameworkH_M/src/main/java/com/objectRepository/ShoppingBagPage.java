package com.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.utilities.GestureUtility;

import io.appium.java_client.android.AndroidDriver;

public class ShoppingBagPage {
	AndroidDriver driver;
	

	public ShoppingBagPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//androidx.compose.ui.platform.ComposeView[@resource-id=\"com.hm.goe:id/composeView\"]/android.view.View/android.view.View/android.view.View[3]")
	private WebElement quantityDry;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"DryMove™ Pocket-detail sports cycling shorts\"]")
	private WebElement nameDry;


	public WebElement getQuantityDry() {
		return quantityDry;
	}

	public WebElement getNameDry() {
		return nameDry;
	}
	
	public void validateDryProd(GestureUtility gUtil,String text) throws InterruptedException {
		quantityDry.click();
		Thread.sleep(2000);
		gUtil.scrollAction(text);
		Thread.sleep(2000);
		//Assert.assertTrue(nameDry.isDisplayed(), "");
		if(nameDry.isDisplayed()) {
			System.out.println("Added to cart");
		}
		else {
			System.out.println("Not Added");
		}
	}
	
	
}
