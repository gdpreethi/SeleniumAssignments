package week2.day3;

public class LoginTestData extends TestData{

	public String enterUsername() {
		return "sample username";
		
	}
	
	public String enterPassword() {
		return "pwd";
	}
	public static void main(String[] args) {
		LoginTestData loginTest = new LoginTestData();
		String sampleUsrName=loginTest.enterUsername();
		String samplePwd=loginTest.enterPassword();
		loginTest.enterCredentials(sampleUsrName,samplePwd);
	}

}
