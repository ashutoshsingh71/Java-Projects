
import java.util.Scanner;

public class LongestCommonSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String s1 = scn.nextLine();
		String s2 = scn.nextLine();
		char [] x = s1.toCharArray();
		char [] y = s2.toCharArray();
		int m = x.length;
		int n = y.length;
		System.out.println("Longest Common subsequence is : " +lcsDynamic(x,y,m,n));
	}
	
	static int lcs(char [] x,char [] y,int m,int n){
		if(m == 0 || n == 0){
			return 0;
		}
		if(x[m-1] == y[n-1]){
			return 1 + lcs(x,y,m-1,n-1);
		}else{
			return max(lcs(x,y,m-1,n),lcs(x,y,m,n-1));
		}
	}
	static int max(int a ,int b){
		return (a>b)? a : b ;
	}
	
	static int lcsDynamic(char []x,char[] y,int m,int n){
		int [][] L = new int[m+1][n+1];
		for(int i = 0; i<=m ; i++){
			for(int j = 0;j<=n;j++){
				if(i==0 || j == 0){
					L[i][j] = 0;
				}else if(x[i-1] == y[j-1]){
					L[i][j] = L[i-1][j-1] + 1;
				}else{
					L[i][j] = max(L[i-1][j],L[i][j-1]);
				}
			}
		}
		return L[m][n];
	}
}
