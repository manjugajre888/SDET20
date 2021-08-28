package DataDriven;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MakeMyTripTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String Date="31";
		String monthYear="December 2021";
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		
		Actions actions=new Actions(driver);
		actions.click().perform();
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		for(;;) {
			try {
				driver.findElement(By.xpath("//div[text()='"+monthYear+"']/ancestor::div[@class='DayPicker-Month']//p[text()='"+Date+"']")).click();
				break;
			}catch(Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
		
		
	}

}
