package com.moneycontrol.pages;



import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.moneycontrol.init.CommonUtility;

import io.appium.java_client.android.AndroidDriver;

public class NewsArticlePage {
	
	public AndroidDriver aDriver;
	
	CommonUtility commonUtility;

	public NewsArticlePage(AndroidDriver driver) {
		this.aDriver = driver;
		commonUtility = new CommonUtility(aDriver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//android.view.View[@resource-id='ANDROIDPHONE_AD_UNIT_300_250_EN_div']")
	private WebElement midBannerAd;
	
	@FindBy(xpath = "//android.widget.TextView[@text='SWIPE ACROSS NEWS']")
	private WebElement swipeAcrossTxt;
	
	@FindBy(xpath = "//android.widget.ImageView[@resource-id='com.divum.MoneyControl:id/ivNewsNext']")
	private WebElement nextArticleArrowBtn;
	

	public String tapOnMidBannerAd() throws InterruptedException, IOException {
//		commonUtility.verticalScroll();
//		commonUtility.verticalScroll();
//		boolean check = commonUtility.isElementDisplayed(midBannerAd);
//		if(check == true) {
//			midBannerAd.click();
//		}
		String currentActivity = null;
		for (int i = 0; i < 5; i++) {
			for(int j=0;j<3;j++) {
				Thread.sleep(2000);
				commonUtility.verticalScroll();
				boolean check = commonUtility.isElementDisplayed(midBannerAd);
				if(check == true) {
					break;
				}
			}
			if(commonUtility.isElementDisplayed(midBannerAd)) {
				currentActivity = aDriver.currentActivity();
				midBannerAd.click();
//				commonUtility.tapUsingAdb(midBannerAd);
				break;
			}
			else {
				commonUtility.horizonalScroll();
			}
			
		}
		return currentActivity;
	}
}
