package com.vtiger.comcast.genericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Random;



/**
 * 
 * @author Manju
 *
 */

public class JavaUtility {
	/**
	 * it is used to generate the integer RanDom number with  in the boundary of 0 to 1000
	 * 
	 */
	 public int getRanDomNumber() {
		 Random random=new Random();
		 int randomnum = random.nextInt(1000);
		return randomnum;
		 
	 }
	 
	 /**
	  * it is used to get the current system date and time
	  *  @return
	  */
	 public String getSystemDate() {
		 Date date =new Date();
		 String systemDateAndTime = date.toString();
		 return systemDateAndTime;
	 }
	 
	 /**
	  * it is used to get the current system date with YYYY-MM-DD format
	  * @return
	  */
	 public String getSystemDate_YYYY_MM_DD() {
		 Date date =new Date();
		 String systemDateAndTime = date.toString();
		 System.out.println(systemDateAndTime);
		 String[]arr=systemDateAndTime.split("");
		 String DD=arr[2];
		 String YYYY=arr[5];
		 int MM = date.getMonth()+1;
		 String finalFormat=YYYY+"-"+MM+"-DD";
		return finalFormat;
	 }
	 
	 /**
	  *  it is used to pass Virtual key to OS
	  * @throws AWTException
	  */
		
		private void pressVirtualEnterKey() throws AWTException {
			Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		
		
		
		}

	
	}
	 

