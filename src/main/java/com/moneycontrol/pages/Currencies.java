package com.moneycontrol.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.moneycontrol.init.CommonUtility;

import io.appium.java_client.android.AndroidDriver;

public class Currencies {

	public AndroidDriver aDriver;

	CommonUtility commonUtility;

	public Currencies(AndroidDriver aDriver) {
		this.aDriver=aDriver;
		commonUtility = new CommonUtility(aDriver);
		PageFactory.initElements(aDriver, this);
	}
	
	@FindBy(xpath = "//android.widget.RelativeLayout[@resource-id='com.divum.MoneyControl:id/toolbar_wrapper']/following-sibling::android.widget.RelativeLayout[@resource-id='com.divum.MoneyControl:id/admobi_root']")
	private WebElement topBannerAd;
	
	public String tapOnTapBannerAd() throws InterruptedException {
		String currenActivity = aDriver.currentActivity();
		Thread.sleep(10000);
		commonUtility.click(topBannerAd, "Top Banner Ad");
		return currenActivity;
	}
}
