package com.company;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class ZigZagString {
    public static String printZigZag(String str,int rows){
        char [] c = str.toCharArray();
        StringBuilder [] sbs = new StringBuilder[rows];
        int i = 0;
        int length = c.length;
        for(int k = 0; k<rows;k++){
            sbs[k] = new StringBuilder();
        }
        while(i < length){
            for(int idx = 0;idx < rows && i<length;idx++){
                sbs[idx].append(c[i++]);
            }
            for(int idx = rows-2;idx>=1 && i < length;idx--){
                sbs[idx].append(c[i++]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder s:
             sbs) {
            sb.append(s);
        }
        return sb.toString();
    }
    public static void main(String [] args){
        String s = "PAYPALISHIRING";
        //System.out.println(printZigZag(s,4));
        //System.out.print(Math.pow(-2,31));
        int x = 1534236469;
        if(x == 0){
           System.out.print(x);
        }
        int xCopy = x;
        int reverse = 0;
        while(xCopy != 0){
            int digit = xCopy % 10;
            reverse = reverse * 10 + digit;
            if ((reverse - digit) / 10 != reverse)
            { System.out.println(0); }
            xCopy  = xCopy /10;
        }
        if(reverse < Math.pow(-2,31) || reverse > (Math.pow(2,31)-1)){
            System.out.println(0);
        }else
            System.out.println(reverse);
    }
}
