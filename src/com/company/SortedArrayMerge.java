package com.company;

public class SortedArrayMerge {
    public static int[] mergeSortedArray(int [] arr1,int [] arr2,int [] merged,int i,int j, int k){
        if(i >= arr1.length){
            while(j < arr2.length){
                merged[k] = arr2[j];
                j++;
                k++;
            }
        }
        if(j >= arr2.length){
            while(i < arr1.length){
                merged[k] = arr1[i];
                i++;
                k++;
            }
        }
        if(k >= merged.length){
            return merged;
        }
        if(arr1[i] < arr2[j]){
            merged[k] = arr1[i];
            k++;
            i++;
        }else{
            merged[k] = arr2[j];
            k++;
            j++;
        }
        return mergeSortedArray(arr1,arr2,merged,i,j,k);
    }

    public static double findMedian(int [] arr){
        double res = 0.00;
        if(arr.length == 0){
            return 0;
        }
        if(arr.length == 1){
            return arr[0];
        }
        int mid = arr.length / 2;
        if(arr.length % 2 == 0){
            res =  ((double)arr[mid-1] + (double)arr[mid])/2;
        }else{
            res =  (double)arr[mid];
        }
        return res;
    }
    public static void main(String [] args){
        /*int [] arr1 = {1,2,7,9,11};
        int [] arr2 = {3,4,5,8,10};*/

        int [] arr1 = {1,2};
        int [] arr2 = {3,4};
        int [] merged = new int[arr1.length+arr2.length];
        int [] res = mergeSortedArray(arr1,arr2,merged,0,0,0);
        for (int ele:
             res) {
            System.out.print(ele);
        }
        System.out.println();
        System.out.println(findMedian(res));
    }
}
