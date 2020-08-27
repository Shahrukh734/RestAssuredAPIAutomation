package JavaProgramsLogic;

import java.util.Scanner;

public class FactorialByRecursion {

	public static int fact = 1;
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number for Factorial is: ");
		int no = s.nextInt();
		FactorialByRecursion obj = new FactorialByRecursion();
		obj.calFact(no);
		System.out.println("Factorial of " + no + " is: "+fact);
		
	}
	
	public void calFact(int no){
		if(no>1) {
			
			fact = fact*no;
			calFact(no-1);
		}
	}

}
