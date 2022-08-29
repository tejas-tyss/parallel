package com.moneycontrol.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.moneycontrol.init.CommonConfig;
import com.moneycontrol.pages.Hamburger;
import com.moneycontrol.pages.Homepage;

public class TC013_RT_3_5 extends CommonConfig {
	
	@Test(description = "Validate when user tap on Ad Creative")
	 public void Test_RT_3_5() throws InterruptedException, IOException {
		 Homepage homepage = new Homepage(aDriver);
		 Hamburger hamburger = new Hamburger(aDriver);
		 
		 homepage.launchApp();

		 //Tap on 'Hamburger' Menu in the 'Home' screen
		 homepage.tapOnHamburgerMenu();
		 
		 //Tap on 'English' language from the dropdown which is present near the 'Settings icon'  feature 
		 hamburger.selectEnglishLanguage();
		 
		 //Tap on 'Home' in the footer of the 'Home' screen
		 homepage.tapOnHomeicon();
		 
		 // Tap on Logo Banner ad which is present within the 'Indices' section of the 'Home' screen
		 String currentActivity =  homepage.tapOnIndicesLogoBannerAd();
		 
		 /*Ad Creative landing page can be
		 a) URL or
		 b) Playstore or
		 c) Native app */
		 homepage.verifyAd(currentActivity);

	}
	
}
