package week3.day3;
//This class merges two contacts in LeafTaps site using window handler and alert box handling
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestLeafWindowHandling {
	ChromeDriver driver=new ChromeDriver();
	
	//To open the given URL in chrome browser
	public void loadLeafTapsPage(String URL) {	 
	 driver.manage().window().maximize();
	 driver.get(URL);
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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
		driver.findElement(By.partialLinkText("Contacts")).click();
	}
	
	//Create contact details
	public void createContact() throws InterruptedException {
				
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdFrom']/following-sibling::a")).click();
		
		Set<String> allOpenWindows = driver.getWindowHandles(); //get id/name of all the open windows
		List<String> listOfOpenWindows = new ArrayList<String>(allOpenWindows);
		
		  driver.switchTo().window(listOfOpenWindows.get(1)); //going to child window
		  driver.findElement(By.xpath("//tbody/tr/td[contains(@class,'partyId')]/div/a")).click();
		
		  driver.switchTo().window(listOfOpenWindows.get(0)); //back to parent window

		  driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdTo']/following-sibling::a")).click();
		
		 Set<String> allOpenWindows1 = driver.getWindowHandles(); //get id/name of all the open windows since the find contacts is closed perviously
		 List<String> listOfOpenWindows1 = new ArrayList<String>(allOpenWindows1);
		 
	     driver.switchTo().window(listOfOpenWindows1.get(1));
	     
		 driver.findElement(By.xpath("(//tbody/tr/td[contains(@class,'partyId')])[2]/div/a")).click();	
		 
		 driver.switchTo().window(listOfOpenWindows1.get(0));
		 
		 driver.findElement(By.xpath("//a[text()='Merge']")).click();
		 
		 //Handling the alert box
		 Alert mergeConfirm = driver.switchTo().alert();
		 mergeConfirm.accept();
		 
		 System.out.println(driver.getTitle());
		 driver.close();
		
	}
	
	public static void main(String[] args) {
		TestLeafWindowHandling windowHandler= new TestLeafWindowHandling();
		windowHandler.loadLeafTapsPage("http://leaftaps.com/opentaps/control/login");
		windowHandler.loginCredentials("democsr", "crmsfa");
		windowHandler.clickHyperLink();
		try {
			windowHandler.createContact();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
