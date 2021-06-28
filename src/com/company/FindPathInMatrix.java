package com.company;

import java.util.HashMap;

public class FindPathInMatrix {
    public String findPathIn2DMatrix(int n, int m, int row, int col, int[][] arr2d, HashMap<String,String> k){
        if(k == null){
            k = new HashMap<>();
        }
        if(k.get(n + "," + m) != null){
            return k.get(n + "," + m);
        }
        if(n < 0 || m < 0 || n > row || m > col ){
            return "No";
        }
        if(n == row && arr2d[n][m] == 1){
            return "yes";
        }
        if(isAdjacent(n,m,arr2d,row,col)){
            k.put(n+","+m,"yes");
        }
        findPathIn2DMatrix(n+1,m,row,col,arr2d,k);
        findPathIn2DMatrix(n,m-1,row,col,arr2d,k);
        findPathIn2DMatrix(n,m+1,row,col,arr2d,k);
        findPathIn2DMatrix(n-1,m-1,row,col,arr2d,k);
        findPathIn2DMatrix(n+1,m+1,row,col,arr2d,k);
        findPathIn2DMatrix(n+1,m-1,row,col,arr2d,k);
        findPathIn2DMatrix(n-1,m+1,row,col,arr2d,k);
        return "No";
    }

    public boolean isAdjacent(int n,int m,int [][] arr,int row,int col){
        if(n == 0 && m== 0){
            if(arr[n][m+1] == 1 ||
                    arr[n+1][m] == 1 ||
                    arr[n+1][m+1] == 1){
                return true;
            }
        }
        if(n > 0 && m > 0 && n < row && m < col){
            if(arr[n-1][m] == 1 ||
                    arr[n+1][m] == 1 ||
                    arr[n][m-1] == 1 ||
                    arr[n][m+1] == 1 ||
                    arr[n-1][m-1] == 1 ||
                    arr[n+1][m+1] == 1 ||
                    arr[n+1][m-1] == 1 ||
                    arr[n-1][m+1] == 1){
                return true;
            }
        }
        return false;
    }
    public int[][] initialize2DMatrix(int []arr,int row,int col,int size){
        int [][] arr2d = new int[row][col];
        int i =0,j=0,k;
        while(j<row){
            k = 0;
            while(k<col){
                arr2d[j][k] = arr[i];
                k++;
                i++;
            }
            j++;
        }
        return arr2d;
    }

    public void print2DMatrix(int [][] arr2D,int row,int col){
        for (int i = 0; i < arr2D.length; i++) { //this equals to the row in our matrix.
            for (int j = 0; j < arr2D.length; j++) { //this equals to the column in each row.
                System.out.print(arr2D[i][j] + " ");
            }
            System.out.println(); //change line on console as row comes to end in the matrix.
        }
    }
}
