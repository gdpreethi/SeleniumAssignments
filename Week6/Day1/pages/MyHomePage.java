package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.ProjectSpecificMethods;

//This class access the elements of MyHomePage page of Leaftaps application to select the Account tab/menu

public class MyHomePage extends ProjectSpecificMethods{

	public MyAccountPage clickAccountMenu() {
		
		WebElement accMenu=getRd().findElement(By.linkText("Accounts"));
		if(accMenu.isDisplayed() && accMenu.isEnabled()) {
			accMenu.click();
		}
	return new MyAccountPage();	
	}
}
