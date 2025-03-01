package week2.day3;

public class NavigatePageData extends TestData{

	public String currPage() {
		return "Home Page";
	}
	public String nextPage() {
		return "Leads Home page";
	}
	public static void main(String[] args) {
		NavigatePageData navPage = new NavigatePageData();
		String current = navPage.currPage();
		String nxt = navPage.nextPage();
		navPage.navigateToHomePage(current, nxt);
	}

}
