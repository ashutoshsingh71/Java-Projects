package DynamicProgramming.KnapsackProblems;

public class KnapsackTopDownApproach {

    public static int findMaxProfit(int [] wt,int [] val,int n,int W){
        int [][] profitMatrix = new int[n+1][W+1];
        //initialization
        for(int i = 0;i<n+1;i++){
            for(int j = 0; j<W+1;j++){
                if(i == 0 || j == 0){
                    profitMatrix[i][j] = 0;
                }
            }
        }
        for(int i = 1;i<n+1;i++){
            for(int j = 1;j<W+1;j++){
                if(wt[i-1] <= j){
                    profitMatrix[i][j] = Math.max(val[i-1] + profitMatrix[i-1][j-wt[i-1]],profitMatrix[i-1][j]);
                }else
                    profitMatrix[i][j] = profitMatrix[i-1][j];
            }
        }
        printMatrix(profitMatrix,n+1,W+1);
        return profitMatrix[n][W];
    }

    public static void printMatrix(int [][] mat,int row,int col){
        for(int i = 0; i< row;i++){
            for(int j = 0;j<col;j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String [] args){
        int [] wt = {4,3,2};
        int [] val = {8,3,7};
        int W = 6;
        System.out.println(findMaxProfit(wt,val,wt.length,W));
    }
}
