package com.company;


import jdk.internal.util.xml.impl.Pair;

import java.util.*;

public class MiniumSwapFinder {
    static int findMinimumSwapRequired(int [] arr,int length){
        int answer = 0;
        //ArrayList<Map<Integer,Integer>> arrPos = new ArrayList<>();
        ArrayList<ArrayList<Integer>> arrPos = new ArrayList<>();
        for(int i =0; i< length;i++){
            //Map<Integer,Integer> hashMap = new HashMap<>();
            //hashMap.put(arr[i],i);
            ArrayList<Integer> array = new ArrayList<>();
            array.add(arr[i]);
            array.add(i);
            arrPos.add(array);
        }
        arrPos.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(o1.get(0) > o2.get(0)){
                    return 1;
                }
                else if(o1.get(0) < o2.get(0)){
                    return -1;
                }else{
                    return 0;
                }
            }
        });

        boolean [] visited = new boolean[length];
        Arrays.fill(visited,false);
        for(int i = 0;i<length;i++){
            int cycleSize = 0;
            int j = i;
            if(visited[i] || arrPos.get(i).get(1) == i)
                continue;
            while(!visited[j]){
                visited[j] = true;
                j = arrPos.get(j).get(1);
                cycleSize++;
            }
            if(cycleSize > 0){
                answer += cycleSize -1;
            }
        }
        printArray(arrPos);
        return answer;
    }

    static void printArray(ArrayList arr){
        Iterator itr = arr.iterator();
        while (itr.hasNext()){
            //HashMap<Integer,Integer> map = ((HashMap<Integer,Integer>) itr.next());
            System.out.println(itr.next());
        }
    }
    public static void main(String [] args){
        int [] arr = {1,5,4,3,2};
        int length = arr.length;
        System.out.println(findMinimumSwapRequired(arr,length));
    }
}
