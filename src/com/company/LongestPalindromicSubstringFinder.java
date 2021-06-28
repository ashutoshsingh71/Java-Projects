package com.company;

public class LongestPalindromicSubstringFinder {
    public static String findLongestPalindromicSubstring(String str,int length){
        String maxString ="", currentString;
        int maxLength = 0,currentLength;
        for(int i =0; i< length;i++){
            currentString = expand(str,i,i);
            currentLength = currentString.length();
            if(currentLength > maxLength){
                maxLength = currentLength;
                maxString = currentString;
            }
            currentString = expand(str,i,i+1);
            currentLength = currentString.length();
            if(currentLength > maxLength){
                maxLength = currentLength;
                maxString = currentString;
            }
        }
        return maxString;
    }

    public static String expand(String str,int begin,int end){
        while(begin >= 0 && end <= str.length()-1 && str.charAt(begin) == str.charAt(end)){
            begin--;
            end++;
        }
        return str.substring(begin+1,end);
    }

    public static void main(String [] args){
        String str= "ABDCBCDBDCBBC";
        System.out.println("Longest palindromic substring is: " + findLongestPalindromicSubstring(str,str.length()));
    }
}
