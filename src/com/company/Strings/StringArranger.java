package com.company.Strings;

//we have a string with letter s = [a-zA-Z0-9] . we need to arrange this like lower alphabets appears lexographically
// before uppercase letters followed by digits
// I/p - "dacTUfAB8715"
// O/P - "acdfABTU8157"

import java.util.*;

public class StringArranger {
    public static String arrangeString(final String str){
        StringBuilder lower = new StringBuilder();
        StringBuilder upper = new StringBuilder();
        StringBuilder evendigit = new StringBuilder();
        StringBuilder odddigit = new StringBuilder();

        for(int i = 0; i< str.length();i++){
            if(str.charAt(i) >= 97 && str.charAt(i) <= 122){
                lower.append(str.charAt(i));
            }
            if(str.charAt(i) >= 65 && str.charAt(i) <= 90){
                upper.append(str.charAt(i));
            }
            if(Character.isDigit(str.charAt(i))){
                if(Integer.valueOf(String.valueOf(str.charAt(i))) % 2 == 0)
                    evendigit.append(str.charAt(i));
                else
                    odddigit.append(str.charAt(i));
            }
        }
        char [] arrLower = lower.toString().toCharArray();
        Arrays.sort(arrLower);
        char [] arrUpper = upper.toString().toCharArray();
        Arrays.sort(arrUpper);
        Arrays.sort(evendigit.toString().toCharArray());
        Arrays.sort(odddigit.toString().toCharArray());

        return new String(arrLower) + new String(arrUpper) + evendigit + odddigit;
    }

    public static String stringArrangement(final String str){
        Map<Integer,Character> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< str.length();i++){
            if(str.charAt(i) >= 97 && str.charAt(i) <= 122){
                //lower.append(str.charAt(i));
                map.put(Integer.valueOf(str.charAt(i)),str.charAt(i));
            }
            if(str.charAt(i) >= 65 && str.charAt(i) <= 90){
                map.put(Integer.valueOf(str.charAt(i))+122,str.charAt(i));
            }
            if(Character.isDigit(str.charAt(i))){
                if(Integer.valueOf(String.valueOf(str.charAt(i))) % 2 == 0)
                    map.put(Integer.valueOf(str.charAt(i))+150,str.charAt(i));
                else
                    map.put(Integer.valueOf(str.charAt(i))+161,str.charAt(i));
            }
        }
        //Object [] arr = map.keySet().toArray();
        ArrayList<Integer> sortedKeys
                = new ArrayList<Integer>(map.keySet());
        Collections.sort(sortedKeys);
        for(Integer i : sortedKeys){
            sb.append(map.get(i));
        }
        return sb.toString();
    }
    public static void main(String [] args){
        String str = "dacTUfAB8715";
        System.out.println(arrangeString(str));
        System.out.println(stringArrangement(str));
    }
}
