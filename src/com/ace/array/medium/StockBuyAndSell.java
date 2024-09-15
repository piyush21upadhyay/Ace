package com.ace.array.medium;
/*
Problem Statement: You are given an array of prices where prices[i] is the price of a given
stock on an ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a
different day in the future to sell that stock. Return the maximum profit you can achieve from
this transaction. If you cannot achieve any profit, return 0.

Example 1:
Input:
 prices = [7,1,5,3,6,4]
Output:
 5
Explanation:
 Buy on day 2 (price = 1) and
sell on day 5 (price = 6), profit = 6-1 = 5.

Note
: That buying on day 2 and selling on day 1
is not allowed because you must buy before
you sell.

Example 2:
Input:
 prices = [7,6,4,3,1]
Output:
 0
Explanation:
 In this case, no transactions are
done and the max profit = 0.
*
**/
public class StockBuyAndSell {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfitBruteForce(prices));
        System.out.println(maxProfitBetterApproach(prices));

        int[] prices1 = {7, 6, 4, 3, 1};
        System.out.println(maxProfitBruteForce(prices1));
    }

    private static int maxProfitBetterApproach(int[] prices) {
        int profit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            profit = Math.max(profit, prices[i] - minPrice);
        }
        return profit;
    }

    private static int maxProfitBruteForce(int[] prices) {
        int profit = 0;
        for(int i=0; i< prices.length; i++){
            for(int j=i+1; j< prices.length; j++){
                if(prices[j] > prices[i]){
                    int diff = prices[j] - prices[i];
                    if(diff>profit){
                        profit = diff;

                    }
                }
            }
        }
        return profit;
    }
}
