package com.company;


import java.io.*;
import java.util.*;


public class Nucash {}

    /*public static void main(String [] args){
        String string = "((3*((4-5)/23)-15%)";
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i< string.length();i++){
            if()

        }*/


       /* String str = "23:60:30";
        if(isvalidFormat(str)){
            List<Integer> datList = extractData(str);
            if(isValidData(datList)){
                System.out.println("Valid date");
            }else
                System.out.println("Not a Valid date");
        }else
            System.out.println("Not a Valid date");*/
    //}

    /*public static boolean isValidData(List<Integer> dataList){
        boolean result = true;
        for(int i = 0; i< dataList.size();i++){
            if(i == 0){
                if(!(dataList.get(i) >= 0 && dataList.get(i) <= 23)){
                    return false;
                }
            }else{
                if(!(dataList.get(i) >= 0 && dataList.get(i) <= 59))
                    return false;
            }
        }
        return result;
    }

    public static List<Integer> extractData(String str){
        String [] strArray = str.split(":");
        List<Integer> list = new ArrayList<>();
        for (String s:
             strArray) {
            list.add(Integer.valueOf(s));
        }
        return list;
    }
    public static boolean isvalidFormat(String str){
        return true;
    }*/

