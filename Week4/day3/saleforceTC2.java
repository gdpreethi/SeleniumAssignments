package week4.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
/*
 *This class creates a new legal entity in Salesforce with CompanyName, Description and Status 
 */
public class saleforceTC2 extends ProjectSpecificMethod{
  @Test
  public void newLegalEntityDesc() {
	  
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  
      //click on the Legal entities Tab
       driver.findElement(By.xpath("//span[text()='Legal Entities List']/parent::a")).click();
       //Selection of New Legal Entity tab
       WebElement legalEntityTab = driver.findElement(By.xpath("(//one-app-nav-bar-menu-item[@class='slds-dropdown__item'])[1]"));
       wait.until(ExpectedConditions.visibilityOf(legalEntityTab));
       legalEntityTab.click();
      /* WebElement newEntity = driver.findElement(By.xpath("//span[text()='New Legal Entity']//ancestor::a"));
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("arguments[0].click();", newEntity);
 */
       driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("TestLeaf");
       driver.findElement(By.xpath("//label[text()='Description']/following-sibling::div/textarea")).sendKeys("Salesforce"); 
       WebElement statusDropdown = driver.findElement(By.xpath("//button[@aria-label='Status']/parent::div"));
       
       js.executeScript("arguments[0].scrollIntoView();", statusDropdown);
       js.executeScript("arguments[0].click();", statusDropdown);
       driver.findElement(By.xpath("//span[@class='slds-media__body']/span[text()='Active']")).click();
       driver.findElement(By.xpath("//button[@name='SaveEdit']")).click(); 
       
       //Get the Company Name from Toast message after saving the data
       WebElement toastMsg = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]/a/div"));
       wait.until(ExpectedConditions.visibilityOf(toastMsg));
       Assert.assertEquals(toastMsg, "TestLeaf","company name does not match");
}

}
