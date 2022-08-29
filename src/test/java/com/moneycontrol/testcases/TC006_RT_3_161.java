package com.moneycontrol.testcases;

import org.testng.annotations.Test;

import com.moneycontrol.init.CommonConfig;
import com.moneycontrol.pages.Hamburger;
import com.moneycontrol.pages.Homepage;
import com.moneycontrol.pages.VideosOnDemand;

public class TC006_RT_3_161 extends CommonConfig{

	@Test(description = "Validate when user tap on Ad Creative")
	public void Test_RT_3_161() throws InterruptedException {
		Homepage homepage = new Homepage(aDriver);
		Hamburger hamburger = new Hamburger(aDriver);
		VideosOnDemand videosOnDemand = new VideosOnDemand(aDriver);
		
		homepage.launchApp();
		
		//Tap on 'Hamburger' Menu in the 'Home' screen
		 homepage.tapOnHamburgerMenu();
		 
		 //Tap on 'English' language from the dropdown
		 hamburger.selectEnglishLanguage();
		 
		 //Tap on 'Videos on Demand' under 'Media'
		 hamburger.tapOnVideosOnDemandButton();
		 
		 //Tap on Top banner ad which is present on the 'Videos on Demand' screen
		 String currentActivity = videosOnDemand.tapOnTopBannerAd();
		 
		 /*Ad Creative landing page can be
		 a) URL or
		 b) Playstore or
		 c) Native app */
		 homepage.verifyAd(currentActivity);
	}
}
