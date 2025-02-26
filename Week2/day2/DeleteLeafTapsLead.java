package week2.day2;
//This class deletes the lead from the Leaftaps web page by identifying the Lead with Phonenumbers

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLeafTapsLead {

	//Delete the Lead by searching the Phone number
	public void removeLead(ChromeDriver driver,String phoneNumber) throws InterruptedException {
		
		 driver.findElement(By.xpath("//ul[@class='shortcuts']/li[3]")).click();
		 driver.findElement(By.xpath("(//a[@class='x-tab-right'])[2]")).click();
		 driver.findElement(By.name("phoneNumber")).sendKeys(phoneNumber);
		 driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		 Thread.sleep(3000);
		 WebElement firstLeadId =driver.findElement(By.xpath("(//div[contains(@class,'x-grid3-col-partyId')])/a"));
		 String delLeadId=firstLeadId.getText();
		 System.out.println(delLeadId);
		 firstLeadId.click();
		 Thread.sleep(1000);
		 driver.findElement(By.className("subMenuButtonDangerous")).click();
		  
		 driver.findElement(By.xpath("//ul[@class='shortcuts']/li[3]")).click();
		 driver.findElement(By.xpath("(//label[contains(text(),'Lead ID')])/following::input")).sendKeys(delLeadId);
		 driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	     Thread.sleep(2000);
	     
		 String noRecordsMsg = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		 System.out.println(noRecordsMsg);
		  if(noRecordsMsg.equalsIgnoreCase("No records to display"))
			  System.out.println("Lead is deleted successfully");
		  driver.close();
		
	}
	public static void main(String[] args) throws InterruptedException{
		//Instantiation of existing class for navigating to the Home page for creating Account
				NavigateLeafTapsHomePage nav = new NavigateLeafTapsHomePage();
				
				//Using the driver loaded from the CreateLeadLeafTaps class
				 ChromeDriver driver = nav.driver;
				 
				//Below method call is used to load and open the My Home page in LeafTaps app 
				 nav.loadLeafTapsPage();
				 nav.loginCredentials("demosalesmanager","crmsfa");
				 nav.clickHyperLink("Leads");
				 
				 DeleteLeafTapsLead delLeafTapsLead = new DeleteLeafTapsLead();
				 delLeafTapsLead.removeLead(driver,"123456789");
				
	}

}
