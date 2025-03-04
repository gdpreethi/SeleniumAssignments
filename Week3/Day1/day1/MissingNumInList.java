package week3.day1;

import java.util.ArrayList;
import java.util.List;

public class MissingNumInList {

	public static void main(String[] args) {
		List<Integer> testNum= new ArrayList<Integer>();
		testNum.add(1);
		testNum.add(2);
		testNum.add(3);
		testNum.add(4);
		testNum.add(6);
		testNum.add(8);
		testNum.add(10);
		testNum.sort(null);
		//System.out.println(testNum.size());
		  for(int i=0;i<testNum.size()-1;i++) {
			  if(testNum.get(i)+1 != testNum.get(i+1)) {
				  System.out.println(testNum.get(i)+1);
			  }
		  }
	}
}

