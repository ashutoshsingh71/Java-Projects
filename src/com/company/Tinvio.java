package com.company;

import java.util.Arrays;

public class Tinvio {

    //quadratic approach i.e. O(n*n)
    static String findUniqueLengthSubString(String string){
        int i = 0;
        int j = i+1;
        while(j < string.length()-1){
            if(j >= i && !presentInWindow(i,j,string,string.charAt(j+1))){
                j++;
            }else{
                i++;
                j=i+1;
            }
        }
        return string.substring(i,j+1);
    }
    static boolean presentInWindow(int i,int j,String str,char c){
       while(i <= j){
           if(str.charAt(i) != c){
               i++;
           }else{
               return true;
           }
       }
       return false;
    }
    public static String findMinimumLengthSubstringWithAllCharacters(String str){
        int n = str.length();
        if(n == 1){
            return str;
        }
        boolean [] visited = new boolean [256];
        Arrays.fill(visited,false);
        int uniqueCount = 0;
        for(int i = 0;i<n;i++){
            if(visited[str.charAt(i)] == false){
                visited[str.charAt(i)] = true;
                uniqueCount++;
            }
        }
        System.out.println("No of unique characters are: " + uniqueCount);
        int count = 0;
        int start = 0;
        int startIndex = -1;
        int len = Integer.MAX_VALUE;
        int [] countChar = new int [256];
        for(int i =0;i<n;i++) {
            countChar[str.charAt(i)]++;
            if (countChar[str.charAt(i)] == 1) {
                count++;
            }
            if (count == uniqueCount) {
                while (countChar[str.charAt(start)] > 1) {
                    if (countChar[str.charAt(start)] > 1) {
                        countChar[str.charAt(start)]--;
                    }
                    start++;
                }
                int window = i - start + 1;
                if (len > window) {
                    len = window;
                    startIndex = start;
                }
            }
        }
        return str.substring(startIndex,startIndex+len);
    }
    public  static void main(String [] args){
        //String str = "jiujithsu";
        String str = "usbstring";
        //String str = "aaab";
        //System.out.println(findUniqueLengthSubString(str));
        System.out.println(findMinimumLengthSubstringWithAllCharacters(str));
    }
}