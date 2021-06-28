package com.company;

public class FindPairSumInArray {
    public void findPairsInSortedArray(int[] arr, int sum,int size){
        sortArray(arr,size);
        int l_pointer = 0;
        int r_pointer = size-1;
        while(l_pointer <= r_pointer){
            if(arr[l_pointer]+arr[r_pointer] == sum){
                System.out.println("Found pair: ("+ arr[l_pointer]+"," + arr[r_pointer]+")");
            }
            if(arr[l_pointer]+arr[r_pointer] > sum){
                r_pointer--;
            }else {
                l_pointer++;
            }
        }
    }

    public void findPairsInSortedAndRotatedArray(int[] arr,int size,int sum){
        int i;
        for(i = 0;i<size;i++){
            if(arr[i] > arr[i+1])
                break;
        }
        int l = (i+1)%size;
        int r = i;
        while(l!=r){
            if(arr[l]+arr[r] == sum){
                System.out.println("Found pair: (" + arr[l] +"," + arr[r] + ")");
            }
            if(arr[l]+arr[r] < sum){
                l = (l+1)%size;
            }else
                r = (size+r-1)%size;
        }
    }
    public void sortArray(int [] arr,int size){

    }
}
