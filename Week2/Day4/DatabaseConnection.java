package week2.day4;

//Interface for connecting Database
public interface DatabaseConnection {

	public void connect();
	public void disconnect();
	public void executeUpdate();
}
