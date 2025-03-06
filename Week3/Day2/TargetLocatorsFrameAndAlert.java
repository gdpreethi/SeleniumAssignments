package week3.day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//This class uses switchTo method to alert box and iframe

public class TargetLocatorsFrameAndAlert {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
        driver.switchTo().frame("iframeResult"); //switch to the Try if button iframe
        driver.findElement(By.xpath("//button[text()='Try it']")).click();
        //Handle Alert box 
        Alert tryItAlert = driver.switchTo().alert();
        tryItAlert.sendKeys("Preethi"); //sending values to input box in alert
        tryItAlert.accept();
     
        //Verification steps
        String result = driver.findElement(By.xpath("//p[@id='demo']")).getText();       
       // System.out.println(result);
          if(result.contains("How are you today?")) {
        	  System.out.println("Result of OK button is displayed: "+result);
          }else if(result.contains("User cancelled the prompt.")) {
        	  System.out.println("Result of Cancel button is displayed: "+result);
          }  
          driver.close();
	}

}
