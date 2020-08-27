package JavaProgramsLogic;

public class FibonacciSeriesByRecursion {

	static int a=0; static int b=1; int c;
	public static void main(String[] args) {

		
		System.out.println(a+ " " +b);
		FibonacciSeriesByRecursion obj = new FibonacciSeriesByRecursion();
		obj.CalFibo(10);
		
	}
	
	public void CalFibo(int i){
		if(i>=1){
			c= a+b;
			System.out.print(" " +c);
			a=b;
			b=c;
			CalFibo(i-1);
		}
	}

}
