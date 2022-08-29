package com.moneycontrol.testcases;

import org.testng.annotations.Test;

import com.moneycontrol.init.CommonConfig;
import com.moneycontrol.pages.Hamburger;
import com.moneycontrol.pages.Homepage;
import com.moneycontrol.pages.Markets;

public class TC007_RT_3_176 extends CommonConfig{

	@Test(description = "Validate when user tap on Ad Creative")
	public void Test_RT_3_176() throws InterruptedException {
		Homepage homepage = new Homepage(aDriver);
		Hamburger hamburger = new Hamburger(aDriver);
		Markets markets = new Markets(aDriver);
		
		homepage.launchApp();
		
		//Tap on 'Hamburger' Menu in the 'Home' screen
		 homepage.tapOnHamburgerMenu();
		 
		 // Tap on 'Market Movers' under 'Markets'
		 hamburger.tapOnMarketMoversButton();
		 
		 //Tap on Top banner ad which is present on the 'Markets' screen
		 String currentActivity = markets.tapOnTopBannerAd();
		 
		 /*Ad Creative landing page can be
		 a) URL or
		 b) Playstore or
		 c) Native app */
		 homepage.verifyAd(currentActivity);
	}
}
