package DataDriven;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class GetTheDataFromPropertiesFileByOrganizationModuleTest {

	public static void main(String[] args) throws IOException, InterruptedException {

	FileInputStream fis=new FileInputStream("./Data/commonData.properties7");
     Properties pobj=new Properties();
     
  
	pobj.load(fis);
     
     String BROWSER = pobj.getProperty("browser");
     String URL = pobj.getProperty("url");
     String USERNAME = pobj.getProperty("username");
     String PASSWORD = pobj.getProperty("password");
     String ORGANIZATION = pobj.getProperty("organizationName");
     String WEBSITE = pobj.getProperty("website");
     String PHONE = pobj.getProperty("phone");
     
     WebDriver driver=null;
		
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}else if(BROWSER.equals("ie")) {
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(ORGANIZATION);
		driver.findElement(By.name("website")).sendKeys(WEBSITE);
		driver.findElement(By.id("phone")).sendKeys(PHONE);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Thread.sleep(5000);
         String actualHeaderText = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actualHeaderText.contains(ORGANIZATION)) {
			System.out.println("PASS:: Organization name in header is correct");
		} else {
			System.out.println("FAIL:: Organization name in header is incorrect");
		}
		
		WebElement userImg = driver.findElement(By.xpath("//img[contains(@src,'user.PNG')]"));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(userImg).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
	}

}
