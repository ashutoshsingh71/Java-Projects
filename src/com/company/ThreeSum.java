package com.company;

import java.util.ArrayList;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<Integer> lInitial = new ArrayList<Integer>();
        List<List<Integer>> lFinal = new ArrayList(lInitial);
        List<Integer> ans1 = new ArrayList();
        for(int i = 0; i< nums.length;i++){
            int num1 = nums[i];
            int num2 = 0 - num1;
            ans1 = find2sum(nums,i+1,num2);
            if(!ans1.isEmpty()){
                ans1.add(num1);
                lFinal.add(lInitial);
            }
        }
        return lFinal;
    }

    public static List<Integer> find2sum(int[] nums,int index,int sum){
        if(index == nums.length-1){
            return new ArrayList();
        }
        if(nums[index] + nums[index+1] == sum){
            List<Integer> ans =  new ArrayList<Integer>();
            ans.add(nums[index]);
            ans.add(nums[index+1]);
            return ans;
        }
        return find2sum(nums,index+1,sum-nums[index]);
    }

    public static void main(String [] args){
       int [] nums = {-1,0,1,2,-1,-4};
       System.out.print(threeSum(nums));
    }
}
