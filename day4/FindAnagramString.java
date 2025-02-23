package week1.day4;

import java.util.Arrays;

//This class checks if the given two strings are anagram or not

public class FindAnagramString {

	public boolean checkAnagram(String val1,String val2) {
		
		char text1[],text2[];
		
		//Logic to validate the given strings for Anagram
		
		 //convert the string values to char array and sort the array values
		text1 = val1.toCharArray();
		text2 = val2.toCharArray();
		 Arrays.sort(text1);
		 Arrays.sort(text2);
		 //System.out.println(text1 + " " + text2);
		 //check every character from the two arrays with indexing
		  for(int i=0;i<text1.length;i++) {
			 // System.out.print(text1[i] + " " + text2[i]);
			  if(text1[i] == text2[i]) {
				  return true;
			  }else {
				  return false;
			  }
		  }
		  return false;
		
	}
	public static void main(String[] args) {
     
		String val1="stops";
		String val2="potss";
		//Create an object for the class FindAnagramString and call the method to check the two strings
		
		FindAnagramString fas = new FindAnagramString();
		boolean returnValue=fas.checkAnagram(val1,val2);
		
		//Message to display if given two strings length are different
		if(val1.length() != val2.length()) {
			System.out.println("Lengths mismatch, therefore the strings are not an Anagram");
		}else if(returnValue && val1.length() == val2.length()) {
			  System.out.println("The given strings are Anagram.");
		  }else {
			  System.out.println("The given strings are not Anagram.");
		  }
			  
	}

}
