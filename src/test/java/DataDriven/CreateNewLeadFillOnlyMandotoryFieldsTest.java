package DataDriven;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewLeadFillOnlyMandotoryFieldsTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis=new FileInputStream("./Data/commonData.properties7");
		Properties pobj =new Properties();
		pobj.load(fis);
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		
		FileInputStream fis1=new FileInputStream("./Data/testScriptData3.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("Sheet1");
		Row row = sh.getRow(1);
		String partialText = row.getCell(2).getStringCellValue();
		String FIRSTNAME = row.getCell(3).getStringCellValue();
		String TITLE = row.getCell(4).getStringCellValue();
		Cell cel = row.getCell(5);
		
        
		 WebDriver driver=null;
			
			if(BROWSER.equals("chrome")) {
				driver=new ChromeDriver();
			}else if(BROWSER.equals("firefox")) {
				driver=new FirefoxDriver();
			}else if(BROWSER.equals("opera")) {
				driver=new OperaDriver();
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebDriverWait wait=new WebDriverWait(driver,10);
			
			driver.get(URL);
			
			boolean isStepCorrect = true;
			if(driver.findElement(By.id("submitbutton")).isDisplayed()) {
				System.out.println("PASS:=LOGIN PAGE IS DISPLAYED");
			}else {
				System.out.println("FAIL:=LOGIN PAGE IS NOT DISPLAYED");
			}
			    driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				if(driver.getTitle().contains(partialText)) {
					System.out.println("PASS:=HOME PAGE IS DISPLAYED");
				}else {
					System.out.println("FAIL:=HOME PAGE IS NOT DISPLAYED");
				}
			    
				driver.findElement(By.xpath("//td[@class]/a[text()='Leads']")).click();
				driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
				
				if(driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).isDisplayed()) {
					System.out.println("PASS:: Creating New Lead page is displayed");
				} else {
					System.out.println("FAIL:: Creating New Lead page is not displayed");
				}
				
				cel.setCellValue("PASS");
				FileOutputStream fos = new FileOutputStream("./data/testScriptData3.xlsx");
				wb.write(fos);
				wb.close();
				driver.findElement(By.name("salutationtype")).click();
				driver.findElement(By.id("mouseArea_First Name")).sendKeys(FIRSTNAME);
				driver.findElement(By.id("mouseArea_Title")).sendKeys(TITLE);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				

	             WebElement userImg = driver.findElement(By.xpath("//img[contains(@src,'user.PNG')]"));
				
				Actions actions = new Actions(driver);
				actions.moveToElement(userImg).perform();
				
				driver.findElement(By.linkText("Sign Out")).click();
				
				driver.quit();

			
				
				
	}

}
