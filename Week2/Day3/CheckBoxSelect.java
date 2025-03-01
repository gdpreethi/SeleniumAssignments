package week2.day3;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckBoxSelect {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://leafground.com/checkbox.xhtml");
		Thread.sleep(1000);

		WebElement checkBoxBasic = driver.findElement(By.xpath("//span[text()='Basic']/preceding-sibling::div[1]"));
		checkBoxBasic.click();

		WebElement checkBoxAjax =driver.findElement(By.xpath("//span[text()='Ajax']/preceding-sibling::div[1]"));
		checkBoxAjax.click();

		//Explicit wait to get Ajax flyover
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ui-growl-title']")));

		//getting text from flyover	
		String text = driver.findElement(By.xpath("//span[@class='ui-growl-title']")).getText();

		System.out.println(text);
		//validation using the text from flyover as the checkbox click is writter on span tag not with <input> tag

		if(text.contains("Checked"))
			System.out.println("Ajax checkbox is selected" + text);
		else if (text.contains("Unchecked"))
			System.out.println("Ajax checkbox is not selected" + text);

		driver.findElement(By.xpath("(//label[text()='Java'])/preceding-sibling::div[contains(@class,'ui-chkbox')]/div[2]")).click();
		driver.findElement(By.xpath("(//label[text()='Javascript'])/preceding-sibling::div[contains(@class,'ui-chkbox')]/div[2]")).click();

		Thread.sleep(2000);

		WebElement triStateElement = driver.findElement(By.xpath("//h5[text()='Tri State Checkbox']/following::div[5]"));
		triStateElement.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Information']/following-sibling::div/span/following-sibling::p")));

		/*Below sysout will not print as the checkbox click is not a input type isSelected only works for <input> tag
		System.out.println("TriState Checkbos "+triStateElement.isSelected());
		 */
		//Below Webelement will get the checked or unchecked status of the TriState checkbox
		WebElement triStateCheckboxStatus = driver.findElement(By.xpath("//h5[text()='Tri State Checkbox']/following::div[5]/span"));

		String triStateTxt=driver.findElement(By.xpath("//span[text()='Information']/following-sibling::div/span/following-sibling::p")).getText();

		System.out.println(triStateCheckboxStatus.getAttribute("class"));
		//Storing the return value of the triStateCheckboxStatus element
		String returnCheckStatus=triStateCheckboxStatus.getAttribute("class");

		System.out.println(triStateCheckboxStatus.getAttribute("class"));

		driver.findElement(By.xpath("//h5[text()='Toggle Switch']//following::div//following::div")).click();

		WebElement disabledCheckBox = driver.findElement(By.xpath("//span[text()='Disabled']/preceding-sibling::div[1]"));
		String disabledClassProperty = disabledCheckBox.getAttribute("class");

		System.out.println(disabledClassProperty);
		if(disabledClassProperty.equals("ui-chkbox-box ui-widget ui-corner-all ui-state-default ui-state-disabled ui-state-disabled")) {
			System.out.println("Checkbox is disabled");
		}

		//Verification method for Tri State Checkbox
		if(returnCheckStatus.contains("ui-chkbox-icon ui-c ui-icon ui-icon-check") && triStateTxt.equals("State = 1")) {
			System.out.println("Tri State CheckBox checked");
		}else if(returnCheckStatus.contains("ui-chkbox-icon ui-c ui-icon ui-icon-closethick") && triStateTxt.equals("State = 2")) {
			System.out.println("Tri State Checkbox is closed");
		}else if(returnCheckStatus.contains("ui-chkbox-icon ui-c") && triStateTxt.equals("State = 0")) {
			System.out.println("Tri State Checkbox not selected");
		}
		//Multi Select
		WebElement multiSelect=driver.findElement(By.xpath("//h5[text()='Select Multiple']/following-sibling::div"));
		multiSelect.click();

		//using List of webelements to select option in Multiselect	    
		List<WebElement> selectedELements=new ArrayList<WebElement>();
		selectedELements.add(driver.findElement(By.xpath("(//label[text()='Miami'])[2]/preceding::div[1]")));
		selectedELements.add(driver.findElement(By.xpath("(//label[text()='Paris'])[2]/preceding::div[1]")));
		WebDriverWait waitForSelect = new WebDriverWait(driver,Duration.ofSeconds(10));
		waitForSelect.until(ExpectedConditions.visibilityOfAllElements(selectedELements));	    
		for (WebElement e : selectedELements) {
			e.click();
		}

	}

}
