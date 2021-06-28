package DynamicProgramming.KnapsackProblems;

//Problem Statement: Given an array Ar=[] and an integer Sum S.
// We need to find the total number of subsets having the elements sum as given sum S.

public class CountOfSubsetWithGivenSum {
    public static int findCountOfSubsets(int [] arr,int size,int sum){
        if(sum == 0){
            return 1;
        }
        if(size == 0){
            return 0;
        }
        if(arr[size-1] <= sum){
            return findCountOfSubsets(arr,size-1,sum-arr[size-1]) + findCountOfSubsets(arr,size-1,sum);
        }else
            return findCountOfSubsets(arr,size-1,sum);
    }

    public static void printMatrix(int [][] arr,int row,int col){
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(arr[i][j] + ", ");
            }
            System.out.println();
        }
    }
    public static int findCountOfSubsetsIterative(int [] arr,int size,int sum){
        int [][] dp= new int[size+1][sum+1];
        //initialization
        for(int i=0;i<size+1;i++){
            for(int j=0;j<sum+1;j++){
                if(j==0){
                    dp[i][j] = 1;
                }
                if(i == 0 && j> 0){
                    dp[i][j] = 0;
                }
            }
        }
        //logic to fill the matrix
        for(int i=1;i<size+1;i++) {
            for (int j = 1; j < sum + 1; j++) {
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j- arr[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        printMatrix(dp,size+1,sum+1);
        System.out.println();
        return dp[size][sum];
    }

    public static void main(String [] args){
        int [] arr = {3,4,1,5,10,2};
        int sum = 10;
        System.out.println(findCountOfSubsetsIterative(arr,6,sum));
    }
}
