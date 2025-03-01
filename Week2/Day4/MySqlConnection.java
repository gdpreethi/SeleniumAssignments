package week2.day4;

public abstract class MySqlConnection implements DatabaseConnection{
	
	public abstract void executeQuery();
	public void connect() {
	   System.out.println("Connection established from MySqlConnection abstract class");
   }
}
