package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;
import io.cucumber.java.en.When;
/*
 * 
	
	driver.findElement(By.className("decorativeSubmit")).click();
 */

public class LoginPage extends ProjectSpecificMethods {
	
	  
	
	
	@When("the user enters the username as")
	public LoginPage enterUserName() {	
		getRd().findElement(By.id("username")).sendKeys("Demosalesmanager");
		return this;
	}
	@When("the user enters the password as")
	public LoginPage enterPassword() {
		getRd().findElement(By.id("password")).sendKeys("crmsfa");
		return this;

	}
	@When("the user clicks the login button")
	public HomePage clickLogin() {
		getRd().findElement(By.className("decorativeSubmit")).click();
		return new HomePage();

	}


	
	
	
	
	
	

}
