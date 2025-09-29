package com.leetcode.dynamic_programming.medium;

public class LeetCode1641 {
    public int countVowelStrings(int n) {
        int[] dp = new int[n+1];
        dp[1] = 5;
        for(int i = 2; i <= n; ++i) {
            dp[i] = 15 + (dp[i-1] - 5);
        }
        return dp[n];
    }
}
