package pages;

import org.openqa.selenium.By;

import base.ProjectSpecificMethods;

public class CreateLead extends ProjectSpecificMethods{

	public CreateLead leadCompanyName() {
		getRd().findElement(By.id("createLeadForm_companyName")).sendKeys("HCL");
		return this;
	}
	public CreateLead leadFirstLastName() {
		getRd().findElement(By.id("createLeadForm_firstName")).sendKeys("PP");
		getRd().findElement(By.id("createLeadForm_lastName")).sendKeys("LL");
		return this;
	}
	public CreateLead leadPhNum() {
		getRd().findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("989");
		return this;
	}
	public ViewLead submit() {
		getRd().findElement(By.name("submitButton")).click();
		String text = getRd().findElement(By.id("viewLead_companyName_sp")).getText();
		if (text.contains("Testleaf")) {
			System.out.println("Lead created successfully");
		}
		else {
			System.out.println("Lead is not created");
		}
		return new ViewLead();
	}
}
