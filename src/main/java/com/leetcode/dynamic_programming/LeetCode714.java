package com.leetcode.dynamic_programming;

public class LeetCode714 {
    int INT_MIN = -50_001;
    public int maxProfit(int[] prices, int fee) {
        int buy = INT_MIN, sell = 0;
        for(int price: prices) {
            buy = Math.max(buy, sell - price);
            sell = Math.max(sell, buy + price - fee);
        }
        return sell;
    }
}
