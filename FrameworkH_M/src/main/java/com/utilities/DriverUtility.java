package com.utilities;

import java.time.Duration;

import io.appium.java_client.android.AndroidDriver;

public class DriverUtility {

	AndroidDriver driver;

	public DriverUtility(AndroidDriver driver) {
		this.driver = driver;
	}
	public void installApp(String pathOfApplication) {
		driver.installApp(pathOfApplication);
	}
	public void activateApp(String packageName) {
		driver.activateApp(packageName);
	}
	
	public void quitApp() {
		driver.quit();
	}
	public void implicitWait() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
	}
}
