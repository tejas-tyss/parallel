package com.moneycontrol.pages;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.moneycontrol.init.CommonUtility;

import io.appium.java_client.android.AndroidDriver;

public class Hamburger {

	public AndroidDriver aDriver;

	CommonUtility commonUtility;

	public Hamburger(AndroidDriver aDriver) {
		this.aDriver=aDriver;
		commonUtility = new CommonUtility(aDriver);
		PageFactory.initElements(aDriver, this);
	}

	@FindBy(xpath = "//*[@text='Skip']")
	private WebElement skipButton;

	@FindBy(xpath = "//android.widget.Spinner[@resource-id='com.divum.MoneyControl:id/dropdown_ll']")
	private WebElement languageDropdown;

	@FindBy(id = "android:id/text1")
	private WebElement languageDropTxt;


	@FindBy(xpath = "//android.widget.CheckedTextView[@text='English']")
	private WebElement englishLanguageButton;

	@FindBy(id = "com.divum.MoneyControl:id/rbEnglish")
	private WebElement englishRadioButton;

	@FindBy(id="com.divum.MoneyControl:id/rbHindi")
	private WebElement hindiRadioButton;

	@FindBy(id = "com.divum.MoneyControl:id/rbGujarti")
	private WebElement gujaratiRadioButton;

	@FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.divum.MoneyControl:id/menu_ll']/descendant::android.widget.TextView[@resource-id='com.divum.MoneyControl:id/menuName' and @text='News']")
	private WebElement newsButton;

	@FindBy(xpath = "//android.widget.TextView[@text='Top News']")
	private WebElement topNewsButton;

	@FindBy(xpath = "//android.widget.TextView[@text='My News']")
	private WebElement myNewsButton;

	@FindBy(xpath = "//android.widget.TextView[@text='Markets']")
	private WebElement marketsButton;

	@FindBy(xpath = "//android.widget.TextView[@text='Stocks']")
	private WebElement stocksButton;

	@FindBy(xpath = "//android.widget.TextView[@text='Personal Finance']")
	private WebElement personalFinanceButton;

	@FindBy(xpath = "//android.widget.TextView[@text='Opinion']")
	private WebElement opinionButton;

	@FindBy(xpath = "//android.widget.TextView[@text='Podcasts']")
	private WebElement podcastsButton;

	@FindBy(xpath = "//android.widget.TextView[@text='Business']")
	private WebElement businessButton;

	@FindBy(xpath = "//android.widget.TextView[@text='Moneycontrol Research']")
	private WebElement moneycontrolResearchButton;

	@FindBy(xpath = "//android.widget.TextView[@text='Mutual Funds']")
	private WebElement mutualFundsButton;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.divum.MoneyControl:id/submenuName'and @text='Mutual Funds']")
	private WebElement newsMutualFundsButton;

	@FindBy(xpath = "//android.widget.TextView[@text='Commodities']")
	private WebElement commoditiesButton;

	@FindBy(xpath = "//android.widget.TextView[@text='Economy']")
	private WebElement economyButton;

	@FindBy(xpath = "//android.widget.TextView[@text='Politics']")
	private WebElement politicsButton;

	@FindBy(xpath = "//android.widget.TextView[@text='International']")
	private WebElement internationalButton;

	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.divum.MoneyControl:id/submenuName'and @text='Startup']")
	private WebElement newsStartupButton;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.divum.MoneyControl:id/submenuName'and @text='Top News']")
	private WebElement newsTopNewsButton;

	@FindBy(xpath = "//*[@resource-id='com.divum.MoneyControl:id/bottomTabs']//android.widget.RelativeLayout[@index='0']")
	private WebElement homeTab;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.divum.MoneyControl:id/submenuName'and @text='Videos']")
	private WebElement videosOnDemandButton;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.divum.MoneyControl:id/submenuName'and @text='Market Movers']")
	private WebElement marketMoversButton;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.divum.MoneyControl:id/menuName' and @text='Personal Finance']")
	private WebElement personalFinanceMenu;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.divum.MoneyControl:id/menuName' and @text='Events Calendar']")
	private WebElement eventsCalendarMenu;

	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.divum.MoneyControl:id/submenuName'and @text='Top Commodities']")
	private WebElement topCommoditiesButton;
	
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.divum.MoneyControl:id/submenuName'and @text='Currency Movers']")
	private WebElement currencyMoversButton;
	
	public void selectEnglishLanguage() {
		commonUtility.click(languageDropdown, "Dropdown Button");
		commonUtility.click(englishLanguageButton, "English Language");

	}

	public void tapOnNewsInHamburger() {
		commonUtility.click(newsButton, "News In Hamburger Menu");
	}
	
	

	public void selectOptionInHamburgerMenu(String option) {
		commonUtility.scrollToElement(newsMutualFundsButton);
		int height = aDriver.manage().window().getSize().getHeight();
		Point loc = newsMutualFundsButton.getLocation();
		int y = loc.y;
		if(height-y<height/2) {
			commonUtility.verticalScroll(height-y);
		}
		newsMutualFundsButton.click();
		
	}

	public void tapOnMutualFundsPrsentInNewsSec() {
		commonUtility.scrollAndClick(newsMutualFundsButton);
		
	}

	public void tapOnStartupPresentInNews() {
		commonUtility.scrollAndClick(newsStartupButton);
		
	}
	
	public void tapOnTopNewsPresentInNews() {
		commonUtility.scrollAndClick(newsTopNewsButton);
		
	}
	
	public void tapOnVideosOnDemandButton() {
		commonUtility.scrollAndClick(videosOnDemandButton);
		
	}
	
	public void tapOnMarketMoversButton() {
		commonUtility.click(marketMoversButton, "Market Movers");
	}
	
	public void tapOnPersonalFinanceMenu() {
		commonUtility.click(personalFinanceMenu, "Personal Finance Menu");
	}
	
	public void tapOnEventsCalendar() {
		commonUtility.click(eventsCalendarMenu, "Events Calendar");
	}

	public void tapOnTopCommoditiesButton() {
		commonUtility.scrollAndClick(topCommoditiesButton);
	}
	
	public void tapOnCurrencyMoversButton() {
		commonUtility.scrollAndClick(currencyMoversButton);
	}
	
}
