package week2.day4;

public class JavaConnectionAbstract extends MySqlConnection{

	public static void main(String[] args) {
		JavaConnectionAbstract javaAsbtract = new JavaConnectionAbstract();
		javaAsbtract.connect();
		javaAsbtract.disconnect();
		javaAsbtract.executeUpdate();
		javaAsbtract.executeQuery();
	}

	/*@Override
	public void connect() {
		System.out.println("Connecting from MySqlConnection");
		
	}
*/
	@Override
	public void disconnect() {
		System.out.println("Disconnect from MySqlConnection");
	}

	@Override
	public void executeUpdate() {
		System.out.println("Updating from MySqlConnection");
	}

	@Override
	public void executeQuery() {
		System.out.println("Query execute from MySqlConnection abstract method");
	}

}
