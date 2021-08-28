package com.vtiger.comcast.genericUtility;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class contains web driver specific generic methods
 * @author Manju
 *
 */

public class WebDriverUtility {
	
	/**
	 * this method wait for 20seconds for page loading
	 * @param driver
	 */
	public void waitUntilPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/**
	 * this method wait for the element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementVisibility(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * this method wait for the element to be clicked,its custom wait created to avoid elementinterruptedexcption
	 * @param element
	 * @throws InterruptedException
	 */
		
		public void waitAndClick(WebElement element)throws InterruptedException {
			int count=0;
			while(count<20) {
				try {
					
				}catch(Throwable e) {
					Thread.sleep(5000);
					count++;
				}
			}
		}
			
			/**
			 * this method enables users to handle drop down using visible text
			 * @param element
			 * @param option
			 */
			public void select(WebElement element,String option) {
				Select select=new Select(element);
				select.selectByVisibleText(option);
			}
			/**
			 * this method enables users to handle drop down using index
			 * @param element
			 * @param index
			 */
			
		    public void select(WebElement element,int index) {
		    	Select select=new Select(element);
				select.selectByIndex(index);
		    }
		    /**
		     * this method will perform mouse hover action
		     * @param driver
		     * @param element
		     */
			public void mouseHover(WebDriver driver,WebElement element) {
					Actions action=new Actions(driver);
					action.moveToElement(element).perform();
			}
			/**
			 * this method perform right click operation
			 * @param driver
			 * @param element
			 */
					
		    public void rightclick(WebDriver driver,WebElement element) {
		    	Actions action=new Actions(driver);
		    	action.contextClick(element).perform();
		    }
		    /**
		     * this method helps to switch one window to another
		     * @param driver
		     * @param partialWinTitle
		     */
		    public void switchToWindow(WebDriver driver,String partialWinTitle) {
		    	Set<String> window = driver.getWindowHandles();
		    	Iterator<String> it = window.iterator();
		    	while(it.hasNext()) {
		    		String winId = it.next();
		    		String title = driver.switchTo().window(winId).getTitle();
		    		if(title.contains(partialWinTitle)) {
		    			break;
		    		}
		    	}
		    }
		    /**
		     * Accept alert
		     * @param driver
		     */
		    	
		   	public  void acceptAlert(WebDriver driver) {
		    		driver.switchTo().alert().accept();
		   	}
		   	/**
		   	 * Cancel alert
		   	 * @param driver
		   	 */
		   public void cancelAlert(WebDriver driver) {
			   
			   driver.switchTo().alert().dismiss();
		   }
		   /**
		    * this method used for scrolling action in webpage
		    * @param driver
		    * @param element
		    */
			public  void scrollToWebElement(WebDriver driver,WebElement element) {
				JavascriptExecutor js=(JavascriptExecutor) driver;
				int y=element.getLocation().getY();
				js.executeScript("window.srollBy(0,"+y+")", element);
			}
			/**
			 * this method is used for switching the frame using index
			 * @param driver
			 * @param index
			 */
			public void switchFrame(WebDriver driver,int index) {
				driver.switchTo().frame(index);
			}
			/**
			 * this method is used for switching the frame using Webelement
			 * @param driver
			 * @param element
			 */
				
			public void switchFrame(WebDriver driver,WebElement element) {
				driver.switchTo().frame(element);
			}
			/**
			 * this method is used for switching the frame using ID OR NAME
			 * @param driver
			 * @param IdOrName
			 */
			
			public void switchFrame(WebDriver driver,String IdOrName) {
					driver.switchTo().frame(IdOrName);
			}
			/**
			 * this method is used for taking the screenshot
			 * @param driver
			 * @param screenshotName
			 * @throws Throwable
			 */
			public void takescreenshot(WebDriver driver,String screenshotName)throws Throwable {
				TakesScreenshot ts=(TakesScreenshot) driver;
				File src = ts.getScreenshotAs(OutputType.FILE);
				File dest=new File("./screenshot/"+screenshotName+".PNG");
				Files.copy(src, dest);
			}
			/**
			 * this method is used for enter key in browser
			 * @param driver
			 */
			public void passEnterKey(WebDriver driver) {
				Actions action=new Actions(driver);
				action.sendKeys(Keys.ENTER);
			}
		}
				
			
				
		
			
	
			
		 
		   
     
		    
		  
	  
		    
	
		  
		
		
	
	


