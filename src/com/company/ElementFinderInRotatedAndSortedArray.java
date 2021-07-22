package com.company;

public class ElementFinderInRotatedAndSortedArray {
    public static int findElement(int [] array, int target){
       int pivotIndex = findPivot(array,0,array.length-1);
       if(pivotIndex == -1){
           return binarySearch(array,0,array.length-1,target);
       }
       if(array[pivotIndex] == target){
           return pivotIndex;
       }
       if(array[0] <= target){
           return binarySearch(array,0,pivotIndex-1,target);
       }else
           return binarySearch(array,pivotIndex+1,array.length-1,target);
        //return pivotIndex;
    }
    public static int binarySearch(int [] array,int low,int high,int key){
        if(high < low){
            return -1;
        }
        int mid = (low+high)/2;
        if(array[mid] == key){
            return mid;
        }
        if(key > array[mid]){
            return binarySearch(array,mid+1,high,key);
        }else
            return binarySearch(array,low,mid-1,key);
    }
    public static int findPivot(int [] array,int low,int high){
        if(high < low){
            return -1;
        }
        if(low == high){
            return low;
        }
        int mid = (low + high)/2;
        if(mid < high && array[mid] > array[mid+1]){
            return mid;
        }
        if(mid > low && array[mid] < array[mid-1]){
            return mid-1;
        }
        if(array[low] >= array[mid]){
            return findPivot(array,low,mid-1);
        }
        return findPivot(array,mid+1,high);
    }
    public static void main(String [] args){
        /*int [] arr = {5,6,7,8,9,10,1,2,3,4};
        int target = 3;
        System.out.println(findElement(arr,target));*/
        try
        {
            System.out.println("Hello world ");
            throwit();
            System.out.println("try block ");
        }
        finally
        {
            System.out.println("Finally");
        }
    }
    public static void throwit(){
        throw new RuntimeException();
    }
}
