package DynamicProgramming.KnapsackProblems.UnboundedKnapSackProblems;

//We will have a rod of length L unit. We need to identify the total number of ways to get the maximum profit by cutting the rod, in two ways below
// 1. For given length as an array []
//2 . For assuming the length of cut on your own

public class RodCuttingProblem {
    public static int findRodCuttingProfit(int [] len,int [] val,int l){
        int row = len.length + 1;
        int col = l + 1;
        int [][] dp = new int[row][col];
        //initialization of row and column
        for(int i= 0; i< row; i++){
            for(int j = 0; j< col;j++){
                if(i == 0){
                    dp[i][j] = 0;
                }
                if(j == 0){
                    dp[i][j] = 0;
                }
            }
        }
        //implementation
        for(int i = 1; i< row;i++){
            for(int j = 1; j< col;j++){
                if(len[i-1] < l){
                    dp [i][j] = Math.max(val[i-1] + dp[i][j-len[i-1]],dp[i-1][j]);
                }else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[len.length][l];
    }
    public static void main(String [] args){
        int [] len = {1,2,3,4,5,6,7,8};
        int [] val = {1,5,8,9,10,17,17,20};
        int l = 8;
        System.out.println(findRodCuttingProfit(len,val,l));
    }
}
