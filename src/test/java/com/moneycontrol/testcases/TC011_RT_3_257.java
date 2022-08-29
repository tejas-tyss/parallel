package com.moneycontrol.testcases;

import org.testng.annotations.Test;

import com.moneycontrol.init.CommonConfig;
import com.moneycontrol.pages.Currencies;
import com.moneycontrol.pages.Hamburger;
import com.moneycontrol.pages.Homepage;

public class TC011_RT_3_257 extends CommonConfig{

	@Test(description = "Validate when user tap on Ad Creative")
	public void Test_3_257() throws InterruptedException {
		Homepage homepage = new Homepage(aDriver);
		Hamburger hamburger = new Hamburger(aDriver);
		Currencies currencies = new Currencies(aDriver);
		
		homepage.launchApp();
		
		//Tap on 'Hamburger' Menu in the 'Home' screen
		homepage.tapOnHamburgerMenu();
		
		//Tap on 'Currency Movers' under 'Currencies' section
		hamburger.tapOnCurrencyMoversButton();
		
		// Tap on Top banner ad present on the 'Currency Movers' screen
		String currentActivity = currencies.tapOnTapBannerAd();
		
		/*Ad Creative landing page can be
		 a) URL or
		 b) Playstore or
		 c) Native app */
		 homepage.verifyAd(currentActivity);
		
	}
}
