package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificMethods;
import io.cucumber.java.en.When;

public class MyHomePage extends ProjectSpecificMethods {

	

	
	@When("the user clicks the lead menu")
	public MyLeads clickLead() {

		getRd().findElement(By.linkText("Leads")).click();
		return new MyLeads();

	}
}
