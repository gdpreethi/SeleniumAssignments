package week4.day3;

import org.testng.annotations.Test;


import org.openqa.selenium.By;

public class SalesforceTC1 extends ProjectSpecificMethod{
 
  @Test	
  public void newLegalEntity() {
	       //click on the New button
	        driver.findElement(By.xpath("//span[text()='Legal Entities List']/parent::a")).click();
	        driver.findElement(By.xpath("(//one-app-nav-bar-menu-item[@class='slds-dropdown__item'])[1]")).click();
	       /* WebElement newEntity = driver.findElement(By.xpath("//span[text()='New Legal Entity']//ancestor::a"));
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", newEntity);
      */
	        driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by Preethi");
	        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click(); 
  }

}
