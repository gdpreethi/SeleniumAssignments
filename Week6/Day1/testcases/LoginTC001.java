package testcases;

import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class LoginTC001 extends ProjectSpecificMethods{
	
	@Test
	public void runLogin(){
		
//		LoginPage lp = new LoginPage();
//		lp.enterUserName();
//		lp.enterPassword();
//		lp.clickLogin();
		
		System.out.println("driver value for runLogin() is "+getRd());
		//d2e67af72908815476743b31b57f201f
		new LoginPage()
		.enterUserName()
		.enterPassword()
		.clickLogin();
		
		
		
		
		
		
		
		

	}

}
