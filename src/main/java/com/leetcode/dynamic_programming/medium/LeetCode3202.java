package com.leetcode.dynamic_programming.medium;

public class LeetCode3202 {
    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k];
        int n = nums.length;
        int res = 0;
        for(int i = n-1; i >= 0; --i) {
            int curr = nums[i] % k;
            for(int prev = 0; prev < k; ++prev) {
                dp[curr][prev] = 1 + dp[prev][curr];
                res = Math.max(res, dp[curr][prev]);
            }
        }
        return res;
    }
}
