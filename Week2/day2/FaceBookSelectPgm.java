package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FaceBookSelectPgm {

	public static void main(String[] args) throws InterruptedException{
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Below code to load and login into facebook page with the credentials
		driver.get("https://en-gb.facebook.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(@class,'selected')]")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Test");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("facebook");
		driver.findElement(By.xpath("//div[text()='Mobile number or email address']/following-sibling::input")).sendKeys("9865320145");
		WebElement dobDayDropdownEle = driver.findElement(By.xpath("//select[@id='day']"));
		Select dobDayDropdown = new Select(dobDayDropdownEle);
		dobDayDropdown.selectByValue("30");
		
		WebElement dobMonthDropdownEle = driver.findElement(By.xpath("//select[@id='month']"));
		Select dobMonthDropdown = new Select(dobMonthDropdownEle);
		dobMonthDropdown.selectByValue("11");
		
		WebElement dobYearDropdownEle = driver.findElement(By.xpath("//select[@id='year']"));
		Select dobYearDropdown = new Select(dobYearDropdownEle);
		dobYearDropdown.selectByValue("1990");
		
		driver.findElement(By.xpath("(//input[@id='sex'])[1]")).click();
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("NewAccount11");
		
	}

}
