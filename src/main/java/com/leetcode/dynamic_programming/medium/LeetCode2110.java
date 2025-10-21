package com.leetcode.dynamic_programming.medium;

public class LeetCode2110 {
    public long getDescentPeriods(int[] prices) {
        long prev = 1, curr, res = 1, n = prices.length;
        for(int i = 1; i < n; ++i) {
            if(prices[i-1] - prices[i] == 1) {
                curr = 1 + prev;
            } else {
                curr = 1;
            }
            res += curr;
            prev = curr;
        }
        return res;
    }
}
