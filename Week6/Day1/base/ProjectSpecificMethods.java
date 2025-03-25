package base;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ProjectSpecificMethods {
	//public static ChromeDriver driver;
	private static final ThreadLocal<RemoteWebDriver> rd=new ThreadLocal<RemoteWebDriver>();
	@BeforeMethod
	//initilazation of driver object
	public void preCondition() {
		
		//driver=new ChromeDriver();
		setRd(new ChromeDriver());
		//RemoteWebDriver driver=getRd();
		getRd().manage().window().maximize();
		getRd().get("http://leaftaps.com/opentaps/");
		getRd().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	@AfterMethod
	public void postCondition() {
		getRd().quit();
		
	}
	public RemoteWebDriver getRd() {
		return rd.get();
	}
	public void setRd(RemoteWebDriver driver) {
		rd.set(driver);
	}

}
