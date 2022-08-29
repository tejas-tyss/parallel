package com.moneycontrol.init;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Demo {

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver aDriver;
		
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "device");		
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("appPackage", "com.divum.MoneyControl");
		capabilities.setCapability("appActivity", "com.moneycontrol.handheld.SplashActivity");
		capabilities.setCapability("autoAcceptAlerts", true);
		capabilities.setCapability("autoGrantPermissions", true);
		capabilities.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(AndroidMobileCapabilityType.BROWSER_NAME, "");	
		aDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		aDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

}
