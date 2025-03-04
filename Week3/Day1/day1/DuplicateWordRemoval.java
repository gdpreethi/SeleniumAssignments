package week3.day1;

//This class removes the duplicate words in the given string
public class DuplicateWordRemoval {

	public static void main(String[] args) {

		String text = "We learn Java basics as part of java sessions in java week1";
		String splittedText[]=text.split(" ");
		int count=0;
		
		for(int i=0;i<splittedText.length;i++) {
			for(int j=i+1;j<splittedText.length;j++) {
				
				if(splittedText[i].equalsIgnoreCase(splittedText[j])) {
					
					splittedText[j] = splittedText[j].replace(splittedText[j], " ");
					count++;
				}
			}
		}
		
		if(count>0) {	//tells there is atleast one repeated word
			
			for(int i=0;i<splittedText.length;i++) {
    	   
				System.out.print(splittedText[i]+" ");
			}
		}
	}

}
