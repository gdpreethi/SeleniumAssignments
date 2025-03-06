package week3.day2;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTargetLocator {

	public static void main(String[] args) throws InterruptedException, AWTException {
      ChromeDriver driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("https://www.leafground.com/alert.xhtml");
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       WebElement alertElement=driver.findElement(By.xpath("//h5[text()=' Alert (Prompt Dialog)']/following-sibling::button"));
       
       driver.executeScript("arguments[0].click()", alertElement);
       Alert alertDialog=driver.switchTo().alert();
        alertDialog.sendKeys("Hello");
        
        //USING ROBOT CLASS TO ENTER THE VALUES AND VISIBLY SEE IN THE INPUT TEXT BOX
//       Robot r= new Robot();
//       r.keyPress(KeyEvent.VK_H);
//       r.keyPress(KeyEvent.VK_E);
//       r.keyPress(KeyEvent.VK_L);
//       r.keyRelease(KeyEvent.VK_L);
//       r.keyPress(KeyEvent.VK_L);
//       r.keyPress(KeyEvent.VK_O);
        
       Thread.sleep(5000);
       System.out.println(alertDialog.getText());
       Thread.sleep(2000);
       alertDialog.accept();
       String text = driver.findElement(By.id("confirm_result")).getText();
       System.out.println(text);
       driver.close();
	}

}
