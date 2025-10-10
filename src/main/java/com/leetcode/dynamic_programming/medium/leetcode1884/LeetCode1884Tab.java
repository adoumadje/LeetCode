package com.leetcode.dynamic_programming.medium.leetcode1884;

public class LeetCode1884Tab {
    int[] dp = new int[1001];

    public int twoEggDrop(int n) {
        if(dp[n] == 0) {
            dp[n] = n;
            for(int i = 1; i <= n; ++i) {
                dp[n] = Math.min(dp[n], 1 + Math.max(i-1, twoEggDrop(n-i)));
            }
        }
        return dp[n];
    }
}
