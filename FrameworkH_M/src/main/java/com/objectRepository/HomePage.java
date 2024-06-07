package com.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.GestureUtility;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class HomePage {
  AndroidDriver driver;
  
	public HomePage(AndroidDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

	public WebElement getDivided() {
		return divided;
	}

	
	public WebElement getSportOpt() {
		return sportOpt;
	}


	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.hm.goe:id/textPill\" and @text=\"Sport\"]")		
	private WebElement sportOpt;
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.hm.goe:id/textPill\" and @text=\"Divided\"]")
	private WebElement divided;
	@FindBy(id="com.hm.goe:id/carouselImage")
	private WebElement dryMoveImg;
	
	@FindBy(id="com.hm.goe:id/ivCloseCarousel")
	private WebElement closedryMove;
	@FindBy(id="com.hm.goe:id/stickyAtbButton")
	private WebElement dryMoveBag;
	
	
	public WebElement getCloseDry() {
		return closeDry;
	}

	public WebElement getAddBagDry() {
		return addBagDry;
	}


	@FindBy(id="com.hm.goe:id/ivCloseCarousel")
	private WebElement closeDry;
	
	@FindBy(id="com.hm.goe:id/stickyAtbButton")
	private WebElement addBagDry;
	
	@FindBy(id="com.hm.goe:id/action_search_button")
	private WebElement searchOpt;
	@FindBy(xpath="//android.view.ViewGroup[@resource-id=\"com.hm.goe:id/hm_toolbar\"]/android.widget.ImageButton")
	private WebElement hamburgerOpt;
	
	public WebElement getDryMoveImg() {
		return dryMoveImg;
	}

	public void action(GestureUtility gUtil,String text,String direc,double per) throws InterruptedException {
		
		gUtil.scrollAction(text);
		//gUtil.swipeAction(divided, direc, per);
		WebElement dividedELe = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Divided\")"));
		gUtil.swipeAction(dividedELe, direc, per);
		sportOpt.click();
		WebElement dryMoveEle = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"DryMove™ Pocket-detail sports cycling shorts\")"));
		//gUtil.swipeAction(dryMoveEle, direcs, pers);
		dryMoveEle.click();
		dryMoveImg.click();
		Thread.sleep(2000);
		WebElement dryMovePhoto = driver.findElement(AppiumBy.id("com.hm.goe:id/carouselPhotoView"));
		gUtil.zoomIn(dryMovePhoto, per);
		Thread.sleep(2000);
		gUtil.zoomOut(dryMovePhoto, per);
		WebElement dryMoveSwipe = driver.findElement(AppiumBy.accessibilityId("Product Image"));
		gUtil.swipeAction(dryMoveSwipe, direc, per);
		WebElement dryMoveRight = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.hm.goe:id/carouselPhotoView\")"));
		gUtil.swipeAction(dryMoveRight, direc, per);
		closeDry.click();
		addBagDry.click();
	}
}
