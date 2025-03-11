package week4.day1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import preconditionFiles.OpenURL;

public class WebtableErail {

	public static void main(String[] args) {
		ChromeDriver driver;
		OpenURL urlOpen=new OpenURL();
		driver = urlOpen.openUrlPage("https://erail.in/");
		driver.findElement(By.id("chkSelectDateOnly")).click();
		Set<String> trainNames=new HashSet<String>();
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@id='divTrainsList']/table[contains(@class,'TrainList')]//tr"));
		
		 for(int i=2;i<elements.size();i++) {
			WebElement elements1 = driver.findElement(By.xpath("//div[@id='divTrainsList']/table[contains(@class,'TrainList')]//tr["+i+"]/td[2]"));
			String text = elements1.getText();
			trainNames.add(text);
		 }	  	
	   for(String trainName : trainNames) {
			  System.out.println(trainName);		  
	   }
		
	}

}
