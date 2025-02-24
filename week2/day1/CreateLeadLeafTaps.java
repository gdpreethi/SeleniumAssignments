package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

//This class Login to LeafTaps login page and create a Lead from the website

public class CreateLeadLeafTaps {
	ChromeDriver driver = new ChromeDriver();
	
	//To open the given URL in chrome browser
	public void loadLeafTapsPage(String URL) {	 
	 driver.manage().window().maximize();
	 driver.get(URL);
	}
	
	//To provide the Login credentials in the Login page
	public void loginCredentials(String userName,String pwd) {
	driver.findElement(By.id("username")).sendKeys(userName);
	driver.findElement(By.id("password")).sendKeys(pwd);
	driver.findElement(By.className("decorativeSubmit")).click();
	}
	
	//To navigate to the page where we can create leads
	public void clickHyperLink(){
		driver.findElement(By.partialLinkText("CRM")).click();
		driver.findElement(By.partialLinkText("Leads")).click();
	}
	
	//To create a Lead with the mandatory field values
	public void createLead() {
		//driver.findElement(By.partialLinkText("Leads")).click();
		driver.findElement(By.partialLinkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Amazon");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Alexa2 ");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Home Use");
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("org");
		driver.findElement(By.className("smallSubmit")).click();
		
		String title = driver.getTitle();
		System.out.println(title);
		if(title.equals("View Lead | opentaps CRM"))
			System.out.println("Expected Title");
		else
			System.out.println("Wrong Title");
		
		driver.close();
	}
	
	public static void main(String[] args){
		
		String url="http://leaftaps.com/opentaps/";
		String usrName="democsr",pwd="crmsfa";
		
		CreateLeadLeafTaps createLead = new CreateLeadLeafTaps();
		
		createLead.loadLeafTapsPage(url);
		createLead.loginCredentials(usrName, pwd);
		createLead.clickHyperLink();
		createLead.createLead();
	}

}
