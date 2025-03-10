package week3.day4;
//This class uses mouse hover actions to select elements and order items in basket 
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import preconditionFiles.OpenURL;

public class ActionBigBasket {
   public static ChromeDriver driver;
   
   public void search() throws InterruptedException, IOException {
	   Actions action =new Actions(driver);
	   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	  
	   //Shop by Category
	   WebElement categoryMenu = driver.findElement(By.xpath("(//div[contains(@class,'CategoryMenu')]//button)[2]"));
       action.moveToElement(categoryMenu).click().perform();
       action.pause(1000).perform();
       
       //Foodgrains,oil & masala
	   WebElement categoryElem = driver.findElement(By.xpath("(//a[text()='Foodgrains, Oil & Masala'])[2]/parent::li"));
	   action.moveToElement(categoryElem).perform();
	   
	   //Rice & rice products
	   WebElement categoryElem1 = driver.findElement(By.xpath("//a[text()='Rice & Rice Products']/parent::li"));
	   wait.until(ExpectedConditions.visibilityOf(categoryElem1));
	   action.moveToElement(categoryElem1).perform();	   
	   
	   //Boild & Steam Rice
	   WebElement categoryElem2 = driver.findElement(By.xpath("(//a[text()='Boiled & Steam Rice'])[1]"));
	   action.moveToElement(categoryElem2).perform();	
	   categoryElem2.click();
	   
	   //select the bb Royal checkbox
	   WebElement brand = driver.findElement(By.xpath("//input[@id='i-BBRoyal']"));
	   wait.until(ExpectedConditions.visibilityOf(brand));
	 	action.moveToElement(brand).click(brand).perform();
	 	action.pause(1000).perform();
	 	
	   //Tamil ponni rice item
	   WebElement ponniBoiledRiceElem = driver.findElement(By.xpath("//h3[contains(text(),'Tamil Ponni Boiled Rice')]"));
	   wait.until(ExpectedConditions.visibilityOf(ponniBoiledRiceElem));
	   action.moveToElement(ponniBoiledRiceElem).click().perform();
	   action.pause(2000).perform();
	   
	   //Selecting the size of the rice bag in new window
	    Set<String> bagSizeWindow = driver.getWindowHandles();
	    List<String> bagSizeWindowList = new ArrayList<String>(bagSizeWindow);
	    driver.switchTo().window(bagSizeWindowList.get(1)); //switch to detailed page of rice bag
	    
	    WebElement kgSize = driver.findElement(By.xpath("//span[text()='5 kg']/parent::div"));//get the element to select the 5kg bag
	    action.moveToElement(kgSize).click().perform();
	    action.pause(1000);
	   
	    //Add to basket
	    driver.findElement(By.xpath("//button[text()='Add to basket']")).click();
	    WebElement successMsg = driver.findElement(By.xpath("//p[@class='mx-4 flex-1']"));
	    wait.until(ExpectedConditions.visibilityOf(successMsg));
	    String successMsgText = successMsg.getText();
	      if(successMsgText.equals("An item has been added to your basket successfully")) {
	    	  System.out.println("Success Message Displayed");
	      }else {
	    	  System.out.println("Success message not displayed");
	      }
	      
	     //Taking screenShot
	      File fileType = driver.getScreenshotAs(OutputType.FILE);
	      File fileDetails = new File("./BigBasket/snap/Order.png");
	      FileUtils.moveFile(fileType, fileDetails);
	      
     driver.close(); //close the rice bag details page window
     driver.switchTo().window(bagSizeWindowList.get(0)); //move to parent window
     driver.close();
   }
	public static void main(String[] args) {
		
		 OpenURL urlLoad= new OpenURL();
         driver = urlLoad.openUrlPage("https://www.bigbasket.com/");
         ActionBigBasket bigBasket = new ActionBigBasket();
         try {
			bigBasket.search();
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
