package com.leaftaps.qa.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{

	private int count = 0;
	private static int maxTry = 3;
	
	@Override
	public boolean retry(ITestResult ITestResult) {
		if(!ITestResult.isSuccess())
		{
			if(count<maxTry)
			{
				count++;
				ITestResult.setStatus(ITestResult.FAILURE);
			}
			ITestResult.setStatus(ITestResult.FAILURE);
		}
		else
		{
		ITestResult.setStatus(ITestResult.SUCCESS);
		}
		return false;
	}

}
