import java.util.Scanner;

public class FibonacciSeriesWithDynamicProgramming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter the number:");
		int num = scn.nextInt();
		/*int [] result = findFibonacci(num);
		//System.out.println("fibonacci numbers till " + num + " are: ");
		for(int a:result){
			System.out.print(a);
			System.out.print(" ");
		}*/
		int result = fibonacciFunctionInLognTime(num);
		System.out.println(result);
	}
	public static int fibonacciFunctionInLognTime(int num){
		int [][] f = new int[][] {{1,1},{1,0}}; 
		if(num == 0){
			return 0;
		}
		power(f,num-1);
		return f[0][0];
	}
	static void power(int [][] f,int num){
		int i;
		int [][] m = new int[][] {{1,1},{1,0}};
		//this below line code time compelixity will be o(n) and can be reduced to o(logn)
		/*for(i=2;i<=num;i++){
			multiply(f,m);
		}*/
		//this below line time complexity would be o(logn)
		if(num == 0 || num == 1){
			return ;
		}
		power(f,num/2);
		multiply(f,f);
		if(num%2 != 0){
			multiply(f,m);
		}
	}
	static void multiply(int [][] f,int [][] m){
		int x =  f[0][0]*m[0][0] + f[0][1]*m[1][0];
	    int y =  f[0][0]*m[0][1] + f[0][1]*m[1][1];
	    int z =  f[1][0]*m[0][0] + f[1][1]*m[1][0];
	    int w =  f[1][0]*m[0][1] + f[1][1]*m[1][1];
	    f[0][0] = x;
	    f[0][1] = y;
	    f[1][0] = z;
	    f[1][1] = w;
	}
	public static int [] findFibonacci(int num){
		int [] f = new int [num+1];
		f[0] = 0;
		f[1] = 1;
		for(int i = 2;i<=num;i++){
			f[i] = f[i-1] + f[i-2];
		}
		return f;
	}
	
}
