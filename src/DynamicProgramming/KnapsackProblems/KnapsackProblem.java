package DynamicProgramming.KnapsackProblems;

//there are 2 arrays given.One is weight array wt[] and another is value array v[]. We need to find the maximum profit we can
//choose for a given capacity of a knapsack W.

import java.util.HashMap;
import java.util.Map;

public class KnapsackProblem {

    static int [][] dp;
    static int[][] createAndInitializeDP(int row,int col){
         dp = new int[row+1][col+1];
        for(int i =0;i<row+1;i++){
            for(int j = 0;j<col+1;j++){
                dp[i][j] = -1;
            }
        }
        return dp;
    }

    static int findMaxProfit(int [] wt,int [] val,int n,int W){
        if(n==0 || W == 0){
            return 0;
        }
        if(wt[n-1] <= W){
            return Math.max(val[n-1] + findMaxProfit(wt,val,n-1,W-wt[n-1]),findMaxProfit(wt,val,n-1,W));
        }else
            return findMaxProfit(wt,val,n-1,W);
    }

    static int findMaxProfitThroughMemoization(int [] wt, int [] val, int n, int W,int [][] dp){
        if(n==0 || W == 0){
            return 0;
        }
        if(dp[n][W] != -1){
            return dp[n][W];
        }
        if(wt[n-1] <= W){
            dp[n][W] =  Math.max(val[n-1] + findMaxProfitThroughMemoization(wt,val,n-1,W-wt[n-1],dp),findMaxProfitThroughMemoization(wt,val,n-1,W,dp));
        }else
            dp[n][W] = findMaxProfitThroughMemoization(wt,val,n-1,W,dp);
        return dp[n][W];
    }

    public static void main(String [] args){
        int [] wt = {2,3,5};
        int [] val = {2,3,5};
        int W = 4;
        int [][] dp =createAndInitializeDP(wt.length,W);
        System.out.println(findMaxProfitThroughMemoization(wt,val,wt.length,W,dp));
    }
}
