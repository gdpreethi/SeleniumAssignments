package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

//In this class the facebook page in opened and login using the credentials
public class LoginFaceBookPage {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Below code to load and login into facebook page with the credentials
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("testleaf.2023@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Tuna@321");
		driver.findElement(By.name("login")).click();
		driver.findElement(By.partialLinkText("Find")).click();
		
		String title = driver.getTitle(); //To get the title of the current web page
		
		if(title.equals("Forgotten Password | Can't Log In | Facebook"))
			System.out.println("Title Matches");
		else
			System.out.println("Title don't match");
		
		driver.close(); //Closes the chrome browser
	}

}
