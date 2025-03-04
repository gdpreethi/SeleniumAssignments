package week3.day1;
//This class checks if the given two strings are Anagram to each other
import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		
		String text1="stops";
		String text2="sstop";
		//convert the strings to char Array
		char text1Array[]= text1.toCharArray();
		char text2Array[]= text2.toCharArray();
		
		//Sort both char Arrays
		 Arrays.sort(text1Array);
		 Arrays.sort(text2Array);
		/* System.out.println(text1Array);
		 System.out.println(text2Array);
		 System.out.println(Arrays.equals(text1Array, text2Array));*/
		   if(text1.length()!=text2.length()) {
			   System.out.println("Lengths mismatch, therefore the strings are not an Anagram");
		   }else if(Arrays.equals(text1Array, text2Array)){ //this returns true if both the char Arrays contains same characters
			  System.out.println("The given strings are Anagram.");
			  
		   }else {
			   System.out.println("The given strings are not an Anagram.");
		   }
	}

}
