package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class MyThread extends Thread
{
    MyThread() {}
    MyThread(Runnable r) {super(r); }
    public void run()
    {
        System.out.print("Inside Thread ");
    }
}
class RunnableDemo implements Runnable
{
    public void run()
    {
        System.out.print(" Inside Runnable");
    }
}
class ThreadDemo
{
    static List<Integer> findTraingle(List<Integer> sticks){
        Collections.sort(sticks);
        List<Integer> traingles = new ArrayList();
        int maxPerimeter = Integer.MIN_VALUE;
        for(int i = 0;i<sticks.size()-2;i++){
            if(sticks.get(i) + sticks.get(i+1) > sticks.get(i+2)){
                int perimeter = sticks.get(i) + sticks.get(i+1) + sticks.get(i+2);
                if(perimeter >= maxPerimeter){
                    maxPerimeter = perimeter;
                    if(traingles.size() == 0){
                        traingles.add(sticks.get(i));
                        traingles.add(sticks.get(i+1));
                        traingles.add(sticks.get(i+2));
                    }else{
                        int greaterSide = traingles.get(traingles.size()-1);
                        System.out.println(greaterSide);
                        if(greaterSide >= sticks.get(i+2)){
                            continue;
                        }else{
                            traingles.clear();
                            traingles.add(sticks.get(i));
                            traingles.add(sticks.get(i+1));
                            traingles.add(sticks.get(i+2));
                        }
                        System.out.println(sticks.get(i) +"," + sticks.get(i+1) +"," + sticks.get(i+2));
                    }
                }
            }
        }
        if(traingles.size() == 0){
            traingles.add(-1);
        }
        return traingles;
    }

    public static long candies(int n, List<Integer> arr) {
        // Write your code here
        int candyToGive = 1;
        long candiesSoFor = candyToGive;
        System.out.println(candyToGive);
        for(int i = 1; i<=n-1;i++){
            if(arr.get(i) > arr.get(i-1)){
                candyToGive += 1;
            }else
                if(arr.get(i) > arr.get(i+1) && arr.get(i+1) == 1){
                    candyToGive -= 1;
                }else
                    candyToGive = 1;
            System.out.println(candyToGive);
            candiesSoFor += candyToGive;
        }
        return candiesSoFor;
    }

    public static boolean findWithBinarySearch(int [] arr,int low,int high,int key){
        if(high >= low){
            int mid = (low+high)/2;
            if(arr[mid] == key){
                return true;
            }
            if(key > arr[mid]){
                return findWithBinarySearch(arr,mid+1,high,key);
            }else{
                return findWithBinarySearch(arr,low,mid-1,key);
            }
        }else
            return false;
    }
    public static void main(String[] args)
    {
        /*List<Integer> sticks = new ArrayList<>();
        sticks.add(1);
        sticks.add(1);
        sticks.add(1);
        sticks.add(3);
        sticks.add(3);
        List<Integer> ans = findTraingle(sticks);
        for(int i : ans){
            System.out.println(i);
        }*/
        /*Integer [] ar = {1,2,2};
        List<Integer> arr = Arrays.asList(ar);
        System.out.println(candies(3,arr));*/
        int [] a = {1,3,6,4,1,2};
        Arrays.sort(a);
        int i = 1;
        int highest = a[a.length - 1];
        while(i <= highest) {
            System.out.println(findWithBinarySearch(a, 0, a.length - 1, i));
            i++;
        }
    }
}

