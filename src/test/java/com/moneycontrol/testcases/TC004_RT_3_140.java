package com.moneycontrol.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.moneycontrol.init.CommonConfig;
import com.moneycontrol.pages.Hamburger;
import com.moneycontrol.pages.Homepage;

public class TC004_RT_3_140 extends CommonConfig{

	@Test(description = "Validate when user tap on Ad Creative")
	public void Test_RT_3_140() throws IOException, InterruptedException {
		Homepage homepage = new Homepage(aDriver);
		Hamburger hamburger = new Hamburger(aDriver);

		homepage.launchApp();
		
		//Tap on 'Hamburger' Menu in the 'Home' screen
		homepage.tapOnHamburgerMenu();

		//Tap on 'English' language from the dropdown
		hamburger.selectEnglishLanguage();

		//Tap on 'Home' in the footer
		homepage.tapOnHomeicon();

		//Tap on mid banner ad below the 'For You' feature
		String currentActivity = homepage.tapOnMidBannerAdBelowForYouFeature();
		
		/*Ad Creative landing page can be
		 a) URL or
		 b) Playstore or
		 c) Native app */
		 homepage.verifyAd(currentActivity);
	}
}
