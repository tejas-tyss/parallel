package com.moneycontrol.testcases;

import org.testng.annotations.Test;

import com.moneycontrol.init.CommonConfig;
import com.moneycontrol.pages.Hamburger;
import com.moneycontrol.pages.Homepage;

public class TC005_RT_3_149 extends CommonConfig{

	@Test(description = "Validate when user tap on Ad Creative")
	public void Test_RT_3_149() throws InterruptedException {
		Homepage homepage = new Homepage(aDriver);
		Hamburger hamburger = new Hamburger(aDriver);

		homepage.launchApp();
		
		//Tap on 'Hamburger' Menu in the 'Home' screen
		homepage.tapOnHamburgerMenu();

		//Tap on 'English' language from the dropdown
		hamburger.selectEnglishLanguage();

		//Tap on 'Home' in the footer
		homepage.tapOnHomeicon();

		// Tap on bottom banner ad on the 'Home' screen
		String currentActivity = homepage.clickOnBottomBannerAd();

		/*Ad Creative landing page can be
		 a) URL or
		 b) Playstore or
		 c) Native app */
		homepage.verifyAd(currentActivity);
	}
}
