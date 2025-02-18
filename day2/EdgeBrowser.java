/* This class is used to call the methods of Browser class 
 * and display the messages in console*/
package week1.day2;

public class EdgeBrowser {

	public static void main(String[] args) {
		
		//Intializing instance for Browser class
		Browser browserCall = new Browser();
		
		//Calling methods of browser class
		browserCall.launchBrowser("Browser launched successfully");
		browserCall.loadUrl("Application URL loaded successfully");

	}

}
