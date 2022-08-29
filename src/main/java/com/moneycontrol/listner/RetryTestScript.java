package com.moneycontrol.listner;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @author Rahul Kulkarni
 * @implNote Used to retry Failed Test Scripts 
 *
 */
public class RetryTestScript implements IRetryAnalyzer{
		int counter=1;
		int maxRetryCount=2;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(counter<maxRetryCount)
		{
			counter++;
			System.out.println("RetryingTest :"+result.getMethod()+ " for " + counter +" times. ");
			return true;
		}
		return false;
	}

}
