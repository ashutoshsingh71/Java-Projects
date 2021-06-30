package com.company;

import javax.swing.plaf.PanelUI;

//GAS = [1,2,3,4,5]
//Cost = [3,4,5,1,2]
// Gas-cost = [-2,-2,-2,3,3]
//gas left till last station => [0,2,4,6,3]
//idea is we should have gas left till last station should be greater than or equal to zero
public class GasStationProblem {
    public static int returnMinIndex(int [] A,int []B){
        int length = A.length;
        int startIndex = 0;
        int left = 0;
        int maxLeft = 0;
        int gasLeft = 0;
        for(int i = length-1;i>=0;i--){
            left += A[i] - B[i];
            if(left > maxLeft){
                maxLeft = left;
                startIndex = i;
            }
        }
        return left < 0 ? -1 : startIndex;
    }

    public static void main(String [] args){
        int [] gas = {1,2,3,4,5};
        int [] cost = {3,4,5,1,2};
        System.out.println(returnMinIndex(gas,cost));
    }
}
