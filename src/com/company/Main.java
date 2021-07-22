package com.company;

import TrieImplementation.Trie;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {
        /*int[][] matrix = {
                { 0, 1, 0 },
                { 1, 0, 0 },
                { 0, 1, 0 }
        };*/
        //int [] arr = {0,1,0,1,0,0,0,1,0};
        /*int rotation = 2;
        ArrayRotation ar = new ArrayRotation();
        System.out.println("Array before rotation is: " );
        ar.printArray(arr,arr.length);
        System.out.println();
        ar.rotationThroughGCD(arr,rotation,arr.length);
        //ar.arrayRotationThroughReversal(arr,rotation,arr.length);
        System.out.println("Array after " + rotation + " is:");
        ar.printArray(arr,arr.length);*/
        /*ArrayRotation ar = new ArrayRotation();
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        System.out.println("Greatest common divisor of given numbers is: " + ar.gcd(a,b));*/
        //FindPairSumInArray findPairSumInArray = new FindPairSumInArray();
        //findPairSumInArray.findPairsInSortedArray(arr,11,7);
        //findPairSumInArray.findPairsInSortedAndRotatedArray(arr,7,11);
        //System.out.println(new ArrayRotation().findRotationWithBinarySearch(arr,0,4));
        //ArrayRotation ar= new ArrayRotation();
        //ar.rearrangeArrayInOrder(arr,7);
        /*FindPathInMatrix fmp= new FindPathInMatrix();
        fmp.print2DMatrix(matrix,3,3);
        HashMap<String,String> k = new HashMap<>();
        System.out.println(fmp.findPathIn2DMatrix(0,0,2,2,matrix,k));*/


        //Trie implementation code
        /*Trie t = new Trie();
        t.insert("raju");
        t.insert("raj");
        t.insert("ramesh");
        t.insert("akash");
        System.out.println(t.validPrefix("ram"));*/

        /*Map<String,List<Integer>> map = new HashMap<>();
        String line = "reg 1 B V";
       int n = Integer.parseInt(line.replaceAll("[^0-9]", ""));
       map.put("Ab",new ArrayList<Integer>().add(n));*/

        /*Map<String,String> map = new HashMap<>();
        map.put("Chennai", "Idly");
        map.put("Mumbai","vadapav");
        map.put("kolkata","rasgulla");

        for(String city : map.keySet()){
            System.out.println(map.get(city));
            map.put("Hyderabad","Biryani");
        }*/
        /*long [] a1 = {3,4,5};
        long [] a3 = badStuff(a1);
        for(long i : a3){
            System.out.println(i);
        }*/
        Scanner scn = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        System.out.println("Enter the number of contacts to be stored: ");
        int num = scn.nextInt();
        int i = 1;
        while(i <= num){
            System.out.println("Enter name: ");
            String name = scn.next();
            list.add(name);
            i++;
        }

        /*list.add("Ajay");
        list.add("Ajenta");
        list.add("Ajor");
        list.add("Akash");
        list.add("Akshay");*/
        Trie trie = new Trie(list);
        System.out.println("Enter String to be searched: ");
        String target = scn.next();
        //String str = "Aka";
        List<String> stringList = trie.getAllStringWithGivenPrefix(target);
        for (String s:
                stringList) {
            System.out.println(s);
        }
    }
    public static long[] badStuff(long [] a2){
        a2[1] = 7;
        return a2;
    }
}


