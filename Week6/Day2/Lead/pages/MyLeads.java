package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;
import io.cucumber.java.en.When;

public class MyLeads  extends ProjectSpecificMethods{
	


	
	@When("the user clicks the creat lead menu")
	public CreateLead clickCreateLeadMenu() {
		getRd().findElement(By.linkText("Create Lead")).click();
		return new CreateLead();

	}

}
