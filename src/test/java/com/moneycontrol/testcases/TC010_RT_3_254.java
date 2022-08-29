package com.moneycontrol.testcases;

import org.testng.annotations.Test;

import com.moneycontrol.init.CommonConfig;
import com.moneycontrol.pages.Commodities;
import com.moneycontrol.pages.Hamburger;
import com.moneycontrol.pages.Homepage;

public class TC010_RT_3_254 extends CommonConfig{

	@Test(description = "Validate when user tap on Ad Creative")
	public void Test_3_254() throws InterruptedException {
		Homepage homepage = new Homepage(aDriver);
		Hamburger hamburger = new Hamburger(aDriver);
		Commodities commodities = new Commodities(aDriver);
		
		homepage.launchApp();
		
		//Tap on 'Hamburger' Menu in the 'Home' screen
		homepage.tapOnHamburgerMenu();
		
		// Tap on 'Top Commodities' under 'Commodities' section
		hamburger.tapOnTopCommoditiesButton();
		
		//Tap on Top banner ad present on the 'Top Commodities' screen
		String currentActivity = commodities.tapOnTopBannerAd();
		
		/*Ad Creative landing page can be
		 a) URL or
		 b) Playstore or
		 c) Native app */
		 homepage.verifyAd(currentActivity);
	}
}
