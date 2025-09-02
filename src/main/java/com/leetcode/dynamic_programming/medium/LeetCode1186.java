package com.leetcode.dynamic_programming.medium;

public class LeetCode1186 {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[2][n+2];
        int res = Integer.MIN_VALUE;
        for(int i = 2; i < n+2; ++i) {
            dp[0][i] = Math.max(arr[i-2], arr[i-2] + dp[0][i-1]);
            dp[1][i] = Math.max(arr[i-2], Math.max(arr[i-2] + dp[1][i-1], arr[i-2] + dp[0][i-2]));
            res = Math.max(res, Math.max(dp[0][i], dp[1][i]));
        }
        return res;
    }
}
