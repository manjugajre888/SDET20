package com.vtiger.comcast.genericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementingClass implements ITestListener{
	
	
	public void onTestFailure(ITestResult result) {
		String name=result.getMethod().getMethodName();
		System.out.println("========Executing =============");
		
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sDriver);
		File srcFile=edriver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile,new File("./screenshot/"+name+".png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
