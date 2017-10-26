import java.util.Scanner;
public class StringReversal {

	public static void main(String[] args) {
		/*
		Scanner scn = new Scanner(System.in);
		String target = scn.next();
		System.out.println("Entered String is "+ target);
		int len = target.length();
		char [] str = target.toCharArray();
		for(int i = 0,j=len-1;j>i;i++,j--){
			char temp = str[i];
			str[i] = str[j];
			str[j] = temp;
		}
		System.out.println("Reversed String is " + String.valueOf(str));*/
		stringReversal();
	}
	
	public static void stringReversal(){
		Scanner scn = new Scanner(System.in);
		String target = scn.nextLine();
		int len = target.length();
		int start,end=len-1;
		for(int i = end;i >= 0;i--){
			if(target.charAt(i) == ' ' || i ==0){
				if(i == 0){
					start = i;
				}else
					start = i + 1;
				while(start <= end){
					System.out.print(target.charAt(start));
					start++;
				}
				System.out.print(" ");
				end = i -1;
			}
		}
	}
}
