package JavaProgramsLogic;

public class ReverseAWordFromstringInSentence {

	public static void main(String[] args) {

		String sen = "Shahrukh is a good boy";
		String[] words = sen.split(" ");
		String rev= " ";
		
		for(int i=0; i<words.length; i++){
			String word = words[i];
			String revWord= " ";
			for(int j=word.length()-1; j>=0;j--){
				revWord = revWord + word.charAt(j);
			}
			rev = rev + revWord + " ";
		}
		System.out.println(rev);
	}

}
