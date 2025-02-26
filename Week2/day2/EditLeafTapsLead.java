package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EditLeafTapsLead extends NavigateLeafTapsHomePage{

	public void editLead(ChromeDriver driver) throws InterruptedException {
		driver.findElement(By.partialLinkText("Create Lead")).click();
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("Amazon");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("Alexa Edit5");
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("Home use");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys("Home use");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Product");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("New product alexa edit");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("product4@gmail.com");		
		
		//Webelement to select state/province dropdown	
				WebElement selectStateEle = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
				Select stateProvinceDropdown = new Select(selectStateEle);
				 //Select the option in state/province dropdown
				stateProvinceDropdown.selectByVisibleText("New York");
	    driver.findElement(By.className("smallSubmit")).click(); 
	    driver.findElement(By.xpath("//a[text()='Edit']")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.id("updateLeadForm_description")).clear();
	    driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Update Important text for Alexa Home use");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@value='Update']")).click();
	    
	    String title = driver.getTitle();
		System.out.println(title);
		if(title.equals("View Lead | opentaps CRM"))
			System.out.println("Expected Title");
		else
			System.out.println("Wrong Title");
		
		driver.close();
	  
	}
	
	public static void main(String[] args) {
		
		EditLeafTapsLead editLead = new EditLeafTapsLead();
		ChromeDriver driver= editLead.driver;
		editLead.loadLeafTapsPage();
		editLead.loginCredentials("demosalesmanager","crmsfa");
		editLead.clickHyperLink("Leads");
		try {
			editLead.editLead(driver);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
