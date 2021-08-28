package com.vtiger.comcast.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.vtiger.comcast.pomrepositylib.HomePage;
import com.vtiger.comcast.pomrepositylib.LoginPage;

public class BaseClass {
	
	public WebDriver driver;
	public static WebDriver sDriver;
	
	/*Object creation for Lib*/
	 public JavaUtility jLib=new JavaUtility();
	 public WebDriverUtility wLib=new WebDriverUtility();
	 public ExcelUtility eLib=new ExcelUtility();
	 public FileUtility fLib=new FileUtility();
	
	//@Parameters("BROWSER")
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void configureBeforeClas() throws Throwable {
		
			
			
			String browser = fLib.getPropertyKeyValue("browser");
     		String URL = fLib.getPropertyKeyValue("url");
//			driver=new ChromeDriver();
//			wLib.waitUntilPageLoad(driver);
//			driver.manage().window().maximize();
			 //driver.get(URL);
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(browser.equals("firefox")) {
		   driver=new FirefoxDriver();
		}
		driver.get(URL);
		sDriver = driver;
		wLib.waitUntilPageLoad(driver);
		driver.manage().window().maximize();
	
		
//			
	}
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void configureBeforeMethod() throws Throwable {
		/*common Data*/
		//String BROWSER = fLib.getPropertyKeyValue("browser");
		//String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		//driver.get(URL);
		LoginPage loginpage=new LoginPage(driver);
		if(loginpage.getLoginButton().isDisplayed()) {
			System.out.println("PASS:=LOGIN PAGE IS DISPLAYED");
		}else {
			System.out.println("FAIL:=LOGIN PAGE IS NOT DISPLAYED");
		}
		loginpage.LoginToApp(USERNAME,PASSWORD);
		Thread.sleep(5000);
		
	}

	
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void configAM() {
		//logout
		new HomePage(driver).LogOut();
	}
	
	@AfterClass(groups= {"smokeTest,regression"})
	private void configureAfterClass() {
		driver.quit();
		
	}

}
