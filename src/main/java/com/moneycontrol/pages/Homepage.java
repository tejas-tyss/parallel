package com.moneycontrol.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.moneycontrol.init.CommonUtility;
import com.moneycontrol.listner.MyExtentListners;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class Homepage {

	public AndroidDriver aDriver;

	CommonUtility commonUtility;

	public Homepage(AndroidDriver driver) {
		this.aDriver = driver;
		commonUtility = new CommonUtility(aDriver);
		PageFactory.initElements(driver, this);

	}


	public WebElement getHamburgerMenu() {
		return hamburgerMenu;
	}


	@FindBy(xpath = "//*[@text='Skip']")
	private WebElement skipButton;

	@FindBy(id = "com.divum.MoneyControl:id/menu_button")
	private WebElement hamburgerMenu;

	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.divum.MoneyControl:id/nav_label' and @text='Home']")
	private WebElement homeTab;

	@FindBy(xpath = "//*[@resource-id='com.divum.MoneyControl:id/bottomTabs']//android.widget.RelativeLayout[@index='1']")
	private WebElement marketsTab;

	@FindBy(xpath = "//*[@resource-id='com.divum.MoneyControl:id/bottomTabs']//android.widget.RelativeLayout[@index='2']")
	private WebElement beAProTab;

	@FindBy(xpath = "//*[@resource-id='com.divum.MoneyControl:id/bottomTabs']//android.widget.RelativeLayout[@index='3']")
	private WebElement newsTab;

	@FindBy(xpath = "//*[@resource-id='com.divum.MoneyControl:id/bottomTabs']//android.widget.RelativeLayout[@index='4']")
	private WebElement portfolioTab;

	@FindBy(xpath = "//android.widget.RelativeLayout[@resource-id='com.divum.MoneyControl:id/toolbar_wrapper']/following-sibling::android.widget.RelativeLayout[@resource-id='com.divum.MoneyControl:id/admobi_root']")
	private WebElement topBannerAd;

	@FindBy(xpath = "//*[@text='For You']/ancestor::android.widget.LinearLayout[@resource-id='com.divum.MoneyControl:id/exploreContainer']/parent::android.widget.LinearLayout/following-sibling::android.widget.FrameLayout[1]")
	private WebElement midBannerAdBelowForYouFeature;
	
	@FindBy(xpath = "//*[@text='Cryptocurrency']/ancestor::android.view.ViewGroup/preceding-sibling::android.widget.FrameLayout")
	private WebElement bottomBannerAd;
	
	@FindBy(xpath="//android.widget.RelativeLayout[@resource-id='com.divum.MoneyControl:id/headerAdContainer']/descendant::android.view.View[@resource-id='google_image_div']")
	private WebElement logoAdInIndicesSection;

	public void tapOnHamburgerMenu() {
		commonUtility.click(getHamburgerMenu(), "Hamburger Menu");
	}

	public void verifyAd(String currentActivity) throws InterruptedException{
//		Thread.sleep(10000);
//		Set<String> con = aDriver.getContextHandles();
//		System.out.println(con);
//		Thread.sleep(5000);
//		WebDriver driver = aDriver.context("WEBVIEW_chrome");
//		String mainWindow = driver.getWindowHandle();
//		driver.switchTo().window(mainWindow);
//		String url = driver.getCurrentUrl();
//		System.out.println(url);
//		MyExtentListners.test.pass("Navigated to Ad url - "+url);
		Thread.sleep(5000);
		System.out.println(currentActivity);
		Thread.sleep(5000);
		String verifyActivity = aDriver.currentActivity();
		System.out.println(verifyActivity);
		if(verifyActivity.equalsIgnoreCase(currentActivity)) {
			MyExtentListners.test.fail("Failed to Navigate to Ad page ");
			Assert.assertNotEquals(verifyActivity, currentActivity, "Failed in navigating to Ad Page");
		}
		else {
			MyExtentListners.test.pass("App Successfully Navigate to Ad page ");
		}
	}


	public String tapOnTopBannerAd() throws IOException, InterruptedException {
		String currentActivity = aDriver.currentActivity();
		Thread.sleep(2000);
		topBannerAd.click();
		return currentActivity;
	}

	public void tapOnHomeicon() {
		commonUtility.click(homeTab, "Home Icon");
		commonUtility.refreshPage();

	}


	public String tapOnIndicesLogoBannerAd() throws InterruptedException {
		String currentActivity = aDriver.currentActivity();
		Thread.sleep(1000);
		commonUtility.refreshPage();
		commonUtility.click(logoAdInIndicesSection, "Indices Logo Banner Ad");
		return currentActivity;
	}

	
	public String tapOnMidBannerAdBelowForYouFeature() throws IOException, InterruptedException{
//		commonUtility.click(midBannerAdBelowForYouFeature, "Mid Banner Ad below For You feature");
		String currentActivity = aDriver.currentActivity();
		Thread.sleep(1000);
		commonUtility.refreshPage();
		commonUtility.click(midBannerAdBelowForYouFeature, "Mid Banner Ad"); 
		return currentActivity;
	}
	

	public String clickOnBottomBannerAd() throws InterruptedException {
		String currentActivity = aDriver.currentActivity();
		Thread.sleep(1000);
		commonUtility.scrollToElement(bottomBannerAd);
		commonUtility.click(bottomBannerAd, "Bottom banner Ad in home page");
//		Thread.sleep(1000);
//		bottomBannerAd.click();
		return currentActivity;
	}
	

	public void launchApp() {
		Activity activity = new Activity("com.divum.MoneyControl", "com.moneycontrol.handheld.SplashActivity");
		aDriver.startActivity(activity);
	}
	
	










}
