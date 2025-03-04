package week3.day1;
//this class will reverse the strings/words present in the Odd index of a given string literal

import java.util.Arrays;

public class ReverseOddPositionWords {

	public static void main(String[] args) {
		String text="I am Software Tester";
		String[] splitText = text.split(" ");
		char charArray[] = null;
			for(int i=0;i<splitText.length;i++) {
				if(i%2==0) { //to get splitText values from even index
					System.out.print(" "+splitText[i]+" ");
				}else {
				charArray=splitText[i].toCharArray(); //odd index values are stored in charArray
				for(int j=charArray.length-1;j>=0;j--) { //charArray is looped from last index to reverse the given characters
					System.out.print(charArray[j]);
				}
				}
			}
	}

}
