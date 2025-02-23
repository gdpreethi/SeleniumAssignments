package week1.day4;
//This class is used to change the character at odd index to Uppercase character
public class StringManipulationOddIndex {

	public static void main(String[] args) {
      String text1="changeme";
      char []charArray = text1.toCharArray();
      
       //Change the character at odd index to upper case character
       for(int i=1;i<=text1.length();i+=2) {
    	    charArray[i] = Character.toUpperCase(charArray[i]);    	    
       }
       
       //Assign the manipulated char array to String object
      String text2 = new String(charArray);
      System.out.println(text2);
    	   
	}

}
