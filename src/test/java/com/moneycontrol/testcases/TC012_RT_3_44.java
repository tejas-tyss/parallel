package com.moneycontrol.testcases;

import org.testng.annotations.Test;

import com.moneycontrol.init.CommonConfig;
import com.moneycontrol.pages.Hamburger;
import com.moneycontrol.pages.Homepage;
import com.moneycontrol.pages.NewsPage;

public class TC012_RT_3_44 extends CommonConfig {
	
	@Test(description = "RT_3.44 Validate when user tap on Ad Creative")
	 public void Test_RT_3_44() throws InterruptedException {
		 Homepage homepage = new Homepage(aDriver);
		 Hamburger hamburger = new Hamburger(aDriver);
		 NewsPage newsPage = new NewsPage(aDriver);

		 homepage.launchApp();
		 
		 //Tap on 'Hamburger' Menu in the 'Home' screen
		 homepage.tapOnHamburgerMenu();
		 
		 //Tap on 'Mutual funds' under News
		 hamburger.tapOnMutualFundsPrsentInNewsSec();
		 
		 //Tap on Mid banner Ad which is present on 'Mutual funds' screen
		 String currentActivity = newsPage.tapOnMidBannerAd();
		 
		 /*Ad Creative landing page can be
		 a) URL or
		 b) Playstore or
		 c) Native app */
		 homepage.verifyAd(currentActivity);
		 
	}

}
