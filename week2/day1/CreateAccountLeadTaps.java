package week2.day1;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

//This class Login to LeafTaps login page and create an Account from the website

public class CreateAccountLeadTaps {

  //ChromeDriver driver = new ChromeDriver();
	
	/*//To open the given URL in chrome browser
	public void loadLeafTapsPage(String URL) {	 
	 driver.manage().window().maximize();
	 driver.get(URL);
	}
	
	//To provide the Login credentials in the Login page
	public void loginCredentials(String userName,String pwd) {
	driver.findElement(By.id("username")).sendKeys(userName);
	driver.findElement(By.id("password")).sendKeys(pwd);
	driver.findElement(By.className("decorativeSubmit")).click();
	}*/
	
	//To navigate to the page where we can create an Account
	public void clickHyperLink(ChromeDriver driver){
		driver.findElement(By.partialLinkText("CRM")).click();
		driver.findElement(By.partialLinkText("Accounts")).click();
	}
	
	//To create a Lead with the mandatory field values
	public void createAccount(ChromeDriver driver) {
		driver.findElement(By.partialLinkText("Create")).click();
		driver.findElement(By.id("accountName")).sendKeys("Amazon");
		driver.findElement(By.className("inputBox")).sendKeys("Selenium Automation Tester");
		driver.findElement(By.id("numberEmployees")).sendKeys("300000");
		driver.findElement(By.id("officeSiteName")).sendKeys("LeafTaps");
		driver.findElement(By.className("smallSubmit")).click();
		
		String title = driver.getTitle();
		System.out.println(title);
		if(title.equals("Account Details | opentaps CRM"))
			System.out.println("Expected Title");
		else
			System.out.println("Wrong Title");
		
		driver.close();
	}
	
	public static void main(String[] args){
		
		String url="http://leaftaps.com/opentaps/";
		String usrName="democsr",pwd="crmsfa";
			    
		//Instantiation of existing class with loading the URL and login credentials
		CreateLeadLeafTaps createLead = new CreateLeadLeafTaps();
		
		//Using the driver loaded from the CreateLeadLeafTaps class
		ChromeDriver driver = createLead.driver;
		
		createLead.loadLeafTapsPage(url);
		createLead.loginCredentials(usrName, pwd);
		
		//Object to call the methods in this class
		CreateAccountLeadTaps createAccLeadTaps = new CreateAccountLeadTaps();
		createAccLeadTaps.clickHyperLink(driver);
		createAccLeadTaps.createAccount(driver);
	}

}
