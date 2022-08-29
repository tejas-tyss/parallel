package com.moneycontrol.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class WelcomePage {
	
	private AndroidDriver driver;

	public WelcomePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="com.divum.MoneyControl:id/rbEnglish")
	private WebElement englishLanguage;

	@FindBy(id="com.divum.MoneyControl:id/btn_getStarted")
	private WebElement getStarted;
	
	@FindBy(xpath="//android.widget.RelativeLayout[@resource-id='com.divum.MoneyControl:id/admobi_root']")
    private WebElement topBannerAd;

	
//	String getStarted = "com.divum.MoneyControl:id/btn_getStarted";

	@FindBy(xpath="//*[@text='Skip']")
	private WebElement skipText;


	public void clickOnElement() {
		getStarted.click();
		skipText.click();

	}
	
	public void clickOnTopBannerAd() throws InterruptedException {
		boolean check = topBannerAd.isDisplayed();
		System.out.println(check);
		System.out.println(driver.currentActivity());
		topBannerAd.click();
		System.out.println(driver.currentActivity());
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(2000);
		System.out.println(driver.currentActivity());
		
	}

}
