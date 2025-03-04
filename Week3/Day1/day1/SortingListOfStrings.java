package week3.day1;

import java.util.ArrayList;
import java.util.List;

public class SortingListOfStrings {

	public static void main(String[] args) {
     List<String> test = new ArrayList<String>();

     test.add("HCL");
	test.add("Wipro");
	test.add("Aspire Systems");
	test.add("CTS");
	 test.sort(null);
	  for(int i=test.size()-1;i>=0;i--)
	  {
		  System.out.println(test.get(i));
	  }
	} 

}
