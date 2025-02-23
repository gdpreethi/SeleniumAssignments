package week1.day4;
//This class checks whether the given input integer value is Palindrome or not
public class CheckPalindrome {
 
	//Method to reverse the given input value and return to main method
	public static int calPalindrome(int n) {
		int output=0;
		for(int i = n;i>0;i=i/10) {		
		   output = output * 10 + i % 10;
			n = n/10;
		}
		return output;
	}
	public static void main(String[] args) {

		int input=121;
		
		//check if the given input and reversed value are equal
		if(input == calPalindrome(input)) {
			System.out.println("Palindrome");
		}else {
			System.out.println("Not palindrome");
		}
		
	}

}
