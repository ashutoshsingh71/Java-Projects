import java.util.*;
public class LargestSumContiguousSubArray {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int size = scn.nextInt();
		int [] arr = new int[size];
		System.out.println("Please input array elements");
		for(int i=0;i<size;i++){
			int num = scn.nextInt();
			arr[i] = num;
		}
		/* This will work for mostly positive numbers if the whole numbers in array are negative 
		 * this will fail
		int maxEndingHere = 0;
		int start = 0;
		int end = 0;
		int maxSoFor = 0;
		for(int i = 0; i< size;i++){
			maxEndingHere = maxEndingHere + arr[i];
			if(maxEndingHere < 0){
				maxEndingHere = 0;
			}
			if(maxSoFor < maxEndingHere){
				if(start == 0){
					start = i;
				}else
					end = i;
				if(end == 0){
					end = start;
				}
				maxSoFor = maxEndingHere;
			}
		}
		System.out.println("Max sum of contiguous subarray is: " + maxSoFor);
		System.out.println("Max contiguous sum array is: ");
		for(int i = start;i<=end;i++){
			System.out.print(arr[i] + " ");
		}*/
		//Another solution is as follows
		int maxSoFar = arr[0];
		int currentMax = arr[0];
		int start=0,end = 0;
		for(int i = 1;i<size;i++){
			currentMax = max(arr[i] , currentMax + arr[i]);
			maxSoFar = max(maxSoFar,currentMax);
			if(start == 0){
				start = i;
			}else
				end = i;
		}
		System.out.println("Max sum of contiguous subarray is: " + maxSoFar);
	}
	public static int max(int a,int b){
		return a > b ? a : b;
	}
}
