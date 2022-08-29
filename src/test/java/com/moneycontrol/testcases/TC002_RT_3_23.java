package com.moneycontrol.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.moneycontrol.init.CommonConfig;
import com.moneycontrol.pages.Hamburger;
import com.moneycontrol.pages.Homepage;
import com.moneycontrol.pages.NewsArticlePage;
import com.moneycontrol.pages.NewsPage;

public class TC002_RT_3_23 extends CommonConfig {
	
	@Test(description = "RT_3.23 Validate when user tap on Ad Creative")
	 public void Test_RT_3_23() throws InterruptedException, IOException {
		 Homepage homepage = new Homepage(aDriver);
		 Hamburger hamburger = new Hamburger(aDriver);
		 NewsPage topNews = new NewsPage(aDriver);
		 NewsArticlePage newsArticlePage = new NewsArticlePage(aDriver);

		 homepage.launchApp();
		 
		 //Tap on 'Hamburger' Menu in the 'Home' screen
		 homepage.tapOnHamburgerMenu();
		 
		 //Tap on 'News' section
		 hamburger.tapOnNewsInHamburger();
		 
		 //Tap on any articles under 'Top News' screen
		 topNews.clickOnArticleInTopNews();
		 
		 //Tap on mid banner Ad which is present on the 'News Details' screen
		  String currentActivity = newsArticlePage.tapOnMidBannerAd();
		 
		 /*Ad Creative landing page can be
		 a) URL or
		 b) Playstore or
		 c) Native app */
		 homepage.verifyAd(currentActivity);
	}

}
