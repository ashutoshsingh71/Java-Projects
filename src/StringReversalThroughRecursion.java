import java.util.Scanner;

public class StringReversalThroughRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s = scn.nextLine();
		int length = s.length();
		reverseString(s);
	}
	public static void reverseString(String s){
		if (s == null || s.length()<=1){
			System.out.print(s);
		}else{
			System.out.print(s.charAt(s.length()-1));
			reverseString(s.substring(0, s.length()-1));	
		}
	}
}
