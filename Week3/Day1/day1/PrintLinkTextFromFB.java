package week3.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintLinkTextFromFB {

	public static void main(String[] args) {
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		 driver.get("https://www.facebook.com/login/");
	 	 
	List<WebElement> hyperLinkText = driver.findElements(By.tagName("a"));	 
	   for(int i=0;i<hyperLinkText.size();i++) {
		   WebElement hyperLinkElements = hyperLinkText.get(i);
		     System.out.println(hyperLinkElements.getText());
	   }
	   System.out.println("Total Elements in hyperlink tags: "+hyperLinkText.size());
	   driver.close();
	}

}
