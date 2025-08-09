package com.leetcode.dynamic_programming.medium;

public class LeetCode1043 {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n+1];
        for(int i = 0; i < n; ++i) {
            int max = Integer.MIN_VALUE;
            for(int j = i; j >= 0 && j > i - k; --j) {
                max = Math.max(max, arr[j]);
                dp[i+1] = Math.max(dp[i+1], dp[j] + (i-j+1) * max);
            }
        }
        return dp[n];
    }
}
