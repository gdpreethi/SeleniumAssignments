package week1.day3;
//This class is used to check if the given number is prime number

public class IsPrimeNumber {

	//Below logic returns true if the number provided is prime
	public boolean isPrime(int num) {
		if(num<=1) {
			return true;
		}
		for(int i=2;i<num;i++) {
			//if the reminder is zero then given number is not prime
			if(num % i == 0)
				return false;
		}
		return true;
	}
	 
	public static void main(String[] args) {
		IsPrimeNumber isPrimeNumber = new IsPrimeNumber();
		//Passing the number to be checked
		boolean result = isPrimeNumber.isPrime(13);
		
		 if(result)
			 System.out.println("Given number is a prime number");
		 else
			 System.out.println("Given number is not a prime number");
	}

}
