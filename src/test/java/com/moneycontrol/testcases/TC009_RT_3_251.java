package com.moneycontrol.testcases;

import org.testng.annotations.Test;

import com.moneycontrol.init.CommonConfig;
import com.moneycontrol.pages.EventsCalendar;
import com.moneycontrol.pages.Hamburger;
import com.moneycontrol.pages.Homepage;

public class TC009_RT_3_251 extends CommonConfig{

	@Test(description = "Validate when user tap on Ad Creative")
	public void Test_RT_3_251() throws InterruptedException {
		Homepage homepage = new Homepage(aDriver);
		Hamburger hamburger = new Hamburger(aDriver);
		EventsCalendar eventsCalendar = new EventsCalendar(aDriver);
		
		homepage.launchApp();
		
		//Tap on 'Hamburger' Menu in the 'Home' screen
		homepage.tapOnHamburgerMenu();

		// Tap on 'Event Calender'
		hamburger.tapOnEventsCalendar();
		
		//Tap on Top banner ad present on the 'Event Calender' screen
		String currentActivity = eventsCalendar.tapOnTopBannerAd();
		
		 /*Ad Creative landing page can be
		 a) URL or
		 b) Playstore or
		 c) Native app */
		 homepage.verifyAd(currentActivity);
	}
}
