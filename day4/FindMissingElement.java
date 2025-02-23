package week1.day4;

import java.util.Arrays;

//This class finds the missing element in an given array
public class FindMissingElement {

	public static void main(String[] args) {
		int intArray[] = {1,4,3,2,8,6,7};
		
		Arrays.sort(intArray); // Sort the given array in ascending order
		//Iterate through the array to find the missing elements
		for(int i =0 ;i<intArray.length;i++) {
			
			if(intArray[i]!=i+1) {
				System.out.print(i+1);
				break;
			}
	    }

    }
}
