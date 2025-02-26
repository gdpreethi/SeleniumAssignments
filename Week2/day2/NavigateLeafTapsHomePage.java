package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
//This is a common class to Load,Login and navigate to Home page in LeafTaps site
public class NavigateLeafTapsHomePage {
	
	ChromeDriver driver=new ChromeDriver();
	public static void main(String[] args) {

	}
	//To open the given URL in chrome browser
		public void loadLeafTapsPage() {
		  String url="http://leaftaps.com/opentaps/";
			driver.manage().window().maximize();
			driver.get(url);
		}
	
	//To provide the Login credentials in the Login page
		public void loginCredentials(String usrName,String pwd) {
		//String usrName="democsr",pwd="crmsfa";
			driver.findElement(By.id("username")).sendKeys(usrName);
			driver.findElement(By.id("password")).sendKeys(pwd);
			driver.findElement(By.className("decorativeSubmit")).click();
		}
	//To navigate to the page where we can create leads
		public void clickHyperLink(String tabOption){
			driver.findElement(By.partialLinkText("CRM")).click();
			driver.findElement(By.partialLinkText(tabOption)).click();
		}
			
		
}
