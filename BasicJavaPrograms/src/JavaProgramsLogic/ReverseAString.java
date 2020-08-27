package JavaProgramsLogic;

public class ReverseAString {

	public static void main(String[] args) {

		String name= "Shahrukh is a good boy";
		String rev= " ";
		int length = name.length();
		
		for(int i=length-1;i>=0;i--){
			rev = rev+ name.charAt(i);
		}
		System.out.println(rev);
	}

}
