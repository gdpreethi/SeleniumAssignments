package week2.day4;

public class JavaConnection implements DatabaseConnection{

	public static void main(String[] args) {
		ConnectToDatabase connection=new ConnectToDatabase();
		connection.connect();
		connection.disconnect();
		connection.executeUpdate();
	}

	@Override
	public void connect() {
        System.out.println("Connecting to Database");		
	}

	@Override
	public void disconnect() {
		System.out.println("Disconnect to Database");
	}

	@Override
	public void executeUpdate() {
		System.out.println("Executing Update");
	}


}
