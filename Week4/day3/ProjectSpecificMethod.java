package week4.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class ProjectSpecificMethod {
	WebDriver driver;
	
	@Parameters({"url","username","password"})
    @BeforeMethod
	  public void preCondition(String url,String usrname,String pwd) {
		driver = new  ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-blink-features=AutomationControlled");	
		options.addArguments("--guest");
		options.addArguments("--incognito");
		driver.navigate().refresh();

		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.get(url);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(usrname);
	    driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);

		driver.findElement(By.xpath("//input[@id='Login']")).click();
		//click on App launcher
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
  		//click legal entities link
		WebElement legalEntity= driver.findElement(By.xpath("//div[@id='lgt-accordion-section-179']//ul/li//p[text()='Legal Entities']"));
		//legalEntity.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", legalEntity);       
        legalEntity.click();
        
        //below code with action not working for app launcher so using javascript in this case
		//action.moveToElement(legalEntity).perform();
		//action.pause(1000);
		//action.click().perform();
		
	}
	
	@AfterMethod
	
	public void postCondition() {
		//driver.close();
	}
	
}
