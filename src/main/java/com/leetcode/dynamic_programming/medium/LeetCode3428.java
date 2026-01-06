package com.leetcode.dynamic_programming.medium;

import java.util.Arrays;

public class LeetCode3428 {
    public int minMaxSums(int[] nums, int k) {
        int n = nums.length;
        long MOD = (long) 1e9 + 7;
        long[][] dp = new long[n][n+1];
        dp[0][0] = 1;
        for(int i = 1; i < n; ++i) {
            dp[i][0] = 1;
            for(int j = 1; j <= n; ++j) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % MOD;
            }
        }
        Arrays.sort(nums);
        long res = 0;
        for(int i = 0; i < n; ++i) {
            long M = 0, m = 0, g = nums[i];
            for(int j = 0; j < Math.min(i+1, k); ++j) {
                M = (M + g * dp[i][j]) % MOD;
            }
            for(int j = 0; j < Math.min(n-i, k); ++j) {
                m = (m + g * dp[n-1-i][j]) % MOD;
            }
            res = (res + M + m) % MOD;
        }
        return (int) res;
    }
}
