package week3.day3;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlerIRCTCSite {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.irctc.co.in");
		
		 driver.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();
		 Set<String> opendWindowsAdd = driver.getWindowHandles();
		 List<String> listOfAllWindows=new ArrayList<String>(opendWindowsAdd);
		   driver.switchTo().window(listOfAllWindows.get(1));
		   System.out.println("Title of Child Window: "+driver.getTitle());
		  driver.switchTo().window(listOfAllWindows.get(0));
		  driver.close();
		 
	}

}
