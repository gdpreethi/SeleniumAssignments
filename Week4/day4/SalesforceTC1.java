package week4.day3;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import org.openqa.selenium.By;

public class SalesforceTC1 extends ProjectSpecificMethod{
 @DataProvider(name="LegalEntities")	
 public String[][] sendSFData(){
	 String[][] data = new String[3][1];
	 int i=1;
	 data[0][0]="Salesforce Automation "+ i + "by Preethi";
	 ++i;
	 data[1][0]="Salesforce Automation "+ i + "by Preethi";
	 ++i;
	 data[2][0]="Salesforce Automation "+ i + "by Preethi";
	 return data;
 }
  @Test(dataProvider = "LegalEntities")	
  public void newLegalEntity(String cname) throws InterruptedException {
	  Thread.sleep(1000);
	       //click on the New button
	        driver.findElement(By.xpath("//span[text()='Legal Entities List']/parent::a")).click();
	        driver.findElement(By.xpath("(//one-app-nav-bar-menu-item[@class='slds-dropdown__item'])[1]")).click();
	       /* WebElement newEntity = driver.findElement(By.xpath("//span[text()='New Legal Entity']//ancestor::a"));
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", newEntity);
      */
	        driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(cname);
	        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click(); 
  }

}
