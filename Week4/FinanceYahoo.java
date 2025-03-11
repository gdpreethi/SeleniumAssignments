package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FinanceYahoo {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://finance.yahoo.com/");
		
		Actions action = new Actions(driver);
		  driver.findElement(By.xpath("//span[text()='More']")).click();
		WebElement cryptoElem = driver.findElement(By.xpath("//nav[@role='navigation']//a[text()='Crypto ']"));
		action.moveToElement(cryptoElem).click().perform();
		action.pause(1000).perform();
		
		//getting table rows and column details
		List<WebElement> rowElements = driver.findElements(By.xpath("//table/tbody/tr"));
		int rowSize = rowElements.size();
		System.out.println("Cryptocurrency Names\n");
		
		  for(int i=1;i<rowSize;i++) {
			  //retrieve the crypto currency names from second column of each row
			  WebElement cryptoName = driver.findElement(By.xpath("//table/tbody/tr[" + i +"]/td[2]"));			  																			
			  System.out.println(cryptoName.getText());
			  
	     driver.findElement(By.xpath("//table/thead/tr/th/div[text()='Name']"));		  
		  }
		  driver.close();
		}
  

}
