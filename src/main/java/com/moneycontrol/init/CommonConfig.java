package com.moneycontrol.init;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class CommonConfig {
	
	public static AndroidDriver aDriver;
	String MCPkg = "com.divum.MoneyControl";
	
	@Parameters({"udid", "server"})
	@BeforeTest()
	public void setUp(String udid, String server) throws MalformedURLException{
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("device")
		.setNoReset(true)
		.setAppPackage("com.divum.MoneyControl")
		.setAppActivity("com.moneycontrol.handheld.SplashActivity")
		.setPlatformName("Android")
		.setAutoWebview(true)
		.setUdid(udid)
		.setChromedriverExecutable("C:\\Users\\Tejas S\\mc-pilot-workspace\\mc-pilot\\MC-Pilot\\src\\test\\resources\\drivers");
//		.setChromedriverExecutableDir("C:\\Users\\User\\Downloads\\MoneyControlPilot\\MoneyControlPilot\\src\\test\\resources\\drivers")
		URL url = new URL(server);
		aDriver = new AndroidDriver(url, options);	
		aDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	public static String getScreenShot(String screenShotPath) {
		TakesScreenshot ts = (TakesScreenshot) aDriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = screenShotPath + System.currentTimeMillis() + ".png";
		File destination = new File(path);
//		try {
//			Files.copyFile(src, destination);
//		} catch (IOException e) {
//			System.out.println("Capture Failed" + e.getMessage());
//		}
		return path;
	}
	
	@AfterMethod
	public void closeDriver() throws IOException {
//		aDriver.pressKey(new KeyEvent(AndroidKey.HOME));
		String currentPkg = aDriver.getCurrentPackage();
		Runtime.getRuntime().exec("adb shell am force-stop "+currentPkg);
		Runtime.getRuntime().exec("adb shell am force-stop "+MCPkg);
		
	}
	
	
	
}
