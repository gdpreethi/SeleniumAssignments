package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountWithSelect {

	//To create a Lead with the mandatory field values
	public void createAccount(ChromeDriver driver) {
		driver.findElement(By.partialLinkText("Create")).click();
		//Webelement to select Industry dropdown	
		WebElement selectIndustryEle = driver.findElement(By.name("industryEnumId"));
		Select industryDropdown = new Select(selectIndustryEle);	
		
		//Webelement to select ownership dropdown	
		WebElement selectOwnerEle = driver.findElement(By.name("ownershipEnumId"));
		Select ownershipDropdown = new Select(selectOwnerEle);
		 
		//Webelement to select Source dropdown	
		WebElement selectSourceEle = driver.findElement(By.id("dataSourceId"));
		Select sourceDropdown = new Select(selectSourceEle);
		 
		//Webelement to select Marketing campaign dropdown	
		WebElement selectMrkCampEle = driver.findElement(By.id("marketingCampaignId"));
		Select marketingCampaignDropdown = new Select(selectMrkCampEle);
		
		//Webelement to select state/province dropdown	
		WebElement selectStateEle = driver.findElement(By.id("generalStateProvinceGeoId"));
		Select stateProvinceDropdown = new Select(selectStateEle);
		
			
			driver.findElement(By.id("accountName")).sendKeys("Amazon6");
			driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");
			
			 //Select the option in Industry dropdown
			industryDropdown.selectByIndex(3);
			 //Select the option in ownership dropdown
			ownershipDropdown.selectByVisibleText("S-Corporation");
			 //Select the option in source dropdown
			sourceDropdown.selectByValue("LEAD_EMPLOYEE");
			 //Select the option in Marketing campaign dropdown
			marketingCampaignDropdown.selectByIndex(6);
			 //Select the option in state/province dropdown
			stateProvinceDropdown.selectByValue("TX");
			
			driver.findElement(By.className("smallSubmit")).click();
			
			//Webelement to verify the Account name
			WebElement acctName = driver.findElement(By.xpath("(//span[@class='tabletext'])[3]"));
			String newAccName=acctName.getText();
			
				if(newAccName.contains("Amazon6"))
					System.out.println(newAccName + "Matches");
				else
					System.out.println(newAccName + "different");
			
			driver.close();
		}
	
	public static void main(String[] args) {
		//Instantiation of existing class for navigating to the Home page for creating Account
		NavigateLeafTapsHomePage nav = new NavigateLeafTapsHomePage();
		
		//Using the driver loaded from the CreateLeadLeafTaps class
		 ChromeDriver driver = nav.driver;
		 
		//Below method call is used to load and open the My Home page in LeafTaps app 
		 nav.loadLeafTapsPage();
		 nav.loginCredentials("democsr","crmsfa");
		 nav.clickHyperLink("Accounts");
		 
		 //Initialize the object for this class
		 CreateAccountWithSelect selectAcc = new CreateAccountWithSelect();
		 selectAcc.createAccount(driver);
	}

}
