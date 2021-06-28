package DynamicProgramming.KnapsackProblems;

//Given an array Ar[] , we need to find the number of subsets with minimum difference

public class MinimumSubsetSumDifference {
    public static int findMinimumSubsetSumDifference(int[] arr, int size) {
        int range = 0;
        for (int i = 0; i < size; i++) {
            range += arr[i];
        }
        boolean [] val = findSubsetSumThroughIterative(arr,arr.length,range);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<= range/2;i++){
            if(val[i]){
                int c = range - 2*i;
                if(min > c){
                    min = c;
                }
            }
        }
        return min;
    }

    static boolean[] findSubsetSumThroughIterative(int[] ar, int size, int total) {
        boolean[][] dp = new boolean[ar.length + 1][total + 1];
        //initialization of result matrix
        for (int i = 0; i < ar.length + 1; i++) {
            for (int j = 0; j < total + 1; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                }
                if (i == 0 && j > 0) {
                    dp[i][j] = false;
                }
            }
        }
        for (int i = 1; i < ar.length + 1; i++) {
            for (int j = 1; j < total + 1; j++) {
                if (ar[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - ar[i - 1]] || dp[i - 1][j];
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[ar.length];
    }
    public static void main(String [] args){
        int [] arr = {3,4,1,5,10,2};
        System.out.println(findMinimumSubsetSumDifference(arr,6));
    }
}