import java.util.*;

public class BruteForceStringMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn  = new Scanner(System.in);
		System.out.println("Enter the text:");
		String text = scn.next();
		System.out.println("Enter the pattern:");
		String pattern = scn.next();
		int textLength = text.length();
		int patternLength = pattern.length();
		char [] textArray = text.toCharArray();
		char [] patternArray = pattern.toCharArray();
		int position = -1;
		boolean flag = false;
		for(int i = 0;i <= textLength - patternLength;i++){
			int j = 0;
			while(j < patternLength && patternArray[j] == textArray[i + j]){
				j = j + 1;
			}
			if (j == patternLength){
				flag = true;
				position = i;
			}
			if(flag){
				break;
			}
		}
		if(flag){
			System.out.println("Found at index "+ position + " in text " + text);
		}else
			System.out.println("Not found");
	}

}
