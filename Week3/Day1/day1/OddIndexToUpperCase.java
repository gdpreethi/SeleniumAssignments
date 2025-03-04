package week3.day1;
import java.util.Arrays;
 
//This class changes the characters in odd index of a String to UpperCase
public class OddIndexToUpperCase {

	public static void main(String[] args) {
      String test="changeme";
      char[] testArray=test.toCharArray();
      
      	for(int i=1;i<=test.length()-1;i=i+2) {
     		 
      		 if(Character.isLetter(testArray[i])) {
      			 testArray[i] = Character.toUpperCase(testArray[i]); //convert the characters in odd index to upper case
      		 }
      	}
      	System.out.println(testArray);
	}

}
