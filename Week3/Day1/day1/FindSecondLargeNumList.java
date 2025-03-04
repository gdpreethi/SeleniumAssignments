package week3.day1;

import java.util.ArrayList;
import java.util.List;

public class FindSecondLargeNumList {

	public static void main(String[] args) {
		List<Integer> items=new ArrayList<Integer>();
		items.add(2);
		items.add(11);
		items.add(3);
		items.add(4);
		items.add(6);
		items.add(7);
		items.add(12);
		items.sort(null);
		System.out.println("Second Largest Number is: "+items.get(items.size()-2));
		 
	}

}
