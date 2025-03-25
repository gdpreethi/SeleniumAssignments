package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.ProjectSpecificMethods;


public class ViewAccountPage extends ProjectSpecificMethods{

	public void viewAccountDetails() {
		WebElement accName= getRd().findElement(By.xpath("//span[text()='Account Name']/parent::td/following-sibling::td/span"));
		if(accName.getText()!=null && accName.getText()!="" && accName.isDisplayed()) {
			Assert.assertTrue(accName.getText().contains("Acc1"), "Account Name doesn't match");
		}
	}
}
