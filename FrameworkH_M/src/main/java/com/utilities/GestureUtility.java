package com.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class GestureUtility {

	AndroidDriver driver;

	public GestureUtility(AndroidDriver driver) {	
		this.driver = driver;
	}
	
	public void scrollAction(String text) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));")).click();
	}
	
	public void swipeAction(WebElement Element,String direc,double per) {
		((JavascriptExecutor)driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",((RemoteWebElement)Element).getId(),"direction",direc,"percent",per));
		
	}
	public void zoomIn(WebElement element,double per) {
		((JavascriptExecutor)driver).executeScript("mobile: pinchOpenGesture", ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),"percent",per));
		
	}	
	
	public void zoomOut(WebElement element,double per) {
		((JavascriptExecutor)driver).executeScript("mobile: pinchCloseGesture", ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),"percent",per));
		
	}	
}
