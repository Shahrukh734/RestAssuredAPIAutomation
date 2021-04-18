package JavaProgramsLogic;

import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number whether it is prime or not: ");
		int no= s.nextInt();
		int temp=0;
		
		for(int i=2; i<=no-1; i++){
			if(no%i==0)
				temp = temp+1;
		}
		if(temp==0)
			System.out.println("Number is Prime: " +no);
		else 
			System.out.println("Number is not Prime: "+no);
	}

}
