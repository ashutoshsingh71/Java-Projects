import java.util.Arrays;
public class CoinChangeProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] s = {1,1,1,1,2,3};
		int value = 4;
		long result = checkCoinChange(s,s.length,value);
		System.out.println("Answer is:" + result);
	}
	static long checkCoinChange(int []s,int m,int n){
		long [] table =  new long [n+1]; 
		Arrays.fill(table, 0);
		table[0] = 1;
		for(int i = 0;i<m;i++){
			for(int j=s[i];j<=n;j++){
				table[j] += table[j-s[i]];
			}
		}
		for(long p:table){
			System.out.print(p + " ");
		}
		return table[n];
	}
}
