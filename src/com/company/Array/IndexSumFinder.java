package com.company.Array;

public class IndexSumFinder {

    public static boolean indexWithValuesSum(int [] arr,int size,int start,int next,int end){
        if(next > end || next > size){
            return false;
        }
        if(arr[start] + arr[next] == start + next){
            System.out.println(start + "  " + next);
            return true;
        }//else
            return indexWithValuesSum(arr,size,start,next+1,end);
    }
    public static void main(String [] args){
        int [] arr = {1,2,1,9,3,5,0,7};
        int size = arr.length;
        for(int i = 0; i<arr.length;i++){
            int j = i+1;
            System.out.println(indexWithValuesSum(arr,size,i,j,size-1));
        }
    }
}
