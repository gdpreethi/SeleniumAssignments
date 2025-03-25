package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.ProjectSpecificMethods;

//this class access the elements from create Account page from Leaftaps application

public class CreateAccountPage extends ProjectSpecificMethods{
	
	public CreateAccountPage enterAccountName() {
		WebElement accName= getRd().findElement(By.id("accountName"));
		if(accName.isEnabled()) {
			accName.sendKeys("Acc1");
		}
	return this;	
	}
	public ViewAccountPage clickCreateAccount() {
		WebElement createAccBtn = getRd().findElement(By.xpath("//input[@value='Create Account']"));
		if(createAccBtn.isEnabled()) {
			createAccBtn.click();
		}
	return new ViewAccountPage();	
	}

}
