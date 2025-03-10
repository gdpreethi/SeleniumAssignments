package week3.day4;
//This class search for Phone in Amazon with Action class/Screenshot and Window handler
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

public class ActionsWithAmazonSite {
	static ChromeDriver driver;
	public void searchPhone() throws IOException, InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro");
		driver.findElement(By.id("nav-search-submit-button")).click();
		String firstPdtPrice = driver.findElement(By.xpath("(//span[contains(@class,'a-price-whole')])[1]")).getText();
		System.out.println("First product price: "+firstPdtPrice);
		
		//Popover screen for ratings
		Actions action = new Actions(driver);		
		action.moveToElement(driver.findElement(By.xpath("(//i[@data-cy='reviews-ratings-slot'])[1]"))).click().perform();
		System.out.println(driver.findElement(By.xpath("//h2[@id='acr-popover-title']")).getText());

		//click the first product link
		driver.findElement(By.xpath("(//div[@role='listitem']//div[@data-cy='title-recipe']/a)[1]")).click();
		Set<String> openWindows = driver.getWindowHandles();
		List<String> listOpenWindows = new ArrayList<String>(openWindows);
		  
		driver.switchTo().window(listOpenWindows.get(1)); //switch to details window of search result

		WebElement e = driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]")); //waiting for one element to be visible
																							    //as the page loads for few seconds
		 wait.until(ExpectedConditions.visibilityOf(e));
		 
		//Taking screen shot of the new window
		File scrShtFile = driver.getScreenshotAs(OutputType.FILE);
		File targetFile=new File("./AmazonResult/PdtSearchResult1.png");
		FileUtils.copyFile(scrShtFile, targetFile);
		
		//Add to cart button
		driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]")).click();

		//subtotal cart 
		WebElement subTotalElement = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']"));
		wait.until(ExpectedConditions.visibilityOf(subTotalElement));
		System.out.println("Sub total: " + subTotalElement.getText());
		
		//verify the Subtotal amount with product details page amount
		WebElement pdtPriceInPage = driver.findElement(By.xpath("//div[@id='corePriceDisplay_desktop_feature_div']/div/span"));
		if(subTotalElement.getText().contains(pdtPriceInPage.getText())) {
			System.out.println("Price matches");
		}else {
			System.out.println("Price is different");
		}
	}
	public static void main(String[] args) throws IOException, InterruptedException {
        OpenURL urlLoad= new OpenURL();
         driver = urlLoad.openUrlPage("https://www.amazon.in/");
         ActionsWithAmazonSite actionAmazon = new ActionsWithAmazonSite();
         actionAmazon.searchPhone();
        driver.quit();
         
	}

}
