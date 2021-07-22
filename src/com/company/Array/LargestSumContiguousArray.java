package com.company.Array;

public class LargestSumContiguousArray {
    public static void largestSum(int [] arr,int length) {
        int max_ending_here;
        int max_so_far = Integer.MIN_VALUE;
        max_ending_here = 0;
        int start;
        int end;
        int s;
        start = end= s = 0;
        for(int i = 0; i< length;i++){
            max_ending_here += arr[i];
            if(max_so_far < max_ending_here){
                max_so_far = max_ending_here;
                start = s;
                end = i;
            }
            if(max_ending_here < 0){
                max_ending_here = 0;
                s = i+1;
            }
        }
        System.out.println("Maximum sum is: " + max_so_far);
        for(int i = start;i<=end;i++){
            System.out.print(arr[i] +" ");
        }
    }

    public static void main(String [] args){
        int [] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
        largestSum(arr,arr.length);
    }
}
