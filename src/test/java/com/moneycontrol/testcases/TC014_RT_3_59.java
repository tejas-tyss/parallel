package com.moneycontrol.testcases;

import org.testng.annotations.Test;

import com.moneycontrol.init.CommonConfig;
import com.moneycontrol.pages.Hamburger;
import com.moneycontrol.pages.Homepage;

import com.moneycontrol.pages.NewsPage;

public class TC014_RT_3_59 extends CommonConfig {
	
	@Test(description = "Validate when user tap on Ad Creative")
	 public void test1() throws InterruptedException {
		 Homepage homepage = new Homepage(aDriver);
		 Hamburger hamburger = new Hamburger(aDriver);
		 NewsPage newsPage = new NewsPage(aDriver);

		 homepage.launchApp();
		 
		 //Tap on 'Hamburger' Menu in the 'Home' screen
		 homepage.tapOnHamburgerMenu();
		 
		 //Tap on 'Startup' under News
		 hamburger.tapOnStartupPresentInNews();
		 
		 //Tap on the mid banner ad which is present on 'Startup' screen
		 String currentActivity = newsPage.tapOnMidBannerAd();
		 
		 /*Ad Creative landing page can be
		 a) URL or
		 b) Playstore or
		 c) Native app */
		 homepage.verifyAd(currentActivity);
		 
	}

}
