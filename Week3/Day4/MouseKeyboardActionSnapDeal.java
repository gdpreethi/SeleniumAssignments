package week3.day4;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import preconditionFiles.OpenURL;

public class MouseKeyboardActionSnapDeal{
	static ChromeDriver driver;
	
	public void search() throws InterruptedException, IOException {
		Actions action = new Actions(driver);
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		
		WebElement mensHoverElement = driver.findElement(By.xpath("//span[text()=concat('Men',\"'\",'s Fashion')]"));
		action.moveToElement(mensHoverElement).perform();
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		//find and print the searh count
		System.out.println(driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText());
		//click on Training shoes link
		driver.findElement(By.xpath("//div[contains(text(),'Training Shoes')]")).click();
		//sort by
		driver.findElement(By.xpath("//span[text()='Sort by:']/following-sibling::i")).click();
		driver.findElement(By.xpath("//span[text()='Sort by:']/parent::div/following-sibling::ul/li[@data-index=1]")).click();
		
		Thread.sleep(2000);
		String attribute1 = driver.findElement(By.xpath("(//span[@class='lfloat product-price'])[1]")).getAttribute("data-price");
		System.out.println("data price: "+attribute1);
		
		String attribute2 = driver.findElement(By.xpath("(//span[@class='lfloat product-price'])[2]")).getAttribute("data-price");
		System.out.println("data price: "+attribute2);
			int firstShoePrice=Integer.parseInt(attribute1);
			int secondShowPrice=Integer.parseInt(attribute2);
			
			if(firstShoePrice<secondShowPrice) {
				System.out.println("Sort order is Low to High");
			}else {
				System.out.println("Sort order is not correct");
			}
		//dragdrop slider in price range
			WebElement minPriceRange = driver.findElement(By.xpath("//div[@data-filter-type='slider']//a[1]"));
			Actions priceRangeAction = new Actions(driver);
			priceRangeAction.dragAndDropBy(minPriceRange, 20, 0).perform();
			Thread.sleep(2000);
		//dragdrop max price
			WebElement maxPriceRange = driver.findElement(By.xpath("//div[@data-filter-type='slider']//a[2]"));
			//Actions priceRangeAction = new Actions(driver);
			priceRangeAction.dragAndDropBy(maxPriceRange, -30, 0).perform();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//label[@for='Color_s-Black']")).click();
			Thread.sleep(3000);
			
			WebElement productImageHover = driver.findElement(By.xpath("//div[contains(@class,'product-tuple-description')]"));
			
			action.scrollToElement(productImageHover).perform();
			action.moveToElement(productImageHover).pause(3000).perform();
			
			WebElement quickViewBtn = driver.findElement(By.xpath("//div[contains(text(),'Quick View')]"));
			wait.until(ExpectedConditions.visibilityOf(quickViewBtn));		
			quickViewBtn.click();
			
			//Getting the price in quick view window
			WebElement pdtPrice = driver.findElement(By.xpath("//span[@class='payBlkBig']"));
			wait.until(ExpectedConditions.visibilityOf(pdtPrice));						
			String pdtPriceText = pdtPrice.getText();
			WebElement discountPercent = driver.findElement(By.xpath("//span[contains(@class,'percent-desc')]"));
			String discount = discountPercent.getText();
			
				System.out.println("Product original price: "+pdtPriceText);
				System.out.println("Product Discount %: "+discount);
		//Taking screenshot of the price window
			File scrnShotFile = driver.getScreenshotAs(OutputType.FILE);	
			File fileDetails=new File("./snapDeal/pics/pdtPrice.png");
			FileUtils.copyFile(scrnShotFile,fileDetails);		
		 		
		//close price details window
		    driver.findElement(By.xpath("//div[contains(@class,'close close1')]")).click();
	}
	public static void main(String[] args) {
		 OpenURL urlLoad= new OpenURL();
         driver = urlLoad.openUrlPage("https://www.snapdeal.com");
         MouseKeyboardActionSnapDeal snapDeal= new MouseKeyboardActionSnapDeal();
         try {
			snapDeal.search();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        // driver.close();
         catch (IOException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

}
