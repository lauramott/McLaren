import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class challenge {
	public static int counter =0; //count how many palindromes found
	static String sol1="";
	static String sol2="";
	static String sol3="";
	
	public static void main(String args[]){
	String original = readString(); //read string and save ad original
	findStringToReverse(original); //find the strings to reverse within the original string
	}
	
	public static String readString(){
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter String of your choise: ");
		String input = reader.next();
		System.out.println("Given the input string: " + input + " the output is: ");
		return input;
	}
	public static void reverseString(String toReverse, String original){
		String reversed="";
		for(int i=(toReverse.length()-1);i>=0;i--){
			reversed = reversed + toReverse.charAt(i);
			//call function to compare the original string to the reversed one,
			//if equal it'll print a report
			compareStrings(toReverse,reversed, original); //pass the original string, the string to reverse and the reversed string
			}
		
	}
//	In the findStringToReverse method I'm passing the original string
//	1)I reverse the all string and see if it's a palindrome
//	2)Increase the starting Index and decreasing the length of the string to reverse
//	3)call the reverseString method, to reverse a string
//	4)repeat until the length of the string to reverse in less then 2.

//	EXAMPLE:
	//	string input: ABCDE
	//	the method will reverse the all string and check if it's a palindrome	
	//	EDCBA == ABCDE 	? print the report and increase the counter : search for a new string
		//	the method will reverse a string of length equal to the original length minus 1	
		//	ABCD ==DCBA	 ? print the report and increase the counter : search for a new string
		//	BCDE ==EDCB  ? print the report and increase the counter : search for a new string
			//	the method will reverse a string of length equal to the original length minus 2	
			//	ABC == CBA	 ? print the report and increase the counter : search for a new string
			//	BCD == DCB  ? print the report and increase the counter : search for a new string
			//  CDE == EDC  ? print the report and increase the counter : search for a new string
				//	the method will reverse a string of length equal to the original length minus 3	
				//	AB == BA	 ? print the report and increase the counter : search for a new string
				//	BC == CB  ? print the report and increase the counter : search for a new string
				//  CD == DC  ? print the report and increase the counter : search for a new string
				//  DE == ED  ? print the report and increase the counter : search for a new string
	
	public static void findStringToReverse(String original){
		String toReverse = "";
		int startingIndex = 1;//startingIndex
		int setLength=(original.length());
		do{
		for(int j=0; j<startingIndex ; j++){
			for(int i=j;i<(setLength+j);i++){
				toReverse +=original.charAt(i);
			}
			reverseString(toReverse,original);
			toReverse="";
		}
		setLength--;
		startingIndex++;
		
		}while(setLength>1);
	}
	public static void compareStrings(String toReverse, String reversed, String original){
		
		
		String[] sol = {sol1,sol2,sol3};
		
			if(toReverse.equals(reversed)){
				
		if(counter==0){
				sol1=toReverse;
				sol[0]=sol1;
				printReport(toReverse,original);
				counter++;
		}
		else if(counter ==1){
				sol2=toReverse;
				sol[1]=sol2;
				sol1=sol[0];
				//check if the current palindrome is unique
				//if the starting index of the new palindrome is > starting index of previous palindrome found 
				//& the last index of the new palindrome is < the last index of the previous palindrome found
				// search a new palindrome
				if(((original.indexOf(sol2))>=original.indexOf(sol1))&&((original.indexOf(sol2)+sol2.length()-1))
						<=((original.indexOf(sol1)+sol1.length()-1))){	
				}
				else{
					printReport(toReverse,original);//the palindrome is unique, so print Report
					counter++;
				}
		}
		else if(counter ==2){
				sol3=toReverse;
				sol[2]=sol3;
				sol1=sol[0];
				sol2=sol[1];
				//check if the current palindrome is unique
				//check if the current palindrome is unique
				//if the starting index of the new palindrome is > starting index of previous palindromes found 
				//& the last index of the new palindrome is < the last index of the previous palindromes found
				// search a new palindrome
				if(((original.indexOf(sol3)>=original.indexOf(sol1))&&(((original.indexOf(sol3)+sol3.length()-1))
						<=((original.indexOf(sol1)+sol1.length()-1))))
					||
					((original.indexOf(sol3)>=original.indexOf(sol2))&&((original.indexOf(sol3)+sol3.length()-1))
							<=((original.indexOf(sol2)+sol2.length()-1)))){
				}else{
					printReport(toReverse,original); //the palindrome is unique, so print Report
					counter++;
				}
		}
		else{
			System.out.close();			
			}			
		}		
	}
	public static void printReport (String toReverse, String original){ //Print Report
		System.out.print("Text: " + toReverse + ", ");
		System.out.print("Index: " + original.indexOf(toReverse)+", ");
		System.out.print("Length: " + toReverse.length());
		System.out.println();
		
	}
}
