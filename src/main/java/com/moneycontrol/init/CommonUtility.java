package com.moneycontrol.init;


import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.moneycontrol.listner.MyExtentListners;

import io.appium.java_client.android.AndroidDriver;


public class CommonUtility {

	public AndroidDriver aDriver;
	JavascriptExecutor js;
	public static String pageLoadStatus = "";

	public CommonUtility(AndroidDriver driver) {
		this.aDriver=driver;
		js = (JavascriptExecutor)driver;
	}


	/**
	 * @author Janardhan
	 * This method will wait until element is visible
	 * @param element
	 * @param time
	 */
	public void waitForElementVisibility(WebElement element, int sec) {	
		WebDriverWait wait = new WebDriverWait(aDriver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
	}


	public void waitForPageToLoad() {
		do {
			pageLoadStatus = (String) js.executeScript("return document.readyState");
		} while (!pageLoadStatus.equals("complete"));
		Logs.info(getClass(), "Waiting for Page Load");
	}


	/**
	 * @author Janardhan
	 * This method is used to wait till the element is clicked
	 * @param element
	 * @param i
	 */
	public void waitForElementClickable(WebElement element, int sec) {
		WebDriverWait wait=new WebDriverWait(aDriver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(element));   
		//		Logs.info(getClass(), "Wait for "+element +" till "+time);
	}


	/**
	 * @author Janardhan
	 * This method is used to click on element
	 * @param element
	 */
	public void click(WebElement element, String text) {
		try {
			waitForElementVisibility(element, 20);
			waitForElementClickable(element, 20);
			element.click();
			MyExtentListners.test.pass("Tapped on "+text); 
		}
		catch(Exception e){
			MyExtentListners.test.fail("Failed in Tapping on "+text);
		}
		
	}


	/**
	 * @author Janardhan
	 * @param element
	 * @throws IOException
	 */
	public void tapUsingAdb(WebElement element) throws IOException {
		Point eleSize = element.getLocation();
		int x = eleSize.getX()+100;
		int y = eleSize.getY()+10;
		String cmd = "adb shell input tap "+x+" "+y;
		System.out.println(cmd);
		Runtime.getRuntime().exec(cmd);
	}


	/**
	 * @author Janardhan 
	 * @param element
	 * @return boolean value
	 */
	public boolean isElementDisplayed(WebElement element) {
		aDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		try {
			element.isDisplayed();
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}


	public void verticalScroll(){
		int height = aDriver.manage().window().getSize().getHeight();
		int width = aDriver.manage().window().getSize().getWidth();
		int centerX = (int)(width/2);
		double startY = (int)(height*0.6);
		double endY = (int)(height*0.1);

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence swipe = new Sequence(finger, 1);
		swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), centerX, (int)startY));
		swipe.addAction(finger.createPointerDown(0));
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), centerX, (int)endY));
		swipe.addAction(finger.createPointerUp(0));
		aDriver.perform(Arrays.asList(swipe));
	}


	public void refreshPage(){
		int height = aDriver.manage().window().getSize().getHeight();
		int width = aDriver.manage().window().getSize().getWidth();
		int centerX = (int)(width/2);
		double startY = (int)(height*0.2);
		double endY = (int)(height*0.9);

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence swipe = new Sequence(finger, 1);
		swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), centerX, (int)startY));
		swipe.addAction(finger.createPointerDown(0));
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), centerX, (int)endY));
		swipe.addAction(finger.createPointerUp(0));
		aDriver.perform(Arrays.asList(swipe));
	}

	
	public void scrollToElement(WebElement ele) {
		for (int i = 0; i < 10; i++) {
			if(isElementDisplayed(ele)) {
				break;
			}
			else {
				verticalScroll();
			}

		}
	}

	
	/**
	 * @author Janardhan
	 * @param ele
	 */
	public void scrollAndClick(WebElement ele) {
		for (int i = 0; i < 10; i++) {
			if(isElementDisplayed(ele)) {
				int height = aDriver.manage().window().getSize().getHeight();
				Point loc = ele.getLocation();
				int y = loc.y;
				if(height-y<height/2) {
					verticalScroll(height-y);
				}
				click(ele, "");
				break;
			}
			else {
				verticalScroll();
			}
		}
	}


	/**
	 * @author Janardhan
	 * @param endY
	 */
	public void verticalScroll(int endY){
		int height = aDriver.manage().window().getSize().getHeight();
		int width = aDriver.manage().window().getSize().getWidth();
		int centerX = (int)(width/2);
		double startY = (int)(height*0.8);

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence swipe = new Sequence(finger, 1);
		swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), centerX, (int)startY));
		swipe.addAction(finger.createPointerDown(0));
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), centerX, (int)endY));
		swipe.addAction(finger.createPointerUp(0));
		aDriver.perform(Arrays.asList(swipe));
	}


	public void horizonalScroll(){
		int height = aDriver.manage().window().getSize().getHeight();
		int width = aDriver.manage().window().getSize().getWidth();
		int centerY = (int)(height/2);   
		double startX = (int)(width*0.9);
		double endX = (int)(width*0.1);

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence swipe = new Sequence(finger, 1);
		swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), (int)startX, centerY));
		swipe.addAction(finger.createPointerDown(0));
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), (int)endX, centerY));
		swipe.addAction(finger.createPointerUp(0));
		aDriver.perform(Arrays.asList(swipe));
	}
	
	public void handlePopUp(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
