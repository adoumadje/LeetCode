package com.leetcode.dynamic_programming.medium.leetcode2310;

public class LeetCode2310Knapsack {
    public int minimumNumbers(int num, int k) {
        if(num == 0) return 0;
        int[] dp = new int[num+1];
        for(int s = 1; s <= num; ++s) {
            dp[s] = Integer.MAX_VALUE;
            for(int x = k; x <= s; x += 10) {
                if(dp[s-x] < Integer.MAX_VALUE) {
                    dp[s] = Math.min(dp[s], 1 + dp[s-x]);
                }
            }
        }
        return dp[num] == Integer.MAX_VALUE ? -1 : dp[num];
    }
}
