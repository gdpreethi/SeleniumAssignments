package week1.day3;

//This class checks if the given number is positive or negative number

public class CheckNumberIsPositive {

	public static boolean isPositive(int num) {
		//Check the given number is greater than zero or not
		if(num > 0)
			return true;
		
		return false;
	}
	
	public static void main(String[] args) {
      //Call the static method with input to be checked
		
       if(isPositive(10))
    	   System.out.println("Positive number");
       else
    	   System.out.println("Negative number");
	}

}
