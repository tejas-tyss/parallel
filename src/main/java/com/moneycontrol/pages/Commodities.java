package com.moneycontrol.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.moneycontrol.init.CommonUtility;

import io.appium.java_client.android.AndroidDriver;

public class Commodities {

	public AndroidDriver aDriver;

	CommonUtility commonUtility;

	public Commodities(AndroidDriver driver) {
		this.aDriver = driver;
		commonUtility = new CommonUtility(aDriver);
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(id="com.divum.MoneyControl:id/admobi_root")
	private WebElement topBannerAd;
	
	public String tapOnTopBannerAd() throws InterruptedException {
		String currenActivity = aDriver.currentActivity();
		Thread.sleep(10000);
		commonUtility.click(topBannerAd, "Top Banner Ad");
		return currenActivity;
	}
}
