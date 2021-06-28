package DynamicProgramming.KnapsackProblems;

//Given an array ar[] with +ve integers, we need to find if there ia a subset of elements whose sum is equal to given value X
public class SubsetSumProblem {
    static boolean findSubsetSumThroughRecursion(int [] ar,int size,int total){
        if(size == 0 && total == 0){
            return true;
        }
        if(size == 0 && total > 0){
            return false;
        }
        if(ar[size-1] <= total){
            return (findSubsetSumThroughRecursion(ar,size-1,total-ar[size-1]) || findSubsetSumThroughRecursion(ar,size-1,total));
        }else
            return findSubsetSumThroughRecursion(ar,size-1,total);
    }

    static boolean findSubsetSumThroughIterative(int [] ar,int size,int total){
        boolean [][] dp = new boolean [ar.length+1][total+1];
        //initialization of result matrix
        for(int i = 0;i<ar.length+1;i++){
            for(int j= 0; j<total+1;j++){
                if(j == 0){
                    dp[i][j] = true;
                }
                if(i == 0 && j > 0){
                    dp[i][j] = false;
                }
            }
        }
        for(int i = 1;i<ar.length+1;i++){
            for(int j= 1;j<total+1;j++){
                if(ar[i-1] <= j){
                    dp[i][j] = dp[i-1][j-ar[i-1]] || dp[i-1][j];
                }else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[size][total];
    }
    public static void main(String [] args){
        int [] ar = {1,2,3,4,5};
        int total = 15;
        System.out.println(findSubsetSumThroughRecursion(ar,ar.length,total));
        System.out.println(findSubsetSumThroughIterative(ar,ar.length,total));
    }
}
