package JavaProgramsLogic;

public class FibonacciSeries {

	public static void main(String[] args) {

		int a= 0;
		int b = 1;
		int c;
		System.out.println(a+ "  "+b);
		for(int i =1;i<=10;i++) {
			c = a+b;
			System.out.print(" " +c);
			a=b;
			b=c;
		}
		
	}

}
