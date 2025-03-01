package week2.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RadioButtonSelector {
	WebDriver driver = new ChromeDriver();
	
	public void loadUrl() {

		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/radio.xhtml");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	}
	
	public void verifyRadioButtons() throws InterruptedException {
		
		WebElement favBrowserBtn = driver.findElement(By.xpath("//h5[text()='Your most favorite browser']"
				+ "/following-sibling::div//table/tbody/tr/td[2]//descendant::span"));
		favBrowserBtn.click();
		Thread.sleep(1000);
		favBrowserBtn.click(); // click the favorite browser again to uncheck the radio button
		String favBrowserBtnSelectStatus = favBrowserBtn.getAttribute("class");
		
		  //check the class attribute to verify the radio button is selected or not selected
          if(favBrowserBtnSelectStatus.equals("ui-radiobutton-icon ui-icon ui-c ui-icon-bullet")) {
        	  System.out.println("Radio button for Favorite Browser is Selected");
          }else
        	  System.out.println("Radio button for Favorite Browser is not selected");
          
         WebElement defaultSelectedRadioBtn = driver.findElement(By.xpath("//h5[text()='Find the default select radio button']"
         										+ "//following-sibling::div//descendant::div/span[contains(@class,'ui-icon-bullet')]"));
	    String selectedRadioBtn = defaultSelectedRadioBtn.getTagName();
	    //System.out.println(selectedRadioBtn);
	    
	    if(selectedRadioBtn.equals("div")) {
	    	System.out.println("No default radio button is clicked");
	    }else {
	    	System.out.println("One radio button is clicked by default");
	    }
	   WebElement ageGroupRadioBtn = driver.findElement(By.xpath("//label[text()='21-40 Years']/preceding-sibling::div/div[2]/span"));
	    String ageGroupRadioVal=ageGroupRadioBtn.getAttribute("class");
	     
	    if(ageGroupRadioVal.contains("ui-state-bullet")) {
	    	  System.out.println("Age group 21-40 years is not selected");
	    	  ageGroupRadioBtn.click();
	      }else {
	    	  System.out.println("Age group 21-40 years is selected by default");
	      }
	    	  
	}
	public static void main(String[] args) {
     RadioButtonSelector radioBtn = new RadioButtonSelector();
     radioBtn.loadUrl();
     try {
		radioBtn.verifyRadioButtons();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}



