package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.ProjectSpecificMethods;

//this class access the elements of My Account Page page of Leaftaps application and to select create Account menu 

public class MyAccountPage extends ProjectSpecificMethods{

	public CreateAccountPage clickCreateAccount() {
		WebElement createAcc=getRd().findElement(By.linkText("Create Account"));
		if(createAcc.isDisplayed() && createAcc.isEnabled()) {
			createAcc.click();
		}
     return new CreateAccountPage();
	}
}
