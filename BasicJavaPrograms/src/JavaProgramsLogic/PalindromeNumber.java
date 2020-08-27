package JavaProgramsLogic;

import java.util.Scanner;

public class PalindromeNumber {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number to check the palindrome: ");
		int no = s.nextInt();
		
		int temp=no;
		int rem;
		int rev=0;
		
		while(temp!=0){
			rem = temp%10;
			rev = rev*10+rem;
			temp = temp/10;
		}
		
		if(no==rev)
			System.out.println("Number is palindrome: " +no);
		else
			System.out.println("Number is not palindrome");
		
		
	}

}
