package week3.day1;

import java.time.Duration;
import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v115.browser.model.Bucket;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AjioWebsiteSearch {

	
	public static void main(String[] args) throws InterruptedException {
       
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ajio.com/");
		
		  driver.findElement(By.name("searchVal")).sendKeys("bags");		  
		  driver.findElement(By.xpath("//button[@aria-label='search']")).click();		 
		  driver.findElement(By.xpath("//label[@for='Men']")).click();
		    Thread.sleep(3000);		    
		    driver.findElement(By.xpath("//label[@for='Men - Fashion Bags']")).click();
		    String itemsLength = driver.findElement(By.xpath("//label[@for='Men - Fashion Bags']")).getText();
		    System.out.println(itemsLength);
		 
		    //Get the list of brand names
		  List<WebElement> brandElements =driver.findElements(By.xpath("//div[@class='brand']"));
		    System.out.println(brandElements.size());
		    Thread.sleep(5000); //waiting for the brand elements to be loaded
		    for(int i=0;i<brandElements.size();i++) {
		    	System.out.println(brandElements.get(i).getText());
		    }
		  
		    //Get the bag names
		    List<WebElement> bagNames=driver.findElements(By.xpath("//div[@class='brand']/following-sibling::div[@class='nameCls']"));
		     System.out.println(bagNames.size());
		     for(int i=0;i<bagNames.size();i++) {
		    	 System.out.println(bagNames.get(i).getText());
		     }
		    //Below code displays brand name in some other order which is not displayed in the screen
//		    List<WebElement> brandElements1 =driver.findElements(By.xpath("//div[@class='brand']"));
//
//		    System.out.println(brandElements1.size());
//
//		    for(int i=0;i<brandElements.size();i++) {
//		    	System.out.println(brandElements.get(i).getText());
//		    }
		    
		    
	}

}
