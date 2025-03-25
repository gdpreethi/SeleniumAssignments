package testcases;

import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class TC_001_LoginPage extends  ProjectSpecificMethods{
	@Test
	public void runLogin() {
		new LoginPage().enterUserName().enterPassword().clickLogin().clickCRMSFA()
		.clickAccountMenu().clickCreateAccount().enterAccountName().clickCreateAccount().viewAccountDetails();
	}
	
}
