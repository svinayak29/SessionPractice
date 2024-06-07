package com.utilities;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.objectRepository.AddToCartPage;
import com.objectRepository.HomePage;
import com.objectRepository.ShoppingBagPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {
   FileUtility fUtil = new FileUtility();
   AndroidDriver driver;
   public GestureUtility gUtil;
   public DriverUtility dUtil;
   public HomePage home;
   public AddToCartPage addToCart;
   public ShoppingBagPage shoppingBag;
	AppiumDriverLocalService service;
	@BeforeSuite
	public void startServer()   {
		File f = new File("C:\\Users\\siddhi\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		service=new AppiumServiceBuilder().withAppiumJS(f).withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();
		
		service.start();
		System.out.println("Server Start");
		
	}
	
	@AfterSuite
	public void stopServer() {
		service.stop();
	}
	@BeforeClass
	public void launchApp() throws IOException {
		String platform = fUtil.readData("platformName");
		String device = fUtil.readData("deviceName");
	   String automation = fUtil.readData("automationName");
	   String udid = fUtil.readData("UDID");
	   String noreset = fUtil.readData("noRest");
		String ignoreApi = fUtil.readData("ignoreHiddenApiPolicyError");
		String permission = fUtil.readData("autoGrantPermission");
		String packageName = fUtil.readData("packageName");
		String url = fUtil.readData("url");
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName",platform);
		dc.setCapability("automationName",automation);
		dc.setCapability("deviceName", device);
		dc.setCapability("UDID", udid);
		dc.setCapability("noRest", noreset);
		dc.setCapability("ignoreHiddenApiPolicyError",ignoreApi );
		dc.setCapability("autoGrantPermission", permission);
		
		URL u = new URL(url);
		 driver = new AndroidDriver(u,dc);
		 driver.activateApp(packageName);
		
		 gUtil = new GestureUtility(driver);
		 dUtil = new DriverUtility(driver);	
		 dUtil.implicitWait();
		 home = new HomePage(driver);
		 addToCart =new AddToCartPage(driver);
		 shoppingBag = new ShoppingBagPage(driver);
		 
	}
}
