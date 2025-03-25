package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.ProjectSpecificMethods;

//This class access the elements available in Welcome page of Leaftaps application

public class WelcomePage extends ProjectSpecificMethods{
  
	public MyHomePage clickCRMSFA() {
		WebElement crmsfaLink = getRd().findElement(By.linkText("CRM/SFA"));
		if(crmsfaLink.isDisplayed() && crmsfaLink.isEnabled()) {
		crmsfaLink.click();
		}
	return new MyHomePage();
	}
}
