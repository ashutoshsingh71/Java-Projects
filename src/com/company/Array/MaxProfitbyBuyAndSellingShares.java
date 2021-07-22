package com.company.Array;

public class MaxProfitbyBuyAndSellingShares {
    public static int maxProfit(int [] price,int length){
        int [] profit = new int[length];
        int maxPrice = price[length-1];

        for(int i=length-2;i>=0;i--){
            if(price[i] > maxPrice){
                maxPrice = price[i];
            }
            profit[i] = Math.max(profit[i+1],maxPrice - price[i]);
        }
        // in case at most one transaction in a day then return profit[0];
        //in case of at most 2 transaction we need to traverse the same price arr from left to
        //to right again to check for max profit
        int minPrice = price[0];
        for(int i = 1; i<length;i++){
            if(price[i] < minPrice){
                minPrice = price[i];
            }
            profit[i] = Math.max(profit[i-1],profit[i] + (price[i] - minPrice));
        }
        return profit[length-1];
    }

    public static void main(String [] args){
        int [] price = {10,22,5,75,65,80};
        System.out.println(maxProfit(price,price.length));
    }
}
