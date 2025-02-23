package week1.day4;
//This class is used to find the duplicate values in two arrays
public class FindIntersection {

	public static void main(String[] args) {
		
		//Declaring and Initializing the array values
       int array1[]= {3,2,11,4,6,7};
       int array2[]= {1,2,8,4,9,7};
       
        //outer for loop to iterate the array1 values
         for(int i=0;i<array1.length;i++) {
        	 
        	 //inner for loop to iterate the array2 values
        	 for(int j=0;j<array2.length;j++) {
        		 
        		 //check the arrays has duplicate values
        		 if(array1[i]==array2[j]) {
        			 System.out.println(array1[i]);
        			 break;
        		 }
        			 
        	 }
         }
	}

}
