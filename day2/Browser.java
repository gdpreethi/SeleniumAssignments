/*This class defines the methods to launch browser and URL messages */
package week1.day2;

public class Browser {
	
  //Method to launch the browser
	public void launchBrowser(String browserMsg) {
		System.out.println(browserMsg);
	}
  //Method to load the application URL	
    public void loadUrl(String urlMsg) {
    	System.out.println(urlMsg);
    }
    
	public static void main(String[] args) {
		
		Browser browserDetails = new Browser();
		//values to be passed to the methods
		String browserMsg = "Browser launched successfully";
		String urlMsg="Application URL loaded successfully";
		
		//call the methods to display messages to launch browser and the url
		browserDetails.launchBrowser(browserMsg);
		browserDetails.loadUrl(urlMsg);
	}

}
