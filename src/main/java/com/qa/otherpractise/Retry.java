package com.qa.otherpractise;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	private int count = 0;
	private int maxCount = 3;
	
	@Override
	public boolean retry(ITestResult ITestResult) {
		
		if(!ITestResult.isSuccess())
		{
			if(count<maxCount)
			{
				count++;
				ITestResult.setStatus(ITestResult.FAILURE);	
			}
			ITestResult.setStatus(ITestResult.FAILURE);
		}
		ITestResult.setStatus(ITestResult.SUCCESS);
		return false;
	}

}
