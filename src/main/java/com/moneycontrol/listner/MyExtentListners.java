/***********************************************************************
* @author 			:		Janardhan P
* @description		: 		Listener Class to Generate Report based on ItestListener abstract methods
* @methods 			: 		
*/

package com.moneycontrol.listner;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.moneycontrol.init.CommonConfig;
import com.moneycontrol.init.CommonUtility;
import com.moneycontrol.init.IPath;

public class MyExtentListners implements ITestListener {

	public static String[] sDataGuest = null;
	public static ExtentHtmlReporter sparkReport;
	public static ExtentReports extent;
	public static ExtentTest test;
	int count = 1;
	public static String sExcelDate;
	public static String sExcelPath;
	public static String screenShotPath;
	public static int iPassCount = 0;
	public static int iFailCount = 0;
	public static int iSkippedCount = 0;
	public static int iTotal_Executed;
	public static String sStartTime;
	public static String sEndTime;
	public static long lTotalExecutionTime;
	public static ArrayList<String> sStatus = new ArrayList<String>();
	public static ArrayList<String> sStartMethodTime = new ArrayList<String>();
	public static ArrayList<String> sMethodEndTime = new ArrayList<String>();
	public static ExtentTest parentTest;
	public static ExtentTest childTest;
	

	public static long startTime;
	public static long endtTime;
	String className;
	String current_className;
	int parentCount = 0;
	

	/*
	 * @author:Janardhan P
	 * 
	 * Description: On Test Starts Create a report based on @Test Method Name
	 */
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart");
		String methodName = result.getMethod().getMethodName().toString();
		current_className = result.getTestClass().getName().toString();
		
//		current_className = current_className.substring(current_className.lastIndexOf('.', 2) + 1, current_className.length());

		if(parentCount == 0 || !className.equalsIgnoreCase(current_className) ) {
			className = result.getTestClass().getName().toString();
			className = className.substring(className.lastIndexOf(".") + 1, className.length());
			System.out.println(className);
			parentTest = extent.createTest(className);
			parentCount = parentCount+1;
		}
		String description = result.getMethod().getDescription();
		test = parentTest.createNode(methodName, description);
		startTime = result.getStartMillis();
		sStartMethodTime.add(startTime + "");
		test.info("Launched App");
		test.info(methodName + " has started");
	}

	
	/*
	 * @author:Janardhan P
	 * 
	 * Description: On Test Success Write Status Passed to Extent Report
	 */
	public void onTestSuccess(ITestResult result) {
		endtTime = result.getEndMillis();
		long totTimeInMethod = endtTime - startTime;
		int seconds = (int) (totTimeInMethod / 1000L) % 60;
		int minutes = (int) (totTimeInMethod / 60000L % 60L);
		int hours = (int) (totTimeInMethod / 3600000L % 24L);
		sStatus.add("Passed");
		test.pass(MarkupHelper.createLabel(result.getMethod().getMethodName().toString() + " case has PASSED", ExtentColor.GREEN));
		try {
			extent.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * @author:Janardhan P
	 * 
	 * Description: On Test Failure Write Status Failed to Extent Report With Label
	 * RED
	 */
	public void onTestFailure(ITestResult result) {
		sStatus.add("Failed");
		test.fail(MarkupHelper.createLabel(className + " test script has FAILED", ExtentColor.RED));
		String temp = null;
		try {
			temp = CommonConfig.getScreenShot(screenShotPath);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			test.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			extent.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * @author:Janardhan P
	 * 
	 * Description: On Test Skipped Write Status Skipped to Extent Report With Label
	 * YELLOW
	 */
	public void onTestSkipped(ITestResult result) {
		sStatus.add("Skipped");
		test.skip(MarkupHelper.createLabel(className + " test script has SKIPPED", ExtentColor.YELLOW));
		try {
			extent.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	/*
	 * @author:Janardhan P
	 * 
	 * Description: On Suite Starts 1. Create Directories for Extent Reports, Excel
	 * Report and Screenshots based on system time 2. Add Execution Info Based
	 * Execution Type
	 */

	public void onStart(ITestContext context) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String sDate = sdf.format(date);
		sExcelDate = sDate;
		sStartTime = sDate;
		String testOutputDir = IPath.sDirPath + "/test-output";
		String htmlDir = IPath.sDirPath + "/reports" + "/Run-" + sDate + "/extent/";
		String excelDir = IPath.sDirPath + "/reports" + "/Run-" + sDate + "/excel/";
		sExcelPath = excelDir;
		screenShotPath = IPath.sDirPath + "/reports" + "/Run-" + sDate + "/extent/screenshots/";
		System.out.println(testOutputDir);
		System.out.println(htmlDir);

		// Setting test-output folder location
		File testOutputFile = new File(testOutputDir);

		if (!testOutputFile.exists()) {
			System.out.println(testOutputFile + " does not exist");
			return;
		}
		
		// deletes the test output folder
		if (testOutputFile.isDirectory()) {
			try {
				testOutputFile.delete();
				System.out.println("------test output dir deleted--------");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Deleted file/folder: " + testOutputFile.getAbsolutePath());

		// Setting Extent Report Location
		File file = new File(htmlDir);
		if (!(file.exists())) {
			file.mkdirs();
			System.out.println("--extent folder created");
		}
		String filepath = htmlDir + "extent_" + sDate + ".html";
		System.out.println(filepath);
		File file1 = new File(filepath);
		if (!(file1.exists())) {
			try {
				file1.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// Setting ScreenShot Report Location
		File file3 = new File(screenShotPath);
		if (!(file3.exists())) {
			file3.mkdirs();
			System.out.println("--scrrenshot folder created");
		}

		extent = ExtentManager.createInstance(file1.toString());
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}