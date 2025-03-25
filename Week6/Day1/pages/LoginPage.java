package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.ProjectSpecificMethods;
//This class access and works on the elements of Login Page in Leaftaps application

public class LoginPage extends ProjectSpecificMethods{
   
	public LoginPage enterUserName() {
		WebElement username= getRd().findElement(By.id("username"));
		if(username.isDisplayed() && username.isEnabled()) {
		username.sendKeys("demosalesmanager");
		}
	return this;	
	}
	
	public LoginPage enterPassword() {
		WebElement pwd= getRd().findElement(By.id("password"));
		if(pwd.isDisplayed() && pwd.isEnabled()) {
			pwd.sendKeys("crmsfa");
		}
	return this;
	}
	
	public WelcomePage clickLogin() {
		WebElement loginBtn=getRd().findElement(By.className("decorativeSubmit"));
		if(loginBtn.isDisplayed() && loginBtn.isEnabled()) {
		loginBtn.click();
		}
	 return new WelcomePage();
	}
}
