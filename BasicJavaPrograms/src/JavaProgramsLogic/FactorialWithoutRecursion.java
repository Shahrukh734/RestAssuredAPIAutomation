package JavaProgramsLogic;

public class FactorialWithoutRecursion {

	public static void main(String[] args) {

		int no = 6;int fact=1;
		for(int i=1; i<=no; i++){
			fact= fact*i;
		}
		System.out.println("Factorial of a given number is :" +fact);
		
	}

}
