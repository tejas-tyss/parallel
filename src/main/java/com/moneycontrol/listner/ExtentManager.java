package com.moneycontrol.listner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null)
			createInstance("./Reports/HtmlReport.html");
		return extent;
	}

	public static ExtentReports createInstance(String fileName) {
		
		ExtentReports extent = new ExtentReports();
		ExtentHtmlReporter sparkReporter = new ExtentHtmlReporter(fileName);
		extent.attachReporter(sparkReporter);
		sparkReporter.loadXMLConfig(System.getProperty("user.dir")+"./src\\main\\resources\\ExtentConfiguration\\extent-config.xml");
		return extent;
	}
}