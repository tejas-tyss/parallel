package com.moneycontrol.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.moneycontrol.init.CommonUtility;

import io.appium.java_client.android.AndroidDriver;

public class NewsPage {
	
	public AndroidDriver aDriver;
	
	CommonUtility commonUtility;

	public NewsPage(AndroidDriver driver) {
		this.aDriver = driver;
		commonUtility = new CommonUtility(aDriver);
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "//androidx.viewpager.widget.ViewPager[@resource-id='com.divum.MoneyControl:id/pager']//android.view.ViewGroup[@resource-id='com.divum.MoneyControl:id/rl_item_container']")
	private WebElement articles;
	
	@FindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.divum.MoneyControl:id/nativeContentLayout']")
	private WebElement newsLayoutMidBannerAd;
	
	@FindBy(xpath = "//android.widget.RelativeLayout[@resource-id='com.divum.MoneyControl:id/toolbar_wrapper']/following-sibling::android.widget.RelativeLayout[@resource-id='com.divum.MoneyControl:id/admobi_root']")
	private WebElement newsLayoutTopBannerAd;
	
	
	public void clickOnArticleInTopNews() {
		commonUtility.click(articles, "Random Article News");
	}
	
	public String tapOnMidBannerAd() throws InterruptedException {
		String currentActivity = aDriver.currentActivity();
		commonUtility.click(newsLayoutMidBannerAd, "News Layout Mid Banner Ad");
		return currentActivity;
	}
	
	public String tapOnTopBannerAd() {
		String currentActivity = aDriver.currentActivity();
		commonUtility.click(newsLayoutTopBannerAd, "News Layout Top Banner Ad");
		return currentActivity;
	}
	
	

	
	


}
