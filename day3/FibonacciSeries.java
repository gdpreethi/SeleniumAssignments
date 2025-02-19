package week1.day3;
//This class prints the Fibonacci Series for a given range
public class FibonacciSeries {

	public static void main(String[] args) {
		
	//Initalizing first two fibonacci series numbers	
		int num1=0;
		int num2=1;
		int num3; 
		
		//Displaying the first two fibonacci series numbers
		System.out.println(num1); 
		System.out.println(num2); 
		
		//Iterating the for loop from 1 to 6 as first two numbers 
		//are already printed and remaining six numbers will be printed inside for loop
		  for(int i=1;i<=6;i++) {
			  
		//Logic to calculate the Fibonacci series	  
			  num3 = num1 + num2;
			  num1 = num2;
			  num2 = num3;
			System.out.println(num3);
			
		  }
	}
}
