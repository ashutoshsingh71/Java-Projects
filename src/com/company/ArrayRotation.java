package com.company;

public class ArrayRotation {

    //rotating array from left one by one
    public void rotateArrayFromLeft(int [] arr,int rotation,int size){
        for(int i =1;i<= rotation;i++){
            leftRotateByOne(arr,size);
        }
    }

    public void leftRotateByOne(int [] arr,int size){
        int temp = arr[0];
        for(int i= 1;i<size;i++){
            arr[i-1] = arr[i];
        }
        arr[size-1] = temp;
    }
    public void printArray(int [] arr, int size){
        for (int i: arr) {
            System.out.print(i + " ");
        }
    }

    public void rotationThroughGCD(int[] arr,int rotation,int size){
        /* To handle if d >= n */
        rotation = rotation % size;
        int i, j, k, temp;
        int g_c_d = gcd(rotation, size);
        for (i = 0; i < g_c_d; i++) {
            /* move i-th values of blocks */
            temp = arr[i];
            j = i;
            while (true) {
                k = j + rotation;
                if (k >= size)
                    k = k - size;
                if (k == i)
                    break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }

    public void arrayRotationThroughReversal(int [] arr, int rotation, int size){
        if(rotation == 0){
            return;
        }
        rotation = rotation % size;
        reverseArray(arr,0,rotation -1);
        reverseArray(arr,rotation,size-1);
        reverseArray(arr,0,size-1);
    }

    public void reverseArray(int [] arr,int start,int end){
        int temp;
        while(start < end){
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    //Time complexity will be O(n)
    public void findRotationWithLinearSearch(int[] arr,int size){
        //find pivot element which is smallest number in sorted array
        int i;
        int pivot = 0;
        for(i=0;i<size;i++){
            if(arr[i+1] < arr[i]) {
                pivot = (i+1);
                break;
            }
        }
        //this i will decide how many elements are there before this position
        if(pivot == 0){
            System.out.print("No rotation found");
        }else
            System.out.println(pivot + " rotation found");
    }
    public void rearrangeArrayInOrder(int [] arr,int size){
        System.out.println("Array before rearranging...");
        printArray(arr,size);
        System.out.println("");
        int i,j;
        int [] tempArray = new int[size];
        int arrayIndex = 0;
        System.out.println("Sorting array now...");
        quickSortArray(arr,0,size);
        System.out.println("Array after sorting..");
        printArray(arr,size);
        System.out.println("");
        System.out.println("Starting array arrangment....");
        for (i=0,j=size-1;i<=size/2 || j> size/2;i++,j--){
            if(arrayIndex < size){
                tempArray[arrayIndex] = arr[i];
                arrayIndex++;
            }
            if(arrayIndex < size){
                tempArray[arrayIndex] = arr[j];
                arrayIndex++;
            }
        }
        System.out.println("Array after rearrangement....");
        printArray(tempArray,size);
        System.out.println("");
    }

    public void quickSortArray(int [] arr,int low,int high){
        if(low<high){
            int pi = partition(arr,low,high);
            quickSortArray(arr,low,pi-1);
            quickSortArray(arr,pi+1,high);
        }
    }

    public int partition(int [] arr,int low,int high){
        int pivot = arr[high];
        int i = low-1;
        int temp;
        for(int j = low;j<high;j++){
            if(arr[j] < pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,high);
        return i+1;
    }

    public void swap(int []arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int findRotationWithBinarySearch(int [] arr,int low,int high){
        if(high<low)
            return 0;
        if(low==high)
            return low;
        //find mid
        int mid = low + (high-low)/2;
        if(mid < high && arr[mid+1] < arr[mid])
            return mid+1;
        if(mid > low && arr[mid] < arr[mid - 1])
            return mid;
        if(arr[high] > arr[mid])
            return findRotationWithBinarySearch(arr,low,mid-1);
        else
            return findRotationWithBinarySearch(arr,mid+1,high);
    }
    /*Fuction to get gcd of a and b*/
    public int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    public int findSmallestMissingNumber(int [] arr,int start,int end){
        if(arr[0] != 0)
            return 0;
        if(arr[arr.length -1] == arr.length-1)
            return arr.length;
        return 0;
    }
}
