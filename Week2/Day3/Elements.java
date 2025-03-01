package week2.day3;

import org.openqa.selenium.chrome.ChromeDriver;

public class Elements {
	


	public static void main(String[] args) {

		
		
		CheckBoxButton checkBtn = new CheckBoxButton();
		checkBtn.submit();
		checkBtn.clickCheckButton();
		checkBtn.click();
		checkBtn.setText("Checkbox button Text from Elements");
		
		RadioButton radioBtn = new RadioButton();
		radioBtn.selectRadioButton();
		radioBtn.submit();
		radioBtn.click();
		radioBtn.setText("Radio button Text from Elements");
		
	}

}
